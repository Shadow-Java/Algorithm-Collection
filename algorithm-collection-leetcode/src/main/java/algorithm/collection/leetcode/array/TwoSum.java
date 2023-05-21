package algorithm.collection.leetcode.array;

import java.util.HashMap;
import java.util.Map;

/**
 * 1.two sum
 * 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target  的那 两个 整数，并返回它们的数组下标。
 *
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
 *
 * 你可以按任意顺序返回答案。
 *
 * 输入：nums = [2,7,11,15], target = 9
 * 输出：[0,1]
 * 解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。
 *
 * 输入：nums = [3,2,4], target = 6
 * 输出：[1,2]
 *

 * @author shadow
 * @create 2023-05-18 00:13
 **/
public class TwoSum {

    private Map<Integer,Integer> hashMap = new HashMap<>();

    /**
     * 记忆化搜索，即我要搜索的target-i，在i后面，那么边查边搜索(在当前的i上，搜索i之前的数据)，且hash搜索只有O（1）<br/>
     * 如果不用记忆化搜索，那么需要O(N^2)
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        for(int i=0;i<nums.length;i++){
            if(hashMap.containsKey(target-nums[i])){
                return new int[]{hashMap.get(target - nums[i]),i};
            }
            hashMap.put(nums[i],i);
        }
        return new int[0];
    }

}
