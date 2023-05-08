package algorithm.collection.primary.sort;

/**
 * 堆排序--使用优先队列
 *
 * 堆：完全二叉树的典型应用，分为最小堆、最大堆
 * 堆就是一颗完全二叉树，比如小根堆的特性，所有父节点都比子节点小，没有左节点比父节点小的特性
 *
 * 删除堆顶元素并在堆顶新增一个元素：将堆顶元素依次跟子节点比较，选择跟最小的元素进行交换，依次向下调整
 * 删除堆顶元素不新增元素：那么默认将最后的一个元素与第一个元素进行交换，然后根据第一个情况向下调整
 * 只新增一个元素：则在堆的末尾新增一个元素，则需要比较该节点和父节点的值（不用跟左节点比较，因为之前就已经是最小堆，即最小值肯定在父节点），取最小的进行交换向上调整，插入一个元素所需要的时间为O（logN）
 *
 * @author shadow
 * @create 2023-05-08 22:19
 **/
public class HeapSort {

    /**
     * 因为堆是一个完全二叉树，所以底层是个数组，依次排列即可
     */
    private int[] node = new int[10];

    /**
     * 节点i向下调整
     * @param i 第几个节点
     */
    public void adjustDown(int i){
        /**
         * 表示是否需要向下调整，flag=true表示需要 flag=flase表示不需要
         */
        boolean flag = true;
        /**
         * n为节点个数,t为要交换的节点，即相对于i节点更小的节点
         */
        int n = 10,t=i;
        /**
         * 因为堆的特殊是完全二叉树，即有左节点就有右节点，只有判断有左节点就需要向下调整
         * 父节点为i，则左节点为2*i，右节点为2*i+1
         */
        while (i*2 <= n && flag == true){
            if(node[i] > node[2*i]){
                t = 2*i;
            }else {
                t = i;
            }
            /**
             * 右节点是否存在，不存在数组可能会越界
             */
            if(i*2+1 <= n){
                if(node[i] < node[i*2+1]){
                    t = i*2+1;
                }
            }
            /**
             * 不等则需要交换，相等则不需要
             */
            if(t != i){
                swap(t,i);
                i = t;
            }else{
                flag = false;
            }
        }
    }

    /**
     * 传入一个节点向上调整
     *
     * @param i
     */
    public void adjustUp(int i){
        /**
         * 是否需要向上调整
         */
        boolean flag = true;
        /**
         * n表示多少个节点
         */
        int n = 10,t = i;
        /**
         * 顶点则不需要向上调整
         */
        if(i == 1){
            return;
        }
        while (i != 1 && flag == true){
            if(node[i/2] > node[i]){
                swap(i/2,i);
            }else {
                flag = false;
            }
            i = i/2;
        }
    }

    /**
     * 如何建堆
     * 1.先是一个空数组，依次向这个数组的最后添加一个数，然后依次向上调整
     */
    public void createHeap(){
        int m = 10;
        int[] heapNode = new int[m];
        for(int i=0;i<m;i++){
            /**
             * 每个节点的值，由用户输入
             */
            int nodeVal = 3;
            heapNode[i] = nodeVal;
            /**
             * 向上调整第i节点
             */
            adjustDown(i);
        }
    }

    public void createHeap2(){
        int m = 10;
        /**
         * 直接将所有的节点存储在一维数组中，不管是否有大小依赖，此时是一个完全二叉树
         */
        int[] heapNode = new int[m];
        for (int i=0;i<m;i++){
            /**
             * 由用户输入
             */
            int nodeVal = 3;
            heapNode[i] = nodeVal;
        }
        /**
         * 从最后一个节点开始依次判断  以该节点为根的子树是否符合堆特性 不符合则调整
         * 开始时左右的叶子节点都符合最小堆特性，所以不需要处理，直接跳过；从N/2个（最后一个非叶子结点）节点开始开始处理
         */
        for(int i=m/2;i>=0;i--){
            /**
             * 依次向上调整n/2 n/2-1。。。结点
             */
            adjustDown(i);
        }
    }

    /**
     * 堆排序：每次删除堆顶元素(即最小值)
     *
     * @return
     */
    public int deleteMin(){
        int t = node[1];
        int n = 10;
        /**
         * 直接覆盖堆顶元素
         */
        node[1] = node[n];
        /**
         * 堆的元素减一
         */
        n--;
        adjustDown(1);
        return t;
    }


    public void swap(int i,int j){
        /**
         * 交换
         */
    }

}
