package SourceCode.src;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 给定一个 m x n 的矩阵，如果一个元素为 0 ，则将其所在行和列的所有元素都设为 0 。请使用 原地 算法。
 *
 * 输入：matrix = [[0,1,2,0],[3,4,5,2],[1,3,1,5]]
 * 输出：[[0,0,0,0],[0,4,5,0],[0,3,1,0]]
 */
public class SetMatrixZeroes {

    public static void setZeroes(int[][] matrix) {
        HashMap<Integer, List<Integer>> hashMap= new HashMap<>();//记录零的位置
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                if(matrix[i][j] == 0){
                    List<Integer> cols = hashMap.getOrDefault(i,new ArrayList<>());
                    cols.add(j);
                    hashMap.put(i,cols);
                }
            }
        }

        for(int i=0;i<matrix.length;i++){
            List<Integer> cols = hashMap.getOrDefault(i,new ArrayList<>());
            int count = 0;
            if(!cols.isEmpty()){
                for(int col : cols){
                    while(count < matrix.length){//横向清零
                        matrix[count++][col]=0;
                    }
                    count = 0;
                }
                while(count < matrix[0].length){//纵向清零
                        matrix[i][count++]=0;
                }
            }
        }
    }


    /**
     * O(1)空间复杂度，在数据比较多的情况下可以记录那些已经清零的，稍作计算
     * @param matrix
     */
    public void setZeroes_2(int[][] matrix) {
        boolean col0_flag = false;
        int row = matrix.length;
        int col = matrix[0].length;
        for (int i = 0; i < row; i++) {
            if (matrix[i][0] == 0) col0_flag = true;
            for (int j = 1; j < col; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = matrix[0][j] = 0;
                }
            }
        }
        for (int i = row - 1; i >= 0; i--) {
            for (int j = col - 1; j >= 1; j--) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
            if (col0_flag) matrix[i][0] = 0;
        }
    }


}
