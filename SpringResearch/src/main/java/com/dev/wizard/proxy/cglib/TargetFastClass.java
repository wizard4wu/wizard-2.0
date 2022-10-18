package com.dev.wizard.proxy.cglib;

import org.springframework.cglib.core.Signature;

public class TargetFastClass {


    static Signature s0 = new Signature("saveMethod", "()V");
    static Signature s1 = new Signature("saveMethod", "(I)Ljava/lang/String;");

    /**
     * 根据方法的签名信息获取对应的编号
     * void saveMethod()   ---> 0
     * String saveMethod(int value) ---> 1
     */
    public int getIndex(Signature signature){
        //signature = 方法名 + 参数 + 返回值类型， 实际上方法名+参数就可以确定一个方法
        //因为一个方法的重载和返回类型没有关系

        if(s0.equals(signature)){
            return 0;
        }else if(s1.equals(signature)){
            return 1;
        }
        return -1;
    }

    /**
     * 根据方法的编号找到对应的方法，使用target对象直接调用该方法
     */
    public Object invoke(int index, Object target, Object[] args){

        if( 0 == index){
            ((CglibTarget)target).saveMethod();
        }else if( 1 == index){
           return ((CglibTarget)target).saveMethod((int)args[0]);
        }
        return null;
    }

    public static void main(String[] args) {

        TargetFastClass targetFastClass = new TargetFastClass();
        // 由于在生成MethodInterceptor对象的时候塞了方法名和参数返回类型，根据此信息可得到index值
        int index = targetFastClass.getIndex(new Signature("saveMethod", "()V"));
        System.out.println( "index: "+ index);
        //  再根据index找到对应的方法进行执行
        targetFastClass.invoke(index, new CglibTarget(), new Object[0]);

        int indexTwo = targetFastClass.getIndex(new Signature("saveMethod", "(I)Ljava/lang/String;"));
        System.out.println( "index: "+ indexTwo);
        String result = (String)targetFastClass.invoke(indexTwo, new CglibTarget(), new Object[]{100});
        System.out.println(result);
    }
}
