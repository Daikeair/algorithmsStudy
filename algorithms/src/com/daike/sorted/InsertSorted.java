package com.daike.sorted;

import java.util.Arrays;


/**
 * @Author alex.chen
 * @Date 2020-05-26 00:30
 * @Version 1.0
 * 插入排序,"隔板法"
 * 隔板右边的选择一个数插入隔板左边，和隔板左边的数作比较，找到合适的位置插入
 */
public class InsertSorted {


    public int[] insertSorted(int[] input){
       if(input==null||input.length<=1){
           return null;
       }

        int temp=0;
        for (int i = 1; i < input.length; i++) {
            temp=input[i];
            int j = i-1;
            while(j>=0 && temp<input[j]){
                input[j+1]=input[j];
                j--;

            }
            input[j+1]=temp;
        }




        return input;
    }

    public static void main(String[] args) {

        int[] input=new int[]{4,17,8,2,56,9,0,1};

        InsertSorted insertSorted = new InsertSorted();
        int[] sorted = insertSorted.insertSorted(input);

        System.out.println(Arrays.toString(sorted));

    }
}
