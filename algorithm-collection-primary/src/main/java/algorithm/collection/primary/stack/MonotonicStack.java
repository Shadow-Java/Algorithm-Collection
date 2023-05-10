package algorithm.collection.primary.stack;

import java.util.Arrays;
import java.util.Stack;

/**
 * 单调栈:一种单调的栈结构，比如单调递增栈、单调递减栈
 * 如下为单调递增栈：
 * ---------
 * ！23、24、25
 * ----------
 * 如下为单调递减栈：
 * -----------
 * ！25、24、23
 * ------------
 *
 * 为什么要使用单调栈？
 * 单调栈一般用作辅助数据结构，比如求当前还有几天有更高的温度，即下一个更高的温度。如果是遍历数组，需要O（n^2）,如果是单调栈则只需要遍历O（n）
 * @author shadow
 * @create 2023-05-11 00:33
 **/
public class MonotonicStack {

    /**
     * 1.为什么需要设置单调递减栈
     * 因为只要遇到更大的温度，就需要出栈，栈顶记录的是下标，相隔的距离就是距离的天数
     * 2.流程
     *
     */
    public static void template(){
        /**
         * 天气预报记录了最近10天的天气数据，要求每一天还需要几天能遇到更到的温度
         */
        int[] temperatures = {20,10,30,35,15,22,36,40,9,42};
        /**
         * 结果数组，以-1表示不会有更高的温度，即当前就是最高的温度
         */
        int[] res = new int[10];
        Arrays.fill(res,-1);
        /**
         * 辅助栈结构，即空间换时间,栈存的是数组的下标
         */
        Stack<Integer> stack = new Stack<>();
        /**
         * 只需要遍历一个数组，即可求得每一天离下一次的最高温度
         */
        for(int i=0;i<10;i++){
            while (!stack.isEmpty() && temperatures[stack.peek()] < temperatures[i]){
                int cur = stack.pop();
                res[cur] = i-cur;
            }
            stack.push(i);
        }

        for (int x: res) {
            System.out.print(x+" ");
        }
    }

    public static void main(String[] args) {
        template();
    }

}
