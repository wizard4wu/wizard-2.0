package com.wizard.data.hot100;

import java.util.HashMap;
import java.util.Map;

public class Hot10 {


    public static void main(String[] args) {

        int[] array = {3,4,7,2,-3,1,4,2};
        int k = 7;
        int result = subarraySum(array, 7);


    }

    public static int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> sumResultMap = new HashMap<>();
        sumResultMap.put(0, 1);
        int sum = 0;
        int counter = 0;
        for(int index = 0; index < nums.length; index ++){
            sum += nums[index];
            if(sumResultMap.containsKey(sum - k)){
                counter += sumResultMap.get(sum - k);
            }

            sumResultMap.put(sum, sumResultMap.getOrDefault(sum, 0) + 1);
        }
        return counter;
    }
}
