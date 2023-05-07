package algorithm.collection.primary.tree;

import algorithm.collection.common.datastruct.tree.BinaryTreeGenerator;
import algorithm.collection.common.datastruct.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 添加深度优先搜索模版方法
 * @author shadow
 * @create 2023-05-07 15:42
 **/
public class DeepWidthSearch {

    /**
     * 10个箱子
     */
    private int[] box = new int[4];
    /**
     * 标记那些卡片已经放入箱子中，book[i]=1表示i号卡牌已经放入箱子，book[i]=0表示i号卡牌还在手里
     */
    private int[] book = new int[4];

    /**
     * 输出1-n的全排列 情况有n!=n*(n-1)*(n-2)*(n-3)*(n-4)*...1
     * 类似于旅行商问题
     */
    private int n = 4;

    private int count = 0;


    /**
     * 输入一个n，输出1-n的全排列
     * 加入有n个箱子，相当于将1-n放入n个箱子中，使用深度优先搜索
     * @param step 代表第几个箱子
     */
    public void dfs(int step){

        /**
         * 满足全排列条件
         */
        if(step == n){
            for(int i=0;i<n;i++){
                System.out.print(box[i]+" ");
            }
            /**
             * 一种情况结束，返回上次调用的地方
             */
            count++;
            System.out.println("");
            return;
        }
        /**
         * 站在第step个盒子面前，应该放那张牌，将所有的牌都试下，因为有book数组记录了那些已经被访问过
         */
        for(int i=0;i<n;i++){
            /**
             * 还未被访问
             */
            if(book[i] == 0){
                box[step] = i;
                book[i] = 1;
                dfs(step+1);
                /**
                 * 该情况是将step-n个盒子都访问完成后，需要回退，将尝试的卡牌收回
                 */
                book[i] = 0;
            }
        }
        return;
    }


    public void test1(){
        DeepWidthSearch deepWidthSearch = new DeepWidthSearch();
        deepWidthSearch.dfs(1);
        int n = deepWidthSearch.n;
        int res = 1;
        for(int i=n;i>0;i--){
            res *= i;
        }
        System.out.println(n+"的全排列情况为"+res);
        System.out.println("总共的情况："+deepWidthSearch.count);
    }


    /**
     * 深度优先遍历探寻遍历的顺序
     * todo 有问题
     * @param root
     */
    public void dfs(TreeNode root,Stack<Integer> searchPath){
        if(root == null){
            return;
        }
        searchPath.add(root.val);
        if(root.right == null && root.left == null){
            searchPath.forEach(x->{
                System.out.print(x+" ");
            });
            System.out.println("");
            searchPath.pop();
        }
        dfs(root.left,searchPath);
        dfs(root.right,searchPath);
    }


    /**
     * 非递归实现
     * @param root
     */
    public void dfs(TreeNode root){
        if(root == null){
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()){
            TreeNode treeNode = stack.pop();
            System.out.println(treeNode.val +"");
            /**
             * 为什么要先入栈右节点，因为出栈是相反的
             */
            if(treeNode.right != null){
                stack.push(treeNode.right);
            }
            if(treeNode.left != null){
                stack.push(treeNode.left);
            }
        }
    }

    public void dfstest(){
        Stack<Integer> searchPath = new Stack<>();
        TreeNode root = BinaryTreeGenerator.generateBinaryTree(3,4);
        BinaryTreeGenerator.levelOrder(root);
        dfs(root,searchPath);
    }


    public static void main(String[] args) {
        DeepWidthSearch deepWidthSearch = new DeepWidthSearch();
        deepWidthSearch.dfstest();
    }

}
