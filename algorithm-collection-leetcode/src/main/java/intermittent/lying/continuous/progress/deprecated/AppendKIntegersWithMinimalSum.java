package intermittent.lying.continuous.progress.deprecated;

import java.util.Arrays;

/**
 * @Classname AppendKIntegersWithMinimalSum
 * @Description
 * 给你一个整数数组 nums 和一个整数 k 。请你向 nums 中追加 k 个 未 出现在 nums 中的、互不相同 的 正 整数，并使结果数组的元素和 最小 。
 *
 * 返回追加到 nums 中的 k 个整数之和。
 *
 * 输入：nums = [1,4,25,10,25], k = 2
 * 输出：5
 * 解释：在该解法中，向数组中追加的两个互不相同且未出现的正整数是 2 和 3 。
 * nums 最终元素和为 1 + 4 + 25 + 10 + 25 + 2 + 3 = 70 ，这是所有情况中的最小值。
 * 所以追加到数组中的两个整数之和是 2 + 3 = 5 ，所以返回 5 。
 *
 *学到的知识：数组拷贝函数System.arraycopy 分为浅拷贝和深拷贝
 * 这两题都是数学相关的知识点，需要理论才能立马想出解决方法
 *
 * @Date 2022/3/27 17:35
 * @Created by Shadow
 */
public class AppendKIntegersWithMinimalSum {
    //这题就叫见缝插针

    /**
     * 超出输出限制
     * @param nums
     * @param k
     * @return
     */
    public static long minimalKSum(int[] nums, int k) {
        int res = 0,index = 0,count = 0;//count计数到k，res最后累加的结果，index当前的值
        int[] nums2 = new int[nums.length+2];
        nums2[0] = 0;//扩充数组，第一个为1
        nums2[nums.length+1] = Integer.MAX_VALUE;
        System.arraycopy(nums,0,nums2,1,nums.length);
        for(int i=1;i<nums2.length;i++){
            int countInterval = nums2[i] - nums2[i-1];//中间能有多少个数 2-1=1
            if(i==1){
                index = nums2[i-1]+1;
            }else{//比如2 5，那么下个数从3开始
                index = nums2[i-1]+1;
            }
            while(countInterval > 1){
                res += index;
                System.out.print(index+"  ");
                index ++;
                count++;
                countInterval--;
                if(count == k){
                    break;
                }
            }
        }
        return res;
    }
}
