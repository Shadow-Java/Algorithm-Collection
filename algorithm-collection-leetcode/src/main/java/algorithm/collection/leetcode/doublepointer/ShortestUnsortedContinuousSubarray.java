package algorithm.collection.leetcode.doublepointer;

import algorithm.collection.common.datastruct.tag.AlgorithmCategory;
import algorithm.collection.common.datastruct.tag.DataStructType;
import algorithm.collection.common.datastruct.tag.DifficultyLevel;
import algorithm.collection.common.datastruct.tag.MethodTag;
import algorithm.collection.common.datastruct.tag.QuestionTag;
import algorithm.collection.common.datastruct.tag.TimeComplexity;
import algorithm.collection.primary.tree.DeepWidthSearch;

import java.util.Arrays;

/**
 * 给你一个整数数组 nums ，你需要找出一个 连续子数组 ，如果对这个子数组进行升序排序，那么整个数组都会变为升序排序.
 *
 * 输入：nums = [2,6,4,8,10,9,15]
 * 输出：5
 * 解释：你只需要对 [6, 4, 8, 10, 9] 进行升序排序，那么整个表都会变为升序排序
 *
 * 输入：nums = [1,2,3,4]
 * 输出：0
 *
 * 输入：nums = [1]
 * 输出：0
 *
 * @author shadow
 * @create 2023-08-20 19:01
 **/
@QuestionTag(
        difficultyLeve = DifficultyLevel.MEDIUM,
        questionNumber = "581",
        questionTitle = "最短无序连续子数组",
        relevateClass = DeepWidthSearch.class,
        desc = "给你一个整数数组 nums ，你需要找出一个 连续子数组 ，如果对这个子数组进行升序排序，那么整个数组都会变为升序排序。",
        questionLink = "https://leetcode.cn/problems/shortest-unsorted-continuous-subarray/",
        algorithmCategory = AlgorithmCategory.DOUBLE_POINTER,
        timeComplexity = TimeComplexity.O_N_2,
        dataStructTypes = {DataStructType.ARRAY_LIST}
)
public class ShortestUnsortedContinuousSubarray {

    /**
     * 拷贝一份数组，将该数组排序，利用双指针追溯不同的值则为区间
     * @param nums
     * @return
     */
    @MethodTag(
            questionNumber = "581",
            methodLink = "https://leetcode.cn/problems/shortest-unsorted-continuous-subarray/description/",
            timeComplexity = TimeComplexity.O_N,
            dataStructType = DataStructType.ARRAY_LIST,
            algorithmCategory = AlgorithmCategory.DOUBLE_POINTER
    )
    public int findUnsortedSubarray(int[] nums) {
        int[] arr = nums.clone();
        Arrays.sort(arr);
        int length = arr.length;
        int left = 0;
        int right = length-1;
        while (left < length && arr[left] == nums[left]) {
            left++;
        }
        while (right >= 0 && arr[right] == nums[right]) {
            right--;
        }
        return right - left > 0 ? right-left+1 : 0;
    }

}
