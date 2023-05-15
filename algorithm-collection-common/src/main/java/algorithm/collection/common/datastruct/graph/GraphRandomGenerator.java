package algorithm.collection.common.datastruct.graph;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author shadow
 * @create 2023-05-14 17:01
 **/
public class GraphRandomGenerator {

    /**
     * 链接表生成图结构
     * @param nodeCount 结点个数
     * @param MaxValue  结点的最大值
     * @param existRing 是否存在环结构
     * @return
     */
    public Map<Integer, List<Integer>> generatorGraph(int nodeCount,int MaxValue,boolean existRing){
        Map<Integer, List<Integer>> graph = new HashMap<>();
        graph.put(0, Arrays.asList(1, 2));
        graph.put(1, Arrays.asList(0, 3, 4));
        graph.put(2, Arrays.asList(0, 5, 6));
        graph.put(3, Arrays.asList(1));
        graph.put(4, Arrays.asList(1, 5));
        graph.put(5, Arrays.asList(2, 4));
        graph.put(6, Arrays.asList(2));
        return graph;
    }

}
