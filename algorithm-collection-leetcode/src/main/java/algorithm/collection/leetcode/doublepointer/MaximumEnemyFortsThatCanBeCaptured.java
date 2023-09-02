package algorithm.collection.leetcode.doublepointer;

import algorithm.collection.common.datastruct.tag.AlgorithmCategory;
import algorithm.collection.common.datastruct.tag.DataStructType;
import algorithm.collection.common.datastruct.tag.DifficultyLevel;
import algorithm.collection.common.datastruct.tag.MethodTag;
import algorithm.collection.common.datastruct.tag.QuestionTag;
import algorithm.collection.common.datastruct.tag.TimeComplexity;

/**
 * 给你一个长度为 n ，下标从 0 开始的整数数组 forts ，表示一些城堡。forts[i] 可以是 -1 ，0 或者 1 ，其中：
 *
 * -1 表示第 i 个位置 没有 城堡。
 * 0 表示第 i 个位置有一个 敌人 的城堡。
 * 1 表示第 i 个位置有一个你控制的城堡。
 * 现在，你需要决定，将你的军队从某个你控制的城堡位置 i 移动到一个空的位置 j ，满足：
 *
 * 0 <= i, j <= n - 1
 * 军队经过的位置 只有 敌人的城堡。正式的，对于所有 min(i,j) < k < max(i,j) 的 k ，都满足 forts[k] == 0 。
 * 当军队移动时，所有途中经过的敌人城堡都会被 摧毁 。
 *
 * 请你返回 最多 可以摧毁的敌人城堡数目。如果 无法 移动你的军队，或者没有你控制的城堡，请返回 0 。
 * @author shadow
 * @create 2023-09-03 00:41
 **/
@QuestionTag(
        difficultyLeve = DifficultyLevel.EASY,
        questionNumber = "2511",
        questionTitle = "最多可以摧毁的敌人城堡数目",
        relevateClass = LinkedListCycle.class,
        desc = "给你一个长度为 n ，下标从 0 开始的整数数组 forts ，表示一些城堡。forts[i] 可以是 -1 ，0 或者 1 ，其中",
        questionLink = "https://leetcode.cn/problems/maximum-enemy-forts-that-can-be-captured/description/",
        algorithmCategory = AlgorithmCategory.DOUBLE_POINTER,
        timeComplexity = TimeComplexity.O_N_2,
        dataStructTypes = {DataStructType.ARRAY_LIST}
)
public class MaximumEnemyFortsThatCanBeCaptured {


    /**
     * 总的来说就是统计[1,-1]中0的个数，那么只需要知道左区间left1或-1，到当前cur+left==0时统计0的个数即可
     * @param forts
     * @return
     */
    @MethodTag(
            questionNumber = "2511",
            methodLink = "https://leetcode.cn/problems/maximum-enemy-forts-that-can-be-captured/solutions/2393779/zui-duo-ke-yi-cui-hui-de-di-ren-cheng-ba-5qmc/",
            timeComplexity = TimeComplexity.O_N,
            dataStructType = DataStructType.ARRAY_LIST,
            algorithmCategory = AlgorithmCategory.DOUBLE_POINTER
    )
    public int captureForts(int[] forts) {
        int max = 0;
        //左区间的值
        int curLeftOne = 0;
        for(int i=0;i<forts.length;i++){
            int cur = forts[i];
            if(cur == 1 || cur == -1){
                curLeftOne = cur;
                break;
            }
        }
        //从1到-1间0的个数
        int countZero = 0;
        for(int i=0;i<forts.length;i++){
            int cur = forts[i];
            if(cur == curLeftOne){
                countZero = 0;
            }
            if(curLeftOne + cur == 0){
                curLeftOne = cur;
                max = Math.max(max,countZero);
                countZero = 0;
            }
            if(cur == 0){//从-1到1的转变
                countZero++;
            }
        }
        return max;
    }

    /**
     * 直接模拟:
     * 根据以上分析可以知道由于军队只能在不同位置之间连续移动，军队移动的起点为 111，军队移动的终点为 −1-1−1，军队可以向左移动也可以向右移动，因此我们只需要找到相邻的 111 与 −1-1−1 之间的最大距离即可，此时 111 与 −1-1−1 之间所有的 000 都会被摧毁。查找过程如下：
     *
     * 依次遍历为数组 forts\textit{forts}forts 中的每个元素，此时我们用 pre\textit{pre}pre 记录数组中前一个为 111 或者 −1-1−1 的位置；
     * 假设当前元素 forts[i]\textit{forts}[i]forts[i] 为 111 或者 −1-1−1，即当前位置可能为军队的起点为终点，此时假设 forts[i]≠forts[pre]\textit{forts}[i] \neq \textit{forts}[\textit{pre}]forts[i]
     * 
     * =forts[pre]，即此时可以在 iii 与 pre\textit{pre}pre 之间可以移动，此时可以摧毁的城堡数目为 i−pre−1i - \textit{pre} - 1i−pre−1，更新当前的最大城堡数目，同时记录新的 pre\textit{pre}pre；
     * 按照上述方法找到最大可以摧毁的城堡数目即可。
     *
     * @param forts
     * @return
     */
    @MethodTag(
            questionNumber = "2511",
            methodLink = "https://leetcode.cn/problems/maximum-enemy-forts-that-can-be-captured/solutions/2393779/zui-duo-ke-yi-cui-hui-de-di-ren-cheng-ba-5qmc/",
            timeComplexity = TimeComplexity.O_N,
            dataStructType = DataStructType.ARRAY_LIST,
            algorithmCategory = AlgorithmCategory.DOUBLE_POINTER
    )
    public int captureFortsAnotherWay(int[] forts) {
        int n = forts.length;
        int ans = 0, pre = -1;
        for (int i = 0; i < n; i++) {
            if (forts[i] == 1 || forts[i] == -1) {
                if (pre >= 0 && forts[i] != forts[pre]) {
                    ans = Math.max(ans, i - pre - 1);
                }
                pre = i;
            }
        }
        return ans;
    }

}
