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
        int randomSize = maxSize == minSize ? maxSize: randomUtil.nextInt(maxSize-minSize)+minSize;
        int[] arr = new int[randomSize];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) ((maxValue + 1) * Math.random()) - (int) (maxValue * Math.random());
        }
        return arr;
    }

    /**
     *
     * @param size             数组固定长度
     * @param maxVal           首个元素最大值
     * @param randomIncrease  是否随机自增
     * @param incDegree       递增度
     * @return                如果元素是随机递增，会随机选择递增度范围内的数递增，如果不是随机则元素按递增度递增
     */
    public static int[] generateRandomArray(int size,int maxVal,boolean randomIncrease, int incDegree) {
        Random randomUtil = new Random();
        int[] arr = new int[size];
        arr[0] = randomUtil.nextInt(maxVal);
        for (int i = 1; i < size; i++) {
            int arrVal = randomIncrease ? arr[i-1] + randomUtil.nextInt(incDegree) : arr[i-1] + incDegree;
            arr[i] = arrVal;
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
