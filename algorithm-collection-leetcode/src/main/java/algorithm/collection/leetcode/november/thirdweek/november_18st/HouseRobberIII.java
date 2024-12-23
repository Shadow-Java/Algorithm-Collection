package algorithm.collection.leetcode.november.thirdweek.november_18st;


import algorithm.collection.common.datastruct.tree.TreeNode;

/**
 * 337.打家劫舍 III
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
 * @create 2024-11-25 00:14
 **/
public class HouseRobberIII {

    /**
     * 1、这题不能用打家劫舍的思想去做，如果按照打家劫舍去做的话，那么对于子节点，就需要讨论右节点的子节点选或者不选，左节点的子节点选或不选；这样会有四种情况，且需要判空
     * 2、那么可以用买卖股票的最佳时机的方式，将选或不选列入状态；即选这个节点时，这棵子树我选的数的和最大是多少；不选这个节点时，这颗子树选的数最大是多少
     * <block>
     * 需要注意的是树形结构：
     *                 2
     *               /   \
     *              1     6
     *             /       \
     *            6         1
     *    a.对于6，选它就是6，不选就是0
     *    b.对于6上面的1，选它是1，不选就是6
     *    c.对于右子树的1，选是1，不选是0
     *    d.对于右子树1上面的6，选它是6，不选是1
     *    e.最后2，选2，那么儿子都不能选（6+1+2=9）;不选2，那么右子树选或不选都可以max(1,6)=6，左子树选或不选都可以max(1,6)=6,最后就是12
     *    f.对根节点在选或者不选的情况求最大值
     * 3.选或不选
     *      a.选当前节点：左右儿子都不能选
     *      b.不选当前节点：左右儿子可选可不选
     * 4.提炼状态
     *      a.选当前节点时，以当前节点为根的子树的最大点权和
     *      b.不选当前节点时，以当前节点为根的子树的最大点权和
     * 5.转移方程
     *      a.选 = 左不选+右不选+当前节点值
     *      b.不选=max(左旋，左不选) +max(右选，右不选)
     * 6.最终答案=max(根选，根不选)
     * </block>
     * @param root
     * @return
     */
    public int rob(TreeNode root) {
        int[] res = dfs(root);
        return Math.max(res[0], res[1]); // 根节点选或不选的最大值
    }

    /**
     * 1.复杂度分析
     * 2.时间复杂度：O(n)，其中 n 为二叉树的节点个数。每个节点都会递归恰好一次。
     * 3.空间复杂度：O(n)。最坏情况下，二叉树是一条链，递归需要 O(n) 的栈空间。
     *
     *
     * 4.没有上司的舞会
     *     拓展：一般树
     *             a.选=求和[不选子节点]+当前值
     *             b.不选=求和[max(选子节点，不选子节点)]
     * 5.树上最大独立集需要从图中选择尽量多的点，使得这些点不相邻。
     * 6.变形：最大化点权之和
     *
     * 课后作业
     * 1377. T 秒后青蛙的位置，题解
     * 2646. 最小化旅行的价格总和，题解
     *
     *
     * @param node
     * @return
     */
    public int[] dfs(TreeNode node) {
        if (node == null) { // 递归边界
            return new int[]{0, 0}; // 没有节点，怎么选都是 0
        }
        int[] left = dfs(node.left); // 递归左子树
        int[] right = dfs(node.right); // 递归右子树
        int rob = left[1] + right[1] + node.val; // 选
        int notRob = Math.max(left[0], left[1]) + Math.max(right[0], right[1]); // 不选
        return new int[]{rob, notRob};
    }

}
