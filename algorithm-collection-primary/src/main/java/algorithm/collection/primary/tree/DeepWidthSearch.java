package algorithm.collection.primary.tree;

import algorithm.collection.common.datastruct.tree.BinaryTreeGenerator;
import algorithm.collection.common.datastruct.tree.TreeNode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
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
    /**
     * 全排列的情况
     */
    private int count = 0;

    private Map<Integer, List<Integer>> graph;


    /**
     * 输入一个n，输出1-n的全排列<br/>
     * 比如123的全排列：123,132,213,231，312,321<br/>
     * 假如有n个箱子，相当于将1-n放入n个箱子中，使用深度优先搜索<br/>
     * 大致逻辑：step是站在第几个箱子面前，n表示手里的牌，book表示手里的牌是否已经被使用，每次站在箱子前查看手机那些牌没有使用，随机取一张，选择好后放下一个箱子，当所有的箱子安排好后回收当前的牌
     *
     * @param step 代表第几个箱子
     */
    public void dfs(int step) {

        /**
         * 满足全排列条件
         */
        if (step == n) {
            for (int i = 0; i < n; i++) {
                System.out.print(box[i] + " ");
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
        for (int i = 0; i < n; i++) {
            /**
             * 还未被访问
             */
            if (book[i] == 0) {
                box[step] = i;
                book[i] = 1;
                dfs(step + 1);
                /**
                 * 该情况是将step-n个盒子都访问完成后，需要回退，将尝试的卡牌收回
                 */
                book[i] = 0;
            }
        }
        return;
    }


    public void test1() {
        DeepWidthSearch deepWidthSearch = new DeepWidthSearch();
        deepWidthSearch.dfs(0);
        int n = deepWidthSearch.n;
        int res = 1;
        for (int i = n; i > 0; i--) {
            res *= i;
        }
        System.out.println(n + "的全排列情况为" + res);
        System.out.println("总共的情况：" + deepWidthSearch.count);
    }


    /**
     * 深度优先遍历二叉树结构，通过栈打印回溯的路径
     * todo 有问题
     *
     * @param root
     */
    public void dfs(TreeNode root, Stack<Integer> searchPath) {
        if (root == null) {
            return;
        }
        searchPath.add(root.val);
        if (root.right == null && root.left == null) {
            searchPath.forEach(x -> {
                System.out.print(x + " ");
            });
            System.out.println("");
            searchPath.pop();
        }
        dfs(root.left, searchPath);
        dfs(root.right, searchPath);
    }


    /**
     * 非递归实现
     *
     * @param root
     */
    public void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode treeNode = stack.pop();
            System.out.println(treeNode.val + "");
            /**
             * 为什么要先入栈右节点，因为出栈是相反的
             */
            if (treeNode.right != null) {
                stack.push(treeNode.right);
            }
            if (treeNode.left != null) {
                stack.push(treeNode.left);
            }
        }
    }

    /**
     * 递归求二叉树的最大深度
     * 怎么写递归：即从当前节点出发，计算左右子节点的最大深度，递归一般不计算当前计算
     *
     * @return
     */
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);
        return Math.max(leftDepth, rightDepth) + 1;
    }

    int maxLevel = 0;

    public int dfsMaxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        dfs(root, 1);
        return maxLevel;
    }

    public void dfs(TreeNode root, int level) {
        if (root == null) {
            return;
        }
        if (level > maxLevel) {
            maxLevel = level;
        }
        dfs(root.left, level + 1);
        dfs(root.right, level + 1);
    }

    // 迭代实现后序遍历
    public void postorderTraversalIterative(TreeNode root) {
        if (root == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        List<Integer> result = new ArrayList<>();

        while (!stack.isEmpty()) {
            TreeNode currentNode = stack.pop();
            result.add(0, currentNode.val); // 在列表前端添加
            if (currentNode.left != null) {
                stack.push(currentNode.left);
            }
            if (currentNode.right != null) {
                stack.push(currentNode.right);
            }
        }

        for (int val : result) {
            System.out.print(val + " ");
        }
    }

    // 迭代实现中序遍历
    public void inorderTraversalIterative(TreeNode root) {
        if (root == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode currentNode = root;

        while (currentNode != null || !stack.isEmpty()) {
            while (currentNode != null) {
                stack.push(currentNode);
                currentNode = currentNode.left;
            }
            currentNode = stack.pop();
            System.out.print(currentNode.val + " ");
            currentNode = currentNode.right;
        }
    }


    /**
     * 注意前序遍历、中序遍历和后序遍历都属于dfs遍历，且遍历不需要加Set<Integer> visited；
     * 前序遍历：根节点 -> 左子树 -> 右子树
     * 中序遍历：左子树 -> 根节点 -> 右子树
     * 后序遍历：左子树 -> 右子树 -> 根节点
     * 在这三种遍历方式中，每个节点都会被访问一次且仅一次，不会出现重复访问的情况
     * @param root   迭代实现前序遍历
     */
    public static void preorderTraversalIterative(TreeNode root) {
        if (root == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode currentNode = stack.pop();
            System.out.print(currentNode.val + " ");
            //栈结构是先进的后访问，故要遍历结果为根节点 -> 左子树 -> 右子树，则先加入右子树
            if (currentNode.right != null) {
                stack.push(currentNode.right);
            }
            if (currentNode.left != null) {
                stack.push(currentNode.left);
            }
        }
    }


    /**
     * dfs遍历图结构
     *
     * @param start 任意选择其中一个图结点
     * @return
     */
    public List<Integer> dfsGraph(int start) {
        /**
         * 记录已经访问过的点
         */
        Set<Integer> visited = new HashSet<>();
        /**
         * 遍历的顺序
         */
        List<Integer> result = new ArrayList<>();
        dfsHelper(start, visited, result);
        return result;
    }


    private void dfsHelper(int node, Set<Integer> visited, List<Integer> result) {
        visited.add(node);
        result.add(node);
        for (int neighbor : graph.get(node)) {
            if (!visited.contains(neighbor)) {
                dfsHelper(neighbor, visited, result);
            }
        }
    }

    private static void dfs(int[][] grid, int row, int col, boolean[][] visited) {
        int numRows = grid.length;
        int numCols = grid[0].length;

        // 检查边界条件和访问状态
        if (row < 0 || row >= numRows || col < 0 || col >= numCols || visited[row][col]) {
            return;
        }

        // 访问当前单元格
        visited[row][col] = true;
        System.out.println("Visiting cell: " + row + ", " + col);

        // 递归遍历相邻的单元格
        dfs(grid, row + 1, col, visited);  // 向下
        dfs(grid, row - 1, col, visited);  // 向上
        dfs(grid, row, col + 1, visited);  // 向右
        dfs(grid, row, col - 1, visited);  // 向左
    }

    public void dfstest() {
        Stack<Integer> searchPath = new Stack<>();
        TreeNode root = BinaryTreeGenerator.generateBinaryTree(3, 4);
        BinaryTreeGenerator.levelOrder(root);
        dfs(root, searchPath);
    }


    public static void main(String[] args) {
        DeepWidthSearch deepWidthSearch = new DeepWidthSearch();
        deepWidthSearch.test1();
    }

}
