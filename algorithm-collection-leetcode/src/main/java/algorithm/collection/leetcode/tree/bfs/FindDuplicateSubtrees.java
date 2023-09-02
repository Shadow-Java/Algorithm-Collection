package algorithm.collection.leetcode.tree.bfs;

import algorithm.collection.common.datastruct.tag.AlgorithmCategory;
import algorithm.collection.common.datastruct.tag.DataStructType;
import algorithm.collection.common.datastruct.tag.DifficultyLevel;
import algorithm.collection.common.datastruct.tag.QuestionTag;
import algorithm.collection.common.datastruct.tag.TimeComplexity;
import algorithm.collection.common.datastruct.tree.TreeNode;
import algorithm.collection.primary.tree.DeepWidthSearch;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 给你一棵二叉树的根节点 root ，返回所有 重复的子树 。
 *
 * 对于同一类的重复子树，你只需要返回其中任意 一棵 的根结点即可。
 *
 * 如果两棵树具有 相同的结构 和 相同的结点值 ，则认为二者是 重复 的。
 *
 * 输入：root = [1,2,3,4,null,2,4,null,null,4]
 * 输出：[[2,4],[4]]
 *
 * 输入：root = [2,1,1]
 * 输出：[[1]]
 *
 * 输入：root = [2,2,2,3,null,3,null]
 * 输出：[[2,3],[3]]
 * @author shadow
 * @create 2023-09-03 01:04
 **/
@QuestionTag(
        difficultyLeve = DifficultyLevel.MEDIUM,
        questionNumber = "652",
        questionTitle = "寻找重复的子树",
        relevateClass = DeepWidthSearch.class,
        desc = "给你一棵二叉树的根节点 root ，返回所有 重复的子树。",
        questionLink = "https://leetcode.cn/problems/find-duplicate-subtrees/",
        algorithmCategory = AlgorithmCategory.DEPTH_FIRST_SEARCH,
        timeComplexity = TimeComplexity.O_N_2,
        dataStructTypes = {DataStructType.ARRAY_LIST}
)
public class FindDuplicateSubtrees {

    Map<String, Integer> map = new HashMap<>();
    List<TreeNode> ans = new ArrayList<>();
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        dfs(root);
        return ans;
    }
    public String dfs(TreeNode root) {
        if (root == null) return " ";
        StringBuilder sb = new StringBuilder();
        sb.append(root.val).append("_");
        sb.append(dfs(root.left)).append(dfs(root.right));
        String key = sb.toString();
        map.put(key, map.getOrDefault(key, 0) + 1);
        if (map.get(key) == 2) ans.add(root);
        return key;
    }

}
