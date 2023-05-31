package com.wizard.data.leetcode;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class GenerateParenthesis_22 {

    public static void main(String[] args) {

        generateParenthesis(2);
    }

    public static List<String> generateParenthesis(int n) {

        Map<String, String> map = new HashMap<>(n);

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
}
