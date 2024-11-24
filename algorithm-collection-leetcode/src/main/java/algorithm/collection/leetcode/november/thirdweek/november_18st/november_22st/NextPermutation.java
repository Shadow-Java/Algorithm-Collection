package algorithm.collection.leetcode.november.thirdweek.november_18st.november_22st;

/**
 * @author shadow
 * @create 2024-11-23 23:51
 **/
public class NextPermutation {

    /**
     * 我们可以将该问题形式化地描述为：给定若干个数字，将其组合为一个整数。如何将这些数字重新排列，以得到下一个更大的整数。如 123 下一个更大的数为 132。如果没有更大的整数，则输出最小的整数。
     *
     * 以 1,2,3,4,5,6 为例，其排列依次为：
     * 123456
     * 123465
     * 123546
     * ...
     * 654321
     * @param nums
     */
    public void nextPermutation(int[] nums) {
        int len = nums.length;
        for(int i = len-2;i>=0;i--){
            if(nums[i] < nums[i+1]){//找到小数
                //重新找一个较大的数，可能是之前的i+1,也可能不是，
                for(int j=len-1;j>i;j--){
                    //最差可能就是i+1，最好是尽量靠右的
                    if(nums[j]>nums[i]){
                        swap(nums,i,j);
                        //i从最小，换为右边较大的数，然后后面开始逆置
                        reverse(nums,i+1,len-1);
                        return;
                    }
                }
            }
        }
        //如果没有提前退出，那么就是没碰到逆序遍历是降序的，全是升序，说明最大了
        reverse(nums,0,len-1);
    }

    void swap(int[] nums, int i,int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    //由于nums[i] < nums[i+1]，我们可以知道，到满足这个条件的前提，是必须存在递增，
    //从后面往前，遍历了很多个才碰到第一个符合条件的，
    //那么说明从第一个符合条件开始往后，后面的肯定都是递减，是降序的，所以逆置即可最快重新排序。
    void reverse(int[] nums,int start,int end){
        while(start<end){
            swap(nums,start,end);
            start++;
            end--;
        }
    }

}
