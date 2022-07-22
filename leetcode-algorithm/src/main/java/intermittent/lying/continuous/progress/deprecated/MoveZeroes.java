package intermittent.lying.continuous.progress.deprecated;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 * 输入: [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 */
public class MoveZeroes {
    public void moveZeroes(int[] nums) {
        if(nums.length <= 1) return;
        //每一个数字跟前面的数字
        Queue<Integer> index_zero = new LinkedList<>();
        for(int i = 0;i<nums.length;i++){
            if(nums[i] == 0){//在前面记录每一个为0的序列
                index_zero.offer(i);
            }else if(index_zero.size() != 0){//交换
                swap(nums,index_zero.poll(),i);//交换完后
                if(nums[i] == 0) index_zero.offer(i);
            }
        }
    }

    public void swap(int[] nums,int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    //这个方法排除了为0的情况
    public void moveZeroes_2(int[] nums) {
        int i = 0,j = 0;
        for(i = 0 ; i < nums.length; i++)
        {
            if(nums[i] != 0)
            {
                nums[j++] = nums[i];
            }
        }
        while(j < nums.length)
        {
            nums[j++] = 0;
        }
    }

}
