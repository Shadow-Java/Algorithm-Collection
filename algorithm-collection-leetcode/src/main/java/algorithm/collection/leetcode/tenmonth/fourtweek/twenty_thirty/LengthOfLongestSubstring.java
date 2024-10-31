package algorithm.collection.leetcode.tenmonth.fourtweek.twenty_thirty;

import java.util.ArrayList;
import java.util.List;

/**
 * @author shadow
 * @create 2024-10-30 21:16
 **/
public class LengthOfLongestSubstring {

    public int lengthOfLongestSubstring(String s) {
        if("".equals(s) || s == null) {
            return 0;
        }
        int left = 0;
        List<Character> window = new ArrayList<>();
        int[] dict = new int[24];
        int max = 1;
        for(int right =0;right<s.length();right++) {
            if(window.contains(s.charAt(right))) {
                int cur = left;
                left = dict[s.charAt(right)-'a']+1;
                while(cur < left) {
                    window.remove(s.charAt(cur));
                    cur++;
                }
            }
            max = Math.max(max, right - left+1);
            dict[s.charAt(right)-'a'] = right;
            window.add(s.charAt(right));
        }
        return max;
    }

}
