import find.BinaryFind;
import org.junit.Test;

import java.util.Random;

/**
 * @author Shadow at 2022/6/27 22:33
 * @version 1.0.1
 */
public class FindTest {

    private static int[] nums = SortTest.generateRandomArray(10,15,100);

    public static void main(String[] args) {
        for(int i = 0;i<50000;i++){
            int[] arr = generateRandomArray(2,10,20);
            int index = finMin(arr);
            if(arr.length > 1 && index >= 1 && index <= arr.length-2){

                if(arr[index-1] < arr[index] || arr[index] > arr[index+1]){
                    printArray(arr);
                    System.out.println("算法错误！"+arr[index]);
                    break;
                }
            }
        }
    }

    /**
     * @see BinaryFind#nearestRightIndex(int[], int)
     */
    @Test
    public void testRightIndex(){
        int[] arr = {1,2,3,3,3,3,4,4,6,7,7,8,8,8,9,10};
        System.out.println(BinaryFind.nearestRightIndex(arr,4));
    }

    public static void printArray(int[] arr) {
        if (arr == null) {
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }


    /**
     * 找到排序数组 的最左边界的索引值
     * @param arr
     */
    public static int findNeastMin(int[] arr,int target){
        if(arr == null || arr.length == 0){
            return -1;
        }
        int L = 0,R = arr.length-1,mid = 0,index = 0;
        while(L <= R){
            mid = L+((R-L)>>1);
            if(arr[mid] >= target){
                R = mid - 1;
                index = mid;
            }else{
                L = mid +1;
            }
        }
        return index;
    }

    public static int finMin(int[] arr){
        if(arr == null || arr.length == 0){
            return -1;
        }
        if(arr.length == 1 || arr[0] < arr[1]){
            return 0;
        }
        //局部最小值就是最低谷，如果i-1 < i的，那么i-1不可能是最小值，因为可能会一直在上升
        //如果最后两个数 N-1 > N,那么N一定是最小值
        if(arr.length > 1 && arr[arr.length-1] < arr[arr.length-2]){
            return arr.length-1;
        }
        //为什么要从1到N-2，因为首尾已经排除
        int L = 1,R = arr.length-2;
        //为什么没有加上等于，是因为有三个if条件，如果两个则是<=
        while (L < R){
            int mid = L+((R-L)>>1);
            if(arr[mid] > arr[mid+1]){
                L = mid + 1;
            }else if(arr[mid] > arr[mid - 1]){
                R = mid - 1;
            }else{
                return mid;
            }
        }
        //为什么L或R都可以，因为结束条件就是L==R
        return L;
    }


    /**
     * 随机生成[minsize---maxsize]长度的数组
     * @param minSize    最小长度的数组 不能为负
     * @param maxSize    最大长度数组
     * @param maxValue   数组元素最大值
     * @return
     */
    public static int[] generateRandomArray(int minSize,int maxSize, int maxValue) {
        Random randomUtil = new Random();
        int random = randomUtil.nextInt(maxSize-minSize)+minSize;
        int[] arr = new int[random];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) ((maxValue + 1) * Math.random()) - (int) (maxValue * Math.random());
        }
        return arr;
    }

}
