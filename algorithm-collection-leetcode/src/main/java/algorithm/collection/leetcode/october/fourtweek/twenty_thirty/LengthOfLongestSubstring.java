package algorithm.collection.leetcode.october.fourtweek.twenty_thirty;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 3. 无重复字符的最长子串
 * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串的长度。
 *
 *
 * 输入: s = "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 *
 * 输入: s = "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 *
 * 输入: s = "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 * @author shadow
 * @create 2024-10-30 21:16
 **/
public class LengthOfLongestSubstring {


    /**
     * 难点：这道题的窗口需要没有重复的字符，那么left需要移动到上一次right出现的下一个位置
     * 先判断是否存在后在存储当前字符
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring_V2(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int maxLen = 0;//用于记录最大不重复子串的长度
        int left = 0;//滑动窗口左指针
        for (int i = 0; i < s.length() ; i++)
        {
            /**
             1、首先，判断当前字符是否包含在map中，如果不包含，将该字符添加到map（字符，字符在数组下标）,
             此时没有出现重复的字符，左指针不需要变化。此时不重复子串的长度为：i-left+1，与原来的maxLen比较，取最大值；

             2、如果当前字符 ch 包含在 map中，此时有2类情况：
             1）当前字符包含在当前有效的子段中，如：abca，当我们遍历到第二个a，当前有效最长子段是 abc，我们又遍历到a，
             那么此时更新 left 为 map.get(a)+1=1，当前有效子段更新为 bca；
             2）当前字符不包含在当前最长有效子段中，如：abba，我们先添加a,b进map，此时left=0，我们再添加b，发现map中包含b，
             而且b包含在最长有效子段中，就是1）的情况，我们更新 left=map.get(b)+1=2，此时子段更新为 b，而且map中仍然包含a，map.get(a)=0；
             随后，我们遍历到a，发现a包含在map中，且map.get(a)=0，如果我们像1）一样处理，就会发现 left=map.get(a)+1=1，实际上，left此时
             应该不变，left始终为2，子段变成 ba才对。

             为了处理以上2类情况，我们每次更新left，left=Math.max(left , map.get(ch)+1).
             另外，更新left后，不管原来的 s.charAt(i) 是否在最长子段中，我们都要将 s.charAt(i) 的位置更新为当前的i，
             因此此时新的 s.charAt(i) 已经进入到 当前最长的子段中！
             */
            if(map.containsKey(s.charAt(i)))
            {
                left = Math.max(left , map.get(s.charAt(i))+1);
            }
            //不管是否更新left，都要更新 s.charAt(i) 的位置！
            map.put(s.charAt(i) , i);
            maxLen = Math.max(maxLen , i-left+1);
        }

        return maxLen;
    }

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
