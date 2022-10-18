package com.dev.wizard.proxy.spring;

import com.sun.scenario.effect.Merge;
import org.springframework.aop.aspectj.AspectJExpressionPointcut;
import org.springframework.aop.support.StaticMethodMatcherPointcut;
import org.springframework.core.annotation.MergedAnnotation;
import org.springframework.core.annotation.MergedAnnotations;
import org.springframework.transaction.annotation.Transactional;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

public class AspectPointMatch {

    public static void main(String[] args) throws NoSuchMethodException {

        AspectJExpressionPointcut methodNamePointCut = new AspectJExpressionPointcut();
        //设置切点表达式，进行方法名匹配
        methodNamePointCut.setExpression("execution (* method())");

        boolean result1 = methodNamePointCut.matches(TestClass.class.getMethod("method"), TestClass.class);
        boolean result2 = methodNamePointCut.matches(TestClass.class.getMethod("testMethod"), TestClass.class);
        System.out.println(result1);
        System.out.println(result2);

        AspectJExpressionPointcut annotationPointCut = new AspectJExpressionPointcut();
        //设置切点表达式，进行注解匹配
        annotationPointCut.setExpression("@annotation(com.dev.wizard.proxy.spring.MyAnnotation)");
        boolean result3 = annotationPointCut.matches(TestClass.class.getMethod("method"), TestClass.class);
        boolean result4 = annotationPointCut.matches(TestClass.class.getMethod("testMethod"), TestClass.class);
        System.out.println(result3);
        System.out.println(result4);


        StaticMethodMatcherPointcut pointcut = new StaticMethodMatcherPointcut() {
            @Override
            public boolean matches(Method method, Class<?> targetClass) {
               MergedAnnotations mergedAnnotations = MergedAnnotations.from(method);
               //如果该方法上存在该注解直接返回
               if(mergedAnnotations.isPresent(MyAnnotation.class)){
                   return true;
               }
               mergedAnnotations = MergedAnnotations.from(targetClass, MergedAnnotations.SearchStrategy.TYPE_HIERARCHY);
               if(mergedAnnotations.isPresent(MyAnnotation.class)){
                   return true;
               }
                return false;
            }
        };

        boolean result5 = pointcut.matches(TestTransactionalClass.class.getMethod("methodSecond"), TestTransactionalClass.class);
        boolean result6 = pointcut.matches(TestClass.class.getMethod("testMethod"), TestClass.class);
        System.out.println("result5:" + result5);
        System.out.println("result6:" + result6);
    }

    @MyAnnotation
    static class TestClass {
        public void method() {
            System.out.println("I am method");
        }

        public void testMethod() {
            System.out.println("I am testMethod");
        }
    }
    @Transactional
    @MyAnnotation
    interface TestTransactionalInterface{
        void methodFirst();
        void methodSecond();
    }

    static class TestTransactionalClass implements TestTransactionalInterface{
        @Override
        public void methodFirst() {
            System.out.println("TestTransactionalClass###methodFirst");
        }


        @Override
        public void methodSecond() {
            System.out.println("TestTransactionalClass###methodSecond");
        }
    }

}
