package com.dev.wizard.lambda;


public class LambdaDemo {


    public static void test(MyFirstFunction function){
        function.execute("MyFirstFunction");
    }

    public static void test(MySecondFunction function){
        function.execute("MySecondFunction");
    }

    public static void main(String[] args) {

        int number = 33;
        //1.类型推断
        test(new MyFirstFunction() {

            @Override
            public void execute(String value) {
                int number = 44;
                System.out.println("value + " + value);
                System.out.println(number);
            }
        });

        test((MySecondFunction) value -> {
            int numbers = 66;
            System.out.println("value + " + value);
            System.out.println(number);
        });

        //super和this的含义

    }
}
