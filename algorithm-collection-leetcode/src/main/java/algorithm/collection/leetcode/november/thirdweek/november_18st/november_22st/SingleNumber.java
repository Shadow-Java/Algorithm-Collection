package algorithm.collection.leetcode.november.thirdweek.november_18st.november_22st;

/**
 * 136. 只出现一次的数字
 * 给你一个 非空 整数数组 nums ，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 *
 * 你必须设计并实现线性时间复杂度的算法来解决此问题，且该算法只使用常量额外空间。
 *
 * 输入：nums = [2,2,1]
 * 输出：1
 *
 * 输入：nums = [4,1,2,1,2]
 * 输出：4
 *
 * 输入：nums = [1]
 * 输出：1
 *
 * @author shadow
 * @create 2024-11-23 16:05
 **/
public class SingleNumber {

    /**
     * 异或运算：相同为0，不同为1；一个数与0异或是它本身,很多相同的对转换为0后，0与0异或也是本身0，所以最终是0异或唯一的那个数
     * @param nums
     * @return
     */
    public int singleNumber(int[] nums) {
        int ans =0;
        for (int num:nums) {
            ans = ans^num;
        }
        return ans;
    }

    /**
     * 位运算技巧：
     *    1.异或计算交换两个数
     *    2.
     */
    public void bitOperations() {
        //判断一个数是否为奇数还是偶数
        //1.异或找出只出现一次的数和偶数次的数
    }

    /**
     * 判断一个数是否为奇数或偶数；
     * 作用：检查 x 的最低位（即最右边的一位）是否为1；
     *    如果 x 是奇数，x & 1 的结果是 1。
     *    如果 x 是偶数，x & 1 的结果是 0
     * 等价：x%2==0
     * @param x
     * @return
     */
    boolean isOdd(int x) {
        return (x & 1) == 1;
    }

    /**
     * 提取最右侧的1
     * x = 5         -> 0000 0101
     * ~x            -> 1111 1010
     * ~x + 1        -> 1111 1011
     * x & (~x + 1)  -> 0000 0001
     */

}
