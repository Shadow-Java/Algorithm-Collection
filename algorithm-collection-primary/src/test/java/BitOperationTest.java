import algorithm.collection.primary.bitoperation.BitOperation;
import org.junit.Test;

/**
 *
 *
 * @author Shadow at 2022/7/26 2:35
 * @version 1.0.1
 */
public class BitOperationTest {

    @Test
    public void findOddTimesTwo(){
        int[] arr = {1,1,1,3,3,4,4,4,5,5};
        int eor = 0;
        for(int num : arr){
            eor ^= num;
        }
        System.out.println(eor);
    }

    @Test
    public void count1Binary(){
        int N = 12;
        System.out.println(fun(N));
        System.out.println(BitOperation.bit1counts(N));
    }
    private static int fun(int n) {
        int count = 0;  // 记录1的个数
        while (n != 0) {
            count += n & 1;  // 如果数最右边是1，那么&运算后结果为1；如果是0，那么&运算后结果为0
            n = n >>> 1;  // 将数右移动
        }
        return count;
    }

}
