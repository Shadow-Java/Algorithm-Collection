使用深度优先搜索（DFS）可以求解1到n的全排列。在DFS过程中，我们从1开始，依次选择每个数字作为当前位置的数，并递归地搜索剩余的位置。当选择完所有位置后，即得到一个全排列。

理解**回溯**的过程需要注意以下几点：

**选择和回退**：在DFS的每一步中，我们选择一个未被使用过的数字放置到当前位置，然后递归地搜索下一个位置。当递归返回时，表示已经得到了一个全排列或无法继续选择数字。此时，我们需要回退到上一步，撤销当前选择，以便尝试其他选择。

**标记和取消标记**：为了避免重复选择数字，需要使用一个数组或集合来标记哪些数字已经被使用过。在选择数字进行放置时，将其标记为已使用，当回退时，需要取消对该数字的标记，以便其他位置可以选择该数字。

**递归调用**：在每一步中，通过递归地调用DFS函数来搜索下一个位置。递归调用会深入到更深的层级，直到达到终止条件。当递归返回时，回到上一层级，继续搜索其他选择。

**可视化回退**：可以想象DFS过程为树的遍历，其中每个节点表示一个选择点。当回退时，可以理解为从当前节点返回到上一层级的节点。这个过程可以通过树的遍历可视化，帮助理解回退的过程。

## 算法模版：
## 无辅助栈结构模版（算法会带有选择和回退、标记和取消标记的特点）

入参一般是从节点编号（从那个节点开始遍历）、visit[length]（记录节点是否被访问）、result[length]（访问顺序）
```
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
```

## 有辅助栈结构模版（一般是遍历节点）
入参一般是顶点节点

```
public void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode treeNode = stack.pop();
            System.out.println(treeNode.val + "");
            if (treeNode.right != null) {
                stack.push(treeNode.right);
            }
            if (treeNode.left != null) {
                stack.push(treeNode.left);
            }
        }
    }
```

## 怎么遍历一棵树
使用bfs和dfs遍历或者递归实现

## 怎么遍历图(树结构的图)
使用无辅助栈的dfs遍历

```
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
```

## 怎么遍历表格
利用行和列遍历，即两个for循环；使用dfs，将每个表格当成一个节点，无辅助栈的dfs遍历
```
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
```

## 有哪些算法问题

DFS（深度优先搜索）算法在解决某些问题时可能会遇到以下几个常见的问题：

**无限循环**：如果在DFS算法的实现中没有正确处理访问状态或没有设置终止条件，可能会导致陷入无限循环的情况。这通常是由于访问状态未正确更新或判断条件不准确引起的。确保在适当的时候标记已访问的节点，并设置合适的终止条件，以避免无限循环。

**栈溢出**：DFS算法使用函数调用栈来管理递归调用，如果递归调用的层数过多，可能导致栈溢出的错误。这种情况通常发生在处理非常深的递归树时，可以考虑使用迭代方式（显式栈）来替代递归，或者通过优化算法或数据结构来减少递归的深度。

**重复访问**：在某些情况下，DFS算法可能会重复访问相同的节点或路径，导致不必要的计算或陷入循环。这通常发生在图或图形结构中存在环路的情况下。为了避免重复访问，可以使用访问状态数组或集合来记录已访问的节点，并在每次访问前进行检查。

**最优解问题**：DFS算法通常在搜索问题的解空间时，并不保证找到最优解。它会在搜索过程中穷尽所有可能的路径，但不一定找到最短路径或最优解。如果需要找到最优解，可以考虑使用其他搜索算法（如BFS、Dijkstra、A*等）或结合DFS和剪枝技术来优化搜索过程。

**空间复杂度**：DFS算法在搜索过程中需要使用栈来存储递归调用的信息，因此可能需要较大的空间复杂度。特别是在搜索树或图的深度较大时，递归调用的层数也会增加，进而增加了空间的使用。在处理大规模问题时，可能需要考虑空间优化的方法，如迭代方式替代递归或使用其他数据结构来减少空间占用。

目前遇到的有：全排列问题、01背包问题（树形dp）等

## TODO
01背包问题
