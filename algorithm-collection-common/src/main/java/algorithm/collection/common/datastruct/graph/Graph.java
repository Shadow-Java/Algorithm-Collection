package algorithm.collection.common.datastruct.graph;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author shadow
 * @create 2023-05-14 16:54
 **/
public class Graph {

    /**
     * 使用链接表结构实现图
     */
    private Map<Integer, List<Integer>> graph;

    public Graph(Map<Integer, List<Integer>> graph) {
        this.graph = graph;
    }

}
