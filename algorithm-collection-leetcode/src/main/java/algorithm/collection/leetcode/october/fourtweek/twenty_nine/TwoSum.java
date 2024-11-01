package algorithm.collection.leetcode.october.fourtweek.twenty_nine;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    /**
     * 两数之和
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums,int target) {
        Map<Integer,Integer> map = new HashMap<>();
        int[] ans = new int[2];
        for (int i=0;i< nums.length;i++) {
            if(map.containsKey(target-nums[i])) {
                ans[0] = map.get(target-nums[i]);
                ans[1] = i;
                return ans;
            }
            map.put(nums[i],map.getOrDefault(nums[i],i));
        }
        return new int[2];
    }
}
