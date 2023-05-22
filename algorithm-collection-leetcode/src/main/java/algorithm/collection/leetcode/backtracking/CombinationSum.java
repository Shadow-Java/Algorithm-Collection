package algorithm.collection.leetcode.backtracking;


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
     * 需要弄清楚递归的内存分配，每个变量是怎样存储的
     * @param i
     * @param candidates
     * @param res
     * @param target
     * @param list
     * @param ans
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


    private void dfs(int[] arr,int begin,int target,int sum,List<Integer> path,List<List<Integer>> res){
        // 终止条件
        if(sum > target){
            return ;
        }

        if(sum == target){
            res.add(new ArrayList<Integer>(path));  // 这里要新拷贝一个 list ，放入 res 中，避免 res 中引用同一个元素；
            return ;
        }

        for(int i = begin;i<arr.length;i++){  //从begin 开始，使用当前元素及比当前元素大的（前面使用排序的作用在于此）
            path.add(arr[i]);
            //  对 i 节点进行深度优先搜索，但只能从 i 及比 i 大的位置开始；避免{1，2，3}，{1，3，2} 的情况
            dfs(arr,i,target,sum+arr[i],path,res);
            path.remove(path.size()-1);  // 回溯
        }
        return ;
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
