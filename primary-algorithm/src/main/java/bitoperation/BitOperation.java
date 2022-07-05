package bitoperation;

/**
 *位运算
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
     *         <li>全部异或结果为a^b=2^5,再次异或a^b^b=a;a^b^a=b;</li>
     *         <li>todo 怎么找到最右边的1</li>
     *     </ul>
     *</pre>
     *
     * @param arr
     */
    public void findOddTimesTwo(int[] arr){
        int eO = 0,eOhasOne=0;
        for(int cur : arr){
            eO = eO^cur;//a^b
        }
        //eor = a ^ b
        //eor != 0
        //eor 必然有一个位置为1
        //0110010000
        //0000010000
        int rightOne = eO & (~eO + 1);//提取最右侧的1
        for (int cur : arr) {
            if ((cur & rightOne) != 0) {//这位上有1的数字
                eOhasOne ^= cur;//eor'
            }
        }
        System.out.println(eOhasOne + " " + (eO ^ eOhasOne));
    }

    /**
     * todo 统计1的个数
     * todo 找出二进制最右侧的1，其他变为0
     */

}
