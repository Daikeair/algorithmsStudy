package com.daike.sorted;


import java.util.Arrays;

/**
 * @Author alex.chen
 * @Date 2020-05-28 01:14
 * @Version 1.0
 * 归并排序---分治策略（divide and conquer）
 * Arrays.sort()采用了叫TimSort的排序算法，就是归并排序的优化版本
 * 分治法的三大步骤：
 * 分：大问题分解成小问题----把一个数组拆成两个数组
 * 治：用同样的方法解决小问题-----用归并排序去排这两个数组，不断地分，直到每个数组都变成一个元素，而一个元素可以看成有序，"不治而治"
 * 合：用小问题的解构造大问题的解----将两个排序好的小数组合并成大数组
 * ----base case 当只剩一个元素的时候，无法再分解，直接返回
 */
public class MergeSort {
    /**
     * 将数组array[left] 和 array[right]进行归并排序
     * @param array 被排序的数组
     * @param left   左边界
     * @param right  右边界
     */
    public void mergeSort(int[] array,int left,int right){

        if(array==null || array.length<=1){
            return;
        }
        //归并终止条件left==right，也就是递归到只有一个元素，不治而治，因为单个元素可以看成有序
        if(left<right){

            //【分】：将数组一分为二

            //不用（left+right)/2是为了防止栈溢出类比两杯水的例子*/
            int mid=left+(right-left)/2;

            //【治】：将左边的数组排序(left--->mid)
            mergeSort(array,left,mid);
            //【治】：将右边的数组排序（mid+1-->right）
            mergeSort(array,mid+1,right);

            //【合】：合并两个有序数组
            int[] temp=new int[array.length];//数组必须在这定义长度，不然会溢出。。。。。
            merge(array,left,mid,right,temp);

        }
    }

    /**
     * 将array[left....mid]和array[mid+1....right]两个有序数组合并成一个有序数组
     *
     */
    private void merge(int[] array,int left, int mid, int right,int[] temp) {
        //构建辅助数组，先将数组的值放到辅助数组里面
        temp=new int[right-left+1];

        //定义两个指针，分别从两个有序数组的最左边（小）开始
        int i=left,j=mid+1;
        int k;
        //先通过比较将两个有序数组合并成一个有序数组，暂放在temp数组里
        for (k=left; k <= right; k++) {
            //比较大小，更小的那个依次放入辅助数组
            if(array[i]<=array[j]){
                temp[k]=array[i++];//先赋值再自增~~~也就是自增完后返回自增前的值
            }else{
                temp[k]=array[j++];
            }

        }
        //如果左边的元素取完了（i>mid），则直接copy右边的元素到空数组里,右边数组同理
        while(i<=mid){
            temp[k]=array[i++];
        }
        while(j<=right){
            temp[k]=array[j++];
        }



        //再将已经排好序的辅助数组放回原数组
            for(int m=left;m<=right;m++){
                array[m]=temp[m];
            }
    }


    public static void main(String[] args) {
//        int[] input=new int[1000];
//        for (int i = 0; i < 1000; i++) {
//            int random = (int)(Math.random()*876);
//            input[i]=random;
//        }
        int[] input=new int[]{4,17,8,2,56,9,0,1};

        MergeSort mergeSort = new MergeSort();
        mergeSort.mergeSort(input,0,input.length-1);

        System.out.println(Arrays.toString(input));
    }

}
