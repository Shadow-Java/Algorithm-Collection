package algorithm.collection.leetcode.array;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 2070. 每一个查询的最大美丽值
 * 给你一个二维整数数组 items ，其中 items[i] = [pricei, beautyi] 分别表示每一个物品的 价格 和 美丽值 。
 *
 * 同时给你一个下标从 0 开始的整数数组 queries 。对于每个查询 queries[j] ，你想求出价格小于等于 queries[j] 的物品中，最大的美丽值 是多少。如果不存在符合条件的物品，那么查询的结果为 0 。
 *
 * 请你返回一个长度与 queries 相同的数组 answer，其中 answer[j]是第 j 个查询的答案。
 *
 * 输入：items = [[1,2],[3,2],[2,4],[5,6],[3,5]], queries = [1,2,3,4,5,6]
 * 输出：[2,4,5,5,6,6]
 * 解释：
 * - queries[0]=1 ，[1,2] 是唯一价格 <= 1 的物品。所以这个查询的答案为 2 。
 * - queries[1]=2 ，符合条件的物品有 [1,2] 和 [2,4] 。
 *   它们中的最大美丽值为 4 。
 * - queries[2]=3 和 queries[3]=4 ，符合条件的物品都为 [1,2] ，[3,2] ，[2,4] 和 [3,5] 。
 *   它们中的最大美丽值为 5 。
 * - queries[4]=5 和 queries[5]=6 ，所有物品都符合条件。
 *   所以，答案为所有物品中的最大美丽值，为 6
 *
 * @author shadow
 * @create 2025-03-09 13:16
 **/
public class MaximumBeauty {

    public int[] maximumBeauty(int[][] items, int[] queries) {
        Arrays.sort(items, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                /**
                 * 如果价格相同的情况下，按照第二个数字降序排序
                 */
                if(o1[0] - o2[0] == 0) {
                    return o2[1] - o1[1];
                }
                /**
                 * 其他按照价格升序排序
                 */
                return o2[0]-  o1[0];
            }
        });
        int[] ans = new int[queries.length];
        for (int j = 0; j < queries.length; j++) {
            for (int i = 0; i < items.length; i++) {
                if(items[i][0] <= queries[j]) {
                    ans[j] = items[i][1];
                    break;
                }
            }
        }
        return ans;
    }


    public static void main(String[] args) {
        int[][] items = {{193,732},{781,962},{864,954},{749,627},{136,746},{478,548},{640,908},{210,799},{567,715},{914,388},{487,853},{533,554},{247,919},{958,150},{193,523},{176,656},{395,469},{763,821},{542,946},{701,676}};
        MaximumBeauty maximumBeauty = new MaximumBeauty();
        int[] queries = {885,1445,1580,1309,205,1788,1214,1404,572,1170,989,265,153,151,1479,1180,875,276,1584};
        maximumBeauty.maximumBeauty(items,queries);
    }

}
