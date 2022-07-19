package src;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
 *
 * 输入: [3,2,1,5,6,4] 和 k = 2
 * 输出: 5
 */
public class KthLargestElementArray {

    /**
     * 优先队列：默认是小顶堆，可以使用Comparator实现大顶堆
     * 最大优先队列，无论入队顺序，当前最大的元素优先出队。
     * 最小优先队列，无论入队顺序，当前最小的元素优先出队。
     *
     *
     * 二叉堆：
     * 最大堆的堆顶是整个堆中的最大元素
     * 最小堆的堆顶是整个堆中的最小元素
     *
     * 那么可以利用二叉堆实现最大优先队列，每次入队操作就是插入操作，每一次出队操作就是删除堆顶节点
     * @param nums
     * @param k
     * @return
     */
    public static int findKthLargest(int[] nums, int k) {//小顶堆
        Queue<Integer> pq = new PriorityQueue<>();
        for (int num : nums) {
            if(pq.size() < k){//只留三个元素在堆中，返回顶首元素则是第k大元素
                pq.add(num);
            }
            else if(pq.peek() < num){//其他元素与队首元素比较，如果小则删除，再加入新节点
                pq.remove();
                pq.add(num);
            }
        }
        return pq.peek();//只保留k个元素，顶首元素则是第k大
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
