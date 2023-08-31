package algorithm.collection.leetcode.doublepointer;

import algorithm.collection.common.datastruct.tag.AlgorithmCategory;
import algorithm.collection.common.datastruct.tag.DataStructType;
import algorithm.collection.common.datastruct.tag.DifficultyLevel;
import algorithm.collection.common.datastruct.tag.MethodTag;
import algorithm.collection.common.datastruct.tag.QuestionTag;
import algorithm.collection.common.datastruct.tag.TimeComplexity;

import java.util.Arrays;

/**
 * 实现获取下一个排列的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。
 *
 * 如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。
 *
 * 必须原地修改，只允许使用额外常数空间。
 *
 * 以下是一些例子，输入位于左侧列，其相应输出位于右侧列。
 * 1,2,3 → 1,3,2
 * 3,2,1 → 1,2,3
 * 1,1,5 → 1,5,1
 */
@QuestionTag(
        difficultyLeve = DifficultyLevel.MEDIUM,
        questionNumber = "31",
        questionTitle = "下一个排列",
        relevateClass = NextGreaterElementIII.class,
        desc = "整数数组的一个 排列  就是将其所有成员以序列或线性顺序排列。",
        questionLink = "https://leetcode.cn/problems/next-permutation/",
        algorithmCategory = AlgorithmCategory.DOUBLE_POINTER,
        timeComplexity = TimeComplexity.O_N_2,
        dataStructTypes = {DataStructType.ARRAY_LIST}
)
public class NextPermutation {

    /**
     * 这题都是用for时间复杂度比较高，
     * @param nums
     */
    @MethodTag(
            questionNumber = "31",
            methodLink = "https://leetcode.cn/problems/next-permutation/",
            timeComplexity = TimeComplexity.O_N,
            dataStructType = DataStructType.ARRAY_LIST,
            algorithmCategory = AlgorithmCategory.DOUBLE_POINTER
    )
    public void nextPermutation(int[] nums) {
        boolean isMax = true;//是否是最大的数
        for(int i = 0;i<nums.length;i++){
            int min = i;
            for(int j = i+1;j<nums.length;j++){
                if(nums[j] > nums[min]){//能交换，说明不是最大值
                    isMax = false;
                }
            }
        }

        if(isMax){//是最大值返回最小排序，即升序排列
            for(int i = 0;i<nums.length;i++){
                int min = i;
                for(int j = i+1;j<nums.length;j++){
                    if(nums[j] < nums[min] ){
                        min = j;
                    }
                }
                swap(nums,i,min);
            }
        }else{//寻找最近大的数
            findRecentMax(nums);
        }

    }

    void swap(int[] nums,int i ,int j){//数组交换
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    void findRecentMax(int[] nums){//找出最近大的数
        for(int i=nums.length-2;i >= 0;i--){
            int max = i;//没找到
            boolean finded = false;
            for(int j=nums.length-1; j > i;j--){
                if(nums[j] > nums[max] && finded == false){
                    //交换
                    swap(nums,j,max);
                    finded = true;
                    sort(nums,max+1);//再对后面的排序
                }
            }
            if(finded == true){
                break;
            }
        }
    }

    /**
     *比如[1,3,2] -->[2,3,1]-->[2,1,3],这样就是最近的数
     */
    void sort(int[]  nums,int m){//一旦从后面向前遍历找到最近比当前大的数，退出遍历，再对后面的数升序排列
        if(m < nums.length-1){
            for(int i=m;i<nums.length;i++){
                int min = i;
                for(int j=i+1;j<nums.length;j++){
                    if(nums[j] < nums[min]){
                        min = j;
                    }
                }
                swap(nums,i,min);
            }
        }
    }

    /**
     * 题解有三个方面：
     * 1.使用dfs找出所有的全排列一个个比较
     * 2.找出第一个升序对，但是升序对尽可能相邻
     * @param nums
     */
    private void anotherWay(int[] nums){
        int len = nums.length;
        for (int i = len - 1; i > 0; i--) {
            if (nums[i] > nums[i - 1]) {
                //例如465，只需要交换4和5即可
                Arrays.sort(nums, i, len);
                for (int j = i; j <len; j++) {
                    if (nums[j] > nums[i - 1]) {
                        int temp = nums[j];
                        nums[j] = nums[i - 1];
                        nums[i - 1] = temp;
                        return;
                    }
                }
            }
        }
        //没有则升序排列
        Arrays.sort(nums);
    }


}
