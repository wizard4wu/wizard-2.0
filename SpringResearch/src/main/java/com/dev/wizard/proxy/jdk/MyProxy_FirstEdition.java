package com.dev.wizard.proxy.jdk;

public class MyProxy_FirstEdition {

    interface ProxyInterface{

        void voidMethod() throws NoSuchMethodException;

        void voidMethodWithPram(String value) throws NoSuchMethodException;

        String stringMethodWithPram(String value) throws NoSuchMethodException;
    }

    static class Target implements ProxyInterface{

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

    static class $Proxy0 implements ProxyInterface{


        @Override
        public void voidMethod() {
            System.out.println("before...");
            new Target().voidMethod();

        }

        @Override
        public void voidMethodWithPram(String value) {
            System.out.println("before");
            new Target().voidMethodWithPram("hello");
        }

        @Override
        public String stringMethodWithPram(String value) {
            System.out.println("before");
            return new Target().stringMethodWithPram(value);
        }
    }

    public static void main(String[] args) {
        $Proxy0 proxy0 = new $Proxy0();
        proxy0.voidMethod();
        proxy0.voidMethodWithPram("hello");
        String returnValue = proxy0.stringMethodWithPram("world");
    }
}
