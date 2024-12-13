package algorithm.collection.leetcode.november.secondweek.november_11st;

import java.util.ArrayList;
import java.util.List;

/**
 * 77. 组合
 *
 * 给定两个整数 n 和 k，返回范围 [1, n] 中所有可能的 k 个数的组合。
 *
 * 你可以按 任何顺序 返回答案。
 *
 * 输入：n = 4, k = 2
 * 输出：
 * [
 *   [2,4],
 *   [3,4],
 *   [2,3],
 *   [1,2],
 *   [1,3],
 *   [1,4],
 * ]
 *
 *
 * 输入：n = 1, k = 1
 * 输出：[[1]]
 *
 * 时间复杂度：k*Cn(k)   路径长度*叶子长度
 *
 * @author shadow
 * @create 2024-11-12 22:23
 **/
public class Combine {

    /**
     *
     * @param n
     * @param k
     * @return
     */
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ans = new ArrayList<>();
        dfs(0,k,new ArrayList<>(),ans);
        return ans;
    }

    /**
     *                []
     *            /   |   \
     *          3     2    1
     *        /  \     \
     *      [3,2] [3,1] [2,1](因为选的长度为三，后面不可能再能有选择了)
     *      /
     *    [3,2,1]
     *
     * 设path长为m，那么还需要选d=k-m个数，设当前需要从[1,i]中取数，如果i<d,那么最后无法选出k个数，所以不需要递归
     */
    public void dfs(int i,int k,List<Integer> path,List<List<Integer>> ans) {
        int d = k - path.size();
        if(i < d) {//剪枝
           return;
        }
        if(path.size() == k) {
            ans.add(new ArrayList<>(path));
            return;
        }
        /**
         * 为什么组合型是倒着枚举？
         * 正序枚举也能剪枝，k-当前长度 > 总长度-当前索引+1
         */
        for (int j = i;j >=0;j--) {
            path.add(j);
            dfs(j-1,k,path,ans);
            path.remove(path.size()-1);
        }
    }

    public void backtrack(int n,int k,int start, List<Integer> path, List<List<Integer>> result) {
        if(path.size() == k) {
            result.add(new ArrayList<>(path));
        }
        /**
         * 组合和子集都是单调有序的，所以从start开始遍历；
         * 但是排序型需要从0开始遍历，且需要加visited数组
         */
        for (int i = start; i <= n; i++) {
            // 选择当前元素
            path.add(i);

            // 递归调用，继续生成包含当前元素的子集
            backtrack(n, k,i + 1, path, result);

            // 撤销选择，回溯
            path.remove(path.size() - 1);
        }
    }

}
