package com.dev.wizard.proxy.jdk;


import java.io.IOException;
import java.lang.reflect.Proxy;

public class JDKProxy {

    interface ProxyInterface{
        void voidMethod();

        void voidMethodWithPram(String value);

        String stringMethodWithPram(String value);
    }

    static final class Target implements ProxyInterface{

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

    public static void main(String[] args) throws IOException {

        //1.获取当前加载该代理的类加载器，用于加载运行期间生成的字节码文件
        ClassLoader loader = JDKProxy.class.getClassLoader();
        //2.获取目标类的对象
        Target target = new Target();
        //invocationHandler 提供反射所需要的参数
        //1.代理对象
        //2.需要增强的方法
        //3.增强的方法中的参数
        ProxyInterface proxyInterface = (ProxyInterface) Proxy.newProxyInstance(loader, new Class[]{ProxyInterface.class}, (proxyObject, method, parameters) -> {

            System.out.println("before......");
            //通过反射执行目标类的方法
            Object result = method.invoke(target, parameters);
            System.out.println("after......");
            return null;  //此处是用于方法的返回结果给代理类中执行的方法
        });

        System.out.println(proxyInterface.getClass());
        System.in.read();
    }
}
