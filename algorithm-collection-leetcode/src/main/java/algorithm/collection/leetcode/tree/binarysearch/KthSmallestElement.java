package algorithm.collection.leetcode.tree.binarysearch;

import algorithm.collection.common.datastruct.tag.AlgorithmCategory;
import algorithm.collection.common.datastruct.tag.DataStructType;
import algorithm.collection.common.datastruct.tag.DifficultyLevel;
import algorithm.collection.common.datastruct.tag.MethodTag;
import algorithm.collection.common.datastruct.tag.QuestionTag;
import algorithm.collection.common.datastruct.tag.TimeComplexity;
import algorithm.collection.common.datastruct.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个二叉搜索树的根节点 root ，和一个整数 k ，请你设计一个算法查找其中第 k 个最小元素（从 1 开始计数）。
 * @author shadow
 * @create 2023-09-14 23:17
 **/
@QuestionTag(
        difficultyLeve = DifficultyLevel.MEDIUM,
        questionNumber = "230",
        questionTitle = "二叉搜索树中第K小的元素",
        relevateClass = SerializeDeserializeBST.class,
        desc = "给定一个二叉搜索树的根节点 root ，和一个整数 k ，请你设计一个算法查找其中第 k 个最小元素（从 1 开始计数）。",
        questionLink = "https://leetcode.cn/problems/kth-smallest-element-in-a-bst/description/",
        algorithmCategory = AlgorithmCategory.OTHER,
        timeComplexity = TimeComplexity.O_N_2,
        dataStructTypes = {DataStructType.BINARY_SEARCH_TREE}
)
public class KthSmallestElement {

    @MethodTag(
            questionNumber = "230",
            methodLink = "https://leetcode.cn/problems/root-equals-sum-of-children/description/",
            timeComplexity = TimeComplexity.O_N,
            dataStructType = DataStructType.ARRAY_LIST,
            algorithmCategory = AlgorithmCategory.OTHER
    )
    public int kthSmallest(TreeNode root, int k) {
        List<Integer> res = new ArrayList<>();
        inOrder(root,res);
        if(!res.isEmpty()){
           return res.get(k);
        }
        return 0;
    }


    public void inOrder(TreeNode root, List<Integer> res){
        if(root == null){
            return;
        }
        inOrder(root.left,res);
        res.add(root.val);
        inOrder(root.right,res);
    }

}
