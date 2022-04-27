package com.dev.wizard.redis.config;

import com.dev.wizard.redis.cache.AutoCache;
import com.dev.wizard.redis.cache.MyRedisCache;
import com.dev.wizard.redis.demo.MyRedisCacheClass;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.StringRedisTemplate;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.Arrays;

@Configuration
public class LoadCache implements BeanPostProcessor {

    @Autowired
    private StringRedisTemplate redisTemplate;

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {

        Field[] fields = bean.getClass().getDeclaredFields();
        Arrays.asList(fields).stream().forEach(field -> {
                    AutoCache autoCache = field.getAnnotation(AutoCache.class);
                    if (null != autoCache){
                        String prefix = autoCache.prefix();
                        if(!field.isAccessible()){
                            field.setAccessible(true);
                        }
                        if(MyRedisCache.class.isAssignableFrom(field.getType())){
                            MyRedisCacheClass myRedisCacheClass = new MyRedisCacheClass(redisTemplate, prefix);
                            try {
                                field.set(bean, myRedisCacheClass);
                            } catch (IllegalAccessException e) {
                                e.printStackTrace();
                            }
                        }
                    }

                }
        );
        return bean;
    }
}
