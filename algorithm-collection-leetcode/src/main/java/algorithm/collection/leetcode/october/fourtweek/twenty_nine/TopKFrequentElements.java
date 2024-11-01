package algorithm.collection.leetcode.october.fourtweek.twenty_nine;

import java.util.*;

public class TopKFrequentElements {

    public static void main(String[] args) {
        List<String> strings = List.of("ads","ads","ie","ie","ie","of","of","of","of");
        System.out.println(topK(strings,2));
    }

    /**
     * 第K大的字符串，即出现次数最多的前K个字符串
     * @param strings
     * @param k
     * @return
     */
    public static List<String> topK(List<String> strings,int k) {
        Map<String,Integer> countMap = new HashMap<>();
        for (String str : strings) {
            countMap.put(str, countMap.getOrDefault(str,0)+1);
        }
        PriorityQueue<String> minHeap = new PriorityQueue<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                Integer count1 = countMap.get(o1);
                Integer count2 = countMap.get(o2);
                return count1-count2 == 0 ? o1.compareTo(o2) : count2-count1;
            }
        });
        minHeap.addAll(countMap.keySet());
        List<String> ans = new ArrayList<>();
        while (k > 0) {
            ans.add(minHeap.poll());
            k--;
        }
        return ans;
    }
}
