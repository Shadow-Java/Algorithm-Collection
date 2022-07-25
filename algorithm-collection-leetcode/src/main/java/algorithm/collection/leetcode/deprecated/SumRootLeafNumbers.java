package algorithm.collection.leetcode.deprecated;

/**
 * 给定一个二叉树，它的每个结点都存放一个 0-9 的数字，每条从根到叶子节点的路径都代表一个数字。
 *
 * 例如，从根到叶子节点路径 1->2->3 代表数字 123。
 *输入: [1,2,3]
 *     1
 *    / \
 *   2   3
 * 输出: 25
 * 解释:
 * 从根到叶子节点路径 1->2 代表数字 12.
 * 从根到叶子节点路径 1->3 代表数字 13.
 * 因此，数字总和 = 12 + 13 = 25.
 *
 *
 *
 * A.深度优先搜索算法（Depth First Search）
 * 它沿着树的深度遍历树的节点，尽可能深的搜索树的分支。当节点v的所有边都己被探寻过，搜索将回溯到发现节点v的那条边的起始节点。这一过程一直进行到已发现从源节点可达的所有节点为止。
 * 分析：在遍历了根结点后，就开始遍历左子树，最后才是右子树。
 *      4
 *    / \
 *   9   0
 *  / \
 * 5   1
 * 遍历顺序：4 9 5 1 0 ，类似于前序遍历
 *
 *
 * B.广度优先搜索算法（Breadth First Search）
 * 又叫宽度优先搜索，或横向优先搜索。
 * 是从根节点开始，沿着树的宽度遍历树的节点。如果所有节点均被访问，则算法中止。
 * 遍历顺序：4 9 0 5 1，类似于层序遍历
 */
public class SumRootLeafNumbers {

    /**
     * 利用dfs查找节点，每次遍历都会重复，统计之前节点的值
     * @param root
     * @return
     */
    public int sumNumbers(TreeNode root) {
        return helper(root,0);
    }
    public int helper(TreeNode root,int i){
        if(root == null)
            return 0;
        int temp = i*10 + root.val;
        if(root.left == null && root.right == null)
            return temp;
        return helper(root.left,temp)+helper(root.right,temp);
    }

    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

    /**
     *dfs遍历解决
     */
    public int dfs(TreeNode root, int prevSum) {
        if (root == null) {
            return 0;
        }
        int sum = prevSum * 10 + root.val;
        if (root.left == null && root.right == null) {
            return sum;
        } else {
            return dfs(root.left, sum) + dfs(root.right, sum);
        }
    }

}
