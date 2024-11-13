package algorithm.collection.leetcode.november.secondweek.november_11st;

import java.util.ArrayList;
import java.util.List;

/**
 * 78. 子集
 * 给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。
 *
 * 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。
 *
 * 输入：nums = [1,2,3]
 * 输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
 *
 * 输入：nums = [0]
 * 输出：[[],[0]]
 *
 * @author shadow
 * @create 2024-11-11 22:22
 **/
public class Subsets {


    /**
     * 回溯：
     *    1.子集型回溯(子集型有序且用选或者不选)  比如17. 电话号码的字母组合   78.子集   01背包问题也算一种子集型回溯；
     *         每个元素都可以选或者不选，枚举第i个数选他还是不选他
     *    2.组合型回溯（）：是有顺序的   77. 组合  216.组合总和  22.括号生成
     *    3.排序型回溯（使用visited）：没有顺序的
     *
     * 排序型回溯和组合型回溯的区别：
     *     对于数组[1,2,3]： [1,2]和[2,1]是认为一样的组合，但排序是[1,2,3]和[2,1,3]是不同的排序；即组合只能固定一个数，一直往后找，不嫩往当前位置之前找
     *     那么求数组[1,2,3]的所有组合和所有全排序解法
     * @param nums
     * @return
     */
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<Integer>());
        preOrder(nums,0,new ArrayList<>(),res);
        return res;
    }

    List<List<Integer>> res2 = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    int[] nums = new int[10];
    int n = nums.length;
    public void dp(int i) {
        if(i == n) {//因为可以不用选，所以得长度为n才保存答案
            res2.add(new ArrayList<>(path));
            return;
        }
        dp(i+1);//如果当前元素不选
        path.add(nums[i]);//当前元素选
        dp(i+1);//选了之后直接枚举下一个元素，不用使用for
        //恢复现场，因为是在路径之后添加元素，那么递归之前怎么样递归之后就是什么样
        //所以在返回之前，需要恢复到之前的样子
        //比如这次考虑了2，那么下次得把2弹出
        path.remove(path.size()-1);
    }

    /**
     * 站在答案的视角，每次必须选择一个数；
     * [1,2]和[2,1]是同一个子集，所以不考虑顺序，那么定义一个顺序为从小到大（严格递增）
     * @param i
     */
    public void dp_V2(int i) {
        res2.add(new ArrayList<>(path));//子集长度没有约束，递归到的每个节点都是答案
        for (int j=i;j< nums.length;j++) {
            path.add(nums[j]);//当前元素选
            dp(j+1);//选了之后直接枚举下一个元素，不用使用for
            //恢复现场，因为是在路径之后添加元素，那么递归之前怎么样递归之后就是什么样
            //所以在返回之前，需要恢复到之前的样子
            //比如这次考虑了2，那么下次得把2弹出
            path.remove(path.size()-1);
        }
    }


    public static List<List<Integer>> subsets_V2(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(nums, 0, new ArrayList<>(), result);
        return result;
    }

    /**
     * 防止[1,3]和[3,1]重复，所以定义一个顺序，以数字递增的方向
     */
    private static void backtrack(int[] nums, int start, List<Integer> path, List<List<Integer>> result) {
        // 每次递归调用时，当前路径都是一个有效的子集，添加到结果集中
        result.add(new ArrayList<>(path));

        for (int i = start; i < nums.length; i++) {
            // 选择当前元素
            path.add(nums[i]);

            // 递归调用，继续生成包含当前元素的子集
            backtrack(nums, i + 1, path, result);

            // 撤销选择，回溯
            path.remove(path.size() - 1);
        }
    }

    /**
     * 循环枚举
     */
    public static List<List<Integer>> enumerate(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        res.add(new ArrayList<Integer>());
        for (Integer n : nums) {
            int size = res.size();
            for (int i = 0; i < size; i++) {
                List<Integer> newSub = new ArrayList<Integer>(res.get(i));
                newSub.add(n);
                res.add(newSub);
            }
        }
        return res;
    }

    /**
     * 递归枚举
     */
    public static void recursion(int[] nums, int i, List<List<Integer>> res) {
        if (i >= nums.length) return;
        int size = res.size();
        for (int j = 0; j < size; j++) {
            List<Integer> newSub = new ArrayList<Integer>(res.get(j));
            newSub.add(nums[i]);
            res.add(newSub);
        }
        recursion(nums, i + 1, res);
    }

    /**
     * DFS，前序遍历
     */
    public static void preOrder(int[] nums, int i, ArrayList<Integer> subset, List<List<Integer>> res) {
        if (i >= nums.length) return;
        // 到了新的状态，记录新的路径，要重新拷贝一份
        subset = new ArrayList<Integer>(subset);

        // 这里
        res.add(subset);
        preOrder(nums, i + 1, subset, res);
        subset.add(nums[i]);
        preOrder(nums, i + 1, subset, res);
    }

    /**
     * DFS，中序遍历
     */
    public static void inOrder(int[] nums, int i, ArrayList<Integer> subset, List<List<Integer>> res) {
        if (i >= nums.length) return;
        subset = new ArrayList<Integer>(subset);

        inOrder(nums, i + 1, subset, res);
        subset.add(nums[i]);
        // 这里
        res.add(subset);
        inOrder(nums, i + 1, subset, res);
    }

    /**
     * DFS，后序遍历
     */
    public static void postOrder(int[] nums, int i, ArrayList<Integer> subset, List<List<Integer>> res) {
        if (i >= nums.length) return;
        subset = new ArrayList<Integer>(subset);

        postOrder(nums, i + 1, subset, res);
        subset.add(nums[i]);
        postOrder(nums, i + 1, subset, res);
        // 这里
        res.add(subset);
    }

}
