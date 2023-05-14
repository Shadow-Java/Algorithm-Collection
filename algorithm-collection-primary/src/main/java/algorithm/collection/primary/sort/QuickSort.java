package algorithm.collection.primary.sort;

import algorithm.collection.common.datastruct.array.ArrayRandomGenerator;

/**
 * 采用分而治之的策略
 * 分而治之是一种著名的递归式问题解决方法，例子有快速排序
 * 时间复杂度O（NlogN）
 *
 * 动态规划是将问题分解多个相互依赖的子问题，重复使用子问题的解，减少重复计算，动态规划的核心应该是记忆化搜索
 * 分而治之是将问题划分为多个相互独立的子问题，然后将这些子问题的解结合在一起
 *
 * @author shadow
 * @create 2023-05-08 21:50
 **/
public class QuickSort {


    /**
     * 快速排序分为两部分，一部分是分区，一部分是递归快排
     * 分区：选中一个基准值，将原数组分为左数组（小于基准值）+基准值+右数组（大于基准值）
     * @param num
     * @param low
     * @param high
     */
    public static void quickSort(int[] num, int low, int high){
        if(low < high){
            int pivotIndex = partition(num, low, high);
            quickSort(num,low,pivotIndex-1);
            quickSort(num,pivotIndex+1,high);
        }
    }

    /**
     * 将数组分区，基准值可以用中间值或者第一个值，快速排序的时间复杂度就是选择不同的基准值
     *
     * 最好的情况复杂度：基准值为中间元素或接近中间元素
     * 最坏的情况复杂度：基准值为最大值或者最小值，总是有一个空数组和全数组
     * 平均情况：不出现上述情况，即数据是分散的
     * @param num
     * @param low
     * @param high
     * @return
     */
    public static int partition(int[] num,int low,int high){
        /**
         * 选择最后一个值作为基准值
         * 如果是选择中间值，则与最后一个数进行交换即可
         */
        int pivotIndex = num[high];
        /**
         * 指针指向能够交换的最大值，本来左边是小于基准值，右边是大于基准值；现在pointer记录大于基准值的下标，遍历数组时，如果遇到小于基准值的，则与其交换
         */
        int pointer = low;
        for(int i=low;i<high;i++){
            if(num[i] <= pivotIndex){
                swap(num,pointer,i);
                pointer++;
            }
        }
        /**
         * pointer最后肯定是没有交换的
         */
        swap(num,pointer,high);
        return pointer;
    }

    public static void swap(int[] num,int i,int j){
        int temp = num[i];
        num[i] = num[j];
        num[j] = temp;
    }


    public static void main(String[] args) {
        int[] arr = ArrayRandomGenerator.generateRandomArray(4,7,10);
        ArrayRandomGenerator.printArray(arr);
        quickSort(arr,0,arr.length-1);
        for (int x : arr){
            System.out.print(x+" ");
        }
    }

}
