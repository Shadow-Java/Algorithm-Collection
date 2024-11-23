package algorithm.collection.primary.bitoperation;

/**
 * 位运算
 *
 * <p>异或是相同的为0，不同为1；那么可以通过异或解决什么问题？
 *
 * <p>1.二进制层面：
 * <pre>
 *     1^1=0, 1^0=1,0^0=0
 * </pre>
 * <p>2.十进制层面:
 * <pre>一个数和0异或得到本身  和本身异或得到0
 *     n^0=n n^n=0
 * </pre>
 * <ul>
 *    3.解决问题层面：
 *     <li>
 *         3.1 比如一群数中找出唯一的数，因为数一般是成群结对的，可以通过异或找到
 *         <pre>
 *             如1,2,3,2,3，找出唯一的数，1^2^3^2^3=(2^2)^(3^3)^1=0^1=1
 *         </pre>
 *     </li>
 *     <li>3.2 比如1-1000放在含有1001个元素的数组中，只有唯一的一个元素值重复，假设这个重复的数字是n，那么现在找出n
 *         <pre>
 *            假设：1^2^3......^n.....^1000=T
 *            而： 1^2^3......^n^n.....^1000 = T^n
 *            则：T^T^n = 0^n = n
 *            思路：先将1-1000异或，然后将1-1001每个数异或，最后将两个结果异或
 *         </pre>
 *     </li>
 *     <li>3.3 将一个int类型的数，提取最右侧的1<br> ans = N & ((~N)+1)
 *         <pre>
 *             假设N : 00..01101010000
 *                              ^
 *               ~N : 11..10010101111
 *             ~N+1 : 11..10010110000
 *         N&(~N+1) : 00..00000010000
 *         </pre>
 *     </li>
 * </ul>
 *
 *
 * @author Shadow at 2022/7/5 23:01
 * @version 1.0.1
 */
public class BitOperation {

    /**
     * 题目：一个数组中有一种数出现了奇数次，其他数都出现了偶数次，怎么找到这一个数
     * 例如：2,2,2,3,3,5,5,6,6    找到奇数次的2
     */
    public void findOddTimes(int[] arr){
        int e0 = 0;
        for(int cur : arr){
            e0 = e0^cur;
        }
        System.out.println("出现奇数次的数："+e0);
    }

    /**
     *<p>
     *     题目：一个数组中有两种数出现了奇数次，其他数都出现了偶数次，怎么找到这两个数<br>
     *     例如：2,2,2,3,3,5,5,5,6,6
     *</p>
     *<pre>有以下解决方式：
     *     <ul>
     *         <li>全部异或结果为a^b=2^5,再次异或a^b^b=a;a^b^a=b;(该方法需要在数组中找出a或b)</li>
     *         <li>全部异或结果为a^b=2^5,通过末尾的1来找出a,就能实现a^b^a=b</li>
     *     </ul>
     *</pre>
     *<Strong>Note:</Strong>找末尾中的1时，因为是eor=a^b,异或特点是不同的为1，即1可以区分a和b;<br>
     * 用eor‘=0去异或该位上为1的数，就能得到a
     * @param arr
     */
    public void findOddTimesTwo(int[] arr){
        int eO = 0,eOhasOne=0;
        for(int cur : arr){
            eO = eO^cur;//a^b
        }
        /**
         * eor = a ^ b
         * eor != 0
         * eor 必然有一个位置为1 (不同的位置异或为1,该位置能区分a和b)
         * eor = 0110010000
         * 提取eor最右侧的1,即eor&(~eor+1) = 0000010000
         */
        int rightOne = eO & (~eO + 1);//提取最右侧的1
        for (int cur : arr) {
            if ((cur & rightOne) != 0) {//cur这位上有1的数字
                //首先因为异或原因，导致出现偶数次的两个数肯定分在不同的组内（一组的末尾为一，一组末尾不为1）
                //然后对每个组内的数字求异或，比如[2,2,2,6,6]那么异或为2（求的是出现奇数次的数）
                eOhasOne ^= cur;//eor'
            }
        }
        System.out.println(eOhasOne + " " + (eO ^ eOhasOne));
    }

    /**
     * 题目:统计1的个数<br>
     *
     * 每次找出二进制最右侧的1,逐渐加1，再抹掉右侧的1
     *
     * <pre>
     *            N : 011011010000
     *     N&(~N+1) : 000000010000
     * N^(N&(~N+1)) : 011011000000
     *                       ^
     * </pre>
     */
    public static int bit1counts(int N){
        int count = 0;
        while(N != 0){
            int rightOne = N&(~N+1);
            count++;
            /**
             * 不能用N -= rightOne,N可能为负数
             */
            N ^= rightOne;
        }
        return count;
    }

}
