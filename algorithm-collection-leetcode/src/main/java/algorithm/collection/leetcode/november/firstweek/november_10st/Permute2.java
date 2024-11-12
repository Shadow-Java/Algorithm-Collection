package algorithm.collection.leetcode.november.firstweek.november_10st;

import java.util.ArrayList;
import java.util.List;

/**
 * @author shadow
 * @create 2024-11-12 21:02
 **/
public class Permute2 {

    /**
     *
     * @param i      表示树的深度遍历的路径i，从0-2
     * @param nums
     * @param ans
     * @param path
     * @param onPath
     */
    private void dfs(int i,int[] nums, List<List<Integer>> ans, List<Integer> path, boolean[] onPath) {
        if (i == nums.length) {
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
                path.set(i, nums[j]);
                onPath[j] = true; // 表示选择了nums[j]
                dfs(j+1,nums, ans, path, onPath);
                onPath[j] = false; // 恢复现场
                // 注意 path 无需恢复现场，因为排列长度固定，直接覆盖就行
                //如果不固定，append的话才需要恢复现场
            }
        }
    }

    private static void dfs(List<Integer> remaining, List<Integer> path, List<List<Integer>> result) {
        if (remaining.isEmpty()) {
            // 当前路径已经包含了所有元素，添加到结果集中
            result.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < remaining.size(); i++) {
            // 选择当前元素
            int num = remaining.get(i);
            path.add(num);

            // 创建剩余元素的新列表
            //为什么要重新放入
            List<Integer> newRemaining = new ArrayList<>(remaining);
            newRemaining.remove(i);

            // 递归调用，继续生成排列
            dfs(newRemaining, path, result);

            // 撤销选择，回溯
            path.remove(path.size() - 1);
        }
    }

}
