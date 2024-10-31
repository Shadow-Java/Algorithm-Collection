package algorithm.collection.leetcode.tenmonth.fourtweek.twenty_thirty;

import java.util.ArrayList;
import java.util.List;

/**
 * @author shadow
 * @create 2024-10-30 21:16
 **/
public class LengthOfLongestSubstring {

    /**
     * 设 n 是 p 的长度。本题有两种做法：
     * 定长滑窗。枚举 s 的所有长为 n 的子串 s′，如果 s′的每种字母的出现次数，和 p 的每种字母的出现次数都相同，那么 s′是 p 的异位词。
     * 不定长滑窗。
     * 枚举子串 s′的右端点，如果发现 s′其中一种字母的出现次数大于 p 的这种字母的出现次数，则右移 s′的左端点。如果发现 s′的长度等于 p 的长度，则说明 s′的每种字母的出现次数，
     * 和p的每种字母的出现次数都相同（如果出现次数 s′的小于 p 的，不可能长度一样），那么 s′是 p 的异位词。
     * 方法一：定长滑窗
     * 原理请看【套路】教你解决定长滑窗！适用于所有定长滑窗题目！。
     *
     * 本题维护长为 n 的子串 s′的每种字母的出现次数。如果 s′的每种字母的出现次数，和 p 的每种字母的出现次数都相同，那么 s′是 p 的异位词，把 s′左端点下标加入答案。
     * 方法二：不定长滑窗
     * 前置知识：滑动窗口【基础算法精讲 03】。
     *枚举子串 s′的右端点，如果发现 s′其中一种字母的出现次数大于 p 的这种字母的出现次数，则右移 s′的左端点。如果发现 s′的长度等于 p 的长度，则说明 s′的每种字母的出现次数，和 p 的每种字母的出现次数都相同，那么 s′
     * 是 p 的异位词。
     *
     * 证明：内层循环结束后，s′的每种字母的出现次数，都小于等于 p 的每种字母的出现次数。如果 s′的其中一种字母的出现次数比 p 的小，那么 s′的长度必然小于 p 的长度。所以只要 s′
     * 的长度等于 p 的长度，就说明 s′的每种字母的出现次数，和 p 的每种字母的出现次数都相同，s′是 p 的异位词，把 s′左端点下标加入答案。
     *
     * 代码实现时，可以把 cntS 和 cntP 合并成一个 cnt：
     *
     * 对于 p 的字母 c，把 cnt[p] 加一。
     * 对于 s′的字母 c，把 cnt[c] 减一。
     * 如果 cnt[c]<0，说明窗口中的字母 c 的个数比 p 的多，右移左端点。
     *
     * 答疑
     * 问：为什么只需判断字母 c 的出现次数？
     * 答：字母 c 进入窗口后，如果导致 cnt[c]<0，由于其余字母的出现次数没有变化，所以有且仅有字母 c 的个数比 p 的多。
     *
     *
     * @param s
     * @return
     */
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
