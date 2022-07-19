package recursive;

/**
 * 递归 递归是个很奇妙的方法,怎样才能让我的算法更加简洁
 *
 * <pre>master公式是用于计算递归的时间复杂度：
 *     T（N）=aT（N/b）+O（N^d）
 * </pre>
 *
 * @author Shadow at 2022/7/5 22:14
 * @version 1.0.1
 */
public class Recursive {

    /**
     * 求数组L...R中的最大值
     * 解决方式：区间树
     *
     * @return
     */
    public static int getMax(int[] arr){
        return process(arr,0,arr.length-1);
    }

    /**
     * 题目：递归求L..R中的最大值<br>
     *
     * 递归就是将数组划分为树形结构:比如求数组中[0..8]的最大值<br>
     * 本质是系统栈实现的递归
     *<blockquote>
     *     <pre>
     *               f(0,5)
     *            /          \
     *         f(0,2)          f(3,5)
     *         /     \         /     \
     *      f(0,1)    f(2,2)  f(3,4)  f(5,5)
     *      /   \      \        /  \      \
     *  f(0,0) f(1,1)  f(2,2) f(3,3)f(4,4) f(5,5)
     *     </pre>
     *</blockquote>
     *
     * <Strong>Note:</Strong>跟区间树很类似，base case其实就是到叶子节点
     *
     * @param arr
     * @param L
     * @param R
     * @return
     */
    public static int process(int[] arr,int L,int R){
        if(L == R){// arr[L..R]范围上只有一个数，直接返回，base case
            return arr[L];
        }
        // L...R 不只一个数
        // mid = (L + R) / 2
        int mid = L +((R-L)>>1);
        int leftMax = process(arr,L,mid);
        int rightMax = process(arr,mid+1,R);
        return Math.max(leftMax,rightMax);
    }

    /**
     * 任何的递归都能转成迭代
     */
    public static void iteration(int[] arr,int L,int R){

    }

}
