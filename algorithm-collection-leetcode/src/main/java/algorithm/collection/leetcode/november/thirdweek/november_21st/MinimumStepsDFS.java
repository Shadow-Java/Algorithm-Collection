package algorithm.collection.leetcode.november.thirdweek.november_21st;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

/**
 * 1091. 二进制矩阵中的最短路径
 *
 * 输入一个二维数组，给出一个开始左边和结束坐标，求最终没有经过障碍物的最小步数。‘.’为可以经过的字符‘*’为障碍物，请问java 深度优先求解算法
 * 5 5
 * 1 1 5 5
 * . . . . .
 * * * * * .
 * . . . . .
 * * * . * *
 * . . . . .
 * <p>
 * char[][] nums = {
 * {'.','.','.','.','.'},
 * {'*','*','*','*','.'},
 * {'.','.','.','.','.'},
 * {'*','*','.','*','*'},
 * {'.','.','.','.','.'},
 * };
 *
 * @author shadow
 * @create 2025-03-24 22:04
 **/
public class MinimumStepsDFS {

    Integer min = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int x1 = sc.nextInt();
        int y1 = sc.nextInt();
        int x2 = sc.nextInt();
        int y2 = sc.nextInt();
        /**
         * 在读取完整数后，调用 nextLine() 消耗掉缓冲区中的换行符，否则会影响后续的输入
         */
        sc.nextLine(); // 消耗掉上一行的换行符
        String[][] nums = new String[n][m];
        for (int i = 0; i < n; i++) {
            String input = sc.nextLine();
            nums[i] = input.split(" ");
        }
        MinimumStepsDFS minimumStepsDFS = new MinimumStepsDFS();
        minimumStepsDFS.minimumStepsDFS(nums, x1 - 1, y1 - 1, x2 - 1, y2 - 1, 0, new boolean[n][m]);
        System.out.println("最小步数：" + minimumStepsDFS.min);
    }

    public void minimumStepsDFS(String[][] nums, int x1, int y1, int x2, int y2, int steps, boolean[][] visited) {
        int n = nums.length;
        int m = nums.length;
        if (x1 < 0 || x1 >= n || y1 < 0 || y1 >= m || visited[x1][y1] || "*".equals(nums[x1][y1])) {//遇到障碍物或越界
            return;
        }
        if (x1 == x2 && y1 == y2) {
            min = Math.min(min, steps);
            return;
        }
        visited[x1][y1] = true;//因为用的dfs，同一个地方访问完了之后需要取消访问
        minimumStepsDFS(nums, x1 + 1, y1, x2, y2, steps + 1, visited);
        minimumStepsDFS(nums, x1 - 1, y1, x2, y2, steps + 1, visited);
        minimumStepsDFS(nums, x1, y1 + 1, x2, y2, steps + 1, visited);
        minimumStepsDFS(nums, x1, y1 - 1, x2, y2, steps + 1, visited);
        visited[x1][y1] = false;
    }


    public void minimumStepsBFS(String[][] nums, int x1, int y1, int x2, int y2) {
        int n = nums.length;
        int m = nums.length;
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{x1,y1});//加入头结点，宽度优先搜索二维数组
        int minSteps = 0;
        boolean[][] visited = new boolean[n][m];//因为需要四个方向，索引仍然会回溯，需要看是否已经被访问
        //定义四个方向
        int[][] directors = {{1,0},{-1,0},{0,1},{0,-1}};
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] pin = queue.poll();
                if(pin[0] == x2 && pin[1] == y2) {
                    break;
                }
                visited[pin[0]][pin[1]] = true;
                for (int j = 0; j < 4; j++) {
                    int[] dir = directors[j];
                    int nextX = pin[0]+ dir[0];
                    int nextY = pin[1] + dir[1];
                    if(nextX < 0 || nextX >= n || nextY < 0 || nextY >= m || "*".equals(nums[nextX][nextY]) || visited[nextX][nextY] ) {
                        continue;
                    }
                    queue.add(new int[]{nextX,nextY});
                    visited[nextX][nextY] = true;
                }
            }
            minSteps++;
        }
        System.out.println(minSteps == 0 ? -1 : minSteps);
    }

}
