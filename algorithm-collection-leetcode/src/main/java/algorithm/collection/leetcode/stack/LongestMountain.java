package algorithm.collection.leetcode.stack;

/**
 * LeetCode 845. Longest Mountain in Array
 * 845. 数组中的最长山脉
 * 把符合下列属性的数组 arr 称为 山脉数组 ：
 *
 * arr.length >= 3
 * 存在下标 i（0 < i < arr.length - 1），满足
 * arr[0] < arr[1] < ... < arr[i - 1] < arr[i]
 * arr[i] > arr[i + 1] > ... > arr[arr.length - 1]
 * 给出一个整数数组 arr，返回最长山脉子数组的长度。如果不存在山脉子数组，返回 0
 *
 * 示例 1：
 * 输入：arr = [2,1,4,7,3,2,5]
 * 输出：5
 * 解释：最长的山脉子数组是 [1,4,7,3,2]，长度为 5。
 *
 * 示例 2：
 * 输入：arr = [2,2,2]
 * 输出：0
 * 解释：不存在山脉子数组。
 * 总是做不出来
 */
public class LongestMountain {


    public static void main(String[] args) {
        int[] nums = {0,2,0,2,1,2,3,4,4,1};
        LongestMountain mountain = new LongestMountain();
        System.out.println(mountain.longestMountainV2(nums));
    }

    public int longestMountain(int[] arr) {
        int up = 0;
        int down = 0;
        int maxLen = 0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > arr[i - 1]) {
                if(down > 0) {
                    up = 0;
                    down = 0;
                }
                up++;
            } else if (up > 0 && arr[i] < arr[i - 1]) {
                down++;
                maxLen = Math.max(maxLen, up + down + 1);
            } else {
                up = 0;
                down = 0;
            }
        }
        return maxLen;
    }

    /**
     *
     * @param arr
     * @return
     */
    public int longestMountainV2(int[] arr) {
        int[] leftLen = new int[arr.length];
        int[] rightLen = new int[arr.length];
        for (int i = 1; i < arr.length; i++) {
            leftLen[i] = arr[i] > arr[i - 1] ? leftLen[i - 1] + 1 : 0;
        }
        for (int i = arr.length - 2; i >= 0; i--) {
            rightLen[i] = arr[i] > arr[i + 1] ? rightLen[i + 1] + 1 : 0;
        }
        int maxLen = 0;
        for (int i = 0; i < arr.length; i++) {
            if (rightLen[i] > 0 && leftLen[i] > 0) {
                maxLen = Math.max(maxLen, rightLen[i] + leftLen[i] + 1);
            }
        }
        return maxLen;
    }

}
