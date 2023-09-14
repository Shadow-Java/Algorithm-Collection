package algorithm.collection.leetcode.sort;

import algorithm.collection.common.datastruct.tag.AlgorithmCategory;
import algorithm.collection.common.datastruct.tag.DataStructType;
import algorithm.collection.common.datastruct.tag.DifficultyLevel;
import algorithm.collection.common.datastruct.tag.MethodTag;
import algorithm.collection.common.datastruct.tag.QuestionTag;
import algorithm.collection.common.datastruct.tag.TimeComplexity;
import algorithm.collection.primary.tree.DeepWidthSearch;

import java.util.Arrays;

/**
 * @author shadow
 * @create 2023-09-04 00:25
 **/
@QuestionTag(
        difficultyLeve = DifficultyLevel.MEDIUM,
        questionNumber = "1921",
        questionTitle = "消灭怪物的最大数量",
        relevateClass = DeepWidthSearch.class,
        desc = "你正在玩一款电子游戏，在游戏中你需要保护城市免受怪物侵袭。给你一个 下标从 0 开始 且长度为 n 的整数数组 dist ，其中 dist[i] 是第 i 个怪物与城市的 初始距离（单位：米）。",
        questionLink = "https://leetcode.cn/problems/eliminate-maximum-number-of-monsters/description/?envType=daily-question&envId=2023-09-03",
        algorithmCategory = AlgorithmCategory.OTHER,
        timeComplexity = TimeComplexity.O_N_2,
        dataStructTypes = {DataStructType.ARRAY_LIST}
)
public class EliminateMaximumNumberMonsters {

    @MethodTag(
            questionNumber = "1921",
            methodLink = "https://leetcode.cn/problems/eliminate-maximum-number-of-monsters/solutions/857961/xiao-mie-guai-wu-de-zui-da-shu-liang-by-0ou2p/?envType=daily-question&envId=2023-09-03",
            timeComplexity = TimeComplexity.O_N,
            dataStructType = DataStructType.ARRAY_LIST,
            algorithmCategory = AlgorithmCategory.DEPTH_FIRST_SEARCH
    )
    public static int eliminateMaximum(int[] dist, int[] speed) {
        //java, 排序
        int n = dist.length;
        //记录每只怪兽到达需要的时间
        var arr = new int[n];
        for (int i = 0; i < n; i++) {
            if (dist[i] == 0) {
                return 0;
            }
            arr[i] = dist[i] % speed[i] == 0 ? dist[i] / speed[i] - 1: dist[i] / speed[i];
        }
        //排序
        Arrays.sort(arr);
        //每分钟我们都可以杀一只怪兽，如果怪兽在我们击杀前到达，GG
        for (int i = 1; i < n; i++) {
            //arr[i]为到达需要的时间，那么每个i时只能杀死一只
            if (arr[i] < i) {
                return i;
            }
        }
        return n;
    }


    public static void main(String[] args) {
        int[] nums = {1,3,4};
        int[] speed = {1,1,1};
        System.out.println(eliminateMaximum(nums,speed));
    }

}
