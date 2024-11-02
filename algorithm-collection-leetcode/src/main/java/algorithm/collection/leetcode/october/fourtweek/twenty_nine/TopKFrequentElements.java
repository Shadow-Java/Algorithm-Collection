package algorithm.collection.leetcode.october.fourtweek.twenty_nine;

import java.util.*;

/**
 * 692. 前K个高频单词
 * 给定一个单词列表 words 和一个整数 k ，返回前 k 个出现次数最多的单词。
 *
 * 返回的答案应该按单词出现频率由高到低排序。如果不同的单词有相同出现频率， 按字典顺序 排序。
 *
 * 输入: words = ["i", "love", "leetcode", "i", "love", "coding"], k = 2
 * 输出: ["i", "love"]
 * 解析: "i" 和 "love" 为出现次数最多的两个单词，均为2次。
 * 注意，按字母顺序 "i" 在 "love" 之前。
 *
 * 输入: ["the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"], k = 4
 * 输出: ["the", "is", "sunny", "day"]
 * 解析: "the", "is", "sunny" 和 "day" 是出现次数最多的四个单词，出现次数依次为 4, 3, 2 和 1 次。
 */
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
