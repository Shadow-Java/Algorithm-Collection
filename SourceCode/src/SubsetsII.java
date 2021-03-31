package SourceCode.src;

import java.util.*;

/**
 * 给你一个整数数组 nums ，其中可能包含重复元素，请你返回该数组所有可能的子集（幂集）。
 *
 * 解集 不能 包含重复的子集。返回的解集中，子集可以按 任意顺序 排列。
 *
 *  
 *
 */
public class SubsetsII {

    int n;
    List<List<Integer>> result = new LinkedList();
    Stack<Integer> path = new Stack();
    // 加上剪枝操作, 相同层, 如果当前元素与上一个元素相同, 则跳过不遍历以实现剪枝.
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        if(nums.length <= 0) return result;
        n = nums.length;

        // 先排序, 这是很重要的.
        Arrays.sort(nums);

        dfs(nums, 0);

        return result;
    }

    public void dfs(int[] nums, int start){
        result.add(new LinkedList(path));

        for(int i = start; i < n; i++){
            if((i-1)>=start && nums[i-1] == nums[i]) continue;//去重
            path.push(nums[i]);
            dfs(nums, i+1);
            path.pop();
        }
    }




}
