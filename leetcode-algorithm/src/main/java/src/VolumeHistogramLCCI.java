package src;

/**
 * 给定一个直方图(也称柱状图)，假设有人从上面源源不断地倒水，最后直方图能存多少水量?直方图的宽度为 1。
 * 输入: [0,1,0,2,1,0,1,3,2,1,2,1]
 * 输出: 6
 */
public class VolumeHistogramLCCI {
    /**
     * 计算出每一层雨水和柱子的体积
     * @param height
     * @return
     */
    public int trap(int[] height)
    {
        int sum = 0;
        for(int i = 0;i<height.length;i++) {
            sum += height[i];
        }//求数组总和
        int volume = 0; // 总体积和高度初始化
        int high = 1;
        int size = height.length;
        int left = 0; // 双指针初始化
        int right = size - 1;
        while (left <= right) {
            while (left <= right && height[left] < high) {
                left++;
            }
            while (left <= right && height[right] < high) {
                right--;
            }
            volume += right - left + 1; // 每一层的容量都加起来
            high++; // 高度加一
        }
        return volume -sum; // 总体积减去柱子体积，即雨水总量
    }


}
