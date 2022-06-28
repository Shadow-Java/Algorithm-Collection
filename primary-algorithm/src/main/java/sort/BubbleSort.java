package sort;

/**
 * 冒泡排序算法
 *
 * <ul>冒泡排序算法时间复杂度是O(N^2),有稳定性
 *     <li></li>
 * </ul>
 *
 * @author Shadow at 2022/6/20 21:41
 * @version 1.0.1
 */
public class BubbleSort {

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
     * <p>异或是相同的为0，不同为1；那么可以通过异或解决什么问题？
     *
     * <p>1.二进制层面：
     * <pre>
     *     1^1=0, 1^0=1
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

}
