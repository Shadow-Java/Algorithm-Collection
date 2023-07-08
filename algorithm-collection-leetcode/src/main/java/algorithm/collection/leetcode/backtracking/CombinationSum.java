package algorithm.collection.leetcode.backtracking;


import algorithm.collection.common.datastruct.tag.AlgorithmCategory;
import algorithm.collection.common.datastruct.tag.DataStructType;
import algorithm.collection.common.datastruct.tag.DifficultyLevel;
import algorithm.collection.common.datastruct.tag.QuestionTag;
import algorithm.collection.common.datastruct.tag.TimeComplexity;
import algorithm.collection.leetcode.slidingwindow.PermutationString;
import algorithm.collection.leetcode.tree.dfs.MaxDepth;
import algorithm.collection.primary.tree.DeepWidthSearch;

import java.util.ArrayList;
import java.util.List;

/**
 * 39. 组合总和
 * 给你一个 无重复元素 的整数数组candidates 和一个目标整数target，找出candidates中可以使数字和为目标数target 的 所有不同组合 ，并以列表形式返回。你可以按 任意顺序 返回这些组合。
 *
 * candidates 中的 同一个 数字可以 无限制重复被选取 。如果至少一个数字的被选数量不同，则两种组合是不同的
 *
 * 输入：candidates = [2,3,6,7], target = 7
 * 输出：[[2,2,3],[7]]
 *
 * 输入: candidates = [2,3,5], target = 8
 * 输出: [[2,2,2,2],[2,3,3],[3,5]]
 *
 * @author shadow
 * @create 2023-05-18 00:26
 **/
@QuestionTag(
        questionNumber = "39",
        questionTitle = "组合总和",
        relevateClass = {PermutationString.class, MaxDepth.class, DeepWidthSearch.class},
        difficultyLeve = DifficultyLevel.MEDIUM,
        desc = "给你一个 无重复元素 的整数数组candidates 和一个目标整数target，找出candidates中可以使数字和为目标数target 的 所有不同组合 ，并以列表形式返回。你可以按 任意顺序 返回这些组合",
        questionLink = "https://leetcode.cn/problems/combination-sum/",
        algorithmCategory = AlgorithmCategory.DEPTH_FIRST_SEARCH,
        timeComplexity = TimeComplexity.O_N_LOG_N,
        dataStructTypes = {DataStructType.UNIVERSAL_STACK}
)
public class CombinationSum {

    /**
     * label:back tracking
     *
     * 类似于全排列的回溯，是个树结构
     *
     * @param candidates
     * @param target
     * @return
     */
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        f(0,candidates,0,target,list,ans);
        return ans;
    }

    /**
     * 需要弄清楚递归的内存分配，每个变量是怎样存储的<br/>
     * 回溯算法一般都会重复列举，需要剪支
     * @param i             第几个开始排列
     * @param candidates    数组入参
     * @param res           list的总和
     * @param target        目标值
     * @param list          回溯的每个list
     * @param ans           结果合集，即所有满足list的总和
     */
    private static void f(int i,int[] candidates,int res,int target,List<Integer> list,List<List<Integer>> ans){
        if(res > target){
            return;
        }else if(res == target){
            ans.add(new ArrayList<>(list));
            return;
        }
        /**
         * TODO 这种每次都指定了(0,n-1)的写法有什么不同
         * 1.比如数组[2,3,6,7]，[2,2,3]、[2,3,2]是相同的，需要解决重复的组合
         * 2.利用后两个约束条件做剪枝，较为简单，设置递归出口如下if (sum >= target)
         * 3.利用栈结构
         */
        for(int j=0;j<candidates.length;j++){
            if(res+candidates[j] > target){
                break;
            }
            list.add(candidates[i]);
            f(j,candidates,res+candidates[i],target,list,ans);
            list.remove(list.size()-1);
        }
    }


    /**
     * 从结点begin开始深度遍历分支，即一个分支一个list，如果list满足结果要求则加入ans
     * 空间复杂度：栈的深度 O(target)
     * @param arr      无重复且排序后的数组
     * @param begin    深度遍历开始的节点
     * @param target   目标值
     * @param sum      path的实时总和
     * @param path     遍历的路径
     * @param res      满足target结果的总和
     */
    private void dfs(int[] arr,int begin,int target,int sum,List<Integer> path,List<List<Integer>> res){
        // 终止条件
        if(sum > target){
            return ;
        }

        if(sum == target){
            res.add(new ArrayList<Integer>(path));  // 这里要新拷贝一个 list ，放入 res 中，避免 res 中引用同一个元素；
            return ;
        }
        /**
         * 注：这里使用begin有个奇妙的用法，比如数组[2,3,6,7],当使用2后，下一步只能使用3，即只会出现[2,2,3] 不会出现[2,3,2]的情况
         */
        for(int i = begin;i<arr.length;i++){  //从begin 开始，使用当前元素及比当前元素大的（前面使用排序的作用在于此）
            path.add(arr[i]);
            /**
             * 对 i 节点进行深度优先搜索，但只能从 i 及比 i 大的位置开始；避免{1，2，3}，{1，3，2} 的情况<br/>
             * 为什么是深度优先：从begin结点开始，一直在分支上向下遍历
             */
            dfs(arr,i,target,sum+arr[i],path,res);
            path.remove(path.size()-1);  // 回溯
        }
    }

    public static void main(String[] args) {
        int[] nums = {2,3,6,7};
        int target = 7;
        List<List<Integer>> ans = combinationSum(nums,target);
        ans.forEach(list -> {
            list.forEach(x->{
                System.out.print(x+" ");
            });
            System.out.println("");
        });
    }

}
