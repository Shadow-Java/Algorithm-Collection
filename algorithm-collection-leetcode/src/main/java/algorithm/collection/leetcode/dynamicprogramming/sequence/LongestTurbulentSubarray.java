package algorithm.collection.leetcode.dynamicprogramming.sequence;

import algorithm.collection.common.datastruct.tag.AlgorithmCategory;
import algorithm.collection.common.datastruct.tag.DataStructType;
import algorithm.collection.common.datastruct.tag.DifficultyLevel;
import algorithm.collection.common.datastruct.tag.MethodTag;
import algorithm.collection.common.datastruct.tag.QuestionTag;
import algorithm.collection.common.datastruct.tag.TimeComplexity;

@QuestionTag(
        difficultyLeve = DifficultyLevel.MEDIUM,
        questionNumber = "978",
        questionTitle = "最长湍流子数组",
        relevateClass = LongestIncreasingSubsequence.class,
        desc = "给定一个整数数组 arr ，返回 arr 的 最大湍流子数组的长度",
        questionLink = "https://leetcode.cn/problems/longest-turbulent-subarray/",
        timeComplexity = TimeComplexity.O_N,
        dataStructTypes = {DataStructType.ARRAY_LIST}
)
public class LongestTurbulentSubarray {
    //最长湍流子数组就是只看该数组元素的后一位，数组下标的顺序为偶奇偶奇。。
    //对于当前的数字我需要考虑之前的一位数字，如果是大小，那么后面的就应该是小大，这样组成的数组
    @MethodTag(
            methodLink = "https://leetcode.cn/problems/longest-turbulent-subarray/solution/yi-zhang-dong-tu-xiang-jie-dong-tai-gui-wrwvn/",
            questionNumber = "978",
            timeComplexity = TimeComplexity.O_N,
            dataStructType = DataStructType.ARRAY_LIST,
            algorithmCategory = AlgorithmCategory.DYNAMIC_PROGRAMMING
    )
    public int maxTurbulenceSize(int[] A) {
        //up为f(k)的最后上升段，down为g(k)的最后下降段
        int up = 1,down = 1;
        int ans = 1;
        for(int i=1;i<A.length;i++){
            if(A[i-1] < A[i]){//最后为上升段
                up = down + 1;down = 1;
            }else if(A[i-1] > A[i]){//最后为下降段
                down = up + 1;up = 1;
            }else{
                up = 1;down =1;
            }
            ans = Math.max(ans,Math.max(up,down));
        }
        return ans;
    }
}
