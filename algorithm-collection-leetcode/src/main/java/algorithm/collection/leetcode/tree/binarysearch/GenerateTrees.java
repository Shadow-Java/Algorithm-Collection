package algorithm.collection.leetcode.tree.binarysearch;

import algorithm.collection.common.datastruct.tag.AlgorithmCategory;
import algorithm.collection.common.datastruct.tag.DataStructType;
import algorithm.collection.common.datastruct.tag.DifficultyLevel;
import algorithm.collection.common.datastruct.tag.MethodTag;
import algorithm.collection.common.datastruct.tag.QuestionTag;
import algorithm.collection.common.datastruct.tag.TimeComplexity;
import algorithm.collection.common.datastruct.tree.BinaryTreeGenerator;
import algorithm.collection.common.datastruct.tree.TreeNode;
import algorithm.collection.primary.tree.DeepWidthSearch;

import java.util.ArrayList;
import java.util.List;

/**
 * 输入：n = 3
 * 输出：[[1,null,2,null,3],[1,null,3,2],[2,1,3],[3,1,null,null,2],[3,2,null,1]]
 * <p>
 * 输入：n = 1
 * 输出：[[1]]
 *
 * @author shadow
 * @create 2023-06-28 21:28
 **/
@QuestionTag(
        difficultyLeve = DifficultyLevel.MEDIUM,
        questionNumber = "95",
        questionTitle = "不同的二叉搜索树 II",
        relevateClass = DeepWidthSearch.class,
        desc = "给你一个整数 n ，请你生成并返回所有由 n 个节点组成且节点值从 1 到 n 互不相同的不同 二叉搜索树",
        questionLink = "https://leetcode.cn/problems/unique-binary-search-trees-ii/",
        timeComplexity = TimeComplexity.O_N,
        dataStructTypes = {DataStructType.UNIVERSAL_QUEUE}
)
public class GenerateTrees {

    /**
     * 根据给的结点值生成所有的二叉搜索树<br/>
     * 二叉搜索树特点：根节点值比所有的左子树值大，比所有右子树值小<br/>
     * 那么如果当前根节点的值为i，那么左子树能选择的合集为[start,i-1],那么右子树能选择的合集是[i+1,end]
     * @param n  代表n个节点，且结点值从1~n
     * @return   返回树的集合
     */
    @MethodTag(
            questionNumber = "95",
            methodLink = "https://leetcode.cn/problems/unique-binary-search-trees-ii/solutions/2438263/gong-shui-san-xie-chang-gui-er-cha-shu-b-h4sw/",
            timeComplexity = TimeComplexity.O_LOG_N,
            dataStructType = DataStructType.ARRAY_LIST,
            algorithmCategory = AlgorithmCategory.DOUBLE_POINTER
    )
    public List<TreeNode> generateTrees(int n) {
        if (n < 1) {
            return new ArrayList<>();
        }
        /**
         * 因为二插搜索树是以中序遍历为核心，故[start,end]表示以区间进行构建二叉搜索树，那么首先拿到中间节点，然后递归构建[start,mid-1]和[mid+1,n]
         */
        return helper(1, n);
    }

    /**
     * 从[start,end]选择一个根节点，那么左子树能选择合集是[start,i-1],右子树能选择的集合就是[i+1,end]，使用递归调用
     * 比如选择的根节点为1，那么start>end，即是无效值，则节点为null
     * @param start   起点值
     * @param end
     * @return
     */
    public List<TreeNode> helper(int start, int end) {
        //满足结果的集合
        List<TreeNode> list = new ArrayList<>();
        //递归调用时终止条件，如果范围无效，则给空节点；比如根节点值为1，那么左子树[start,end]=[1,0]没有选择
        if (start > end) {
            // 如果当前子树为空，不加null行吗？
            list.add(null);
            return list;
        }
        /**
         * 每次从[start,end]选择一个节点作为根节点
         */
        for (int i = start; i <= end; i++) {
            // 想想为什么这行不能放在这里，而放在下面？
            //因为是递归调用的，并不是所有根节点都满足要求
            // TreeNode root = new TreeNode(i);
            List<TreeNode> left = helper(start, i - 1);
            List<TreeNode> right = helper(i + 1, end);

            // 固定左孩子，遍历右孩子
            for (TreeNode l : left) {
                for (TreeNode r : right) {
                    TreeNode root = new TreeNode(i);
                    root.left = l;
                    root.right = r;
                    list.add(root);
                }
            }
        }
        return list;
    }


    /**
     * 生成平衡二叉搜索树<br/>
     * 每次只能返回一颗二叉搜索树，构建多颗二叉树，问题就在于如何选择不同的根节点，以构建不同的树和子树
     * @param n   数字从1-n为节点值
     * @return    返回所有的二叉搜索树
     */
    public static TreeNode generateBalanceTrees(int n) {
        if (n == 0) {
            return null;
        }
        return generateSubTree(1, n);
    }

    /**
     * 生成平衡二叉搜索树<br/>
     * 平衡二叉树特点：左右子树的高度不超过1，也就是说左右子树的高度之差不会超过1，所以根节点选择中点；平衡二叉树的查找、插入和删除的复杂度都是O(logn)，n是节点数量，树的高度始终在O(logn)的范围内
     * @param start
     * @param end
     * @return
     */
    private static TreeNode generateSubTree(int start, int end) {
        if (start > end) {
            return null;
        }
        // 这里可以选择从start到end的任何一个值做为根结点，
        // 这里选择它们的中点，实际上，这样构建出来的是一颗平衡二叉搜索树
        int mid = (start + end) / 2;
        TreeNode root = new TreeNode(mid);
        //递归生成单个树
        root.left = generateSubTree(start, mid - 1);
        root.right = generateSubTree(mid + 1, end);
        return root;
    }


    public static void main(String[] args) {
        GenerateTrees generateTrees = new GenerateTrees();
        List<TreeNode> treeNodes = generateTrees.generateTrees(4);
        treeNodes.forEach(treeNode -> {
            System.out.println("---------------------------");
            BinaryTreeGenerator.showTree(treeNode);
            System.out.println("---------------------------");
        });

    }



}
