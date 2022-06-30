package sort;

/**
 * 插入排序算法
 *
 * 插入排序是阶段性的{@link BubbleSort}，分为一半有序，一半无序<br>
 * 	从1-N-1开始，第i轮a[i]是要插入的值，即要冒泡到0 ~ i-1的值
 * 	如果是从小到大排序，则后面的值必须要小才能往前冒泡
 *
 * @author Shadow at 2022/6/20 22:32
 * @version 1.0.1
 */
public class InsertionSort {

    /**
     * 给定一个数组，返回从小到大的数组
     *
     * @param arr
     */
    public static void insertionSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        //插入排序是阶段性的冒泡，分为一半有序，一半无序
        //从1-N-1开始，第i轮a[i]是要插入的值，即要冒泡到0 ~ i-1的值
        //如果是从小到大排序，则后面的值必须要小才能往前冒泡
        for (int i = 1; i < arr.length; i++) {
            for (int j = i - 1; j >= 0 && arr[j] > arr[j + 1]; j--) {
                swap(arr, j, j + 1);
            }
        }
    }

    public static void swap(int[] arr, int i, int j) {
        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];
    }

}
