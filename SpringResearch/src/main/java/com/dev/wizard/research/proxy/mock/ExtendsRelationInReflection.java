package com.dev.wizard.research.proxy.mock;

import com.google.common.eventbus.Subscribe;
import com.google.common.reflect.TypeToken;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Set;


public class ExtendsRelationInReflection {
    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {
        Teacher teacher = new Teacher();
        Set<? extends Class<?>> supertypes = TypeToken.of(teacher.getClass()).getTypes().rawTypes();
        teacher.getClass().getSuperclass();
        for (Class<?> supertype : supertypes) {
            for (Method method : supertype.getDeclaredMethods()) {
                if (method.isAnnotationPresent(Subscribe.class)) {
                    method.setAccessible(true);
                    method.invoke(teacher);
                }
            }
        }
    }
}
