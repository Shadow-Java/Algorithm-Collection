package algorithm.collection.primary.doublepointer;

import cn.hutool.core.util.RandomUtil;

/**
 * 滑动窗口：实际是两个指针形成的窗口区域，关键在于两个指针是如何移动
 *
 * @author shadow
 * @date 2023/5/27 10:29
 * @since 1.0
 */
public class SlideWindow {

    /**
     * 滑动窗口模板方法
     */
    public void template(){
        int left = 0,right = 0;
        char[] arr = new char[RandomUtil.randomInt(10)];
        while(right < Integer.MAX_VALUE){//右指针未越界
            char ch = arr[right++];
            //右指针移动，更新窗口
            while (matchResult()){//窗口满足条件
                //记录或者更新全局数据
                //...todo 具体的事项
                //右指针不动，左指针开始移动一位
                char temp = arr[left++];
                //左指针移动，窗口缩小，更新窗口数据
                //...todo 具体的事项
            }
        }
        //返回结果
    }

    /**
     * 窗口数据是否满足题目条件
     * @return
     */
    public boolean matchResult(){
        return true;
    }




}
