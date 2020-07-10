package com.daike.sorted;

import java.util.Arrays;

/**
 * @Author alex.chen
 * @Date 2020-05-26 01:33
 * @Version 1.0
 */
public class QuickSorted {

    public void quickSort(int[] input){

        recursiveQuikSort(input,0,input.length-1);

    }

    /**
     * 递归的快速排序
     * @param input
     * @param start
     * @param end
     */

    private void recursiveQuikSort(int[] input, int start, int end) {

        if(input==null || input.length<=1 || start<0 || start>end){
            return ;
        }

        //找到基准元素pivot的位置（下标来表示）
        int partition=partition(input,start,end);
        //对划分后的低位段进行快速排序,
        // 此处start不能写为0，会导致每次分治点的左边都从0开始计算，数据量大了以后，递归会导致运行速度非常慢！！！这是容易出错的一个点，
        recursiveQuikSort(input,start,partition-1);
        //对划分后的高位段进行快速排序
        recursiveQuikSort(input,partition+1,end);
  }

    /**
     * 寻找分治点位置
     * @param input
     * @param start
     * @param end
     * @return
     */
    private int partition(int[] input,int start, int end) {
        //以第一个元素为基准
        int pivot=input[start];
        while(start<end){
            //start<end判断条件start<end 为了防止越界
            while(start<end && pivot<=input[end]){
                --end;
            }
            input[start]=input[end];
            //swap(input,start,end);
            while (start<end && input[start]<=pivot){
                start++;
            }
            input[end]=input[start];
            //swap(input,start,end);

        }
        input[start]=pivot;
        return start;

    }

    public static void main(String[] args) {
        int[] input=new int[1000];
     for (int i = 0; i < 1000; i++) {
            int random = (int)(Math.random()*876);
            input[i]=random;
        }

        //int[] input=new int[]{0,5};
        QuickSorted quickSorted = new QuickSorted();
        quickSorted.quickSort(input);

        System.out.println(Arrays.toString(input));
    }





    /**
     * 交换两元素的位置
     * @param input
     * @param start
     * @param end
     */
    private void swap(int[] input,int start, int end) {
        int temp;
        temp=input[start];
        input[start]=input[end];
        input[end]=temp;

    }
}
