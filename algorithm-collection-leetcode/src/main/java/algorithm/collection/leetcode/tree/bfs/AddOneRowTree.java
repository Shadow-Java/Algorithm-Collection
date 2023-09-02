package algorithm.collection.leetcode.tree.bfs;

import algorithm.collection.common.datastruct.tag.AlgorithmCategory;
import algorithm.collection.common.datastruct.tag.DataStructType;
import algorithm.collection.common.datastruct.tag.DifficultyLevel;
import algorithm.collection.common.datastruct.tag.MethodTag;
import algorithm.collection.common.datastruct.tag.QuestionTag;
import algorithm.collection.common.datastruct.tag.TimeComplexity;
import algorithm.collection.common.datastruct.tree.TreeNode;
import algorithm.collection.primary.tree.DeepWidthSearch;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author shadow
 * @create 2023-09-02 22:38
 **/
@QuestionTag(
        difficultyLeve = DifficultyLevel.MEDIUM,
        questionNumber = "623",
        questionTitle = "在二叉树中增加一行",
        relevateClass = DeepWidthSearch.class,
        desc = "给定一个二叉树的根 root 和两个整数 val 和 depth ，在给定的深度 depth 处添加一个值为 val 的节点行。",
        questionLink = "https://leetcode.cn/problems/add-one-row-to-tree/",
        algorithmCategory = AlgorithmCategory.DEPTH_FIRST_SEARCH,
        timeComplexity = TimeComplexity.O_N_2,
        dataStructTypes = {DataStructType.ARRAY_LIST}
)
public class AddOneRowTree {

    @MethodTag(
            questionNumber = "623",
            methodLink = "https://leetcode.cn/problems/add-one-row-to-tree/solutions/1723308/by-ac_oier-sc34/",
            timeComplexity = TimeComplexity.O_N,
            dataStructType = DataStructType.ARRAY_LIST,
            algorithmCategory = AlgorithmCategory.DEPTH_FIRST_SEARCH
    )
    public static TreeNode addOneRow(TreeNode root, int val, int depth) {
        if(depth == 1){
            TreeNode test = new TreeNode(val);
            test.left = root;
            return test;
        }
        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.push(root);
        int level = 0;
        TreeNode rootForAdd = root;
        while (!stack.isEmpty()){
            int n = stack.size();
            level++;
            for(int i=1;i<=n;i++){
                TreeNode curNode = stack.pop();
                if(level+1 == depth){
                    TreeNode nextRight = new TreeNode(val);
                    if(curNode.right != null){
                        TreeNode rihtNode = curNode.right;
                        curNode.right = nextRight;
                        nextRight.right = rihtNode;
                    } else {
                        curNode.right = nextRight;
                    }
                    TreeNode nextLeft = new TreeNode(val);
                    if(curNode.left != null){
                        TreeNode leftNode = curNode.left;
                        curNode.left = nextLeft;
                        nextLeft.left = leftNode;
                    }else{
                        curNode.left = nextLeft;
                    }
                } else {
                    if(curNode.left != null){
                        stack.add(curNode.left);
                    }
                    if(curNode.right != null){
                        stack.add(curNode.right);
                    }
                }
            }
            if(level+1 == depth){
                return rootForAdd;
            }
        }
        return rootForAdd;
    }

    @MethodTag(
            questionNumber = "623",
            methodLink = "https://leetcode.cn/problems/add-one-row-to-tree/solutions/1723308/by-ac_oier-sc34/",
            timeComplexity = TimeComplexity.O_N,
            dataStructType = DataStructType.ARRAY_LIST,
            algorithmCategory = AlgorithmCategory.DEPTH_FIRST_SEARCH
    )
    public TreeNode addOneRowBFS(TreeNode root, int val, int depth) {
        if (depth == 1) return new TreeNode(val, root, null);
        Deque<TreeNode> d = new ArrayDeque<>();
        d.addLast(root);
        int cur = 1;
        while (!d.isEmpty()) {
            int sz = d.size();
            while (sz-- > 0) {
                TreeNode t = d.pollFirst();
                if (cur == depth - 1) {
                    TreeNode a = new TreeNode(val), b = new TreeNode(val);
                    a.left = t.left; b.right = t.right;
                    t.left = a; t.right = b;
                } else {
                    if (t.left != null) {
                        d.addLast(t.left);
                    }
                    if (t.right != null) {
                        d.addLast(t.right);
                    }
                }
            }
            cur++;
        }
        return root;
    }

    public TreeNode addOneRowDFS(TreeNode root, int val, int depth) {
        int d = depth; int v = val;
        if (d == 1) return new TreeNode(val, root, null);
        dfs(root, 1,d,v);
        return root;
    }

    public void dfs(TreeNode root, int cur,int d,int v) {
        if (root == null) {
            return ;
        }
        if (cur == d - 1) {
            TreeNode a = new TreeNode(v), b = new TreeNode(v);
            a.left = root.left; b.right = root.right;
            root.left = a; root.right = b;
        } else {
            dfs(root.left, cur + 1,d,v);
            dfs(root.right, cur + 1,d,v);
        }
    }


    public static void main(String[] args) {
        int[] nums = {4,2,6,3,1,5};
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        TreeNode rootForAdd = addOneRow(root,5,4);
        System.out.println(rootForAdd);
    }

}
