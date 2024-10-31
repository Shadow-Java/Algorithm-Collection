package algorithm.collection.leetcode.tenmonth.fourtweek.twenty_thirty;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author shadow
 * @create 2024-10-30 22:43
 **/
public class FindAnagrams {

    public static List<Integer> findAnagrams(String s, String p) {
        int left = 0;
        List<Integer> ans = new ArrayList<>();
        List<Character> window = new ArrayList<>();
        window.add(s.charAt(0));
        for(int right=1;right<s.length();right++) {
            char ch = s.charAt(right);
            window.add(ch);
            if(right-left +1== p.length()) {
                Character[] winStr = new Character[window.size()];
                window.toArray(winStr);
                Arrays.sort(winStr);
                if(p.equals(String.valueOf(winStr))) {
                    ans.add(left);
                    window.remove(s.charAt(left));
                    left++;
                }
            }
        }
        return ans;
    }


    public static void main(String[] args) {
        String s = "cbaebabacd";
        String p = "abc";
        System.out.println(findAnagrams(s, p));
    }

}
