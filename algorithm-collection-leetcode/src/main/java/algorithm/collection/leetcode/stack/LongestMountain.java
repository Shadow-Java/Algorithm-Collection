package algorithm.collection.leetcode.stack;

/**
 * LeetCode 845. Longest Mountain in Array
 * 总是做不出来
 */
public class LongestMountain {


    public static void main(String[] args) {
        int[] nums = {1, 2, 5, 3, 2, 1, 7};
        LongestMountain mountain = new LongestMountain();
        System.out.println(mountain.longestMountain(nums));
    }

    public int longestMountain(int[] arr) {
        int up = 0;
        int down = 0;
        int maxLen = 0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > arr[i - 1]) {
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

}
