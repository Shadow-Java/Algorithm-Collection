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

    /**
     * <pre>
     *    这种区间将数组分为左段、中段和右段，左段和右段都是升序排列，中段是无序<br/>
     *    如果进入了右段，就没有比最大值小的数，所以最后一个比最大值小的数就是中段的右边界;
     *    同理，如果进入左段，就不会出现比最小值更大的情况，所以最后一个出现就视为中段左边界.
     * </pre>
     * @param nums
     * @return
     */
    public int anotherWay(int[] nums) {
        //初始化
        int len = nums.length;
        int min = nums[len-1];
        int max = nums[0];
        int begin = 0;
        int end = -1;
        //遍历
        for(int i = 0; i < len; i++){
            if(nums[i] < max){      //从左到右维持最大值，寻找右边界end
                end = i;
            }else{
                max = nums[i];
            }

            if(nums[len-i-1] > min){    //从右到左维持最小值，寻找左边界begin
                begin = len-i-1;
            }else{
                min = nums[len-i-1];
            }
        }
        return end-begin+1;
    }



}
