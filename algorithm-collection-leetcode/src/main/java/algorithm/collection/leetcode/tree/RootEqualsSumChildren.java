package algorithm.collection.leetcode.tree;

import algorithm.collection.common.datastruct.tag.AlgorithmCategory;
import algorithm.collection.common.datastruct.tag.DataStructType;
import algorithm.collection.common.datastruct.tag.DifficultyLevel;
import algorithm.collection.common.datastruct.tag.MethodTag;
import algorithm.collection.common.datastruct.tag.QuestionTag;
import algorithm.collection.common.datastruct.tag.TimeComplexity;
import algorithm.collection.common.datastruct.tree.TreeNode;
import algorithm.collection.primary.tree.DeepWidthSearch;

/**
 * 给你一个 二叉树 的根结点 root，该二叉树由恰好 3 个结点组成：根结点、左子结点和右子结点。
 *
 * 如果根结点值等于两个子结点值之和，返回 true ，否则返回 false
 *
 * 输入：root = [10,4,6]
 * 输出：true
 * 解释：根结点、左子结点和右子结点的值分别是 10 、4 和 6 。
 * 由于 10 等于 4 + 6 ，因此返回 true 。
 *
 * 输入：root = [5,3,1]
 * 输出：false
 * 解释：根结点、左子结点和右子结点的值分别是 5 、3 和 1 。
 * 由于 5 不等于 3 + 1 ，因此返回 false 。
 *
 * @author shadow
 * @create 2023-08-20 17:41
 **/
@QuestionTag(
        difficultyLeve = DifficultyLevel.EASY,
        questionNumber = "2236",
        questionTitle = " 判断根结点是否等于子结点之和",
        relevateClass = DeepWidthSearch.class,
        desc = "给你一个 二叉树 的根结点 root，该二叉树由恰好 3 个结点组成：根结点、左子结点和右子结点。",
        questionLink = "https://leetcode.cn/problems/root-equals-sum-of-children/description/",
        algorithmCategory = AlgorithmCategory.OTHER,
        timeComplexity = TimeComplexity.O_N_2,
        dataStructTypes = {DataStructType.ARRAY_LIST}
)
public class RootEqualsSumChildren {

    @MethodTag(
            questionNumber = "2236",
            methodLink = "https://leetcode.cn/problems/root-equals-sum-of-children/description/",
            timeComplexity = TimeComplexity.O_N,
            dataStructType = DataStructType.ARRAY_LIST,
            algorithmCategory = AlgorithmCategory.OTHER
    )
    public boolean checkTree(TreeNode root) {
        return root.val == root.left.val+root.right.val;
    }

}
