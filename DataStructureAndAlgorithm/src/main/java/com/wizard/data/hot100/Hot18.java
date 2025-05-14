package com.wizard.data.hot100;

public class Hot18 {

    public static void main(String[] args) {

        int[][] matrix = {{0,1,2,0},{3,4,5,2},{1,3,1,5}};
        setZeroes(matrix);

        String testValue = "tsseeessz";
        String result = longestString(testValue);
        System.out.println(result);
    }
    public static void setZeroes(int[][] matrix) {

        boolean rowFlag = false;
        boolean columnsFlag = false;

        for(int index = 0; index < matrix.length; index ++){
            if(matrix[index][0] == 0){
                rowFlag = true;
            }
        }

        for(int index = 0; index < matrix[0].length; index ++){
            if(matrix[0][index] == 0){
                columnsFlag = true;
            }
        }

        for(int rowIndex = 1; rowIndex < matrix.length; rowIndex ++){
            for(int columnsIndex = 1; columnsIndex < matrix[0].length; columnsIndex ++){
                if(matrix[rowIndex][columnsIndex] == 0){
                    matrix[rowIndex][0] = 0;
                    matrix[0][columnsIndex] = 0;
                }
            }
        }

        for(int rowIndex = 1; rowIndex < matrix.length; rowIndex ++){
            for(int columnsIndex = 1; columnsIndex < matrix[0].length; columnsIndex ++){
                if(matrix[rowIndex][0] == 0 || matrix[0][columnsIndex] == 0){
                    matrix[rowIndex][columnsIndex] = 0;
                }
            }
        }

        for(int index = 0; index < matrix.length; index ++){
            if(rowFlag){
                matrix[index][0] = 0;
            }
        }

        for(int index = 0; index < matrix[0].length; index ++){
            if(columnsFlag){
                matrix[0][index] = 0;
            }
        }
    }

    public static String longestString(String strValue){
        if(strValue == null || strValue.length() <= 1){
            return strValue;
        }
        int startIndex = 0;
        int endIndex = 0;
        for(int index = 0; index < strValue.length(); index ++){

            //解决奇偶数字符串的问题
            int targetIndex1 = getTargetIndex(strValue, index, index);
            int targetIndex2 = getTargetIndex(strValue, index, index + 1);
            int targetIndex = Math.max(targetIndex1, targetIndex2);
            if(targetIndex > endIndex - startIndex){
                startIndex = index - (index - 1) / 2;
                endIndex = index + targetIndex / 2;
            }
        }
        return strValue.substring(startIndex, endIndex + 1);
    }
    public static int getTargetIndex(String strValue, int startIndex, int endIndex){
        while(startIndex >= 0 && endIndex < strValue.length() && strValue.charAt(startIndex) == strValue.charAt(endIndex)){
            startIndex --;
            endIndex ++;
        }
        return endIndex - startIndex - 1;
    }
}
