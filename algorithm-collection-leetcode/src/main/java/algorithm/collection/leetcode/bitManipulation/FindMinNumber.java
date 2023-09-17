package algorithm.collection.leetcode.bitManipulation;

import algorithm.collection.common.datastruct.tag.AlgorithmCategory;
import algorithm.collection.common.datastruct.tag.DataStructType;
import algorithm.collection.common.datastruct.tag.DifficultyLevel;
import algorithm.collection.common.datastruct.tag.MethodTag;
import algorithm.collection.common.datastruct.tag.QuestionTag;
import algorithm.collection.common.datastruct.tag.TimeComplexity;

/**
 * @author shadow
 * @create 2023-09-16 23:23
 **/
@QuestionTag(
        difficultyLeve = DifficultyLevel.EASY,
        questionNumber = "2605",
        questionTitle = "从两个数字数组里生成最小数字",
        relevateClass = CountPrimeSetBits.class,
        desc = "给你两个只包含 1 到 9 之间数字的数组 nums1 和 nums2 ，每个数组中的元素 互不相同 ，请你返回 最小 的数字，两个数组都 至少 包含这个数字的某个数位。",
        questionLink = "https://leetcode.cn/problems/form-smallest-number-from-two-digit-arrays/description/",
        timeComplexity = TimeComplexity.O_N,
        dataStructTypes = {DataStructType.ARRAY_LIST}
)
public class FindMinNumber {

    @MethodTag(
            questionNumber = "2605",
            methodLink = "https://leetcode.cn/problems/form-smallest-number-from-two-digit-arrays/description/",
            timeComplexity = TimeComplexity.O_N_2,
            dataStructType = DataStructType.ARRAY_LIST,
            algorithmCategory = AlgorithmCategory.BIT_MANIPULATION
    )
    public int minNumber(int[] nums1, int[] nums2) {
        //从这两个数组中找到最小的数字
        int min1 = Integer.MAX_VALUE;
        for(int val:nums1){
            if(val < min1){
                min1 = val;
            }
        }
        int min2 = Integer.MAX_VALUE;
        for(int val:nums2){
            if(val < min2){
                min2 = val;
            }
        }
        int min3 = Integer.MAX_VALUE;
        for(int val1:nums1){
            for(int val2:nums2){
                if(val2 == val1 && val2 < min3){
                    min3 = val1;
                }
            }
        }
        int res = min1 < min2 ? min1*10+min2:min2*10+min1;
        return Math.min(res,min3);
    }

    /**
     * 由于数字的范围是 1∼9，我们可以用一个长度为 10 的二进制数来表示数组 nums1 和 nums2 中的数字。我们用 mask1 表示数组 nums1 中的数字，用 mask2 表示数组 nums2 中的数字。
     *
     * 如果 mask1 和 mask2 进行按位与得到的数字 mask 不等于 0，那么我们提取 mask 中最后一位 111 所在的位置，即为最小的数字。
     *
     * 否则，我们分别提取 mask1 和 mask2 中最后一位 1 所在的位置，分别记为 a 和 b，那么最小的数字就是 min(a×10+b,b×10+a)。
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public int minNumberAnotherway(int[] nums1, int[] nums2) {
        //可以将mask1二进制看成一个容纳[1,9]数字的数组，那么mask1现在就是二进制的，比如数字3记录为1000，即第三位为1
        //这种记录方式(1 << x)|mask,或运算就是将mask的值第x位记录为1
        //比如nums1={2,3,4,5},那么mask的二进制为111100，且十进制为60
        int mask1 = 0, mask2 = 0;
        for (int x : nums1) {
            /**
             * 拆分为1 << x，即1向左移动x位，res = 1*2^x；这行代码的含义是将位于索引 x 的二进制位设置为 1，其他为0
             * mask1 = mask1 | res 或运算，进行或运算时
             *
             */
            mask1 |= 1 << x;
        }
        for (int x : nums2) {
            mask2 |= 1 << x;
        }
        //与运算将相同位置的1记录为1，不同的为0，这样能得到相同的位数，最后找到最低位的1即为最小的相同数
        int mask = mask1 & mask2;
        if (mask != 0) {
            //为二进制数的最后右多少个0，也就是十进制数
            return Integer.numberOfTrailingZeros(mask);
        }
        //拿到十进制数然后记录
        int a = Integer.numberOfTrailingZeros(mask1);
        int b = Integer.numberOfTrailingZeros(mask2);
        return Math.min(a * 10 + b, b * 10 + a);
    }

}
