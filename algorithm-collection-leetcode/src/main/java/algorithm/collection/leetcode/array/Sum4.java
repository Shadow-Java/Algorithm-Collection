package algorithm.collection.leetcode.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 18. 四数之和
 * 给你一个由 n 个整数组成的数组nums ，和一个目标值 target 。请你找出并返回满足下述全部条件且不重复的四元组[nums[a], nums[b], nums[c], nums[d]]（若两个四元组元素一一对应，则认为两个四元组重复）
 *
 *
 * @author shadow
 * @create 2023-05-18 00:16
 **/
public class Sum4 {

    /**
     * 主要考验剪枝，还有就是左右指针（排序后的两数和为target算法类似）
     * @param nums
     * @param target
     * @return
     */
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length < 4)
            return res;

        Arrays.sort(nums);
        int n = nums.length;

        for (int i = 0; i < n - 3; i++) {
            // 去重：跳过相同的 i
            if (i > 0 && nums[i] == nums[i - 1])
                continue;

            // 剪枝：如果最小可能和已经大于 target，直接 break
            if ((long) nums[i] + nums[i + 1] + nums[i + 2] + nums[i + 3] > target)
                break;
            // 剪枝：如果最大可能和还小于 target，跳过
            if ((long) nums[i] + nums[n - 1] + nums[n - 2] + nums[n - 3] < target)
                continue;

            for (int j = i + 1; j < n - 2; j++) {
                // 去重：跳过相同的 j
                if (j > i + 1 && nums[j] == nums[j - 1])
                    continue;

                // 剪枝：最小和大于 target
                if ((long) nums[i] + nums[j] + nums[j + 1] + nums[j + 2] > target)
                    break;
                // 剪枝：最大和小于 target
                if ((long) nums[i] + nums[j] + nums[n - 1] + nums[n - 2] < target)
                    continue;

                int l = j + 1, r = n - 1;
                while (l < r) {
                    long sum = (long) nums[i] + nums[j] + nums[l] + nums[r];
                    if (sum == target) {
                        res.add(Arrays.asList(nums[i], nums[j], nums[l], nums[r]));

                        // 去重 l、r
                        while (l < r && nums[l] == nums[l + 1])
                            l++;
                        while (l < r && nums[r] == nums[r - 1])
                            r--;

                        l++;
                        r--;
                    } else if (sum < target) {
                        l++;
                    } else {
                        r--;
                    }
                }
            }
        }
        return res;
    }
}
