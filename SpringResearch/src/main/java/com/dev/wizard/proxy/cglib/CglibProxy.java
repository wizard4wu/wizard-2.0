package com.dev.wizard.proxy.cglib;

import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class CglibProxy extends CglibTarget {

    private MethodInterceptor methodInterceptor;

    CglibProxy (MethodInterceptor methodInterceptor){
        this.methodInterceptor = methodInterceptor;
    }

    static Method save0;
    static Method save1;

    static MethodProxy save0MethodProxy;
    static MethodProxy save1MethodProxy;

    static {
        try {
            save0 = CglibTarget.class.getDeclaredMethod("saveMethod");
            save1 = CglibTarget.class.getDeclaredMethod("saveMethod", int.class);

            //根据方法信息生成MethodProxy
            //1.目标类的信息；2.代理类的信息；3.方法描述信息；4.需要增强的方法名；5调用原始的方法名；
            save0MethodProxy = MethodProxy.create(CglibTarget.class, CglibProxy.class, "()V", "saveMethod", "saveSuperMethod");
            save1MethodProxy = MethodProxy.create(CglibTarget.class, CglibProxy.class, "(I)Ljava/lang/String;", "saveMethod", "saveSuperMethod");

        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }

    public void saveSuperMethod(){
        super.saveMethod();
    }
    public String saveSuperMethod(int value){
        return super.saveMethod(value);
    }

    public void saveMethod(){
        try {
            methodInterceptor.intercept(this, save0, new Object[0], save0MethodProxy);
        } catch (Throwable e) {
            e.printStackTrace();
        }
    }

    public String saveMethod(int value){
        try {
            methodInterceptor.intercept(this, save1, new Object[]{value}, save1MethodProxy);
        } catch (Throwable e) {
            e.printStackTrace();
        }
        return "int参";
    }


    public static void main(String[] args) {

        CglibTarget target = new CglibTarget();
        CglibProxy cglibProxy = new CglibProxy(new MethodInterceptor() {
            @Override
            public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                System.out.println("before...");
                //method.invoke(target, objects); //底层使用了反射
                methodProxy.invoke(target, objects);
                methodProxy.invokeSuper(o, objects);
                return null;
            }
        });
        cglibProxy.saveMethod();
        cglibProxy.saveMethod(33);
    }
}
