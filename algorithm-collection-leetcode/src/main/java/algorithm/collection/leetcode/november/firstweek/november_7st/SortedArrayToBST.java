package algorithm.collection.leetcode.november.firstweek.november_7st;

import algorithm.collection.common.datastruct.tree.TreeNode;

/**
 * @author shadow
 * @create 2024-11-07 23:17
 **/
public class SortedArrayToBST {

    public TreeNode sortedArrayToBST(int[] nums) {
        return buildBalanceBST(nums,0, nums.length-1);
    }
    public TreeNode buildBalanceBST(int[] nums,int i,int j){
        if(i > j){
            return null;
        }
        int mid = i+(j-i+1)/2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = buildBalanceBST(nums,i,mid-1);
        root.right = buildBalanceBST(nums,mid+1,j);
        return root;
    }

}
