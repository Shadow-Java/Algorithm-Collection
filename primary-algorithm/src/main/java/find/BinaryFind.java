package find;

/**
 * 二分是对于一个<strong>有序数组</strong>的查找算法
 * <p>
 *     算法问题：
 *     <ul>
 *         <li>查找某个数是否存在</li>
 *         <li>找某个数>=最左侧的位置</li>
 *         <li>局部最小值问题</li>
 *     </ul>
 * </p>
 *
 *
 * @author Shadow at 2022/6/20 23:27
 * @version 1.0.1
 */
public class BinaryFind {

    /**
     * 查找有序数组中的某个数是否存在<br>
     *
     * {@code 时间复杂度}:<br>
     * {@code 空间复杂度}
     *
     * @param sortedArr
     * @param num
     * @return
     */
    public static boolean exist(int[] sortedArr, int num) {
        if (sortedArr == null || sortedArr.length == 0) {
            return false;
        }
        int L = 0;
        int R = sortedArr.length - 1;
        int mid = 0;
        while (L < R) {
            //L下标10亿  R下标18亿  mid就会溢出  不安全
            //mid = L+（R-L）/2  R比较大的数 - L的数肯定不会溢出
            //N/2  N >> 1 位运算比除运算快
            //N*2  N << 1
            //N*2+1  (N<<1)|1  N向左移一位，最低位拿0补，所以与1或 则会实现加一
            mid = L +  ((R - L) >> 1);//mid = (L+R)/2
            if (sortedArr[mid] == num) {
                return true;
            } else if (sortedArr[mid] > num) {
                R = mid - 1;
            } else {
                L = mid + 1;
            }
        }
        //最后L=R，会所以那一个都可以
        return sortedArr[L] == num;
    }


    /**
     * 搜索数组的左侧边界，对于一串连续且重复的数字,找到target的最左侧的边界<br>
     *
     * 在arr上，数字是重复出现的，那么需要找到满足target的最左位置
     * <blockquote>如查找下面排序数组target最左位置：<pre>
     *         1 1 2 2 3 3 4 4 5 5 6 6 7 7 7 7 7 8 8 9   target = 3
     *                 ^
     * </pre>
     * <ul>
     *     <li>可以看到target=3重复出现两次，最左侧边界则就是左侧的3，打印数组位置即可</li>
     *     <li>第一轮是：1 1 2 2 3 3 4 4 5 5</li>
     *     <li>第二轮是：1 1 2 2 3</li>
     * </ul>
     * </blockquote>
     *
     * <b>Note:</b>记录中间值：①mid = (R+L)/2 但是这样如果你的R达到1亿，那么就会导致数组越界 ②L+（R-L）/2
     *
     * @param arr
     * @param value
     * @return
     */
    public static int nearestIndex(int[] arr, int value) {
        int L = 0;
        int R = arr.length - 1;
        int index = -1;//记录最左的对号
        while (L < R) {//L<=R说明有范围
            int mid = L + ((R - L) >> 1);//为什么使用L+（R-L）/2
            if (arr[mid] >= value) {
                index = mid;
                R = mid - 1;
            } else {
                L = mid + 1;
            }
        }
        return index;
    }


    /**
     * 局部最小值三种定义
     * <ul>
     *     <li>0位置比1位置小，叫局部最小</li>
     *     <li>N位置比N-1位置小，叫局部最小</li>
     *     <li>i位置比i-1位置小，也比i+1位置小，叫局部最小</li>
     * </ul>
     *
     * arr虽然是无序，但是任意两个相邻位置不相等，要求返回一个局部最小，哪一个都行
     *
     * 如果第0位置比1位置小 则返回0即可；如果N位置不是局部最小，那么比N-1位置要大
     *
     * 所以有个0
     * 一个数组 <num     >num  可以用二分  用一种排他一遍的逻辑的观念
     * @param arr
     * @return
     */
    public static int getLessIndex(int[] arr){
        if (arr == null || arr.length == 0) {
            return -1;//no exist
        }
        if(arr.length == 1 || arr[0] < arr[1]){
            return 0;
        }
        if(arr[arr.length-1] < arr[arr.length - 2]){
            return arr.length - 1;
        }
        int left = 1;int right = arr.length - 2;
        int mid = 0;
        while (left < right){
            mid = (left + right)/2;
            if(arr[mid] > arr[mid - 1]){//左侧二分
                right = mid - 1;
            }else if(arr[mid] > arr[mid+1]){
                left = mid + 1;
            }else{
                return mid;
            }
        }
        return left;
    }


}
