package com.dev.wizard.lambda;

public class LambdaTest {

    public void test(){
        System.out.println("LambdaTest");
    }

    public static void main(String[] args) throws Exception {
        LambdaTest lambdaTest = new LambdaTest();
        Switch switcher = str -> {
            lambdaTest.test();
            return str.toLowerCase();
        };
        print(switcher);
    }

    public static void print(Switch switcher) {
        String str = "Hello World";
        str = switcher.switchLowerCase(str);
        System.out.println(str);
    }

    interface Switch {
        String switchLowerCase(String str);
    }

//   final class LambdaTest$$Lambda$1 implements LambdaTest.Switch{
//       public String switchLowerCase(String str){
//          return LambdaTest.lambda$main$0(str);
//       }
//   }
//
//    private static String lambda$main$0(String str){
//        return str.toLowerCase();
//    }
}
