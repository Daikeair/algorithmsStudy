package com.daike.sortednew;

import java.util.Arrays;

/**
 * @Author alex.chen
 * @Date 2020-07-04 03:03
 * @Version 1.0
 * 希尔排序----插入排序的优化版
 * 插入排序在原数据越有序，插入效率越高。
 * 希尔排序=有分组间隔（组内元素两两间隔gap）插入排序--》缩小间隔直到为1
 */
public class ShellSortedTest {

    public int[] shellSort(int[] input){
        int N=input.length;
        if(input==null || N<=1){
            return null;
        }
        //进行分组，最开始的分组增量为数组长度的一半
        for (int gap = N/2; gap >0 ; gap/=2) {
            //对各个分组进行插入排序
            for (int i = gap; i <N ; i++) {
                insert(input,gap,i);
            }
        }
        return input;
    }

    /**
     * 间隔为gap的插入排序
     * @param input
     * @param gap
     * @param i
     */
    private void insert(int[] input, int gap, int i) {
            int inserted=input[i];
            int j=i-gap;
            //插入的时候按组进行排序（组内元素两两间隔gap----这点对理解很重要）
        //while里面的下界限制条件j>=0
        while(j>=0 && input[j]>inserted){
            input[j+gap]=input[j];
            j-=gap;
        }
        input[j+gap]=inserted;

    }


    /**
     *  test
     */

    public static void main(String[] args) {

        int[] input=new int[]{4,17,8,2,56,9,0,1};

        int[] sorted = new ShellSortedTest().shellSort(input);

        System.out.println(Arrays.toString(sorted));

    }
}
