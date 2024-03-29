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

    //当前树的高度
    private static int minHeight=0;
    //当前树的分支高度
    private static int curBranchHeight = 0;
    private static int num = 0;
    /**
     * 全局共享而不是方法内共享
     */
    private static List<Integer> visited = new ArrayList<>();

    public static void main(String[] args) {
        int[][] edges = new int[5][2];
        edges[0] = new int[]{3,0};
        edges[1] = new int[]{3,1};
        edges[2] = new int[]{3,2};
        edges[3] = new int[]{3,4};
        edges[4] = new int[]{5,4};
        findMinHeightTrees(6,edges);
    }

    public static List<Integer> findMinHeightTrees(int n, int[][] edges) {
        Map<Integer,List<Integer>> listMap = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        listMap.put(n,list);
        num=n;
        for(int i=0;i<n;i++) {
            System.out.println("开始遍历以："+i+"为顶点的树"+"初始高度为："+minHeight);
            dfs(edges,i,listMap,i);
            System.out.println("以："+i+"为顶点的树遍历结束"+"树最大高度为："+minHeight);
            minHeight=0;
            curBranchHeight=0;
            visited.clear();
        }
        Integer curVal = n;
        for (Integer key : listMap.keySet()) {
            System.out.println("树高度为"+key+",顶点集合为"+listMap.get(key));
            curVal = Math.min(curVal,key);
        }
        return listMap.get(curVal);
    }

    /**
     *
     * @param edges    边集合
     * @param i        当前顶点值
     */
    public static void dfs(int[][] edges,Integer i,Map<Integer,List<Integer>> listMap,int curNode) {
        visited.add(i);
        curBranchHeight++;
        minHeight = Math.max(minHeight,curBranchHeight);
        System.out.println("访问节点值为："+i);
        if(visited.size() == num) {
            System.out.println("访问完成后，当前分支高度"+curBranchHeight+"当前树最大高度："+minHeight);
            Optional<Integer> optionalInteger = listMap.keySet().stream().filter(val->val < minHeight).findFirst();
            if(optionalInteger.isEmpty()) {
                List<Integer> list = listMap.getOrDefault(minHeight,new ArrayList<>());
                list.add(curNode);
                listMap.clear();
                listMap.put(minHeight,list);
                System.out.println("以"+curNode+"为顶点的二叉树"+"遍历完所有节点，树高度为"+minHeight+"，当前分支高度为"+curBranchHeight);
                return;
            }
        }
        for(int row=0;row< edges.length;row++) {
            if(edges[row][0] == i && !visited.contains(edges[row][1])) {
                dfs(edges,edges[row][1],listMap,curNode);
                //这里minHeight表示的是当前深度分支的高度，而不是以curNode为顶点的最小高度，可能存在当前分支高度为3，另一个分支高度为4
                //这里回退的高度为当前分支的高度，退一个节点回退一个高度
                System.out.println("回退到节点值为："+edges[row][1]+",树高度为："+minHeight+"，当前分支高度为："+curBranchHeight);
                curBranchHeight--;
                //这里会回溯找其他节点
            } else if(edges[row][1] == i && !visited.contains(edges[row][0])) {
                dfs(edges,edges[row][0],listMap,curNode);
                //这里会回溯找其他节点，即回溯row点，继续遍历row+1点
                System.out.println("回退到节点值为："+edges[row][0]+",树高度为："+minHeight+"，当前分支高度为："+curBranchHeight);
                curBranchHeight--;
            }
        }
        //走到这个区域意味着一个深度分支遍历完毕
        System.out.println("以"+curNode+"为顶点"+"，当前节点值为"+i+"的节点分支深度遍历完毕，树深度为"+curBranchHeight+"，当前分支高度为"+curBranchHeight);
    }

}
