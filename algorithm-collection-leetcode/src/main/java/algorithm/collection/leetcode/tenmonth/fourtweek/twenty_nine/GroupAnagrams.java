package algorithm.collection.leetcode.tenmonth.fourtweek.twenty_nine;

import java.lang.reflect.Array;
import java.util.*;

public class GroupAnagrams {

    /**
     * 字母异位词分组:字母异位词指的是由重新排列源单词的所有字母得到的一个新单词，也就是说，两个单词如果包含相同的字母，只是顺序不同，那么它们就是彼此的字母异位词
     *
     * 什么场景下可以用map结构？
     * 1.将map当做数据库存储，遍历数据时取这个key所在的值
     * 2.当查找这个key逆向的值时，比如两数之和，比如单词的异位词
     * 3.当查找
     * @param strs
     * @return
     */
    public List<List<String>>  groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String key = String.valueOf(chars);
            List<String> list = map.getOrDefault(key, new ArrayList<>());
            list.add(str);
            if(!map.containsKey(key)) {
                map.put(key,list);
            }
        }
        List<List<String>> ans = new ArrayList<>();
        for (String key : map.keySet()) {
            List<String> list = map.get(key);
            ans.add(list);
        }
        return ans;
    }

}
