package com.daike.sortednew;


import java.util.Arrays;

/**
 * @Author alex.chen
 * @Date 2020-07-07 22:04
 * @Version 1.0
 * 快排
 * 1.随机找一个基准值pivot，再将基准值与数组第一个交换位置
 * 2.然后找到pivot在数值中的位置，这样就将数组发分成了两个区域
 * 3.分别递归。。。。
 *
 * 时间复杂度O(nlogn)最坏情况O(n^2)
 */
public class QuickSortedTest {

    public void quickSorted(int[] arr){
        recursiveQuikSort(arr,0,arr.length-1);

    }

    /**
     * 递归快排
     * @param arr
     * @param start
     * @param end
     */
    private void recursiveQuikSort(int[] arr, int start, int end) {
        if(arr==null || arr.length<=1 || start<0 || start>=end){
            return;
        }

        //找到基准元素pivot的位置（下标来表示）
        int partition=partition(arr,start,end);

        recursiveQuikSort(arr,start,partition-1);

        recursiveQuikSort(arr,partition+1,end);

    }

    /**
     * 寻找分治点位置
     * @param arr
     * @param start
     * @param end
     * @return
     */
    private int partition(int[] arr, int start, int end) {
        //以第一个元素为基准
        int pivot=arr[start];
        while(start<end){
            //从最右边开始与基准值比较
            while(start<end && arr[end]>=pivot){
                --end;
            }
            arr[start]=arr[end];

            while(start<end && arr[start]<=pivot){
                start++;
                 int s=0;
            }
            arr[end]=arr[start];
        }
        arr[start]=pivot;
        return start;

    }




    //test

    public static void main(String[] args) {
//        int[] input=new int[100];
//     for (int i = 0; i < 100; i++) {
//            int random = (int)(Math.random()*100);
//            input[i]=random;
//        }

        int[] input=new int[]{0,18,7,9,6,5};
        QuickSortedTest quickSortedTest = new QuickSortedTest();
        quickSortedTest.quickSorted(input);

        System.out.println(Arrays.toString(input));
    }
}
