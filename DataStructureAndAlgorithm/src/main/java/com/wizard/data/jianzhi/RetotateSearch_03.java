package com.wizard.data.jianzhi;

public class RetotateSearch_03 {
    public static void main(String[] args) {
        int[] arr = {5,5,5,1,2,3,4,5};
        int target = 5;
        int result = search(arr, target);
        System.out.println(result);

    }
    public static int search(int[] arr, int target) {

        int left = 0;
        int right = arr.length - 1;
        while(left <= right){
            int middle = (left + right) >> 1;
            if(arr[middle] == target){
                return middle;
            }
            //左侧顺序
            if(arr[left] <= arr[middle]){
                //目标值在0-middle 的中间位置
                if(arr[left] <= target && target <= arr[middle]){
                    right = middle - 1;
                }else{
                    left = middle + 1;
                }
            }else{
                //右侧顺序
                //目标在middle - right之间的位置
                if(arr[middle] <= target && target <= arr[right]){
                    left = middle + 1;
                }else{
                    right = middle - 1;
                }
            }
        }
        return -1;
    }
}
