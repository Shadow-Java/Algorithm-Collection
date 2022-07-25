package intermittent.lying.continuous.progress.deprecated;

import java.util.*;

/**
 * 给你一个整数数组 arr 。请你将数组中的元素按照其二进制表示中数字 1 的数目升序排序。
 *
 * 如果存在多个数字二进制中 1 的数目相同，则必须将它们按照数值大小升序排列。
 *
 * 请你返回排序后的数组。
 *
 * 输入：arr = [0,1,2,3,4,5,6,7,8]
 * 输出：[0,1,2,4,8,3,5,6,7]
 * 解释：[0] 是唯一一个有 0 个 1 的数。
 * [1,2,4,8] 都有 1 个 1 。
 * [3,5,6] 有 2 个 1 。
 * [7] 有 3 个 1 。
 * 按照 1 的个数排序得到的结果数组为 [0,1,2,4,8,3,5,6,7]
 *
 */
public class SortIntegersTheNumberBits {
    //暴力解法一
    public int[] sortByBits(int[] arr) {//加入list，排序利用集合的compare
        int[] bit = new int[10001];
        List<Integer> list = new ArrayList<Integer>();//可以排序的间接数组
        for (int x : arr) {
            list.add(x);
            bit[x] = get(x);
        }
        Collections.sort(list, new Comparator<Integer>() {
            public int compare(Integer x, Integer y) {
                if (bit[x] != bit[y]) {
                    return bit[x] - bit[y];
                } else {
                    return x - y;
                }
            }
        });
        for (int i = 0; i < arr.length; ++i) {
            arr[i] = list.get(i);
        }
        return arr;
    }

    public int get(int x) {//利用十进制转二进制统计1的个数
        int res = 0;
        while (x != 0) {
            res += x % 2;
            x /= 2;
        }
        return res;
    }

    /**
     * 暴力解法二
     * Integer.bitCount统计1的个数，求余的10000000必须比arr[i]大
     * @param arr
     * @return
     */
    public int[] sortByBits_2(int[] arr) {
        int[] res = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            res[i] = Integer.bitCount(arr[i]) * 10000000 + arr[i];
        }
        Arrays.sort(res);//自带的排序函数
        for (int i = 0; i < res.length; i++) {
            res[i] = res[i] % 10000000;//求余得arr[i]
        }
        return res;
    }


}
