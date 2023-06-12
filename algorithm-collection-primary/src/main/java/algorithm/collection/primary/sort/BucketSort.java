package algorithm.collection.primary.sort;

import algorithm.collection.common.datastruct.array.ArrayRandomGenerator;

/**
 * 桶排序是一种基于数据状态的排序
 *
 * <ul>
 *     <li>计数排序</li>
 *     <li>基数排序</li>
 * </ul>
 *
 * @author Shadow at 2022/6/30 8:15
 * @version 1.0.1
 */
public class BucketSort {

    /**
     * 计数排序：比如排序一个班的分数，[3,5,7,7,1,2,4]
     * 那么需要申请长度为10的数组，下标表示分数，通过计数，然后依次遍历数组进行打印
     */
    public static void countSort(int[] nums){
        int[] arr = new int[10];
        for(int x : nums){
            arr[x]++;
        }
        for (int i=0;i< arr.length;i++){
            for(int j=0;j<arr[i] && arr[i] != 0;j++){
                System.out.print(i+" ");
            }
        }
    }


    /**
     * 基数排序
     * @param nums
     */
    public static void radixSort(int[] nums){

    }


    public static void main(String[] args) {
        int[] nums = {3,4,5,3,1,3,3,2,6,9};
        ArrayRandomGenerator.printArray(nums);
        countSort(nums);
    }

}
