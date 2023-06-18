package com.wizard.data.leetcode;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class Multiply_43 {

    public static void main(String[] args) {

        while (true){

        }
        //multiply("123", "456");
    }

    public static String multiply(String num1, String num2) {
        Map<Integer, String> map = new HashMap<>();


        for(int num1Index = num1.length() - 1; num1Index >= 0; num1Index --){
            for(int num2Index = num2.length() - 1; num2Index >= 0; num2Index --){
                int value1 = num1.charAt(num1Index) - 48;
                int value2 = num2.charAt(num2Index) - 48;

                int position = num1.length() + num2.length() - 2 - num1Index - num2Index;

                int multiply = value1 * value2;
                int remain = multiply % 10;
                int sang = multiply / 10;
                String value = map.get(position);
                if(null == value){
                    map.put(position, remain + "");
                }else {
                    int i = Integer.parseInt(map.get(position)) + remain;
                    map.put(position, i + "");
                }
                String value0 = map.get(position + 1);
                if(null == value0){
                    map.put(position + 1, sang + "");
                }else {
                    int i = Integer.parseInt(map.get(position + 1)) + sang;
                    map.put(position + 1, i + "");
                }
            }
        }
        StringBuilder sb = new StringBuilder();


//        for(Map.Entry entrySet : map.entrySet()){
//            if(entrySet.getValue() > 9){
//                int remain = entrySet.getValue() % 10;
//                int sang = entrySet.getValue() / 10;
//                entrySet.setValue(remain);
//            }
//        }
        return "d";
    }
    private static void initMap(Map<Integer, String> map){

    }
}
