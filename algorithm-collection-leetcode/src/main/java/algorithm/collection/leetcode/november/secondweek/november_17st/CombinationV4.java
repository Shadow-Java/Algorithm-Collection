package algorithm.collection.leetcode.november.secondweek.november_17st;

/**
 * 377. 组合总和 Ⅳ
 * 给定一个数组，选择其中的一些数使其和刚好为target
 */
public class CombinationV4 {

    public int combine(int[] nums, int target) {
        return dp(nums, nums.length-1, target);
    }

    public int dp(int[] nums,int i,int path) {
        if(i < 0) {
            //当没有物品的时候，如果背包容量递归到0，则为一个方案；否则都为0
            //这种场景适合恰好容量为capacity，如果是最大容量，则不用判断path==0
            return path == 0 ? 1 : 0;
        }
        if(nums[i] > path) {
            return dp(nums,i-1,path);
        }
        //这里是完全背包，即选择的数可以重复；如果不能重复则为i-1
        return dp(nums,i-1,path) + dp(nums,i,path-nums[i]);
    }

}
