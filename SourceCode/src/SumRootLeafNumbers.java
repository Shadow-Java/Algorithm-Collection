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
}
