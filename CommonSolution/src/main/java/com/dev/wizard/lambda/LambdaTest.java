package com.dev.wizard.lambda;

public class LambdaTest {

    public static void main(String[] args) throws Exception {
        print(new Switch() {
            @Override
            public String switchLowerCase(String str) {
                return str.toLowerCase();
            }
        });
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
