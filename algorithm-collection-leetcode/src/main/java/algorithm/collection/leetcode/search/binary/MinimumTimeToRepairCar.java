package algorithm.collection.leetcode.search.binary;


import algorithm.collection.common.datastruct.tag.AlgorithmCategory;
import algorithm.collection.common.datastruct.tag.DataStructType;
import algorithm.collection.common.datastruct.tag.DifficultyLevel;
import algorithm.collection.common.datastruct.tag.MethodTag;
import algorithm.collection.common.datastruct.tag.QuestionTag;
import algorithm.collection.common.datastruct.tag.TimeComplexity;
import algorithm.collection.primary.tree.DeepWidthSearch;

/**
 * 给你一个整数数组 ranks ，表示一些机械工的 能力值 。ranksi 是第 i 位机械工的能力值。能力值为 r 的机械工可以在 r * n2 分钟内修好 n 辆车。
 *
 * 同时给你一个整数 cars ，表示总共需要修理的汽车数目。
 *
 * 请你返回修理所有汽车 最少 需要多少时间。
 *
 * 注意：所有机械工可以同时修理汽车。
 *
 * 输入：ranks = [4,2,3,1], cars = 10
 * 输出：16
 * 解释：
 * - 第一位机械工修 2 辆车，需要 4 * 2 * 2 = 16 分钟。
 * - 第二位机械工修 2 辆车，需要 2 * 2 * 2 = 8 分钟。
 * - 第三位机械工修 2 辆车，需要 3 * 2 * 2 = 12 分钟。
 * - 第四位机械工修 4 辆车，需要 1 * 4 * 4 = 16 分钟。
 * 16 分钟是修理完所有车需要的最少时间。
 *
 * 输入：ranks = [5,1,8], cars = 6
 * 输出：16
 * 解释：
 * - 第一位机械工修 1 辆车，需要 5 * 1 * 1 = 5 分钟。
 * - 第二位机械工修 4 辆车，需要 1 * 4 * 4 = 16 分钟。
 * - 第三位机械工修 1 辆车，需要 8 * 1 * 1 = 8 分钟。
 * 16 分钟时修理完所有车需要的最少时间。
 *
 * @author shadow
 * @create 2023-09-17 20:08
 **/
@QuestionTag(
        difficultyLeve = DifficultyLevel.HARD,
        questionNumber = "2594",
        questionTitle = "修车的最少时间",
        relevateClass = DeepWidthSearch.class,
        desc = "给你一个整数数组 ranks ，表示一些机械工的 能力值 。ranksi 是第 i 位机械工的能力值。能力值为 r 的机械工可以在 r * n2 分钟内修好 n 辆车。",
        questionLink = "https://leetcode.cn/problems/minimum-time-to-repair-cars/description/",
        algorithmCategory = AlgorithmCategory.BINARY_FIND,
        timeComplexity = TimeComplexity.O_LOG_N,
        dataStructTypes = {DataStructType.ARRAY_LIST}
)
public class MinimumTimeToRepairCar {

    /**
     * ranks表示每个员工的排位，需要rank越低的员工修复多的车辆，这样就能让修车时间更短
     * 员工的time=r*n^2, √time/r为每个员工能修的车辆，即二分查找最大时间，能力值和时间是已知，只需要所修的车辆能大于总的车辆数
     * @param ranks
     * @param cars
     * @return
     */
    @MethodTag(
            questionNumber = "2594",
            methodLink = "https://leetcode.cn/problems/minimum-time-to-repair-cars/solutions/2177199/er-fen-da-an-pythonjavacgo-by-endlessche-keqf/",
            timeComplexity = TimeComplexity.O_N_2,
            dataStructType = DataStructType.ARRAY_LIST,
            algorithmCategory = AlgorithmCategory.BINARY_FIND
    )
    public long repairCars(int[] ranks, int cars) {
        int minR = ranks[0];
        for (int r : ranks) {
            minR = Math.min(minR, r);
        }
        long left = 0;
        //计算出最可能得最大时间，即能力强的人修完全部车所要的时间
        long right = (long) minR * cars * cars;
        //二分查找[0,maxtime]
        while (left + 1 < right) { // 开区间
            long mid = (left + right) >> 1;
            long s = 0;
            for (int r : ranks) {
                s += Math.sqrt(mid / r);
            }
            if (s >= cars) {
                right = mid; // 满足要求
            } else {
                left = mid;
            }
        }
        return right; // 最小的满足要求的值
    }

    /**
     * 能力值相同的人，在 ttt 分钟内修好的车的个数是一样的。
     *
     * 根据数据范围，ranks 中至多有 100 个不同的数字，我们可以统计 ranks中每个数字的出现次数，这样每次二分至多循环 100 次。
     *
     * 此外，如果循环中发现 s≥cars，可以提前退出循环。
     *
     * @param ranks
     * @param cars
     * @return
     */
    public long repairCarsAnotherway(int[] ranks, int cars) {
        int[] cnt = new int[101]; // 数组比哈希表更快
        int minR = ranks[0];
        for (int r : ranks) {
            cnt[r]++;
            minR = Math.min(minR, r);
        }
        long left = 0;
        long right = (long) minR * cars * cars;
        while (left + 1 < right) {
            long mid = (left + right) >> 1;
            long s = 0;
            for (int r = minR; r <= 100 && s < cars; r++) { // 至多循环 100 次
                s += (long) Math.sqrt(mid / r) * cnt[r];
            }
            if (s >= cars) {
                right = mid;
            } else {
                left = mid;
            }
        }
        return right;
    }

}
