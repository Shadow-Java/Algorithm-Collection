import algorithm.collection.primary.sort.Sort;

import java.util.Arrays;
import java.util.Random;

/**
 * @author Shadow at 2022/6/20 22:36
 * @version 1.0.1
 */
public class SortTest {

    private static int[] nums = generateRandomArray(10,15,100);

    public static void main(String[] args) {
        System.out.println(comparator(500000,5,100,100) ?
                "------------------你写的算法是正确的！" : "--------------你写的算法是错误的！");

        System.out.println("--------------------原长度为"+nums.length+" 数组：-------------");
        printArray(nums);
        System.out.println("--------------------数组长度为"+nums.length+" 排序后：-------------");
        Sort.bubbleSort(nums);
        printArray(nums);
    }


    /**
     * 比较器，用于比较目标算法是否正确
     * 目标测试排序算法{@code BubbleSort.bubbleSort(arr)}
     *
     * @param testTime   测试的次数  500000
     * @param maxSize    数组的最大长度  100
     * @param maxValue   数组的最大值   100
     * @return
     */
    public static Boolean comparator(int testTime,int minSize,int maxSize,int maxValue){
        for (int i = 0; i < testTime; i++) {
            int[] arr1 = generateRandomArray(minSize,maxSize, maxValue);
            int[] arr2 = copyArray(arr1);
            Sort.selectionSort(arr1);//目标测试函数
            successSort(arr2);
            if (!isEqual(arr1, arr2)) {
                return false;
            }
        }
        return true;
    }

    /**
     * 随机生成[minsize---maxsize]长度的数组
     * @param minSize    最小长度的数组 不能为负
     * @param maxSize    最大长度数组
     * @param maxValue   数组元素最大值
     * @return
     */
    public static int[] generateRandomArray(int minSize,int maxSize, int maxValue) {
        Random randomUtil = new Random();
        int random = randomUtil.nextInt(maxSize-minSize)+minSize;
        int[] arr = new int[random];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) ((maxValue + 1) * Math.random()) - (int) (maxValue * Math.random());
        }
        return arr;
    }

    /**
     * 数组拷贝
     *
     * @param arr
     * @return
     */
    public static int[] copyArray(int[] arr) {
        if (arr == null) {
            return null;
        }
        int[] res = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            res[i] = arr[i];
        }
        return res;
    }

    /**
     * 两个数组的值判断是否相等
     *
     * @param arr1  源数组
     * @param arr2  目标数组
     * @return
     */
    public static boolean isEqual(int[] arr1, int[] arr2) {
        if ((arr1 == null && arr2 != null) || (arr1 != null && arr2 == null)) {
            return false;
        }
        if (arr1 == null && arr2 == null) {
            return true;
        }
        if (arr1.length != arr2.length) {
            return false;
        }
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }
        return true;
    }

    /**
     * 打印数组
     *
     * @param arr
     */
    public static void printArray(int[] arr) {
        if (arr == null) {
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void successSort(int[] arr) {
        Arrays.sort(arr);
    }

}
