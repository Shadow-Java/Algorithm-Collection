package algorithm.collection.leetcode.sort;

import java.util.Arrays;
import java.util.Comparator;
import java.util.TreeMap;

/**
 * 252. 会议室
 *
 * 给定一个会议时间安排的数组 intervals ，每个会议时间都会包括开始和结束的时间 intervals[i] = [starti, endi] ，请你判断一个人是否能够参加这里面的全部会议。
 *
 * 输入：intervals = [[0,30],[5,10],[15,20]]
 * 输出：false
 *
 * 输入：intervals = [[7,10],[2,4]]
 * 输出：true
 *
 * @author shadow
 * @create 2023-05-24 00:29
 **/
public class CanAttendMeetings {

    /**
     * 暴力排序，然后判断相邻的区间是否有交集，如果有说明不可以完成所有的会议，若都没有，说明可以。O(NlgN)时间
     * 按开始时间排序后，依次检查相邻前一个的结束和后一个的开始时间是否重叠
     * @param intervals
     * @return
     */
    public boolean canAttendMeetings(int[][] intervals) {
        // Arrays.sort(intervals, (o1, o2) -> (o1[0] == o2[0] ? o1[1] - o2[1] : o1[0] - o2[0]));
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0])); // also ok
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] < intervals[i - 1][1]) {
                return false;
            }
        }
        return true;
    }

    /**
     * 不排序，按照区间处理，每当进入一个区间[a, b]，就把区间[a, b)内的conut累计1。
     * 最后扫描看看有没有时间点会议数目超过2，若有说明不能完成所有会议。否则可以。O(Nlg(Span)), N是数组intervals的长度，Span是所有区间内跨度最大的区间的跨度
     * 链接：https://leetcode-cn.com/problems/meeting-rooms/solution/zhong-gui-zhong-ju-si-chong-bu-tong-de-j-ayuh/
     * @param intervals
     * @return
     */
    private boolean helper2(int[][] intervals) {
        int[] count = new int[1000001];
        for (int[] interval : intervals) {
            for (int i = interval[0]; i < interval[1]; i++) {
                count[i]++;
                if (count[i] > 1) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * 小优化
     * @param intervals
     * @return
     */
    private boolean helper2Plus(int[][] intervals) {
        // int[] count = new int[1000001];
        int maxTime = 0;
        // 先遍历一遍所有会议区间，找到最晚的会议结束时间maxTime
        for (int[] interval : intervals) {
            maxTime = Math.max(maxTime, interval[1]);
        }
        // 拿得到的最晚会议结束时间maxTime作为差分数组的长度上限，可以避免按数据范围的可能上限（1e6）进行差分数组的定义而浪费空间
        int[] count = new int[maxTime + 1];
        for (int[] interval : intervals) {
            for (int i = interval[0]; i < interval[1]; i++) {
                count[i]++;
                if (count[i] > 1) {
                    return false;
                }
            }
        }
        return true;
    }


    // 差分法： 在2的基础上的优化。不需要按顺序依次累计区间[a,b]内所有点，因为会议最多的时候一定能够通过检查起点获得。
    // 因此我们可以在进入一个区间的时候对区间start++，出来的时候对区间end--。最后再扫描一遍数组，看有没有时间点会议数目超过2，若有说明不能完成所有会议。否则可以
    private boolean helper3(int[][] intervals) {
        int[] count = new int[1000001];
        for (int[] interval : intervals) {
            count[interval[0]]++;
            count[interval[1]]--;
        }
        int maxMeetingCnt = 0;
        for (int i = 0; i < count.length; i++) {
            maxMeetingCnt += count[i];
            if (maxMeetingCnt > 1) {
                return false;
            }
        }
        return true;
    }

    private boolean helper3Plus(int[][] intervals) {
        // int[] count = new int[1000001];
        int maxTime = 0;
        // 先遍历一遍所有会议区间，找到最晚的会议结束时间maxTime
        for (int[] interval : intervals) {
            maxTime = Math.max(maxTime, interval[1]);
        }
        // 拿得到的最晚会议结束时间maxTime作为差分数组的长度上限，可以避免按数据范围的可能上限（1e6）进行差分数组的定义而浪费空间
        int[] count = new int[maxTime + 1];
        for (int[] interval : intervals) {
            count[interval[0]]++;
            count[interval[1]]--;
        }
        int maxMeetingCnt = 0;
        for (int i = 0; i < count.length; i++) {
            maxMeetingCnt += count[i];
            if (maxMeetingCnt > 1) {
                return false;
            }
        }
        return true;
    }


    // 差分法2： 也是差分，就是相比于解法3用的数组表示，改用map表示，这样对于离散化（discreted）和稀疏数组（sparse）更高效。
    // 注意必须用ordered map （即C++中的map）而不能用unordered_map，因为最后的遍历需要按区间起点从小到大遍历。
    // 而且注意是end--，而不是 (end-1)-- 因为该题目允许刚参加完一个会议，立即参加下一个会议，是合法的。比如 [0, 5], [5, 10]是合法的。
    private boolean helper4(int[][] intervals) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int[] interval : intervals) {
            int start = map.getOrDefault(interval[0], 0);
            map.put(interval[0], ++start);
            int end = map.getOrDefault(interval[1], 0);
            map.put(interval[1], --end);
        }
        int maxMeetingCnt = 0;
        for (Integer key : map.keySet()) {
            maxMeetingCnt += map.get(key);
            if (maxMeetingCnt > 1) {
                return false;
            }
        }
        return true;
    }

}
