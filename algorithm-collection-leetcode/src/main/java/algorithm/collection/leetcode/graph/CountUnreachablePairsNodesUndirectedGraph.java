package algorithm.collection.leetcode.graph;

import algorithm.collection.common.datastruct.tag.AlgorithmCategory;
import algorithm.collection.common.datastruct.tag.DataStructType;
import algorithm.collection.common.datastruct.tag.DifficultyLevel;
import algorithm.collection.common.datastruct.tag.QuestionTag;
import algorithm.collection.common.datastruct.tag.TimeComplexity;
import algorithm.collection.primary.graph.UnionFindSet;

/**
 * @author shadow
 * @create 2023-10-21 19:35
 **/
@QuestionTag(
        difficultyLeve = DifficultyLevel.MEDIUM,
        questionNumber = "2316",
        questionTitle = "统计无向图中无法互相到达点对数",
        relevateClass = UnionFindSet.class,
        desc = "给定一个二叉树的根 root 和两个整数 val 和 depth ，在给定的深度 depth 处添加一个值为 val 的节点行。",
        questionLink = "https://leetcode.cn/problems/add-one-row-to-tree/",
        algorithmCategory = AlgorithmCategory.DEPTH_FIRST_SEARCH,
        timeComplexity = TimeComplexity.O_N_2,
        dataStructTypes = {DataStructType.ARRAY_LIST}
)
public class CountUnreachablePairsNodesUndirectedGraph {
    /**
     * 表示n个节点
     */
    private int[] nodes;

    private int[] cnt;

    /**
     *
     * @param n      结点数
     * @param edges  图的二维结构
     * @return
     */
    public long countPairs(int n, int[][] edges){
        nodes = new int[n];
        cnt = new int[n];
        for (int i=0;i<n;i++){
            /**
             * 并查集初始化：表示n个节点的父节点为自己，即自己为独立个体
             */
            nodes[i] = i;
            /**
             * 表示当前为n个集合，且每个集合的节点数为1
             */
            cnt[i] = 1;
        }
        /**
         * edge[0]->edge[1]
         */
        for (int[] edge:edges) {
            int pa = findLeader(edge[0]);
            int pb = findLeader(edge[1]);
            if(pa != pb){
                /**
                 * 因为初始化时，两个节点为独立个体，利用二维数组组建一个集合；即合并成一个集合，默认edge[1]为edge[0]的父节点
                 */
                nodes[pa] = pb;
                /**
                 * 即当前的集合的CEO pb的个数新增
                 */
                cnt[pb] = cnt[pb]+cnt[pa];
            }
        }
        long res = 0;
        long sum = 0;//这里有一个坑，sum一定要为long，否则res累加的时候，cnt*sum会溢出导致答案错误
        for (int i = 0; i < n; i ++ ) {
            if (nodes[i] == i) {//找到一个集合
                res += cnt[i] * sum;//统计互相不可达的点的数量
                sum += cnt[i];//相当于0*1+1*4+5*2=14
            }
        }
        return res;
    }

    /**
     * 使用路径压缩的方式查找父节点，即集合的代表者
     * @param x    节点编号
     * @return     节点所属的父节点
     */
    private int findLeader(int x) {
        /**
         * 比如A节点的父节点为B，那么接着往上找find[B],且让A的节点指向父节点最高父节点，集合的代表者（可以认为是集团的CEO）
         * 集团的CEO 关系nodes[pa]=pa
         */
        if (x != nodes[x]) {
            nodes[x] = findLeader(nodes[x]);
        }
        return nodes[x];
    }

}
