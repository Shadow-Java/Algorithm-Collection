package SourceCode.src;

/**
 * @Classname SolutionTest
 * @Description TODO
 * @Date 2022/4/4 0:30
 * @Created by Administrator
 */
public class SolutionTest {

    public static void main(String[] args) {
        System.out.println(ones(14));
    }



    public static void countPrimeSetBit(int left,int right){
        int count = 0;
        for (int i = left; i <= right; i++) {
            Integer.toString(i,2);
            String binary = Integer.toString(i,2);
        }

    }

    /**
     * 这样判断的话如果这个数的二进制的一再第31位，后面全是0，你最少需要判断31次
     * 可以考虑每次只减去最后一位1,使用lowbit操作  直接返回 x & -x；x &＝(x-1)就可以知道最后一位1的位置
     * 是因为-x是用补码存的 所以按位与之后返回的就是最后一位1的位置嘛
     * 一个负数的补码就是最后一位1之前的位置全部取反，后面不变
     * @param num
     * @return
     */
    public static String ones(int num){
        String str = "";
        System.out.println(Integer.bitCount(num));
        while(num != 0){
            str = num%2+str;
            num /= 2;
        }
        return str;
    }

    public static int countPrimeSetBits(int left,int right){
        int count = 0;
        for (int i = left; i <= right; i++) {
            int mask = 665772;
            if((mask & (1 << Integer.bitCount(i))) != 0){//1 << Integer.bitCount(i)表示左移多少位，比如2^3=1000
                count++;
            }
        }
        return count;
    }








}
