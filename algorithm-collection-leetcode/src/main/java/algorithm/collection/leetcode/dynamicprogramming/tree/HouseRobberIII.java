package algorithm.collection.leetcode.dynamicprogramming.tree;

import algorithm.collection.common.datastruct.tag.AlgorithmCategory;
import algorithm.collection.common.datastruct.tag.DataStructType;
import algorithm.collection.common.datastruct.tag.DifficultyLevel;
import algorithm.collection.common.datastruct.tag.MethodTag;
import algorithm.collection.common.datastruct.tag.QuestionTag;
import algorithm.collection.common.datastruct.tag.TimeComplexity;
import algorithm.collection.common.datastruct.tree.TreeNode;
import algorithm.collection.leetcode.dynamicprogramming.linear.HouseRobber;

/**
 * 小偷又发现了一个新的可行窃的地区。这个地区只有一个入口，我们称之为root。
 * <p>
 * 除了root之外，每栋房子有且只有一个“父“房子与之相连。一番侦察之后，聪明的小偷意识到“这个地方的所有房屋的排列类似于一棵二叉树”。 如果 两个直接相连的房子在同一天晚上被打劫 ，房屋将自动报警。
 * <p>
 * 给定二叉树的root。返回在不触动警报的情况下，小偷能够盗取的最高金额
 * <p>
 * 输入: root = [3,2,3,null,3,null,1]
 * 输出: 7
 * 解释: 小偷一晚能够盗取的最高金额 3 + 3 + 1 = 7
 * <p>
 * 输入: root = [3,4,5,1,3,null,1]
 * 输出: 9
 * 解释: 小偷一晚能够盗取的最高金额 4 + 5 = 9
 *
 * @author shadow
 * @create 2023-07-09 15:11
 **/
@QuestionTag(
        difficultyLeve = DifficultyLevel.MEDIUM,
        questionNumber = "337",
        questionTitle = "打家劫舍 III",
        relevateClass = HouseRobber.class,
        desc = "给你一个整数数组 nums ，你可以对它进行一些操作",
        questionLink = "https://leetcode.cn/problems/house-robber-iii/",
        timeComplexity = TimeComplexity.O_N,
        dataStructTypes = {DataStructType.BINARY_TREE}
)
public class HouseRobberIII {

    /**
     * 树形dp：使用爷爷、两个孩子、4个孙子定义问题状态
     * 对于单个节点的钱：1.4个孙子偷的钱+爷爷偷的钱   2.两个孩子偷得钱   进行比较两种情况的最大收益
     * int method1 = root.val + rob(root.left.left) + rob(root.left.right) + rob(root.right.left) + rob(root.right.right)
     * int method2 = rob(root.left) + rob(root.right);
     * int result = Math.max(method1, method2);
     *
     * <block>
     * 需要注意的是树形结构：
     *                 2
     *               /   \
     *              1     3
     *               \
     *                4
     *                最大收益是4+3=7
     * </block>
     * @param root
     * @return
     */
    @MethodTag(
            methodLink = "https://leetcode.cn/problems/house-robber-iii/solution/san-chong-fang-fa-jie-jue-shu-xing-dong-tai-gui-hu/",
            questionNumber = "337",
            timeComplexity = TimeComplexity.O_N,
            dataStructType = DataStructType.ARRAY_LIST,
            algorithmCategory = AlgorithmCategory.DYNAMIC_PROGRAMMING
    )
    public int rob(TreeNode root) {
        if (root == null) {
            return 0;
        }
        //偷爷爷节点
        int money = root.val;
        //左孙子
        if (root.left != null) {
            money += (rob(root.left.left) + rob(root.left.right));
        }
        //右孙子
        if (root.right != null) {
            money += (rob(root.right.left) + rob(root.right.right));
        }

        return Math.max(money, rob(root.left) + rob(root.right));
    }

    /**
     * 每个节点可选择偷或者不偷两种状态，根据题目意思，相连节点不能一起偷
     *    当前节点选择偷时，那么两个孩子节点就不能选择偷了
     *    当前节点选择不偷时，两个孩子节点只需要拿最多的钱出来就行(两个孩子节点偷不偷没关系)
     * 我们使用一个大小为 2 的数组来表示 int[] res = new int[2] 0 代表不偷，1 代表偷
     * 任何一个节点能偷到的最大钱的状态可以定义为
     *    当前节点选择不偷：当前节点能偷到的最大钱数 = 左孩子能偷到的钱 + 右孩子能偷到的钱
     *    当前节点选择偷：当前节点能偷到的最大钱数 = 左孩子选择自己不偷时能得到的钱 + 右孩子选择不偷时能得到的钱 + 当前节点的钱数
     * root[0] = Math.max(rob(root.left)[0], rob(root.left)[1]) + Math.max(rob(root.right)[0], rob(root.right)[1])
     * root[1] = rob(root.left)[0] + rob(root.right)[0] + root.val;
     *
     *
     *
     */
    public int robAnotherWay(TreeNode root) {
        int[] result = robInternal(root);
        return Math.max(result[0], result[1]);
    }

    public int[] robInternal(TreeNode root) {
        if (root == null) return new int[2];
        int[] result = new int[2];

        int[] left = robInternal(root.left);
        int[] right = robInternal(root.right);

        result[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        result[1] = left[0] + right[0] + root.val;

        return result;
    }

}
