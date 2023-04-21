package com.dev.wizard.lambda;



import javax.naming.Reference;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.Function;
import java.util.function.Supplier;

public class LambdaDemo {

    public static void main(String[] args) {


    }
   public static String method(String name, int number){

        String tempName = name;
        if(3 == number){
            tempName = "zhouyu";
        }

       Function<String, String> function = value ->{

            if(value.contains("zh")){
                value = tempName;
            }
            return value;
       };
     return null;
   }
}
