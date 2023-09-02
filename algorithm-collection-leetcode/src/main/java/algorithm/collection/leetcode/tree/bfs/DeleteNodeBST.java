package algorithm.collection.leetcode.tree.bfs;

import algorithm.collection.common.datastruct.tag.AlgorithmCategory;
import algorithm.collection.common.datastruct.tag.DataStructType;
import algorithm.collection.common.datastruct.tag.DifficultyLevel;
import algorithm.collection.common.datastruct.tag.QuestionTag;
import algorithm.collection.common.datastruct.tag.TimeComplexity;
import algorithm.collection.common.datastruct.tree.TreeNode;
import algorithm.collection.primary.tree.DeepWidthSearch;

/**
 * 给定一个二叉搜索树的根节点 root 和一个值 key，删除二叉搜索树中的 key 对应的节点，并保证二叉搜索树的性质不变。返回二叉搜索树（有可能被更新）的根节点的引用。
 *
 * 一般来说，删除节点可分为两个步骤：
 *
 * 1.首先找到需要删除的节点；
 * 2.如果找到了，删除它。
 *
 * 输入：root = [5,3,6,2,4,null,7], key = 3
 * 输出：[5,4,6,2,null,null,7]
 * 解释：给定需要删除的节点值是 3，所以我们首先找到 3 这个节点，然后删除它。
 * 一个正确的答案是 [5,4,6,2,null,null,7], 如下图所示。
 * 另一个正确答案是 [5,2,6,null,4,null,7]。
 *
 * 输入: root = [5,3,6,2,4,null,7], key = 0
 * 输出: [5,3,6,2,4,null,7]
 * 解释: 二叉树不包含值为 0 的节点
 * @author shadow
 * @create 2023-09-03 00:57
 **/
@QuestionTag(
        difficultyLeve = DifficultyLevel.MEDIUM,
        questionNumber = "450",
        questionTitle = "删除二叉搜索树中的节点",
        relevateClass = DeepWidthSearch.class,
        desc = "给定一个二叉搜索树的根节点 root 和一个值 key，删除二叉搜索树中的 key 对应的节点，并保证二叉搜索树的性质不变。返回二叉搜索树（有可能被更新）的根节点的引用。",
        questionLink = "https://leetcode.cn/problems/delete-node-in-a-bst/",
        algorithmCategory = AlgorithmCategory.DEPTH_FIRST_SEARCH,
        timeComplexity = TimeComplexity.O_N_2,
        dataStructTypes = {DataStructType.ARRAY_LIST}
)
public class DeleteNodeBST {

    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        }

        if (key > root.val) {
            root.right = deleteNode(root.right, key); // 去右子树删除
        } else if(key < root.val) {
            root.left = deleteNode(root.left, key);  // 去左子树删除
        } else  {  // 当前节点就是要删除的节点

            if (root.left == null)   return root.right;      // 情况1，欲删除节点无左子
            else if (root.right == null)  return root.left;  // 情况2，欲删除节点无右子
            else if (root.left!=null && root.right !=null){  // 情况3，欲删除节点左右子都有
                TreeNode node = root.right;
                while (node.left != null)      // 寻找欲删除节点右子树的最左节点
                    node = node.left;

                node.left = root.left;     // 将欲删除节点的左子树成为其右子树的最左节点的左子树
                root = root.right;         // 欲删除节点的右子顶替其位置，节点被删除
            }
        }
        return root;
    }

}
