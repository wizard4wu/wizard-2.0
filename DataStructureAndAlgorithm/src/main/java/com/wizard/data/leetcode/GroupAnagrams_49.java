package com.wizard.data.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagrams_49 {
    public static void main(String[] args) {

        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};

        Map map = Collections.synchronizedMap(new HashMap<>());
        Map<String, List<String>> resultMap= new HashMap<>();
        for(int index = 0; index < strs.length; index ++){
            char[] charArray = strs[index].toCharArray();
            Arrays.sort(charArray);
            String newString = new String(charArray);

            resultMap.getOrDefault(newString, new ArrayList<String>()).add(strs[index]);

        }

        List<List<String>> list = new ArrayList(resultMap.size());
        for(Map.Entry<String, List<String>> entry : resultMap.entrySet()){
            list.add(entry.getValue());
        }
    }
}
