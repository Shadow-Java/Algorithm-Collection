package intermittent.lying.continuous.progress.deprecated;
/**
 * 给定一个整数数组 A，如果它是有效的山脉数组就返回 true，否则返回 false。
 *
 * 让我们回顾一下，如果 A 满足下述条件，那么它是一个山脉数组：
 * A.length >= 3
 * 在 0 < i < A.length - 1 条件下，存在 i 使得：
 * A[0] < A[1] < ... A[i-1] < A[i]
 * A[i] > A[i+1] > ... > A[A.length - 1]
 *
 * 输入：[2,1]
 * 输出：false
 *
 * 输入：[3,5,5]
 * 输出：false
 */
public class ValidMountainArray {
    //其实就是找最大值，但是需要记录值的id
    public boolean validMountainArray(int[] A) {
        if(A.length < 3){
            return false;
        }
        int max = A[0];int max_i = 0;//最大值的坐标
        for(int i=0;i<A.length;i++){
            if(A[i] >= max){
                max_i=i;max=A[i];
            }
        }
        if(max_i == A.length-1 || max_i == 0) return false;//将两个极端情况剔除
        for(int i=1;i<A.length;i++){
            int pre = A[i-1];
            if((i < max_i && A[i] < pre) || (i > max_i &&  A[i] >= pre)){//不能有相等的情况，只能递增或递减
                return false;
            }
        }
        return true;
    }

    /**
     * 优化方法 双指针
     * 可以使用两种指针，一个从左边找最高山峰，一个从右边找最高山峰，最后判断找到的是不是同一个山峰
     */
    public boolean validMountainArray_2(int[] A) {
        int len = A.length;
        int left = 0;
        int right = len - 1;
        //从左边往右边找，一直找到山峰为止
        while (left + 1 < len && A[left] < A[left + 1])
            left++;
        //从右边往左边找，一直找到山峰为止
        while (right > 0 && A[right - 1] > A[right])
            right--;
        //判断从左边和从右边找的山峰是不是同一个
        return left > 0 && right < len - 1 && left == right;
    }


}
