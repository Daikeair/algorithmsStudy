package com.daike.sortednew;

import java.util.Arrays;

/**
 * @Author alex.chen
 * @Date 2020-07-04 10:16
 * @Version 1.0
 *
 * 归并排序---分治策略（divide and conquer）
 *
 * 分---大问题分成小问题---把一个数组拆成两个数组---怎么拆？
 * 治---用同样的方法解决小问题，达到不治而治的策略---用归并排序去排序这两个数组，不断地分，直到每个数组元素为1，自然有序
 * 合---用小问题构解大问题---将两个小数组合并为大数组
 * base case 当只剩一个元素时，无法再进行分解，这时候直接返回
 */
public class MergeSortTest {

    public void mergeSort(int[] arr){
        if(arr==null || arr.length<=1){
            return;
        }
        int[] newArray=new int[arr.length];
        mergeSort(arr,0,arr.length-1,newArray);

    }

    private void mergeSort(int[] arr, int left, int right, int[] newArray) {
        //分
        int mid=left+(right-left)/2;

        //治
            //baseCase：结束条件，当左边的值等于右边值的时候也就是每个数组被分成只有一个元素的时候
        if(left>=right){
            return;
        }
            //左边数组排序
            mergeSort(arr,left,mid,newArray);
            //右边数组排序
            mergeSort(arr,mid+1,right,newArray);
            //把原数组元素放入辅助数组
            int e=1;
        for (int i = left; i <=right ; i++) {
            newArray[i]=arr[i];
        }

        //合
        int i=left;
        int j=mid+1;
        int k=left;
        e=2;

        while(i<=mid && j<=right){
            if(newArray[i]<=newArray[j]){
                arr[k++]=newArray[i++];
            }else{
                arr[k++]=newArray[j++];
            }
        }
        e=3;
        //因为之前排序是往原数组放数字，所以合并的时候右边已经有序，不需要加while（j<=right）那句
        while(i<=mid){
            arr[k++]=newArray[i++];
        }
    }





    //test-mergeSort

    public static void main(String[] args) {

                int[] input=new int[1000];
        for (int i = 0; i < 1000; i++) {
            int random = (int)(Math.random()*876);
            input[i]=random;
        }

        //int[] input=new int[]{4,17,8,2,56,9,0,1};

        new MergeSortTest().mergeSort(input);

        System.out.println(Arrays.toString(input));

    }


}
