package com.dev.wizard.lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListStreamNoteDemo {

    public static void main(String[] args) {

        List<String> list = new ArrayList<>();

        boolean result1 = list.stream().anyMatch("A"::equals);
        boolean result2 = list.stream().allMatch("B"::equals);
        boolean result3 = list.stream().noneMatch("C"::equals);

        System.out.println("result1: " + result1);
        System.out.println("result2: " + result2);
        System.out.println("result3: " + result3);


        List<String> stringList = Arrays.asList("aBC", "ddd");
        boolean result4 = stringList.parallelStream()
                .filter(string -> string.startsWith("D"))
                .allMatch(string -> string.contains("Z"));
        System.out.println("result4: " + result4);

    }

    public static boolean allMatch(String keyWord, List<String> list) {
        boolean result = true;
        int size = list.size();
        for (int index = 0; index < size; index++) {
            if (!keyWord.equals(list.get(index))) {
                result = false;
                break;
            }
        }
        return result;
    }

}
