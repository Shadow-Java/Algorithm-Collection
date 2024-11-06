package algorithm.collection.leetcode.november.firstweek.november_6st;

import algorithm.collection.common.datastruct.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author shadow
 * @create 2024-11-06 23:34
 **/
public class InorderTraversal {

    public List<Integer> inorderTraversal(TreeNode root) {
        if(root == null) {
            return new ArrayList<>();
        }
        List<Integer> ans = new ArrayList<>();
        inorder(root,ans);
        return ans;
    }

    public void inorder(TreeNode root,List<Integer> ans) {
        if(root == null) {
            return;
        }
        inorder(root.left,ans);
        ans.add(root.val);
        inorder(root.right,ans);
    }

}
