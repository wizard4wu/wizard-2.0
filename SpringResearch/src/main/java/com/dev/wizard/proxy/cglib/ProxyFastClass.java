package com.dev.wizard.proxy.cglib;

import org.springframework.cglib.core.Signature;

import java.lang.reflect.InvocationTargetException;

/**
 * 模拟字节码生成的FastClass
 * 该类的目标是为了避免使用methodProxy.invokeSuper()时通过反射调用生成的
 * 该类会生成所有的方法
 */
public class ProxyFastClass  {
    static Signature s0 = new Signature("saveSuperMethod", "()V");
    static Signature s1 = new Signature("saveSuperMethod", "(I)Ljava/lang/String;");

    /**
     * 根据方法的签名信息获取对应的编号
     * void saveSuperMethod()   ---> 3
     * String saveSuperMethod(int value) ---> 4
     */
    public int getIndex(Signature signature){
        //signature = 方法名 + 参数 + 返回值类型， 实际上方法名+参数就可以确定一个方法
        //因为一个方法的重载和返回类型没有关系

        if(s0.equals(signature)){
            return 3;
        }else if(s1.equals(signature)){
            return 4;
        }
        return -1;
    }

    /**
     * 根据方法的编号找到对应的方法，使用proxy对象直接调用该方法
     */
    public Object invoke(int index, Object proxy, Object[] args){
        if( 3 == index){
            ((CglibProxy)proxy).saveSuperMethod();
        }else if(4 == index){
          return ((CglibProxy)proxy).saveSuperMethod((int)args[0]);
        }
        return null;
    }


    public static void main(String[] args) {

        ProxyFastClass proxyFastClass = new ProxyFastClass();
        int index = proxyFastClass.getIndex(new Signature("saveSuperMethod", "(I)Ljava/lang/String;"));
        System.out.println("index: " + index);
        String result = (String)proxyFastClass.invoke(index, new CglibProxy(), new Object[]{55});
        System.out.println(result);
    }
}
