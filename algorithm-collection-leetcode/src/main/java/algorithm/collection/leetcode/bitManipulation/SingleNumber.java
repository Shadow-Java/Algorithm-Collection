package algorithm.collection.leetcode.bitManipulation;

import algorithm.collection.common.datastruct.tag.AlgorithmCategory;
import algorithm.collection.common.datastruct.tag.DataStructType;
import algorithm.collection.common.datastruct.tag.DifficultyLevel;
import algorithm.collection.common.datastruct.tag.MethodTag;
import algorithm.collection.common.datastruct.tag.QuestionTag;
import algorithm.collection.common.datastruct.tag.TimeComplexity;

import java.util.HashSet;
import java.util.Set;

/**
 * 给你一个 非空 整数数组 nums ，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 * 输入：nums = [2,2,1]
 * 输出：1
 * 示例 2 ：
 *
 * 输入：nums = [4,1,2,1,2]
 * 输出：4
 * 示例 3 ：
 *
 * 输入：nums = [1]
 * 输出：1
 * @author shadow
 * @create 2023-05-18 00:38
 **/
@QuestionTag(
        difficultyLeve = DifficultyLevel.EASY,
        questionNumber = "136",
        questionTitle = "无重复字符的最长子串",
        desc = "给你一个 非空 整数数组 nums ，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。",
        questionLink = "https://leetcode.cn/problems/longest-substring-without-repeating-characters/",
        algorithmCategory = AlgorithmCategory.BIT_MANIPULATION,
        timeComplexity = TimeComplexity.O_N,
        dataStructTypes = {DataStructType.ARRAY_LIST}
)
public class SingleNumber {

    @MethodTag(
            questionNumber = "136",
            methodLink = "https://leetcode.cn/problems/longest-substring-without-repeating-characters/solution/hua-dong-chuang-kou-by-powcai/",
            timeComplexity = TimeComplexity.O_N,
            dataStructType = DataStructType.ARRAY_LIST,
            algorithmCategory = AlgorithmCategory.BIT_MANIPULATION
    )
    public int singleNumber(int[] nums) {
        int res = 0;
        for (int x: nums) {
            res = res^x;
        }
        return res;
    }


    @MethodTag(
            questionNumber = "136",
            methodLink = "https://leetcode.cn/problems/longest-substring-without-repeating-characters/solution/hua-dong-chuang-kou-by-powcai/",
            timeComplexity = TimeComplexity.O_N,
            dataStructType = DataStructType.ARRAY_LIST,
            algorithmCategory = AlgorithmCategory.OTHER
    )
    public static int singleNumberAnotherWay(int[] nums) {
        Set<Integer> set = new HashSet<>();
        //记忆化搜索
        for(int x:nums){
            if(set.contains(x)){
                set.remove(x);
            }else{
                set.add(x);
            }
        }
        return set.size() == 1 ? (Integer)set.toArray()[0] : 0;
    }

    public static void main(String[] args) {
        int[] nums = {1,1,2,5,5,6,6};
        System.out.println(singleNumberAnotherWay(nums));
    }
}
