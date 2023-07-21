package com.dev.wizard.redis.lock;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.aop.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.ReflectUtils;
import org.springframework.stereotype.Component;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

@Aspect
@Component
@Slf4j
public class RedisLockAspect {

    @Autowired
    private RedisLock redisLock;

    @Around("@annotation(com.dev.wizard.redis.lock.RedisLocked)")
    public Object around(ProceedingJoinPoint joinPoint){
        MethodSignature methodSign = (MethodSignature)joinPoint.getSignature();
        Method method = methodSign.getMethod();
        RedisLocked redisLockedAnnotation = method.getAnnotation(RedisLocked.class);
        if(null == redisLockedAnnotation){
            try {
                return joinPoint.proceed();
            } catch (Throwable e) {
                throw new RuntimeException(e);
            }
        }
        String key = redisLockedAnnotation.key();
        long lockExpiredTime = redisLockedAnnotation.lockExpiredTime();
        long tryLockTime = redisLockedAnnotation.tryLockTime();
        return redisLock.executeWithRedisLock(key, lockExpiredTime, tryLockTime, () ->{
            try {
              return joinPoint.proceed();
            } catch (Throwable e) {
                throw new RuntimeException(e);
            }
        });
    }
}
