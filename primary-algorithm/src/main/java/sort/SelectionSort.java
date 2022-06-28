package sort;

/**
 * 选择排序算法
 *
 * <ul>选择排序的时间复杂度为O(N^2),且是不稳定的
 *     <li>第一个for 从0开始到arr.length - 2</li>
 *     <li>第二个for 从i+1 到arr.length - 1</li>
 *     <li>每一轮从{@code i+1} - {@code arr.length - 1}选择最大的值<strong>位置</strong>与第i个位置交换</li>
 * </ul>
 *
 * @author Shadow at 2022/6/20 21:26
 * @version 1.0.1
 */
public class SelectionSort {

    /**
     * 给一个数组,返回{@link java.util.Arrays#sort(int[])}后的数组
     * 
     * @param arr 数组
     */
    public static void selectionSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        //比如认定第i轮是最大|小的值，然后选择i+1~N-1的最大|小的值跟第i轮比较 然后替换
        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;
            //arr[i]是当前最小的值 arr[j]是第i+1 ~ N-1的最小值
            for (int j = i + 1; j < arr.length; j++) {
                if(arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            swap(arr, i, minIndex);
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
    
}
