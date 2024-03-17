package algorithm.collection.leetcode.tree.dfs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * @author shadow
 * @create 2024-03-17 16:59
 **/
public class MinHeightTree {

    private static int minHeight=0;
    private static int num = 0;
    /**
     * 全局共享而不是方法内共享
     */
    private static List<Integer> visited = new ArrayList<>();

    public static void main(String[] args) {
        int[][] edges = new int[3][2];
        edges[0] = new int[]{1,0};
        edges[1] = new int[]{1,2};
        edges[2] = new int[]{1,3};
        findMinHeightTrees(4,edges);
    }

    public static List<Integer> findMinHeightTrees(int n, int[][] edges) {
        Map<Integer,List<Integer>> listMap = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        listMap.put(n,list);
        num=n;
        for(int i=0;i<n;i++) {
            minHeight=0;
            visited.clear();
            System.out.println("开始遍历以："+i+"为顶点的树"+"初始高度为："+minHeight);
            dfs(edges,i,listMap,i);
        }
        return listMap.values().stream().findFirst().get();
    }

    /**
     *
     * @param edges    边集合
     * @param i        当前顶点值
     */
    public static void dfs(int[][] edges,Integer i,Map<Integer,List<Integer>> listMap,int curNode) {
        visited.add(i);
        minHeight++;
        System.out.println("访问节点值为："+i);
        if(visited.size() == num) {
            Optional<Integer> optionalInteger = listMap.keySet().stream().filter(val->val <= minHeight).findFirst();
            if(optionalInteger.isEmpty()) {
                List<Integer> list = listMap.getOrDefault(minHeight,new ArrayList<>());
                list.add(curNode);
                listMap.clear();
                listMap.put(minHeight,list);
                System.out.println("以"+curNode+"为顶点的二叉树"+"遍历完所有节点，高度为"+minHeight);
                return;
            }
        }
        for(int row=0;row< edges.length;row++) {
            if(edges[row][0] == i && !visited.contains(edges[row][1])) {
                dfs(edges,edges[row][1],listMap,curNode);
                //这里minHeight表示的是当前深度分支的高度，而不是以curNode为顶点的最小高度，可能存在当前分支高度为3，另一个分支高度为4
                //这里回退的高度为当前分支的高度，退一个节点回退一个高度
                minHeight--;
                System.out.println("回退到节点值为："+edges[row][1]+",当前高度为："+minHeight);
                //这里会回溯找其他节点
            } else if(edges[row][1] == i && !visited.contains(edges[row][0])) {
                dfs(edges,edges[row][0],listMap,curNode);
                //这里会回溯找其他节点，即回溯row点，继续遍历row+1点
                minHeight--;
                System.out.println("回退到节点值为："+edges[row][0]+",当前高度为："+minHeight);
            }
        }
        //走到这个区域意味着一个深度分支遍历完毕
        System.out.println("以"+curNode+"为顶点"+"，当前节点值为"+i+"的节点分支深度遍历完毕，深度为"+minHeight);
    }

}
