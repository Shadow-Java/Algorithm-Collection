package algorithm.collection.common.datastruct.array;

import java.util.Random;

/**
 * @author shadow
 * @create 2023-05-14 11:53
 **/
public class ArrayRandomGenerator {

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


    public static void printArray(int[] arr) {
        System.out.println("------------生成的数组如下------------");
        if (arr == null) {
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println("");
        System.out.println("------------打印结束------------");
    }

}
