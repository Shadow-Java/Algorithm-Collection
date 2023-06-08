package algorithm.collection.leetcode.bitManipulation;

import algorithm.collection.common.datastruct.array.ArrayRandomGenerator;
import algorithm.collection.common.datastruct.tag.AlgorithmCategory;
import algorithm.collection.common.datastruct.tag.DataStructType;
import algorithm.collection.common.datastruct.tag.DifficultyLevel;
import algorithm.collection.common.datastruct.tag.MethodTag;
import algorithm.collection.common.datastruct.tag.QuestionTag;
import algorithm.collection.common.datastruct.tag.TimeComplexity;

import java.util.ArrayList;
import java.util.List;

/**
 * 给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）
 * 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。
 *
 * 输入：nums = [1,2,3]
 * 输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
 *
 * 输入：nums = [0]
 * 输出：[[],[0]]
 * @author shadow
 * @create 2023-05-18 00:37
 **/
@QuestionTag(
        difficultyLeve = DifficultyLevel.EASY,
        questionNumber = "78",
        questionTitle = "子集",
        desc = "给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）",
        questionLink = "https://leetcode.cn/problems/subsets/",
        algorithmCategory = AlgorithmCategory.BIT_MANIPULATION,
        timeComplexity = TimeComplexity.O_N_2,
        dataStructTypes = {DataStructType.ARRAY_LIST}
)
public class Subsets {

    static List<Integer> t = new ArrayList<>();
    static List<List<Integer>> ans = new ArrayList<>();

    @MethodTag(
            questionNumber = "78",
            methodLink = "https://leetcode.cn/problems/subsets/",
            timeComplexity = TimeComplexity.O_N_2,
            dataStructType = DataStructType.ARRAY_LIST,
            algorithmCategory = AlgorithmCategory.VIOLENCE
    )
    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> resList = new ArrayList<>(new ArrayList<>());
        for (int i=0;i< nums.length;i++){
            List<Integer> list = new ArrayList<>();
            list.add(nums[i]);
            for (int j=i+1;j< nums.length;j++){
                list.add(nums[j]);
            }
            resList.add(list);
        }
        return resList;
    }

    @MethodTag(
            questionNumber = "78",
            methodLink = "https://leetcode.cn/problems/subsets/",
            timeComplexity = TimeComplexity.O_N,
            dataStructType = DataStructType.ARRAY_LIST,
            algorithmCategory = AlgorithmCategory.DEPTH_FIRST_SEARCH
    )
    public static List<List<Integer>> subsetsAnotherWay(int[] nums) {
        dfs(0,nums);
        return ans;
    }

    public static void dfs(int cur,int[] nums){
        if(cur == nums.length){
            ans.add(new ArrayList<>(t));
            return;
        }
        t.add(nums[cur]);//选择当前元素
        dfs(cur+1,nums);
        t.remove(t.size()-1);//不选择当前元素
        dfs(cur+1,nums);
    }



    /**
     * dfs、暴力
     * @param args
     */
    public static void main(String[] args) {
        int[] nums = ArrayRandomGenerator.generateRandomArray(5,7,10);
        ArrayRandomGenerator.printArray(nums);
        List<List<Integer>> resList = subsets(nums);
        resList.forEach(System.out::println);
    }


}
