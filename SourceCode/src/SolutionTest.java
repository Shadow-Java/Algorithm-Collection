package SourceCode.src;

/**
 * @Classname SolutionTest
 * @Description TODO
 * @Date 2022/4/4 0:30
 * @Created by Administrator
 */
public class SolutionTest {

    public static void main(String[] args) {
        int[] arr = {1,3,5,7,9,11};
        int[] tree = new int[14];
        build_tree(arr,tree,0,0,5);
        update_tree(arr,tree,0,0,5,4,6);
        System.out.println(query_tree(arr,tree,0,0,5,2,5));
        for (int i = 0; i < tree.length; i++) {
            System.out.println("tree["+i+"]=="+tree[i]);
        }
    }

    /**
     * [start,end]表示数组的区间 也是线段树结点的区间
     * 建node结点，则就是递归建立左结点和右结点
     * @param arr 原数组
     * @param tree 线段树 数组存储
     * @param node 线段树当前顶点结点
     * @param start 原数组左端点
     * @param end 原数组右端点
     */
    public static void build_tree(int[] arr,int[] tree,int node,int start,int end){
        if(start == end){
            tree[node] = arr[start];
        }else{
            int mid = (start+end)/2;
            int left_node = node*2+1;
            int right_node = node*2+2;
            build_tree(arr,tree,left_node,start,mid);
            build_tree(arr,tree,right_node,mid+1,end);
            tree[node] = tree[left_node] + tree[right_node];//非叶子节点
        }
    }

    /**
     * 作用：单点修改，将数组中的arr[idx]=val,
     * 由于已经创建线段树，那么现在只能通过遍历树修改
     * 过程：将idx号改成val，那么难点在修改树上，遍历区间去修改
     * @param arr 原数组
     * @param tree 线段树数组存储
     * @param node 当前结点
     * @param start 线段树的分段区间 即数组的下标
     * @param end  线段树的分段区间 即数组的下标
     * @param idx 需要修改的数组下标
     * @param val 修改的值
     */
    public static void update_tree(int[] arr,int[] tree,int node,int start,int end,int idx,int val){
        if(start == end){//根据区间走的，所以不需要判断start==idx，只需start==end走到结点即可
            arr[idx] = val;
            tree[node] = val;
        }else{//不是叶子节点
            int mid = (start+end)/2;
            int left_node = node*2+1;
            int right_node = node*2+2;
            if(idx >= start && idx <=mid){
                update_tree(arr,tree,left_node,start,mid,idx,val);
            }else{
                update_tree(arr,tree,right_node,mid+1,end,idx,val);
            }
            tree[node] = tree[left_node]+tree[right_node];
        }
    }

    /**
     * 区间[L,R]求和
     * @param arr
     * @param tree
     * @param node
     * @param start
     * @param end
     * @param L
     * @param R
     * @return
     */
    public static int query_tree(int[] arr,int[] tree,int node,int start,int end,int L,int R){
        if(R < start || L > end){//没落在[start，end]上
            return 0;
        }else if(start == end) {//叶子结点直接返回值
            return tree[node];
        }else if(L <= start && end <= R){//如果[start,end]在[L,R]的子区间直接返回，用于剪枝
            return tree[node];
        }else{
                int mid = (start+end)/2;
                int left_node = node*2+1;
                int right_node = node*2+2;
                int sum_left = query_tree(arr,tree,left_node,start,mid,L,R);
                int sum_right = query_tree(arr,tree,right_node,mid+1,end,L,R);
                return sum_left + sum_right;
        }
    }










}
