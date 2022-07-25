package algorithm.collection.markdown.sort;

/**
 * 插入排序
 *
 * @Date 2022/4/26 22:16
 * @Created by Shadow
 */
public class InsertSort {

    public static void insertSort(int[] arr){
        if(arr == null || arr.length <2){
            return;
        }
        for(int i=1;i<arr.length;i++){//0 ~ i做到有序

            for(int j=i-1;j>0 && arr[j] > arr[j+1];j--){//0 ~ i冒泡
                swap(arr,j,j+1);
            }

        }
    }

    private static void swap(int[] arr, int j, int i) {
        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];
    }
}
