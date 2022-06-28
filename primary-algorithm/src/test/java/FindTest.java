import find.BinaryFind;

import java.util.Arrays;

/**
 * @author Shadow at 2022/6/27 22:33
 * @version 1.0.1
 */
public class FindTest {

    private static int[] nums = SortTest.generateRandomArray(10,15,100);

    public static void main(String[] args) {
        //Integer target = nums[5];
        //System.out.println("target = "+target);
        int[] testNum = {16,-38,-28,-14,50,10,33,-7,41,23,-65,-3,-8};
        int target = 10;
        Arrays.sort(testNum);
        SortTest.printArray(testNum);
        System.out.println(BinaryFind.exist(testNum,target));
    }

}
