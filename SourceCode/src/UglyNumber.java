package SourceCode.src;

/**
 * 给你一个整数 n ，请你判断 n 是否为 丑数 。如果是，返回 true ；否则，返回 false 。
 *
 * 丑数 就是只包含质因数 2、3 和/或 5 的正整数。
 *
 * 输入：n = 6
 * 输出：true
 * 解释：6 = 2 × 3
 */
public class UglyNumber {

    /**
     * 题意：判断一个整数的因数是否仅由 2、3、5 构成。
     *
     * 今天的题目是难得的 Easy 题。只需要把 n 对 2、3、5 整除，看最后是否仅剩下 1。
     *
     * 需要注意的是，0 和负数都不是丑数。因为 0 的因数没有 2、3、5；而负数的因数中一定有一个负数，所以因数不仅仅是 2、3、5。
     *
     * @param n
     * @return
     */
    public boolean isUgly(int n) {
        if(n <= 0){
            return false;
        }
        while(n%2 == 0){
            n = n/2;
        }
        while(n%3 == 0){
            n = n/3;
        }
        while(n%5 == 0){
            n = n/5;
        }

        return n==1;
    }

}
