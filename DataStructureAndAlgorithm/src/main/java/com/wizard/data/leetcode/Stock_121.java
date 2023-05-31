package com.wizard.data.leetcode;

public class Stock_121 {
    public static int maxProfit(int[] prices) {

        int maxProfit = 0;
        int minPrice = prices[0];
        for(int index = 1; index < prices.length; index ++){
            if(minPrice > prices[index]){
                minPrice = prices[index];
            }
            int profit = prices[index] - minPrice;
            if(profit > maxProfit){
                maxProfit = profit;
            }
        }
        return maxProfit;
    }

    public static void main(String[] args) {

    }
}
