package src;

/**
 * 编写一个函数，输入是一个无符号整数（以二进制串的形式），返回其二进制表达式中数字位数为 '1' 的个数（也被称为汉明重量）。
 *
 * 输入：00000000000000000000000000001011
 * 输出：3
 * 解释：输入的二进制串 00000000000000000000000000001011 中，共有三位为 '1'。
 *
 *
 * 二、右移 32 次
 * 如果除去库函数之外，我们最容易想到的办法，肯定还是直观地统计二进制中每一位是否包含 1 。
 *
 * 做法是：
 *  n&1 与运算      可以判断n是否为偶数     如果是偶数，n&1返回0；否则返回1，为奇数。
 * 使用 n & 1 得到二进制末尾是否为 1；
 * 把 n 右移 1 位，直至结束。
 * 于是我们可以写出以下的代码：
 *
 * public int hammingWeight(int n) {
 *         int count = 0;
 *         for (int i = 0; i < 32; ++i) {
 *             count += n & 1;
 *             n >>= 1;
 *         }
 *         return count;
 *     }
 *
 *
 * 值得一提的时候，在 Java 中，以下代码会 超时。这就不得不讲一讲 Java 中的 算术右移 和 逻辑右移 。
 *
 * 算术右移 >> ：舍弃最低位，高位用符号位填补；
 * 逻辑右移 >>> ：舍弃最低位，高位用 0 填补。
 * 那么对于负数而言，其二进制最高位是 1，如果使用算术右移，那么高位填补的仍然是 1。也就是 n 永远不会为 0。所以下面的代码会超时 TLE。
 *
 * public int hammingWeight(int n) {
 *         int count = 0;
 *         while (n != 0) {
 *             count += n & 1;
 *             n >>= 1;
 *         }
 *         return count;
 *     }
 *
 * 在 Java 中需要使用逻辑右移，即 >>> ，while 的判断条件才能是 n != 0 。正确的代码如下
 *
 *
 * public int hammingWeight(int n) {
 *         int count = 0;
 *         while (n != 0) {
 *             count += n & 1;
 *             n >>>= 1;
 *         }
 *         return count;
 *     }
 *
 *
 *
 * 三、消除二进制末尾的 1
 * 有个更为神奇的做法，那就是 n & (n - 1) ，这个代码可以把 n 的二进制中，最后一个出现的 1 改写成 0。
 *
 * 下面的这个图，说明了 n & (n - 1) 这个操作的原理。我们发现只要每次执行这个操作，就会消除掉 n 的二进制中 最后一个出现的 1。
 *
 * 因此执行 n & (n - 1) 使得 n 变成 0 的操作次数，就是 n 的二进制中 1 的个数
 *
 *public int hammingWeight(int n) {
 *         int res = 0;
 *         while (n != 0) {
 *             res += 1;
 *             n &= n - 1;
 *         }
 *         return res;
 *     }
 *
 *
 *
 */
public class NumberofBits {

    public int hammingWeight(int n) {
        int count = 0;
        while (n != 0) {
            count += n & 1;
            n >>>= 1;
        }
        return count;
    }

}
