package src;

import java.util.Arrays;

/**
 * 给定由一些正数（代表长度）组成的数组 A，返回由其中三个长度组成的、面积不为零的三角形的最大周长。
 *
 * 如果不能形成任何面积不为零的三角形，返回 0。
 * 输入：[2,1,2]
 * 输出：5
 * 输入：[3,6,2,3]
 * 输出：8
 */
public class LargestPerimeterTriangle {
    //面积不为零，则是能组成三角形的三边
    public int largestPerimeter(int[] A) {
        //从数组中挑出三边，且能组成三角形，且是周长最长的
        Arrays.sort(A);
        for(int i=A.length-1;i>=2;i--){
            //将数组排序，那么只需取最大的三个数
            if(A[i - 2] + A[i - 1] > A[i]){//因为已经排序，只需最小的两个大于第三边就能组成三角形
                return A[i]+A[i-1]+A[i-2];
            }
        }
        return 0;
    }
}
