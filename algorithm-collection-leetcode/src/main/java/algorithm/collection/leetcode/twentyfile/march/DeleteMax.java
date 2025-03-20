package algorithm.collection.leetcode.twentyfile.march;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * 给出N个正整数ai(1<=i<=n)支持两种操作（可选择任意操作）：
 * 1） 删除两个相同的数，添加这两个数之和
 * 2）删除两个数，添加这两个数中的最大值
 * 已知通过n-1次操作后，只剩下一个数，求这个数的最大值
 * 输入描述：
 *
 * 第一行输入一个整数n(1<=n<=10e5)
 * 第二行输入n个整数ai(1<=n<=10e4)
 *
 * 输出描述：
 * 输出一个整数表示答案。
 *
 * 示例一：
 * 输入：
 * 3
 * 2 2 4
 * 输出：
 * 8
 *
 * 示例二：
 * 输入：
 * 4
 * 1 2 3 4
 * 输出：
 * 4
 *
 * 740. 删除并获得点数
 * 牛客网-AB88 删除相邻数字的最大分数
 * @author shadow
 * @create 2025-03-19 00:13
 **/
public class DeleteMax {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // 读取整数 n，表示数字的数量
        int n = scanner.nextInt();
        List<Integer> nums = new ArrayList<>();
        // 读取 n 个整数并存储在列表中
        for (int i = 0; i < n; i++) {
            nums.add(scanner.nextInt());
        }

        // 进行 n - 1 次操作，直到列表中只剩下一个元素
        while (nums.size()  > 1) {
            // 对列表进行排序
            Collections.sort(nums);
            boolean foundSame = false;
            // 查找相邻的相同元素
            for (int i = 0; i < nums.size()  - 1; i++) {
                if (nums.get(i).equals(nums.get(i  + 1))) {
                    // 执行操作 1：删除两个相同元素并添加它们的和
                    int newNum = nums.get(i)  + nums.get(i  + 1);
                    nums.remove(i  + 1);
                    nums.remove(i);
                    nums.add(newNum);
                    foundSame = true;
                    break;
                }
            }
            // 如果没有找到相同元素，执行操作 2
            if (!foundSame) {
                int maxNum = Math.max(nums.get(nums.size()  - 1), nums.get(nums.size()  - 2));
                nums.remove(nums.size()  - 1);
                nums.remove(nums.size()  - 1);
                nums.add(maxNum);
            }
        }
        // 输出最终结果
        System.out.println(nums.get(0));
    }


    /**
     * 支持两种操作：
     * 1.如果有相同的数，支持删除后将两个数相加
     * 2.如果没有相同的数，那么只能求最大值
     * f[i] =
     * @param nums
     * @return
     */
    public int getMaxResultV2(int[] nums) {
        Arrays.sort(nums);
        int[] f = new int[nums.length];
        f[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            f[i] = nums[i] == f[i - 1] ? f[i - 1] + nums[i] : Math.max(f[i - 1], nums[i]);
        }
        return f[nums.length-1];
    }

    /**
     * 输入处理：
     * 使用 Scanner 类从标准输入读取整数 n，表示数字的数量。
     * 循环 n 次，读取 n 个整数并将它们添加到 ArrayList 类型的 nums 列表中。
     * 循环操作：
     * 使用 while 循环，只要 nums 列表中的元素数量大于 1，就继续进行操作。
     * 在每次循环开始时，使用 Collections.sort(nums) 对列表进行排序，方便后续查找相同元素。
     * 查找相同元素：
     *    使用 for 循环遍历列表，查找相邻的相同元素。
     *   如果找到相同元素，执行操作 1：删除这两个相同元素，并将它们的和添加到列表末尾。
     *   使用 foundSame 标志来记录是否找到了相同元素。
     * 无相同元素情况：
     *   如果 foundSame 为 false，表示没有找到相同元素，执行操作 2：删除列表中最大的两个元素，并将它们中的最大值添加到列表末尾。
     * 输出结果：
     *   当 nums 列表中只剩下一个元素时，输出该元素
     * @param nums
     * @return
     */
    public static int getMaxResult(List<Integer> nums) {
        while (nums.size()  > 1) {
            Collections.sort(nums);
            boolean foundSame = false;
            for (int i = 0; i < nums.size()  - 1; i++) {
                if (nums.get(i).equals(nums.get(i  + 1))) {
                    int newNum = nums.get(i)  + nums.get(i  + 1);
                    nums.remove(i  + 1);
                    nums.remove(i);
                    nums.add(newNum);
                    foundSame = true;
                    break;
                }
            }
            if (!foundSame) {
                int maxNum = Math.max(nums.get(nums.size()  - 1), nums.get(nums.size()  - 2));
                nums.remove(nums.size()  - 1);
                nums.remove(nums.size()  - 1);
                nums.add(maxNum);
            }
        }
        return nums.get(0);
    }

}
