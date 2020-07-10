package com.daike.sortednew;

import java.util.Arrays;

/**
 * @Author alex.chen
 * @Date 2020-07-04 01:40
 * @Version 1.0
 *
 * 选择排序
 * 隔板，从第0下标开始，每次选择隔板右边最小的数和最靠近隔板左边的那个数做交换
 * 时间复杂度最坏情况O（n^2）
 */
public class SelectSortTest {

    public int[] selectSort(int[] input){
        if(input==null|| input.length<=1){
            return null;
        }

        for (int i = 0; i <input.length-1 ; i++) {
            //找到隔板右边最小的数,将0下标设置为初始最小标志，也就是说从下标为1的开始与它比较，谁小就把下标给谁，直到循环
            int minValueIndex=i;
            System.out.println("============"+i);
            for (int j = i+1; j<input.length ; j++) {
                if(input[j]<input[minValueIndex]){
                    minValueIndex=j;
                }
            }
            //内层循环结束后，就会找出隔板右边的最小的下标，然后与最靠近隔板左边的那个数交换
            swap(input,i,minValueIndex);
        }

        return input;

    }

    private void swap(int[] input, int i, int minValueIndex) {
        int temp=input[i];
        input[i]=input[minValueIndex];
        input[minValueIndex]=temp;
    }






    //test


    public static void main(String[] args) {

        int[] input=new int[]{4,17,8,2,56,9,0,1};

        int[] output = new SelectSortTest().selectSort(input);

        System.out.println(Arrays.toString(output));

    }

}
