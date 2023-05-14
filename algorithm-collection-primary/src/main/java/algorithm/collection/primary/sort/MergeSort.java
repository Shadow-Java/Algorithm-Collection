package algorithm.collection.primary.sort;

/**
 * 归并排序：采用分而治之的思想
 *
 * @author shadow
 * @create 2023-05-14 14:17
 **/
public class MergeSort {

    /**
     * 归并排序：采用分治法的思想，将数组分成若干个有序的子数组，然后有序的子数组合并的过程
     * https://blog.csdn.net/justidle/article/details/104203958
     *
     * @param nums
     * @param l
     * @param h
     * @return
     */
    public static int[] mergeSort(int[] nums, int l, int h) {
        if (l == h)
            return new int[] { nums[l] };

        int mid = l + (h - l) / 2;
        int[] leftArr = mergeSort(nums, l, mid); //左有序数组
        int[] rightArr = mergeSort(nums, mid + 1, h); //右有序数组
        int[] newNum = new int[leftArr.length + rightArr.length]; //新有序数组

        int m = 0, i = 0, j = 0;
        while (i < leftArr.length && j < rightArr.length) {
            newNum[m++] = leftArr[i] < rightArr[j] ? leftArr[i++] : rightArr[j++];
        }
        while (i < leftArr.length)
            newNum[m++] = leftArr[i++];
        while (j < rightArr.length)
            newNum[m++] = rightArr[j++];
        return newNum;
    }

}
