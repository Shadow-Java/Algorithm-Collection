package sort;

import java.util.Arrays;

/**
 * 排序算法是需要考虑两个问题：稳定性和时间复杂度
 *
 *
 * <p>算法问题：
 *     <ul>
 *         <li>插入排序</li>
 *         <li>选择排序</li>
 *         <li>冒泡排序</li>
 *         <li>归并排序</li>
 *         <li>桶排序</li>
 *         <li>基数排序</li>
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

}
