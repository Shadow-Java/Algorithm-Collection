package algorithm.collection.leetcode.november.secondweek.november_17st;

import java.util.Arrays;

/**
 * 2466. 统计构造好字符串的方案数
 * 给你整数 zero ，one ，low 和 high ，我们从空字符串开始构造一个字符串，每一步执行下面操作中的一种：
 *
 * 将 '0' 在字符串末尾添加 zero  次。
 * 将 '1' 在字符串末尾添加 one 次。
 * 以上操作可以执行任意次。
 *
 * 如果通过以上过程得到一个 长度 在 low 和 high 之间（包含上下边界）的字符串，那么这个字符串我们称为 好 字符串。
 *
 * 请你返回满足以上要求的 不同 好字符串数目。由于答案可能很大，请将结果对 109 + 7 取余 后返回
 *
 * 示例 1：
 *
 * 输入：low = 3, high = 3, zero = 1, one = 1
 * 输出：8
 * 解释：
 * 一个可能的好字符串是 "011" 。
 * 可以这样构造得到："" -> "0" -> "01" -> "011" 。
 * 从 "000" 到 "111" 之间所有的二进制字符串都是好字符串。
 *
 * 示例 2：
 *
 * 输入：low = 2, high = 3, zero = 1, one = 2
 * 输出：5
 * 解释：好字符串为 "00" ，"11" ，"000" ，"110" 和 "011" 。
 * @author shadow
 * @create 2025-02-12 20:46
 **/
public class CountGoodStrings {

    public static void main(String[] args) {
        CountGoodStrings countGoodStrings = new CountGoodStrings();
        System.out.println(-1-200);
        //System.out.println(countGoodStrings.countGoodStrings(2,3,1,2));
    }

    static int[] memo;
    public int countGoodStrings(int low, int high, int zero, int one) {
        memo = new int[high + 1];
        Arrays.fill(memo, -1);
        int ans = 0;
        // 遍历所有有效长度 [low, high]
        for (int i = low; i <= high; i++) {
            ans = (ans + dfs(i, zero, one)) % 1_000_000_007; // 累加结果并取模
        }
        return ans;
    }

    private int dfs(int i, int zero, int one) {
        if (i <= 0)
            // 找到一种有效组合
            return i == 0 ? 1 : 0; // 长度超限，无效解
        if (memo[i] != -1)
            return memo[i]; // 已缓存结果

        int count = 0;
        // 选择追加 'zero' 个 0 或 'one' 个 1
        if (i >= zero) {//这样不会漏情况
            count = (count + dfs(i - zero, zero, one)) % 1_000_000_007;
        }
        if (i >= one) {
            count = (count + dfs(i - one, zero, one)) % 1_000_000_007;
        }
        memo[i] = count; // 记录缓存
        return count;
    }


    /**
     * 转换为一维数组
     * @param low
     * @param high
     * @param zero
     * @param one
     * @return
     */
    public int countGoodStringsV1(int low, int high, int zero, int one) {
        int[] f = new int[high + 1];
        f[0] = 1;
        // 遍历所有有效长度 [low, high]
        for (int i = 1; i <= high; i++) {
            if (i >= zero) {
                f[i] = (f[i] + f[i - zero]) % 1_000_000_007;
            }
            if (i >= one) {
                f[i] = (f[i] + f[i - one]) % 1_000_000_007;
            }
        }
        int ans = 0;
        for (int i = low; i <= high; i++) {
            ans = (ans + f[i]) % 1_000_000_007;//可能会越界
        }
        return ans;
    }

}
