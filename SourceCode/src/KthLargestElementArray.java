package SourceCode.src;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class KthLargestElementArray {


    public static int findKthLargest(int[] nums, int k) {
        Queue<Integer> pq = new PriorityQueue<>();
        for (int num : nums) {
            if(pq.size() < k){
                pq.add(num);
            }
            else if(pq.peek() < num){
                pq.remove();
                pq.add(num);
            }
        }
        return pq.peek();
    }

    //其他思路，插入排序，定义每轮的最大值为num[i],找到最大值替换，取第二个


    /**
     * 错误dp，定义了，每轮的最大值，但得不到理想值
     * @param nums
     * @param k
     * @return
     */
    public int findKthLargest_2(int[] nums, int k) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[0] = nums[0];
        for(int i=1;i<nums.length;i++){
            dp[i] = nums[i];
            if(dp[i-1] < dp[i]){
                dp[i] = Math.max(dp[i-1]+1,dp[i]);
            }else{
                dp[i] = dp[i-1];
            }
        }
        return dp[k];
    }


}
