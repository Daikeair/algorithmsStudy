package com.daike.sorted;

import java.util.Arrays;

/**
 * @Author alex.chen
 * @Date 2020-06-02 19:17
 * @Version 1.0
 */
public class MergeSort1 {
    public void mergeSort(int[] array){
        if(array==null||array.length<=1){
            return;
        }

        int[] newArray=new int[array.length];
        mergeSort(array,0,array.length-1,newArray);

    }

    private void mergeSort(int[] array, int left, int right, int[] newArray) {
        //[分]
        int mid=left+(right-left)/2;

        if(left>=right){
            return;
        }

        //[治]
        mergeSort(array,left,mid,newArray);
        mergeSort(array,mid+1,right,newArray);

        //辅助newArray
        for (int i = left; i <=right ; i++) {
            //将原数组的值放入新数组
            newArray[i]=array[i];
        }

        //[合]
        int i=left;
        int j=mid+1;
        int k=left;

        while(i<=mid&& j<=right){
            if (newArray[i]<=newArray[j]){
                array[k++]=newArray[i++];
            }else{
                array[k++]=newArray[j++];
            }
        }
        //因为之前排序是往原数组放数字，所以合并的时候右边已经有序，不需要加while（j<=right）那句
        while(i<=mid){
            array[k++]=newArray[i++];
        }

    }
    public static void main(String[] args) {
//        int[] input=new int[1000];
//        for (int i = 0; i < 1000; i++) {
//            int random = (int)(Math.random()*876);
//            input[i]=random;
//        }
        int[] input=new int[]{4,17,8,2,58,9,0,100};

        MergeSort1 mergeSort = new MergeSort1();
        mergeSort.mergeSort(input);

        System.out.println(Arrays.toString(input));
    }


}
