package SourceCode.src;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
/**
 * 给你一个二叉树，请你返回其按 层序遍历 得到的节点值。 （即逐层地，从左到右访问所有节点）。
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 * 返回 [
 *     [3],
 *     [9,20],
 *     [15,7]
 *    ]
 */
public class BinaryTreeLevelOrderTraversal {

    /**
     * 层序遍历需要利用队列进行遍历，出队列的节点判断左右节点是否为空，不为空则加入
     * 通过队列不为空加入List
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        List<List<Integer>> result = new ArrayList<>();
        if(root == null)
            return result;
        while(!queue.isEmpty()){
            List<Integer> rm = new ArrayList<>();
            int legth = queue.size();//队列长度即宽度
            for(int i=1;i<= legth;i++){
                TreeNode poll = queue.poll();//出队列的节点，根据该节点判断是否存在左右节点，即更新节点
                rm.add(poll.val);
                if(poll.left != null)
                    queue.add(poll.left);
                if(poll.right != null)
                    queue.add(poll.right);
            }
            result.add(rm);
        }

        return result;
    }


    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }


}
