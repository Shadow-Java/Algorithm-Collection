package algorithm.collection.primary.find;

import org.junit.jupiter.api.Test;

/**
 *
 * @author shadow
 * @date 2023/6/13 18:12
 * @since 1.0
 */
public class BinaryFindTest {

    @Test
    public static boolean exist(int[] sortedArr, int num) {
        if(sortedArr == null || sortedArr.length == 0){
            return false;
        }
        int L = 0;
        int R = sortedArr.length-1;
        while (L <= R){
            int mid = L+(R-L)/2;
            System.out.println("L=="+L+" R=="+R+" mid=="+mid);
            //有序数组
            if(sortedArr[mid] < num){
                L = mid+1;
            }else if(sortedArr[mid] > num){
                R = mid-1;
            }else{
                return true;
            }
        }
        return false;
    }
}