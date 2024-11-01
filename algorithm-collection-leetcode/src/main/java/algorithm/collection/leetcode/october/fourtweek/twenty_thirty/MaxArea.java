package algorithm.collection.leetcode.october.fourtweek.twenty_thirty;

/**
 * @author shadow
 * @create 2024-10-29 23:10
 **/
public class MaxArea {

    public static void main(String[] args) {
        int[] height = {1,8,6,2,5,4,8,3,7};
        System.out.println(maxArea(height));
    }

    public static int maxArea(int[] height) {
        int l = 0, r = height.length - 1;
        int ans = 0;
        //双指针在于如何移动指针
        while (l < r) {
            int area = Math.min(height[l], height[r]) * (r - l);
            ans = Math.max(ans, area);
            //因为短的高度会影响盛水的容量，所以那边短那边移动；如果高的移动只会减少距离，容量会更小
            if (height[l] <= height[r]) {
                ++l;
            } else {
                --r;
            }
        }
        return ans;
    }

}
