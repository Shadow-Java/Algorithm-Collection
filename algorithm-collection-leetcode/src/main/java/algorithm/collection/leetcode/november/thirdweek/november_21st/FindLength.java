package algorithm.collection.leetcode.november.thirdweek.november_21st;

import java.util.Arrays;

/**
 * 718. 最长重复子数组
 * 给两个整数数组 nums1 和 nums2 ，返回 两个数组中 公共的 、长度最长的子数组的长度
 *
 * 在解决图或网格相关的算法问题时，是否需要遍历每个起点（即对每个节点调用一次DFS/BFS），还是只需要从某个特定起点调用一次DFS/BFS
 * 1. 只需要一次DFS/BFS的情形
 * 特点：
 *  问题明确指定了一个起点。
 *  目标是基于该起点完成某种计算或搜索，例如：
 *  找到从起点到终点的路径。
 *  计算从起点出发能到达的所有节点。
 *  确定从起点开始的最大深度或最短路径
 *
 *2. 需要遍历每个起点的情形
 * 特点：
 *  问题没有明确指定起点，或者需要考虑所有可能的起点。
 *  目标是基于全局信息完成某种计算或搜索，例如：
 *  计算图中所有连通分量的数量。
 *  找到整个图中的最长路径或最大区域。
 *  检查整个图是否连通
 * 示例问题：
 *  连通分量计数：给定一个无向图，计算图中有多少个连通分量。
 *  岛屿数量问题：给定一个二维网格，计算其中有多少个独立的岛屿。
 *  最长路径问题：在一个图中，找到任意两个节点之间的最长路径
 * @author shadow
 * @create 2025-03-24 21:18
 **/
public class FindLength {

    public int maxLen = 0;

    public int findLength(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        memo = new int[n][m];
        for (int i = 0; i < n; i++) {
            Arrays.fill(memo[i], Integer.MIN_VALUE);
        }
        // 遍历所有可能的起点
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {//正向遍历 也可以反向遍历
                dfs(i, j, nums1, nums2);
            }
        }
        return maxLen;
    }

    public int[][] memo;

    public int dfs(int i, int j, int[] nums1, int[] nums2) {
        if (i >= nums1.length || j >= nums2.length) {//如果一个数组已经结束，则不可能再有公共子串
            return 0;
        }
        if (memo[i][j] != Integer.MIN_VALUE) {
            return memo[i][j];
        }

        int current = 0;
        if (nums1[i] == nums2[j]) {
            current = 1 + dfs(i + 1, j + 1, nums1, nums2); // 继续向后匹配
            maxLen = Math.max(maxLen, current);
        }
        // 不匹配时不递归其他分支（直接返回0）
        memo[i][j] = current;
        return current;
    }

}
