package algorithm.collection.leetcode.twentyfile.march;

import java.util.Arrays;

/**
 * 135. 分发糖果
 *
 * n 个孩子站成一排。给你一个整数数组 ratings 表示每个孩子的评分。
 *
 * 你需要按照以下要求，给这些孩子分发糖果：
 *
 * 每个孩子至少分配到 1 个糖果。
 * 相邻两个孩子评分更高的孩子会获得更多的糖果。
 * 请你给每个孩子分发糖果，计算并返回需要准备的 最少糖果数目 。
 *
 * 输入：ratings = [1,0,2]
 * 输出：5
 * 解释：你可以分别给第一个、第二个、第三个孩子分发 2、1、2 颗糖果。
 *
 * 输入：ratings = [1,2,2]
 * 输出：4
 * 解释：你可以分别给第一个、第二个、第三个孩子分发 1、2、1 颗糖果。
 *      第三个孩子只得到 1 颗糖果，这满足题面中的两个条件。
 * @author shadow
 * @create 2025-03-15 21:16
 **/
public class Candy {

    public static void main(String[] args) {
        int[] ratings = {1,2,2,3};
        Candy candy = new Candy();
        System.out.println(candy.candy(ratings));
    }

    public int candy(int[] ratings) {
        if (ratings == null || ratings.length == 0) {
            return 0;
        }
        int n = ratings.length;
        //根据左边的评分，拿到当前糖果
        int[] left = new int[n];
        //根据右边的评分，拿到当前糖果
        int[] right = new int[n];
        Arrays.fill(left, 1);
        Arrays.fill(right, 1);

        // 从左到右遍历，处理左边条件
        for (int i = 1; i < n; i++) {
            if (ratings[i] > ratings[i - 1]) {
                left[i] = left[i - 1] + 1;
            }
        }

        // 从右到左遍历，处理右边条件
        for (int i = n - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                right[i] = right[i + 1] + 1;
            }
        }

        // 计算总和，取左右数组的最大值
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += Math.max(left[i], right[i]);
        }
        return sum;
    }

}
