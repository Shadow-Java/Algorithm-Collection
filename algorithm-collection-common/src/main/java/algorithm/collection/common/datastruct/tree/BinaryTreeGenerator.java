package algorithm.collection.common.datastruct.tree;


import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.Objects;
import java.util.Random;

public class BinaryTreeGenerator {

    /**
     * todo 需要优化，参数给定最小高度  最小左子树等自定义生成
     */
    public static TreeNode generateBinaryTree(int depth, int maxValue) {
        if (depth < 1) {
            return null;
        }
        Random random = new Random();
        TreeNode root = new TreeNode(random.nextInt(maxValue + 1));
        root.left = generateBinaryTree(depth - 1, maxValue);
        root.right = generateBinaryTree(depth - 1, maxValue);
        return root;
    }

    /**
     * 二叉树生成器
     * @param minHeight 最小高度
     * @param width     宽度
     * @param maxValue  结点最大值
     * @return
     */
    public static TreeNode generateBinaryTree(int minHeight, int width, int maxValue) {
        if (minHeight < 1 || width < 1) {
            return null;
        }
        Random random = new Random();
        int rootVal = random.nextInt(maxValue + 1);
        TreeNode root = new TreeNode(rootVal);
        if (minHeight == 1) {
            return root;
        }
        int leftWidth = random.nextInt(width);
        int rightWidth = width - leftWidth - 1;
        root.left = generateBinaryTree(minHeight - 1, leftWidth, maxValue);
        root.right = generateBinaryTree(minHeight - 1, rightWidth, maxValue);
        return root;
    }

    public static void main(String[] args) {
        TreeNode root = generateBinaryTree(6, 10);
        printTree(root);
    }


    public static void bfs(TreeNode root){
        if(root == null){
            System.out.println("--------------------------二叉树为空，请重新输入--------------------------");
        }
        Deque<TreeNode> nodeDeque = new ArrayDeque<>();
        nodeDeque.add(root);
        while(!nodeDeque.isEmpty()){
            int n = nodeDeque.size();//每一层的节点数
            List<Integer> levelNodeVals = new ArrayList<>();
            for(int i=0;i<n;i++){
                TreeNode curNode = nodeDeque.pop();
                levelNodeVals.add(curNode.getVal());
                System.out.print(curNode.getVal()+" ");
                if(curNode.getLeft() != null){
                    nodeDeque.add(curNode.getLeft());
                }
                if(curNode.getRight() != null){
                    nodeDeque.add(curNode.getRight());
                }
            }
            System.out.println("");
        }
    }




    /**
     * 求二叉树的高度
     * @param root
     * @return
     */
    public static int getBinaryTreeDepthByBfs(TreeNode root){
        if(root == null){
            return 0;
        }
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        int level = 0;
        while(!queue.isEmpty()){
            int n = queue.size();
            for(int i=0;i<n;i++){
                TreeNode treeNode = queue.pop();
                if(treeNode.left != null){
                    queue.add(treeNode.left);
                }
                if(treeNode.right != null){
                    queue.add(treeNode.right);
                }
            }
            level++;
        }
        return level;
    }

    public static void levelOrder(TreeNode root) {
        System.out.println("--------------------------二叉树生成如下--------------------------");
        bfs(root);
        System.out.println("--------------------------二叉树打印完成--------------------------");
    }


    public static void printTree(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.print(root.val + " ");
        printTree(root.left);
        printTree(root.right);
    }

    public static void printTreeByOrderLevel(TreeNode root) {
        levelOrder(root);
    }

    /**
     * 可视化打印二叉树
     * @param root
     */
    public static void showTree(TreeNode root){
        int hight = 0;//层数
        List<List<Integer>> list = new ArrayList<>();//所有节点分层保存
        if(root == null){
            System.out.println("--------------------------二叉树为空，请重新输入--------------------------");
        }
        Deque<TreeNode> nodeDeque = new ArrayDeque<>();
        nodeDeque.add(root);
        while(!nodeDeque.isEmpty()){
            int n = nodeDeque.size();//每一层的节点数
            List<Integer> levelNodeVals = new ArrayList<>();
            hight++;
            for(int i=0;i<n;i++){
                TreeNode curNode = nodeDeque.pop();
                levelNodeVals.add(curNode.getVal());
                if(curNode.getLeft() != null){
                    nodeDeque.add(curNode.getLeft());
                }
                if(curNode.getRight() != null){
                    nodeDeque.add(curNode.getRight());
                }
            }
            list.add(levelNodeVals);
        }

        int lastNum = (int)Math.pow(2,hight-1);//满二叉树最后一层的节点数
        int lastLen = lastNum + (lastNum - 1); //最后一层所占数组长度(每个节点之间间隔一个位置)
        Integer[][] tree = new Integer[hight][lastLen];
        for (int i = 0,size = list.size(); i < size ; i ++) {
            List<Integer> strs = list.get(i);//当前层所有节点
            int tempHight = hight - i;
            int start = (int) (Math.pow(2,tempHight-1) - 1);//当前层起始节点下标
            for (Integer nodeVal : strs) {
                tree[i][start] = nodeVal;//节点
                int gap = (int) Math.pow(2,tempHight);//当前层节点间的间隔
                start = start + gap;//下一个节点
            }
        }
        //输出树
        for (int i = 0 ; i < hight ; i ++){
            for(int j = 0 ; j < lastLen ; j ++){
                Integer str = tree[i][j];
                System.out.format("%-2.2s", Objects.isNull(str) || 0==str ?"  ":str);
            }
            System.out.println();
        }
    }

}
