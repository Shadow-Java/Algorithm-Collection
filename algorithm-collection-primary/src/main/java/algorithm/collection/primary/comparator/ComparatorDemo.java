package algorithm.collection.primary.comparator;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 1.Comparator接口用于定义对象之间的自然顺序之外的排序规则。
 * 2.你可以通过实现这个接口来定制特定类型的比较逻辑。通常使用匿名内部类、Lambda表达式或者静态方法引用等方式来创建Comparator实例
 *
 * compare 方法的工作原理
 * Comparator接口中的compare(T o1, T o2)方法返回一个整数值：
 * 通过o1-o2的值的正负来判断谁大谁小
 *    如果o1小于o2，则返回一个负数。
 *    如果o1等于o2，则返回0。
 *    如果o1大于o2，则返回一个正数。
 *
 * 总结：1.return o1-o2 为升序，o2-o1为降序
 *      2.o1.compareTo(o2)，这表示升序排列；o2.compareTo(o1)，这表示降序排列
 *      3.compareTo适合所有对象类型
 *      4.Comparator接口里面是优化过的快排，所以不支持对普通类型进行排序，仅支持Integer等对象引用类型
 *即通过正负数来判断谁大谁先
 * @author shadow
 * @create 2025-03-09 13:31
 **/
public class ComparatorDemo {

    public static void main(String[] args) {
        ComparatorDemo comparatorDemo = new ComparatorDemo();
        comparatorDemo.comparatorTest();
    }

    public void comparatorTest2() {
        Integer[] nums = {2,4,3,5,7,1};
        Arrays.sort(nums, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                //升序
                return o1-o2;
            }
        });
        Arrays.sort(nums, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                //降序
                return o2-o1;
            }
        });
        //lambda表达式
        Arrays.sort(nums, (a, b) -> a - b);
        Integer[][] arr = {{1,2},{3,4}};
        //升序
        Arrays.sort(arr,((o1, o2) -> o1[0] - o2[0]));
        //降序
        Arrays.sort(arr,((o1, o2) -> o2[0] - o1[0]));
    }

    public void comparatorTest() {
        Integer[] nums = {2,4,3,5,7,1};
        System.out.println("#################### 正序排序 ##################");
        Arrays.sort(nums, new Comparator<>() {
            /**
             * o1-o2 <=0 那么是升序排序；
             * o1-o2 >= 0 那么是倒序序排序；
             * @param o1 the first object to be compared.
             * @param o2 the second object to be compared.
             *
             * @return
             */
            @Override
            public int compare(Integer o1, Integer o2) {
                Integer res = o1-o2 ;
                if(res < 0) {
                    //o1 < o2
                    return -1;
                } else if(res == 0) {
                    //o1 == o2
                    return 0;
                }
                //o1 > o2
                return 1;
            }
        });
        for (int num : nums) {
            System.out.print(num+ " ");
        }
        System.out.println("#################### 倒序排序 ##################");
        Arrays.sort(nums, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if(o1 < o2) {//本来o1-o2小于0是升序，那么o1 < o2 返回正数说明是倒序排序
                    return 1;
                }
                return -1;//因为是排序，相等或者大于都返回1
            }
        });
        for (int num : nums) {
            System.out.print(num+ " ");
        }
    }
}
