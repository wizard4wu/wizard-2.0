package com.dev.wizard.proxy.jdk;

import java.lang.reflect.Method;

public class MyProxy_SecondEdition {

    interface ProxyInterface{

        void voidMethod();

        void voidMethodWithPram(String value);

        String stringMethodWithPram(String value);
    }

    interface InvocationHandler {
        Object invoke(Method method, Object[] objects) throws Throwable;
    }
    static class Target implements MyProxy_FirstEdition.ProxyInterface {

        @Override
        public void voidMethod() {
            System.out.println("voidMethod");
        }

        @Override
        public void voidMethodWithPram(String value) {
            System.out.println("voidMethodWithPram" + value);
        }

        @Override
        public String stringMethodWithPram(String value) {
            System.out.println("stringMethodWithPram" + value);
            return "stringMethodWithPram" + value;
        }
    }

    static class $Proxy0 implements MyProxy_FirstEdition.ProxyInterface {
        private InvocationHandler invocationHandler;
        public $Proxy0(InvocationHandler invocationHandler){
            this.invocationHandler = invocationHandler;
        }
        private static Method method0;

        static {
            try {
                method0 = Target.class.getDeclaredMethod("stringMethodWithPram", String.class);
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void voidMethod() {
            try {
                Method method = Target.class.getDeclaredMethod("voidMethod");
                invocationHandler.invoke(method, new Object[0]);
            } catch (Throwable e) {
                e.printStackTrace();
            }
        }

        @Override
        public void voidMethodWithPram(String value) {
            try {
              Method method = Target.class.getDeclaredMethod("voidMethodWithPram", String.class);
              invocationHandler.invoke(method, new Object[]{value});
            } catch (Throwable e) {
                e.printStackTrace();
            }
        }

        @Override
        public String stringMethodWithPram(String value) {
            try {
              Method method = Target.class.getDeclaredMethod("stringMethodWithPram", String.class);
              return (String)invocationHandler.invoke(method, new Object[]{value});
            } catch (Throwable e) {
                e.printStackTrace();
            }
            return null;
        }
    }

    public static void main(String[] args) {
        Target target = new Target();
        MyProxy_SecondEdition.$Proxy0 proxy0 = new MyProxy_SecondEdition.$Proxy0(new InvocationHandler() {
            @Override
            public Object invoke(Method method, Object[] objects) throws Throwable {
                System.out.println("before...");
                Object object = method.invoke(target, objects);
                return object;
            }
        });
        proxy0.voidMethod();
        proxy0.voidMethodWithPram("hello");
        String returnValue = proxy0.stringMethodWithPram("world");
        System.out.println(returnValue);
    }
}
