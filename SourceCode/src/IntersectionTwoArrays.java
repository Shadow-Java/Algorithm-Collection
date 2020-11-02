import java.util.HashSet;
import java.util.Set;

/**
 * 给定两个数组，编写一个函数来计算它们的交集。
 *
 * 输入：nums1 = [1,2,2,1], nums2 = [2,2]
 * 输出：[2]
 * Set转Integer[]数组，set.toArray()
 */
public class IntersectionTwoArrays {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> res = new HashSet<>();//set去重
        for(int i=0;i<nums1.length;i++){//暴力解，最坏情况o(mn)
            for(int j=0;j<nums2.length;j++){
                if(nums1[i] == nums2[j]){
                    res.add(nums1[i]);
                }
            }
        }
        Integer[] result = new Integer[res.size()];
        res.toArray(result);//此处只要求object[]，所以用对象Integer
        int[] intArray = new int[result.length];//返回需要int，则用Integer转int
        for (int i = 0; i < result.length; i++) {
            intArray[i] = result[i].intValue();
        }

        return intArray;
    }

    /**
     * 优化情况，减少一个for，时间复杂度O(m+n)
     * 执行用时3ms，内存消耗39mb
     * @param nums1
     * @param nums2
     * @return
     */
    public int[] intersection_2(int[] nums1, int[] nums2) {
        if(nums1 == null || nums2 == null)
            return null;
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        for(int i : nums1)
            set1.add(i);
        for(int i : nums2){
            if(set1.contains(i)){
                set2.add(i);
            }
        }
        int[] result = new int[set2.size()];
        int start = 0;
        for(int item : set2){
            result[start] = item;
            start++;
        }
        return result;
    }
}
