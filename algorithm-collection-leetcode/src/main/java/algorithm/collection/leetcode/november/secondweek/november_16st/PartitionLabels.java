package algorithm.collection.leetcode.november.secondweek.november_16st;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 763. 划分字母区间
 * 给你一个字符串 s 。我们要把这个字符串划分为尽可能多的片段，同一字母最多出现在一个片段中。
 *
 * 注意，划分结果需要满足：将所有划分结果按顺序连接，得到的字符串仍然是 s 。
 *
 * 返回一个表示每个字符串片段的长度的列表。
 *
 * 输入：s = "ababcbacadefegdehijhklij"
 * 输出：[9,7,8]
 * 解释：
 * 划分结果为 "ababcbaca"、"defegde"、"hijhklij" 。
 * 每个字母最多出现在一个片段中。
 * 像 "ababcbacadefegde", "hijhklij" 这样的划分是错误的，因为划分的片段数较少。
 *
 * 输入：s = "eccbbbbdec"
 * 输出：[10]
 *
 * @author shadow
 * @create 2024-11-16 23:43
 **/
public class PartitionLabels {

    public List<Integer> partitionLabels(String s) {
        List<Integer> ans = new ArrayList<>();
        Map<Character,Integer> dict = new HashMap<>();
        for (int i= 0;i<s.length();i++) {
            dict.put(s.charAt(i),i);
        }
        int left = 0;
        int right = 0;
        for (int i= 0;i<s.length();i++) {
            //拿到每个字符的最后一个位置
            right = Math.max(right,dict.get(s.charAt(i)));
            if(right == i) {//如果到达区间内的最后一个位置，则分割
                ans.add(right-left+1);//取区间长度
                left = i+1;//取下一个位置为区间的左端点
            }
        }
        return ans;
    }

}
