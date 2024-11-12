package algorithm.collection.leetcode.november.secondweek.november_11st;

import java.util.ArrayList;
import java.util.List;

/**
 * 216. 组合总和 III
 * 找出所有相加之和为 n 的 k 个数的组合，且满足下列条件：
 *
 * 只使用数字1到9 每个数字 最多使用一次 ；返回 所有可能的有效组合的列表 。该列表不能包含相同的组合两次，组合可以以任何顺序返回。
 *
 * 输入: k = 3, n = 7
 * 输出: [[1,2,4]]
 * 解释:
 * 1 + 2 + 4 = 7
 * 没有其他符合的组合了。
 *
 * 输入: k = 3, n = 9
 * 输出: [[1,2,6], [1,3,5], [2,3,4]]
 * 解释:
 * 1 + 2 + 6 = 9
 * 1 + 3 + 5 = 9
 * 2 + 3 + 4 = 9
 * 没有其他符合的组合了。
 *
 *
 * 输入: k = 4, n = 1
 * 输出: []
 * 解释: 不存在有效的组合。
 * 在[1,9]范围内使用4个不同的数字，我们可以得到的最小和是1+2+3+4 = 10，因为10 > 1，没有有效的组合。
 *
 *
 * @author shadow
 * @create 2024-11-12 23:02
 **/
public class CombinationSum3 {

    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ans = new ArrayList<>();
        dfs(9,n,k,new ArrayList<>(),ans);
        return new ArrayList<>();
    }

    public void dfs(int i,int sum,int k,List<Integer> path,List<List<Integer>> ans) {
        int d = sum - path.size();
        if(sum < 0 || sum > (i*2 -d +1) *d /2) {//剪枝
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
            dfs(j-1,sum-j,k,path,ans);
            path.remove(path.size()-1);
        }
    }

}
