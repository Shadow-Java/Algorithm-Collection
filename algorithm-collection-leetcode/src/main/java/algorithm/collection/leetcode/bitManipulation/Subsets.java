package algorithm.collection.leetcode.bitManipulation;

import algorithm.collection.common.datastruct.tag.AlgorithmCategory;
import algorithm.collection.common.datastruct.tag.DataStructType;
import algorithm.collection.common.datastruct.tag.DifficultyLevel;
import algorithm.collection.common.datastruct.tag.MethodTag;
import algorithm.collection.common.datastruct.tag.QuestionTag;
import algorithm.collection.common.datastruct.tag.TimeComplexity;
import algorithm.collection.primary.tree.DeepWidthSearch;

import java.util.ArrayList;
import java.util.List;

/**
 * 给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）
 * 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。
 *
 * 输入：nums = [1,2,3]
 * 输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
 *
 * 输入：nums = [0]
 * 输出：[[],[0]]
 * @author shadow
 * @create 2023-05-18 00:37
 **/
@QuestionTag(
        difficultyLeve = DifficultyLevel.EASY,
        questionNumber = "78",
        questionTitle = "子集",
        relevateClass = DeepWidthSearch.class,
        desc = "给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）",
        questionLink = "https://leetcode.cn/problems/subsets/",
        algorithmCategory = AlgorithmCategory.BIT_MANIPULATION,
        timeComplexity = TimeComplexity.O_N_2,
        dataStructTypes = {DataStructType.ARRAY_LIST}
)
public class Subsets {


    /**
     * 集合的每个元素，都有可以选或不选，用二进制和位运算，可以很好的表示<br/>
     * 进制的0可以写成0000，代表一个数也不取，1=0001表示去第一个数也就是[1]，2=0010，表示取第二个数[2]，3=0011表示取1和2位[1,2]，4=0100表示[3]....15=1111表示[1,2,3,4]
     * @param nums
     * @return
     */
    @MethodTag(
            questionNumber = "78",
            methodLink = "https://leetcode.cn/problems/subsets/solutions/7683/er-jin-zhi-wei-zhu-ge-mei-ju-dfssan-chong-si-lu-9c/",
            timeComplexity = TimeComplexity.O_N_2,
            dataStructType = DataStructType.ARRAY_LIST,
            algorithmCategory = AlgorithmCategory.BIT_MANIPULATION
    )
    public static List<List<Integer>> binaryBit(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        /**
         * 1 << nums.length表示有多少种组合，比如nums.length=3,则有2^3=8
         */
        for (int i = 0; i < (1 << nums.length); i++) {
            List<Integer> sub = new ArrayList<>();
            /**
             * 从数组中选择第几个数
             */
            for (int j = 0; j < nums.length; j++) {
                /**
                 * 比如现在第i=2=0010,意味着不放第一个数，需要放第二个数，j表示数组中的第几个数，当j=0时，(i >> j)是0010向右移动0位，判断是否是1，是的话则需要插入
                 * 当j=1时，(i >> j)=0001，&1后就知道当前数需要加入list
                 */
                if (((i >> j) & 1) == 1) {
                    sub.add(nums[j]);
                }
            }
            res.add(sub);
        }
        return res;
    }

    /**
     * 暴力枚举
     * 1.当数组为[1]时：[],[1]  个数：1<<nums.length=2^1=2
     * 2.当数组为[1,2]时：[],[1],[2],[1,2]  个数：1<<nums.length=2^2=4  解释：相当于在1的每个枚举中添加2
     * 3.当数组为[1,2,3]时:[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]  个数：1<<nums.length=2^3=8  解释：相当于在2的每个枚举中添加3
     * 4.当数组为[1,2,3,4]时：....忽略  个数：1<<nums.length=2^4=16 解释：相当于在3的每个枚举中添加4
     * @param nums
     * @return
     */
    @MethodTag(
            questionNumber = "78",
            methodLink = "https://leetcode.cn/problems/subsets/solutions/7683/er-jin-zhi-wei-zhu-ge-mei-ju-dfssan-chong-si-lu-9c/",
            timeComplexity = TimeComplexity.O_N_2_N_1,
            dataStructType = DataStructType.ARRAY_LIST,
            algorithmCategory = AlgorithmCategory.BIT_MANIPULATION
    )
    public static List<List<Integer>> enumerate(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        //开始数组为空
        ans.add(new ArrayList<>());
        for (int x : nums){
            //上一轮的个数，即我对将新增的数加入上之前的轮次中
            int size = ans.size();
            for(int j=0;j< size;j++){
                //比如之前的数组为[1,2,3],新增4，那么ans.get(cur)的索引应该为2^3
                List<Integer> list = new ArrayList<>(ans.get(j));
                list.add(x);
                ans.add(list);
            }
        }
        return ans;
    }


    /**
     * 递归枚举思路如上{@link Subsets#enumerate(int[])}
     * @param nums
     * @param i
     * @param res
     */
    public static void recursion(int[] nums, int i, List<List<Integer>> res) {
        //base case  越界指针
        if (i >= nums.length) {
            return;
        }
        //上一轮的枚举数
        int size = res.size();
        for (int j = 0; j < size; j++) {
            List<Integer> newSub = new ArrayList<>(res.get(j));
            newSub.add(nums[i]);
            res.add(newSub);
        }
        //新增下一个数nums[i+1]
        recursion(nums, i + 1, res);
    }

    @MethodTag(
            questionNumber = "78",
            methodLink = "https://leetcode.cn/problems/subsets/solutions/7683/er-jin-zhi-wei-zhu-ge-mei-ju-dfssan-chong-si-lu-9c/",
            timeComplexity = TimeComplexity.O_N,
            dataStructType = DataStructType.ARRAY_LIST,
            algorithmCategory = AlgorithmCategory.DEPTH_FIRST_SEARCH
    )
    /**
     * 集合中每个元素的选和不选，构成了一个满二叉状态树，比如，左子树是不选，右子树是选，从根节点、到叶子节点的所有路径，构成了所有子集。<br/>
     * 可以有前序、中序、后序的不同写法，结果的顺序不一样。本质上，其实是比较完整的中序遍历。
     *
     * DFS，前序遍历
     *                        中序123
     *                 /              \
     *              不选1                 选1
     *            /      \            /       \
     *         不选2      选2        不选2       选2
     *       /     \     /  \     /     \     /   \
     *     不选3    选3 不选3  选3 不选3   选3  不选3  选3
     *   []      [3]   [2]  [2,3] [1]   [3] [1,2]  [1,2,3]
     */
    public static void preOrder(int[] nums, int i, List<Integer> subset, List<List<Integer>> res) {
        if (i >= nums.length) {
            return;
        }
        // 到了新的状态，记录新的路径，要重新拷贝一份
        subset = new ArrayList<>(subset);

        // 这里
        res.add(subset);
        preOrder(nums, i + 1, subset, res);
        subset.add(nums[i]);
        preOrder(nums, i + 1, subset, res);
    }

    /**
     * DFS，中序遍历
     */
    public static void inOrder(int[] nums, int i, List<Integer> subset, List<List<Integer>> res) {
        if (i >= nums.length) {
            return;
        }
        subset = new ArrayList<>(subset);

        inOrder(nums, i + 1, subset, res);
        subset.add(nums[i]);
        // 这里
        res.add(subset);
        inOrder(nums, i + 1, subset, res);
    }

    /**
     * DFS，后序遍历
     */
    public static void postOrder(int[] nums, int i, List<Integer> subset, List<List<Integer>> res) {
        if (i >= nums.length) {
            return;
        }
        subset = new ArrayList<>(subset);

        postOrder(nums, i + 1, subset, res);
        subset.add(nums[i]);
        postOrder(nums, i + 1, subset, res);
        // 这里
        res.add(subset);
    }


}
