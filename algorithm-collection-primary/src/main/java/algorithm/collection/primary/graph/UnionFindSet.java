package algorithm.collection.primary.graph;

/**
 * 并查集也称为不相交数据结构，并查集通过维护一个一维数组来实现，其本质是维护一个森林；森林的每个点都是孤立的，也可以认为每个点都是一个独立的树，之后通过一些条件，
 * 逐渐将这些树合并成一颗大树（Uion）,其合并的过程就是"结合父节点"的过程
 *
 *
 * 能解决什么问题：
 * 1.连通性问题 给两个节点是否连通
 * 2.动态连通性问题 在一个集合中，动态地添加和删除元素，并判断它们之间是否存在连通关系。例如，在一个社交网络中，动态添加和删除用户，并判断两个用户之间是否存在好友关系。
 *
 * 基本操作包括创建集合、合并集合和查询元素所在的集合。它通过维护一棵树来表示集合，其中每个节点表示一个元素，节点的父节点表示该元素所在的集合。合并集合时，将两个集合的根节点合并为一棵树；查询元素所在的集合时，找到该元素所在的树的根节点即可。
 *
 * Find：查找一个元素所在的集合
 * Union：根据一些规则合并多个集合
 * @author shadow
 * @create 2023-05-08 21:55
 **/
public class UnionFindSet {

    /**
     * i表示第几个强盗，robbers[i]=i，表示第i个强盗的首领是i，即父节点是自己
     */
    private int[] robbers = new int[10];

    public void init(){
        for(int i=0;i<10;i++){
            robbers[i] = i;
        }
    }

    /**
     * 找爹的递归函数，不停的去找爹，直到找到祖宗为止，其实就是找犯罪团伙的最高领导人，"擒贼先擒王"原则
     * @param v
     * @return
     */
    public int getLeader(int v){
        if(robbers[v] == v){
            return v;
        }else{
            /**
             * 路径压缩，每次在函数返回时，顺带把路上遇到人的boss改为最后找到的祖宗编号，也就是犯罪团伙的最高领导人，这样可以提高今后找到犯罪领导人的速度
             */
            robbers[v] = getLeader(robbers[v]);
            return robbers[v];
        }
    }

    /**
     * 根据警察找到的线索进行合并  遵循靠左原则
     *
     * @param v
     * @param u
     */
    public void merge(int v,int u){
        int i = getLeader(v);
        int j = getLeader(u);
        if(i != j){
            robbers[j] = i;
            /**
             * 靠左原则，左边变成右边的boss；即把右边的集合，作为左边集合的子集合
             * 经过路径压缩以后，将u的根的值也赋值为v的祖先robbers(i)
             */
        }
    }

    public static void main(String[] args) {
        /**
         * 10个线索，需要merge 10次
         * 最后有多少个集合，则robbers[i]=i有多少个
         */

    }

}
