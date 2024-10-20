package algorithm.collection.leetcode.list;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author shadow
 * @create 2024-10-13 20:37
 **/
public class JosephusProblem {

    /**
     * 100个人围成一圈，每个人有一个编号，编号从1开始到100。他们从1开始依次报数，报到为M的人自动退出圈圈，然后下一个人接着从1开始报数，直到剩余的人数小于M。请问最后剩余的人在原先的编号为多少？
     * 输入一个整数参数M。
     * 如果输入参数M小于等于1或者大于等于100，输出"ERROR!"；否则按照原先的编号从小到大的顺序，以逗号分割输出编号字符串。
     * 输入：
     * 3
     *
     * 输出：
     * 58,91
     *
     * 说明：
     * 输入M为3，最后剩下两个人
     */
    public static void main(String[] args) {
        int M = 3; // 假设 M 为 3，可以根据实际情况修改
        // 检查 M 是否在有效范围内
        if (M < 2 || M > 99) {
            System.out.println("ERROR!");
            return;
        }

        int N = 100; // 人数为 100
        //循环链表怎么构造，通过队列依次删除入队尾
        Queue<Integer> queue = initializeQueue(N); // 初始化队列

        // 循环移除元素，直到剩下的人数少于 M
        while (queue.size() >= M) {
            int steps = M - 1; // 报数次数
            while (steps-- > 0) {
                queue.add(queue.poll()); // 将当前人移到队列末尾
            }
            queue.poll(); // 移除当前人
        }

        // 输出剩余的人的编号
        StringBuilder result = new StringBuilder();
        while (!queue.isEmpty()) {
            result.append(queue.poll());
            if (!queue.isEmpty()) {
                result.append(", ");
            }
        }

        System.out.println("剩余的人的原始编号为: " + result.toString());
    }

    private static Queue<Integer> initializeQueue(int N) {
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            queue.add(i); // 初始化编号列表
        }
        return queue;
    }

}
