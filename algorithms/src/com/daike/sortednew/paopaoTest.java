package com.daike.sortednew;


import java.util.Arrays;

/**
 * @Author alex.chen
 * @Date 2020-07-02 23:55
 * @Version 1.0
 *
 * 冒泡排序
 * 时间复杂度O（n^2）
 */
public class paopaoTest {

    public void sorted(int[] input){
        //外层循环轮次
        for (int i = 0; i <input.length-1 ; i++) {
            //里层循环依次比较
            boolean issort=true;
            for (int j = 0; j <input.length-1-i ; j++) {
                int temp=0;
                if(input[j]>input[j+1]){
                    temp=input[j];
                    input[j]=input[j+1];
                    input[j+1]=temp;
                    issort=false;
                }
            }
            //优化！利用flag，第一遍循环flag未变化，如果已经有序，直接结束
            if(issort){
                break;
            }
        }
    }

    //test


    public static void main(String[] args) {

        int[] input=new int[]{4,17,8,2,56,9,0,1};

        paopaoTest paopaoTest = new paopaoTest();
        paopaoTest.sorted(input);

        System.out.println(Arrays.toString(input));

    }
}
