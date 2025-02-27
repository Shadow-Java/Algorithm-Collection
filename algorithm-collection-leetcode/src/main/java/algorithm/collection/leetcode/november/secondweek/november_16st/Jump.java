package algorithm.collection.leetcode.november.secondweek.november_16st;

import algorithm.collection.common.datastruct.tag.DataStructType;
import algorithm.collection.common.datastruct.tag.DifficultyLevel;
import algorithm.collection.common.datastruct.tag.QuestionTag;
import algorithm.collection.common.datastruct.tag.TimeComplexity;

import java.util.Arrays;

/**
 * 45. 跳跃游戏 II
 * 给定一个长度为 n 的 0 索引整数数组 nums。初始位置为 nums[0]。
 *
 * 每个元素 nums[i] 表示从索引 i 向前跳转的最大长度。换句话说，如果你在 nums[i] 处，你可以跳转到任意 nums[i + j] 处:
 *
 * 0 <= j <= nums[i]
 * i + j < n
 * 返回到达 nums[n - 1] 的最小跳跃次数。生成的测试用例可以到达 nums[n - 1]。
 *
 * 输入: nums = [2,3,1,1,4]
 * 输出: 2
 * 解释: 跳到最后一个位置的最小跳跃数是 2。
 *      从下标为 0 跳到下标为 1 的位置，跳 1 步，然后跳 3 步到达数组的最后一个位置。
 *
 * 输入: nums = [2,3,0,1,4]
 * 输出: 2
 *
 * @author shadow
 * @create 2024-11-16 23:21
 **/
@QuestionTag(
        difficultyLeve = DifficultyLevel.HARD,
        questionNumber = "45",
        questionTitle = "45. 跳跃游戏 II",
        relevateClass = MinTaps.class,
        timeComplexity = TimeComplexity.O_N,
        dataStructTypes = {DataStructType.ARRAY_LIST}
)
public class Jump {

    /**
     * 1、想象有一条河，你站在0，要到n-1处；把区间[i,nums[i]+i]视作一座桥，一开始只能建造一座桥，也就是[0,0+nums[0]];
     * 2、在可以选中的桥中，选择右端点最大的桥，会让你走的更远
     * 1、问：如果题目没有保证一定能到达 n−1，代码要怎么改？答：见 1326. 灌溉花园的最少水龙头数目
     * @param nums
     * @return
     */
    public int jump(int[] nums) {
        int ans = 0;
        //当前选中的桥能覆盖的范围
        int curRight = 0; // 已建造的桥的右端点
        //在遍历已经选中的覆盖范围后的能经过最大的覆盖范围时，选择下一次能够到达的最大的点
        int nextRight = 0; // 下一座桥的右端点的最大值
        for (int i = 0; i < nums.length - 1; i++) {
            nextRight = Math.max(nextRight, i + nums[i]);
            if (i == curRight) { // 到达已建造的桥的右端点
                curRight = nextRight; // 造一座桥
                ans++;
            }
        }
        return ans;
    }

    /**
     * TODO 校验是否合理
     * @param nums
     * @return
     */
    public int jumpV2(int[] nums) {
        //跳或者不跳
        int[] f = new int[nums.length + 1];
        Arrays.fill(f, Integer.MAX_VALUE);
        f[0] = 1;
        for (int i = 1; i < nums.length + 1; i++) {
            if (i < nums[i - 1]) {//可以选择当前
                f[i] = f[i - 1] + 1;
            } else {
                f[i] = Math.min(f[i - 1], f[i - nums[i - 1]]);
            }
        }
        return f[nums.length];
    }

}
