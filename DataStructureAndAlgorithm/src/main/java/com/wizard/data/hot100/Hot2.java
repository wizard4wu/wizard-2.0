package com.wizard.data.hot100;

import java.util.*;

public class Hot2 {


    public static void main(String[] args) {

        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List list = groupAnagrams(strs);
        System.out.println(list);
    }
    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>(strs.length);
        for (String strValue : strs) {
            char[] charArray = strValue.toCharArray();
            Arrays.sort(charArray);

            String strValueAfterSort = String.valueOf(charArray);;
            map.computeIfAbsent(strValueAfterSort, k -> new ArrayList<>()).add(strValue);
        }
        return new ArrayList<>(map.values());
    }
}
