package algorithm.collection.leetcode.november.thirdweek.november_18st.november_22st;

/**
 * 75. 颜色分类
 * 给定一个包含红色、白色和蓝色、共 n 个元素的数组 nums ，原地 对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
 * <p>
 * 我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。
 * <p>
 * 必须在不使用库内置的 sort 函数的情况下解决这个问题。
 * <p>
 * 输入：nums = [2,0,2,1,1,0]
 * 输出：[0,0,1,1,2,2]
 * <p>
 * 输入：nums = [2,0,1]
 * 输出：[0,1,2]
 *
 * @author shadow
 * @create 2024-11-23 21:53
 **/
public class SortColors {

    /**
     * 荷兰国旗问题，借助的是快排思想
     * @param nums
     */
    public void sortColors(int[] nums) {
        int n = nums.length;
        int left = 0, right = n - 1;
        int i = 0;

        // all in [0, left) = 0
        // all in [left, i) = 1
        // all in [right, len - 1] = 2
        //这里定义的每个区间必须是空区间，所以left=0，
        // left是0,1分界线，right是1,2分界线，cur是当前遍历指针
        // [left,right]是最后的1所占区间
        // cur需要保证前面的元素只有0和1
        while (i <= right) {//只有当i>right时，才能看到[i,right]区间的数
            if (nums[i] == 0) {
                swap(nums, i++, left++);
                continue;
            }
            if (nums[i] == 2) {
                swap(nums, i, right--);
                continue;
            }
            if (nums[i] == 1) {
                i++;
            }
        }
    }

    void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

}
