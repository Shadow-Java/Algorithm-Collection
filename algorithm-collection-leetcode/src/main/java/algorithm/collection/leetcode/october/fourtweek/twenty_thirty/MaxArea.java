package algorithm.collection.leetcode.october.fourtweek.twenty_thirty;

/**
 * 11. 盛最多水的容器
 *
 * 给定一个长度为 n 的整数数组 height 。有 n 条垂线，第 i 条线的两个端点是 (i, 0) 和 (i, height[i]) 。
 *
 * 找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 *
 * 返回容器可以储存的最大水量。
 * 说明：你不能倾斜容器。
 *
 *
 * 输入：[1,8,6,2,5,4,8,3,7]
 * 输出：49
 * 解释：图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为 49。
 *
 * 输入：height = [1,1]
 * 输出：1
 *
 * @author shadow
 * @create 2024-10-29 23:10
 **/
public class MaxArea {

    public static void main(String[] args) {
        int[] height = {1,8,6,2,5,4,8,3,7};
        System.out.println(maxArea(height));
    }

    /**
     * 双指针：双指针是左指针和右指针在相互收拢；而滑动窗口只是一味左指针收拢，而右指针在仍然向前移动
     *
     * 这题和接雨水还是有明显差别，接雨水是能容纳的最多的水，这题是求能接最大的水区域；当要求区域最大，要求左指针最高和右指针最高即可
     * @param height
     * @return
     */
    public static int maxArea(int[] height) {
        int l = 0, r = height.length - 1;
        int ans = 0;
        //终止于在移动到同一个数据上结束，即单点数据不能计算面积
        while (l < r) {
            int area = Math.min(height[l], height[r]) * (r - l);
            ans = Math.max(ans, area);
            //因为短的高度会影响盛水的容量，所以那边短那边移动；如果高的移动只会减少距离，容量会更小
            if (height[l] <= height[r]) {
                ++l;
            } else {//当前双指针只有两种情况，那么left移动要么right，即将height[l] == height[r]归纳到大于或小于的一类
                --r;
            }
        }
        return ans;
    }

}
