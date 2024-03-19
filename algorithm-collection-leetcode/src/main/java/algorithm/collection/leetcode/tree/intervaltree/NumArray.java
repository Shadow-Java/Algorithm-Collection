package algorithm.collection.leetcode.tree.intervaltree;

import algorithm.collection.common.datastruct.tag.DataStructType;
import algorithm.collection.common.datastruct.tag.DifficultyLevel;
import algorithm.collection.common.datastruct.tag.QuestionTag;
import algorithm.collection.common.datastruct.tag.TimeComplexity;
import algorithm.collection.leetcode.tree.binarysearch.GenerateTrees;

/**
 * 给定一个整数数组  nums，处理以下类型的多个查询:
 *
 * 计算索引 left 和 right （包含 left 和 right）之间的 nums 元素的 和 ，其中 left <= right
 * 实现 NumArray 类：
 *
 * NumArray(int[] nums) 使用数组 nums 初始化对象
 * int sumRange(int i, int j) 返回数组 nums 中索引 left 和 right 之间的元素的 总和 ，包含 left 和 right 两点（也就是 nums[left] + nums[left + 1] + ... + nums[right] )
 *
 * 输入：
 * ["NumArray", "sumRange", "sumRange", "sumRange"]
 * [[[-2, 0, 3, -5, 2, -1]], [0, 2], [2, 5], [0, 5]]
 * 输出：
 * [null, 1, -1, -3]
 * @author shadow
 * @create 2024-03-20 04:38
 **/
@QuestionTag(
        difficultyLeve = DifficultyLevel.EASY,
        questionNumber = "303",
        questionTitle = "区域和检索 - 数组不可变",
        relevateClass = GenerateTrees.class,
        desc = "计算索引 left 和 right （包含 left 和 right）之间的 nums 元素的 和 ，其中 left <= right。",
        questionLink = "https://leetcode.cn/problems/range-sum-query-immutable/description/?envType=daily-question&envId=2024-03-18",
        timeComplexity = TimeComplexity.O_N,
        dataStructTypes = {DataStructType.ARRAY_LIST}
)
public class NumArray {

    private int[] nums;

    public NumArray(int[] nums) {
        this.nums = nums;
    }

    public int sumRange(int left, int right) {
        int res=0;
        for(int i=left;i<=right;i++) {
            res += nums[i];
        }
        return res;
    }

    /**
     * 前缀和：在初始化数组的时候分配的前缀和
     * @param nums
     * @param prefixSum
     */
    public NumArray(int[] nums,boolean prefixSum) {
        nums = new int[nums.length];
        int sum =0;
        for(int i=0;i<nums.length;i++){
            sum = sum + nums[i];
            nums[i] = sum;
        }
    }

    public int sumRange_2(int left, int right) {
        if(left==0){
            return nums[right];
        }else {
            return nums[right]-nums[left-1];
        }
    }

}
