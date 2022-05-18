package com.dev.wizard.research.proxy.mock;

import com.google.common.eventbus.Subscribe;
import com.google.common.reflect.TypeToken;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Set;

//创建一个拦截器 用于方法回掉
public class TargetInterceptor implements MethodInterceptor {
    @Override
    public Object intercept(Object obj, Method method,
                            Object[] params, MethodProxy proxy) throws Throwable {
        System.out.println("调用前");
        Object result = proxy.invokeSuper(obj, params);
        System.out.println("调用后");
        return result;
    }

    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        //创建字节码增强器
        Enhancer enhancer =new Enhancer();
        //设置父类
        enhancer.setSuperclass(Teacher.class);
        //设置回调函数
        enhancer.setCallback(new TargetInterceptor());
        //创建代理类
        Teacher teacher=(Teacher)enhancer.create();
       // teacher.teacher("张三");
        Set<? extends Class<?>> supertypes = TypeToken.of(teacher.getClass()).getTypes().rawTypes();


        for (Class<?> supertype : supertypes) {
            for (Method method : supertype.getDeclaredMethods()) {
                if (method.isAnnotationPresent(Subscribe.class)) {
                    method.setAccessible(true);
                    method.invoke(teacher);
                }
            }
        }

        Method playMethod = Teacher.class.getDeclaredMethod("teacher", String.class);
        playMethod.setAccessible(true);

        playMethod.invoke( teacher, "play");
        Method[] methods = teacher.getClass().getMethods();

       // Arrays.asList(methods).stream().forEach( method -> System.out.println(method));
    }
}
