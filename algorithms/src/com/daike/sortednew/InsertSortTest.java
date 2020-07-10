package com.daike.sortednew;

import com.daike.sorted.InsertSorted;

import java.util.Arrays;

/**
 * @Author alex.chen
 * @Date 2020-07-04 02:43
 * @Version 1.0
 * 插入排序---稳定排序
 * "隔板法"：隔板右边的选择一个数插入隔板左边，和隔板左边的数作比较，找到合适的位置插入
 */
public class InsertSortTest {

    public int[] insertSorted(int[] input){
        if(input==null || input.length<=1){
            return null;
        }
        //隔板位置设在index=0处，因此从右边index=1开始插入到隔板左边
        int temp;
        for (int i = 1; i <input.length ; i++) {
            temp=input[i];
            System.out.println("======"+i);
            int j=i-1;
          while(j>=0 && temp<input[j]){
              //这句很关键，input[j+1]==input[i]且已经赋值给了temp，相当于每判断一次就可以把隔板左边的往右移
              input[j+1]=input[j];
              j--;
          }
          input[j+1]=temp;
        }

    return input;
    }




    //test
    public static void main(String[] args) {

        int[] input=new int[]{4,17,8,2,56,9,0,1};

        int[] sorted = new InsertSortTest().insertSorted(input);

        System.out.println(Arrays.toString(sorted));

    }
}
