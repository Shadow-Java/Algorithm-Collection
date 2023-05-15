package algorithm.collection.leetcode.hash;

import java.util.HashSet;
import java.util.Set;

/**
 * 2441. 与对应负数同时存在的最大正整数
 *
 * 给你一个 不包含 任何零的整数数组 nums ，找出自身与对应的负数都在数组中存在的最大正整数 k 。
 *
 * 返回正整数 k ，如果不存在这样的整数，返回 -1
 *
 * @author shadow
 * @create 2023-05-15 00:08
 **/
public class FindMaxK {

    /**
     * 使用哈希表s记录数组中出现的所有元素，用一个变量记录要求的最大值
     * @param nums
     * @return
     */
    public int findMaxK(int[] nums) {
        int ans = -1;
        Set<Integer> s = new HashSet<>();
        for (int x : nums) {
            s.add(x);
        }
        for (int x : s) {
            if (s.contains(-x)) {
                ans = Math.max(ans, x);
            }
        }
        return ans;
    }

}
