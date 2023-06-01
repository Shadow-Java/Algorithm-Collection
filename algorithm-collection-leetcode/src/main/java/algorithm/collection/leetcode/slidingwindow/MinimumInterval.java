package algorithm.collection.leetcode.slidingwindow;

import algorithm.collection.common.datastruct.tag.AlgorithmCategory;
import algorithm.collection.common.datastruct.tag.DataStructType;
import algorithm.collection.common.datastruct.tag.DifficultyLevel;
import algorithm.collection.common.datastruct.tag.MethodTag;
import algorithm.collection.common.datastruct.tag.QuestionTag;
import algorithm.collection.common.datastruct.tag.TimeComplexity;

import java.util.ArrayList;
import java.util.List;

/**
 * 你有 k 个 非递减排列 的整数列表。找到一个 最小 区间，使得 k 个列表中的每个列表至少有一个数包含在其中。
 *
 * 我们定义如果 b-a < d-c 或者在 b-a == d-c 时 a < c，则区间 [a,b] 比 [c,d] 小。
 *
 * 输入：nums = [[4,10,15,24,26], [0,9,12,20], [5,18,22,30]]
 * 输出：[20,24]
 * 解释：
 * 列表 1：[4, 10, 15, 24, 26]，24 在区间 [20,24] 中。
 * 列表 2：[0, 9, 12, 20]，20 在区间 [20,24] 中。
 * 列表 3：[5, 18, 22, 30]，22 在区间 [20,24] 中。
 *
 * 输入：nums = [[1,2,3],[1,2,3],[1,2,3]]
 * 输出：[1,1]
 *
 * @author shadow
 * @create 2023-05-28 17:05
 **/
@QuestionTag(
        questionNumber = "632",
        questionTitle = "最小区间",
        difficultyLeve = DifficultyLevel.HARD,
        membershipQuestion = true,
        questionLink = "https://leetcode.cn/problems/smallest-range-covering-elements-from-k-lists/",
        algorithmCategory = AlgorithmCategory.SLIDE_WINDOW,
        timeComplexity = TimeComplexity.O_N
)
public class MinimumInterval {

    /**
     * 1.需要区间最小，计算区间最小的是：定义如果 b-a < d-c 或者在 b-a == d-c 时 a < c，则区间 [a,b] 比 [c,d] 小。
     * 2.给的参数集 至少有一个元素在该区间内
     * 解题思路：
     * 首先将 kkk 组数据升序合并成一组，并记录每个数字所属的组，例如：[[4,10,15,24,26],[0,9,12,20],[5,18,22,30]]
     * 合并升序后得到： [(0,1),(4,0),(5,2),(9,1),(10,0),(12,1),(15,0),(18,2),(20,1),(22,2),(24,0),(26,0),(30,2)][(0, 1), (4, 0), (5, 2), (9, 1), (10, 0), (12, 1), (15, 0), (18, 2), (20, 1), (22, 2), (24, 0), (26, 0), (30, 2)][(0,1),(4,0),(5,2),(9,1),(10,0),(12,1),(15,0),(18,2),(20,1),(22,2),(24,0),(26,0),(30,2)]
     *
     * 然后只看所属组的话，那么[1,0,2,1,0,1,0,2,1,2,0,0,2]
     * 按组进行滑窗，保证一个窗口的组满足kkk组后在记录窗口的最小区间值
     *
     * [1 0 2] 2 1 0 1 0 2 1 2 0 0 2    [0, 5]
     * 1 [0 2 1] 1 0 1 0 2 1 2 0 0 2    [0, 5]
     * 1 0 [2 1 0] 0 1 0 2 1 2 0 0 2    [0, 5]
     * 1 0 [2 1 0 1] 1 0 2 1 2 0 0 2    [0, 5]
     * 1 0 [2 1 0 1 0] 0 2 1 2 0 0 2    [0, 5]
     * 1 0 2 1 0 [1 0 2] 2 1 2 0 0 2    [0, 5]
     * 1 0 2 1 0 1 [0 2 1] 1 2 0 0 2    [0, 5]
     * 1 0 2 1 0 1 [0 2 1 2] 2 0 0 2    [0, 5]
     * 1 0 2 1 0 1 0 2 [1 2 0] 0 0 2    [20, 24]
     * 1 0 2 1 0 1 0 2 [1 2 0 0] 0 2    [20, 24]
     * 1 0 2 1 0 1 0 2 [1 2 0 0 2] 2    [20, 24]
     *
     *

     *
     * @param nums
     * @return
     */
    @MethodTag(
            questionNumber = "632",
            methodLink = "https://leetcode.cn/problems/smallest-range-covering-elements-from-k-lists/solutions/240717/pai-xu-hua-chuang-by-netcan/",
            timeComplexity = TimeComplexity.O_N,
            dataStructType = DataStructType.ARRAY_LIST,
            algorithmCategory = AlgorithmCategory.SLIDE_WINDOW
    )
    public int[] smallestRange(List<List<Integer>> nums) {
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < nums.size(); i++) {
            List<Integer> num = nums.get(i);
            for (Integer n : num) {
                list.add(new int[]{n, i}); // 整数, 区间
            }
        }
        list.sort((p1, p2) -> p1[0] - p2[0]);
        int winCnt = 0;
        int[] used = new int[nums.size()];
        int left = 0;
        int areaLeft = list.get(0)[0];
        int areaRight = list.get(list.size() - 1)[0];
        for (int right = 0; right < list.size(); right++) {
            int[] cur = list.get(right);
            if (++used[cur[1]] == 1) {
                winCnt++;
            }
            while (winCnt == nums.size()) {
                int[] pre = list.get(left);
                if (cur[0] - pre[0] < areaRight - areaLeft) {
                    areaLeft = pre[0];
                    areaRight = cur[0];
                }
                if (--used[pre[1]] == 0) {
                    winCnt--;
                }
                left++;
            }
        }
        return new int[]{areaLeft, areaRight};
    }

}
