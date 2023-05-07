package algorithm.collection.common.datastruct.tree;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Definition for a binary tree node.
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class TreeNode {

      public int val;
      public TreeNode left;
      public TreeNode right;
      TreeNode(int val) { this.val = val; }

}
