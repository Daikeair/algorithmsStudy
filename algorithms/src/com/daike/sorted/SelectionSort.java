package com.daike.sorted;

import java.util.Arrays;

/**
 * @Author alex.chen
 * @Date 2020-05-26 01:02
 * @Version 1.0
 * 选择排序
 * 隔板，从第0下标开始，每次选择隔板右边最小的数和最靠近隔板左边的那个数做交换
 */
public class SelectionSort {

    public int[] selectionSort(int[] input){
        if(input==null || input.length<=1){
            return null;
        }

        for (int i = 0; i <input.length-1 ; i++) {
            int minValueIndex=i;
            for (int j =i+1 ; j < input.length; j++) {
                if(input[j]<input[minValueIndex]){
                   minValueIndex=j;
                }
            }
            swap(input,i,minValueIndex);

        }
        return input;

    }

    private void swap(int[] input, int i, int j) {
        int temp;
        temp=input[i];
        input[i]=input[j];
        input[j]=temp;
    }

    public static void main(String[] args) {

        int[] input=new int[]{4,17,8,2,56,9,0,1};

        SelectionSort selectionSort = new SelectionSort();
        int[] sort = selectionSort.selectionSort(input);

        System.out.println(Arrays.toString(sort));

    }

}
