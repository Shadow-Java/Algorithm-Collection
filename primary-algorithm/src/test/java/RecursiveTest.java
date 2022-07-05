import org.junit.Test;
import recursive.Recursive;

/**
 * @author Shadow at 2022/7/5 22:46
 * @version 1.0.1
 */
public class RecursiveTest {


    @Test
    public void getMaxTest(){
        for(int i=0;i<50000;i++){
            int[] nums = SortTest.generateRandomArray(10,15,100);
            Integer maxTest = nums[0];
            for(int num : nums){
                if(num > maxTest){
                    maxTest = num;
                }
            }
            Integer maxValue = Recursive.getMax(nums);
            if(!maxTest.equals(maxValue)){
                System.out.println("算法错误！");
                printArray(nums);
            }
        }
        System.out.println("算法成功");
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

}
