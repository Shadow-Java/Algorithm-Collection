package algorithm.collection.leetcode.november.firstweek.november_10st;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * 46. 全排列
 * 给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。
 *
 * 输入：nums = [1,2,3]
 * 输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 *
 * 输入：nums = [0,1]
 * 输出：[[0,1],[1,0]]
 *
 * 输入：nums = [1]
 * 输出：[[1]]
 *
 * @author shadow
 * @create 2024-11-11 22:18
 **/
public class Permute {

    public static void main(String[] args) {
        int[] nums = {1,2,3};
        Permute permute = new Permute();
        permute.permute(nums);
    }


    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> path = new ArrayList<>(); // 所有排列的长度都是一样的 n
        boolean[] visited = new boolean[nums.length];
        dfs(nums, ans, path, visited);
        return ans;
    }

    /**
     * 相当于从空的顶点进入，子节点就是for (int j = 0; j < nums.length; j++),然后通过onPath去过滤已经访问的路径
     * @param nums
     * @param ans
     * @param path
     * @param onPath
     */
    private void dfs(int[] nums, List<List<Integer>> ans, List<Integer> path, boolean[] onPath) {
        if (path.size() == nums.length) {
            //因为需要恢复现场，回退path，所以需要拷贝一份；不拷贝最后path会为空
            ans.add(new ArrayList<>(path));
            return;
        }
        for (int j = 0; j < nums.length; j++) {
            if (!onPath[j]) {
                /**
                 * path.set(i, nums[j]); 如果是定长则使用覆盖，就不用恢复现场；
                 * 如果是path.add(nums[j]);则需要恢复现场
                 */
                path.add(nums[j]);
                onPath[j] = true; // 表示选择了nums[j]
                dfs(nums, ans, path, onPath);
                onPath[j] = false; // 恢复现场
                // 注意 path 无需恢复现场，因为排列长度固定，直接覆盖就行
                //如果不固定，append的话才需要恢复现场
                path.remove(path.size()-1);
            }
        }
    }




    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    HashSet<Integer> hs = new HashSet<>();
    int[] nums;
    public List<List<Integer>> permute_V2(int[] nums) {
        this.nums = nums;
        for (int num : nums) {
            hs.add(num);
        }
        dfs_V2(0,hs);
        return ans;
    }

    /**
     *
     * @param i   应该表示树的深度遍历的路径i
     * @param hs  使用剩余元素作为标记，不再使用on_path作为标记
     */
    private void dfs_V2(int i, HashSet<Integer> hs){
        if(i == nums.length){
            ans.add(new ArrayList<>(path));
            return;
        }

        for (Integer h : hs) {
            path.add(h);
            HashSet<Integer> t = new HashSet<>(hs);
            t.remove(h);
            dfs_V2(i + 1,t);
            path.remove(h);
        }
    }




}
