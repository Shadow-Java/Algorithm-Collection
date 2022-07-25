package algorithm.collection.primary.sort;

import java.util.Arrays;

/**
 * 基于比较的排序算法是需要考虑两个问题：稳定性和时间复杂度
 *
 *
 * <p>算法问题：
 *     <ul>
 *         <li>插入排序{@link Sort#insertionSort(int[])}</li>
 *         <li>选择排序{@link Sort#selectionSort(int[])}</li>
 *         <li>冒泡排序{@link Sort#bubbleSort(int[])}</li>
 *         <li>归并排序</li>
 *         <li>快速排序</li>
 *         <li>拓扑排序</li>
 *         <li>堆排序</li>
 *     </ul>
 * </p>
 *
 *
 * <p>
 *     <ul>
 *         <li>比较器</li>
 *     </ul>
 * </p>
 *
 * @see java.util.Arrays#sort(int[]) ;
 * @author Shadow at 2022/6/30 8:03
 * @version 1.0.1
 */
public class Sort {

    /**
     * 需使用比较器 进行是从大到小排序还是从小到大排序
     * @param arr
     */
    public static void localSort(int[] arr){
        Arrays.sort(arr);
    }


    /**
     * 冒泡排序算法
     *
     * <ul>冒泡排序算法时间复杂度是O(N^2),有稳定性
     *     <li></li>
     * </ul>
     */
    public static void bubbleSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        for (int e = arr.length - 1; e > 0; e--) {
            for (int i = 0; i < e; i++) {
                if (arr[i] > arr[i + 1]) {
                    swap(arr, i, i + 1);
                }
            }
        }
    }


    /**
     * 插入排序算法
     *
     * 插入排序是阶段性的{@link Sort#bubbleSort(int[])}，分为一半有序，一半无序<br>
     * 	从1-N-1开始，第i轮a[i]是要插入的值，即要冒泡到0 ~ i-1的值
     * 	如果是从小到大排序，则后面的值必须要小才能往前冒泡
     *
     * 	给定一个数组，返回从小到大的数组
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



    /**
     * 选择排序算法
     *
     * <ul>选择排序的时间复杂度为O(N^2),且是不稳定的
     *     <li>第一个for 从0开始到arr.length - 2</li>
     *     <li>第二个for 从i+1 到arr.length - 1</li>
     *     <li>每一轮从{@code i+1} - {@code arr.length - 1}选择最大的值<strong>位置</strong>与第i个位置交换</li>
     * </ul>
     *
     * 给一个数组,返回{@link java.util.Arrays#sort(int[])}后的数组
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



    /**
     * <p>异或是相同的为0，不同为1；那么可以通过异或解决什么问题？
     *
     * <p>1.二进制层面：
     * <pre>
     *     1^1=0, 1^0=1,0^0=0
     * </pre>
     * <p>2.十进制层面:
     * <pre>一个数和0异或得到本身  和本身异或得到0
     *     n^0=n n^n=0
     * </pre>
     * <ul>3.解决问题层面：
     *     <li>
     *         3.1 比如一群数中找出唯一得数，因为数一般是成群结对的，可以通过异或找到
     *         <pre>
     *             如1,2,3,2,3，找出唯一的数，1^2^3^2^3=(2^2)^(3^3)^1=0^1=1
     *         </pre>
     *     </li>
     *     <li>3.2 比如1-1000放在含有1001个元素的数组中，只有唯一的一个元素值重复，假设这个重复的数字是n，那么现在找出n
     *         <pre>
     *            假设：1^2^3......^n.....^1000=T
     *            而： 1^2^3......^n^n.....^1000 = T^n
     *            则：T^T^n = 0^n = n
     *            思路：先将1-1000异或，然后将1-1001每个数异或，最后将两个结果异或
     *         </pre>
     *     </li>
     *     <li>3.3 交换数组
     *         <pre>
     *             3.3.1 a=a^b;
     *             3.3.2 b=a^b^b=a^(b^b)=a^0=a;
     *             3.3.3 a=a^b^a=b^0=b;
     *         </pre>
     *     </li>
     * </ul>
     *
     *
     *
     * @param arr
     * @param i
     * @param j
     */
    public static void swap(int[] arr, int i, int j) {//交换  i和j不能是同一位置  不然会变为0   两个空间互相导
        arr[i] = arr[i] ^ arr[j];//异或运算，位数不同则为1，相同则为0
        arr[j] = arr[i] ^ arr[j];//10 ^ 01 = 11
        arr[i] = arr[i] ^ arr[j];//最好别这么写  有bug
    }


    public static void swapOther(int[] arr, int i, int j) {
        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];
    }


}
