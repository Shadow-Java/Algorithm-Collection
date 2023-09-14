package algorithm.collection.leetcode.tree.binarysearch;

import algorithm.collection.common.datastruct.tag.AlgorithmCategory;
import algorithm.collection.common.datastruct.tag.DataStructType;
import algorithm.collection.common.datastruct.tag.DifficultyLevel;
import algorithm.collection.common.datastruct.tag.QuestionTag;
import algorithm.collection.common.datastruct.tag.TimeComplexity;
import algorithm.collection.common.datastruct.tree.TreeNode;
import algorithm.collection.primary.tree.DeepWidthSearch;

/**
 * @author shadow
 * @create 2023-09-05 22:31
 **/
@QuestionTag(
        difficultyLeve = DifficultyLevel.MEDIUM,
        questionNumber = "449",
        questionTitle = "序列化和反序列化二叉搜索树",
        relevateClass = DeepWidthSearch.class,
        desc = "序列化是将数据结构或对象转换为一系列位的过程，以便它可以存储在文件或内存缓冲区中，或通过网络连接链路传输，以便稍后在同一个或另一个计算机环境中重建。",
        questionLink = "https://leetcode.cn/problems/eliminate-maximum-number-of-monsters/description/?envType=daily-question&envId=2023-09-03",
        algorithmCategory = AlgorithmCategory.OTHER,
        timeComplexity = TimeComplexity.O_N_2,
        dataStructTypes = {DataStructType.ARRAY_LIST}
)
public class SerializeDeserializeBST {

    public String serialize(TreeNode root) {
        StringBuilder builder = new StringBuilder();
        preOrder(root, builder);
        return builder.toString();
    }

    /**
     * “先序遍历”和“中序遍历”可以唯一确定一棵二叉树，所以我们可以通过先序遍历的结果和中序遍历的结果来唯一确定一棵二叉搜索树。
     * @param root
     * @param builder
     */
    private void preOrder(TreeNode root, StringBuilder builder){

        if(root == null){
            builder.append("#");
            return;
        }
        builder.append((char)(root.val + 1000));
        preOrder(root.left, builder);
        preOrder(root.right, builder);
    }

    public TreeNode deserialize(String data) {
        return dfs(data);
    }

    int index = 0;
    private TreeNode dfs(String data){
        if(data.charAt(index) =='#'){
            index++;
            return null;
        }

        TreeNode root = new TreeNode(data.charAt(index++) - 1000);
        root.left = dfs(data);
        root.right = dfs(data);
        return root;
    }
}
