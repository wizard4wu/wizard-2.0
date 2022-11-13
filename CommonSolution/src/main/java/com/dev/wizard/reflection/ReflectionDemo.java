package com.dev.wizard.reflection;

import com.google.common.reflect.TypeToken;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Set;

public class ReflectionDemo {

    public static void main(String[] args) throws InterruptedException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {

       Class sonClazz =  Son.class;

       Class parentClazz = sonClazz.getSuperclass();

       Method method = parentClazz.getDeclaredMethod("eat");
       method.setAccessible(true);
       method.invoke(new Son());

//        Parent son = new Son();
//        son.age();



//       Arrays.stream(sonClazz.getMethods()).forEach(t -> System.out.println(t));
//       Arrays.stream(sonClazz.getDeclaredMethods()).forEach(t -> System.out.println(t));
////
//      Arrays.stream(sonClazz.getSuperclass().getDeclaredMethods()).forEach(t -> System.out.println(t));
//
//      Set<? extends Class<?>> supertypes = TypeToken.of(sonClazz).getTypes().rawTypes();
//      supertypes.forEach( type -> System.out.println(type));



    }
}
