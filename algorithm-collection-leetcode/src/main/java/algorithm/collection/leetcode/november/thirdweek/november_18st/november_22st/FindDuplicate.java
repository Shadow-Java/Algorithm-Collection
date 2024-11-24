package algorithm.collection.leetcode.november.thirdweek.november_18st.november_22st;

/**
 * 287. 寻找重复数
 * 给定一个包含 n + 1 个整数的数组 nums ，其数字都在 [1, n] 范围内（包括 1 和 n），可知至少存在一个重复的整数。
 * <p>
 * 假设 nums 只有 一个重复的整数 ，返回 这个重复的数 。
 * <p>
 * 你设计的解决方案必须 不修改 数组 nums 且只用常量级 O(1) 的额外空间。
 * <p>
 * 输入：nums = [1,3,4,2,2]
 * 输出：2
 * <p>
 * 输入：nums = [3,1,3,4,2]
 * 输出：3
 * <p>
 * 输入：nums = [3,3,3,3,3]
 * 输出：3
 *
 * @author shadow
 * @create 2024-11-24 00:13
 **/
public class FindDuplicate {

    /**
     * 使用环形链表II的方法解题（142.环形链表II），使用 142 题的思想来解决此题的关键是要理解如何将输入的数组看作为链表。
     * 首先明确前提，整数的数组 nums 中的数字范围是 [1,n]。考虑一下两种情况
     * 如果数组中有重复的数，以数组 [1,3,4,2,2] 为例,我们将数组下标 n 和数 nums[n] 建立一个映射关系 f(n)，
     * 其映射关系 n->f(n) 为：
     * 0->1
     * 1->3
     * 2->4
     * 3->2
     * 4->2
     * 同样的，我们从下标为 0 出发，根据 f(n) 计算出一个值，以这个值为新的下标，再用这个函数计算，以此类推产生一个类似链表一样的序列。
     * 0->1->3->2->4->2->4->2->……
     * 这里 2->4 是一个循环，那么这个链表可以抽象为下图
     * 从理论上讲，数组中如果有重复的数，那么就会产生多对一的映射，这样，形成的链表就一定会有环路了，
     *
     * 综上
     * 1.数组中有一个重复的整数 <==> 链表中存在环
     * 2.找到数组中的重复整数 <==> 找到链表的环入口
     *
     * 至此，问题转换为 142 题。那么针对此题，快、慢指针该如何走呢。根据上述数组转链表的映射关系，可推出
     * 142 题中慢指针走一步 slow = slow.next ==> 本题 slow = nums[slow]
     * 142 题中快指针走两步 fast = fast.next.next ==> 本题 fast = nums[nums[fast]]
     *
     * @param nums
     * @return
     */
    public int findDuplicate(int[] nums) {
        int slow = 0;
        int fast = 0;
        slow = nums[slow];
        fast = nums[nums[fast]];
        while (slow != fast) {//当出现环停止
            slow = nums[slow];
            fast = nums[nums[fast]];
        }
        int pre1 = 0;
        int pre2 = slow;
        while (pre1 != pre2) {//找到环入口
            pre1 = nums[pre1];
            pre2 = nums[pre2];
        }
        return pre1;
    }

}
