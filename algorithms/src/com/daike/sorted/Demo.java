package com.daike.sorted;

import java.util.Arrays;

/**
 * @Author alex.chen
 * @Date 2020-05-26 15:44
 * @Version 1.0
 */
public class Demo {


    public static void main(String[] args) {
//        int[] input=new int[100];
//     for (int i = 0; i < 100; i++) {
//            int random = (int)(Math.random()*100);
//            input[i]=random;
//        }

     int[] input=new int[]{0,18,7,9,6,5};
        Demo demo = new Demo();
        demo.quikSort(input);

        System.out.println(Arrays.toString(input));
    }


    public void quikSort(int[] array) {
        recursiveQuikSort(array,0, array.length - 1);
    }

    /**
     *
     * - 递归的快速排序
     *
     * - @param low 数组的最小下标
     * - @param high 数组的最大下标
     */
    private void recursiveQuikSort(int[] array,int low, int high) {
        if (low >= high) {
            return;
        } else {
            int pivot = array[low]; // 以第一个元素为基准
            int partition = partition(array,low, high, pivot);
            // 对数组进行划分，比pivot小的元素在低位段，比pivot大的元素在高位段

            //display();

            recursiveQuikSort(array,low, partition - 1); // 对划分后的低位段进行快速排序
            recursiveQuikSort(array,partition + 1, high); // 对划分后的高位段进行快速排序
        }
    }

    /**
     *
     * - 以pivot为基准对下标low到high的数组进行划分
     *
     * - @param low 数组段的最小下标
     *
     * - @param high 数组段的最大下标
     *
     * - @param pivot 划分的基准元素
     *
     * - @return 划分完成后基准元素所在位置的下标
     */
    private int partition(int[] array,int low, int high, int pivot) {

        while (low < high) {

            while (low < high && array[high] >= pivot) {
                // 从右端开始扫描，定位到第一个比pivot小的元素
                high--;
            }
            swap(array,low, high);

            while (low < high && array[low] <= pivot) {
                // 从左端开始扫描，定位到第一个比pivot大的元素
                low++;
            }
            swap(array,low, high);

        }
        return low;

    }

    /**
     *
     * - 交换数组中两个元素的数据
     - @param low 欲交换元素的低位下标
     - @param high 欲交换元素的高位下标
     */
    private void swap(int[] array,int low, int high) {
        int temp = array[high];
        array[high] = array[low];
        array[low] = temp;
    }
}
