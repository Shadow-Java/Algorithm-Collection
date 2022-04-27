package topicconclusion.sort;

/**
 * @Classname BubbleSort
 * @Description 冒泡排序
 * @Date 2022/4/26 21:48
 * @Created by Shadow
 */
public class BubbleSort {

    public static void bubbleSort(int[] arr){
        //0 ~ N-1 冒泡到N-1
        //0 ~ N-2 冒泡到N-2
        //0 ~ N-3
        for(int e = arr.length-1;e>0;e--){//0 ~ e
            //0 1 交换
            //1 2
            for(int i=0;i<e;i++){
                if(arr[i] > arr[i+1]){
                    swap(arr,i,i+1);
                }
            }
        }
    }

    public static void swap(int[] arr,int i,int j){// i和j位置交换
        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];
    }

}
