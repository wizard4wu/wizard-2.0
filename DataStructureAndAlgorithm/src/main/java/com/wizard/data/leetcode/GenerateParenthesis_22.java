package com.wizard.data.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class GenerateParenthesis_22 {

    public static void main(String[] args) {

        generateParenthesis1(3).forEach(System.out::println);
    }

    public static List<String> generateParenthesis(int n) {

        Map<String, String> map = new HashMap<>(n + 1);

        for (int index = 1; index <= n; index++) {
            StringBuilder sb = new StringBuilder();
            sb.append("(".repeat(index));
            sb.append(")".repeat(index));
            map.put(index + "", sb.toString());
        }

        Set<String> set = new LinkedHashSet<>();
        for(int index = 1; index <= n; index ++){
            Iterator<String> iterator = set.iterator();
            while (iterator.hasNext()){
                String value = iterator.next();
                set.add(value + "1");
                set.add("1" + value);
            }
            set.add(index + "");
        }

        set.forEach(s -> System.out.println( s + " "));
        return null;
    }
    public static List<String> generateParenthesis1(int n) {

        List<List<String>> result = new ArrayList<>(n);
        List<String> list0 = new ArrayList<>();
        list0.add("");
        result.add(list0);

        List<String> list1 = new ArrayList<>();
        list1.add("()");
        result.add(list1);


        for(int index = 2; index <= n; index ++){
            List<String> temp = new ArrayList<>();
            for(int leftIndex = 0; leftIndex < index; leftIndex ++){
                List<String> list_1 = result.get(leftIndex);
                List<String> list_2 = result.get(index - leftIndex - 1);
                for(String str1 : list_1){
                    for (String str2 : list_2){
                        temp.add("(" + str1 + ")" + str2);
                    }
                }

            }
            result.add(temp);
        }
        return result.get(n);
    }
}
