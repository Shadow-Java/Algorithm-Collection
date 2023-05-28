package algorithm.collection.leetcode.slidingwindow;

import algorithm.collection.common.datastruct.tag.AlgorithmCategory;
import algorithm.collection.common.datastruct.tag.DataStructType;
import algorithm.collection.common.datastruct.tag.DifficultyLevel;
import algorithm.collection.common.datastruct.tag.MethodTag;
import algorithm.collection.common.datastruct.tag.QuestionTag;
import algorithm.collection.common.datastruct.tag.TimeComplexity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 76. 最小覆盖子串
 * <p>
 * 给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。
 * <p>
 * 输入：s = "ADOBECODEBANC", t = "ABC"
 * 输出："BANC"
 * 解释：最小覆盖子串 "BANC" 包含来自字符串 t 的 'A'、'B' 和 'C'。
 * <p>
 * 输入：s = "a", t = "a"
 * 输出："a"
 * 解释：整个字符串 s 是最小覆盖子串。
 * <p>
 * 如果一个数组问题可以用动态规划解，但又可以使用滑动窗口解决，那么往往滑动窗口的效率更高。<br/>
 * 滑动窗口使用双指针解决问题，所以一般也叫双指针算法，因为两个指针间形成一个窗口
 * <p>
 * 什么情况适合用双指针呢？一般双指针是暴力算法的优化版，所以：
 * 如果题目较为简单，且是数组或链表问题，往往可以尝试双指针是否可解。
 * 如果数组存在规律，可以尝试双指针。
 * 如果链表问题限制较多，比如要求 O(1) 空间复杂度解决，也许只有双指针可解。
 * 也就是说，当一个问题比较有规律，或者较为简单，或较为巧妙时，可以尝试双指针（滑动窗口）解法。
 *
 * @author shadow
 * @create 2023-05-18 00:42
 **/
@QuestionTag(
        difficultyLeve = DifficultyLevel.HARD,
        questionNumber = "76",
        questionTitle = "最小覆盖子串",
        relevateClass = {LongestSubstring.class},
        questionLink = "https://leetcode.cn/problems/minimum-window-substring/",
        algorithmCategory = AlgorithmCategory.DEPTH_FIRST_SEARCH,
        timeComplexity = TimeComplexity.O_N
)
public class MinimumWindowSubstring {

    @MethodTag(
            questionNumber = "3",
            methodLink = "https://leetcode.cn/problems/minimum-window-substring/solution/tong-su-qie-xiang-xi-de-miao-shu-hua-dong-chuang-k/",
            timeComplexity = TimeComplexity.O_N,
            dataStructType = DataStructType.ARRAY_LIST,
            algorithmCategory = AlgorithmCategory.SLIDE_WINDOW
    )
    public String minWindow2(String s, String t) {
        if (s == null || s.length() == 0 || t == null || t.length() == 0) {
            return "";
        }
        int[] need = new int[128];
        //记录需要的字符的个数
        for (int i = 0; i < t.length(); i++) {
            need[t.charAt(i)]++;
        }
        //l是当前左边界，r是当前右边界，size记录窗口大小，count是需求的字符个数，start是最小覆盖串开始的index
        int l = 0, r = 0, size = Integer.MAX_VALUE, count = t.length(), start = 0;
        //遍历所有字符
        while (r < s.length()) {
            char c = s.charAt(r);
            if (need[c] > 0) {//需要字符c
                count--;
            }
            need[c]--;//把右边的字符加入窗口
            if (count == 0) {//窗口中已经包含所有字符
                while (l < r && need[s.charAt(l)] < 0) {
                    need[s.charAt(l)]++;//释放右边移动出窗口的字符
                    l++;//指针右移
                }
                if (r - l + 1 < size) {//不能右移时候挑战最小窗口大小，更新最小窗口开始的start
                    size = r - l + 1;
                    start = l;//记录下最小值时候的开始位置，最后返回覆盖串时候会用到
                }
                //l向右移动后窗口肯定不能满足了 重新开始循环
                need[s.charAt(l)]++;
                l++;
                count++;
            }
            r++;
        }
        return size == Integer.MAX_VALUE ? "" : s.substring(start, start + size);
    }


    @MethodTag(
            questionNumber = "3",
            desc = "错误的解法：使用hashmap进行计数有个问题，Integer会缓存频繁使用的数值，数值范围为-128到127，在此范围内直接返回缓存值。超过该范围就会new 一个对象。当不存在该字符时返回的是空，改为get(x).intValue,且比较时用equals",
            methodLink = "https://leetcode.cn/problems/minimum-window-substring/comments/",
            timeComplexity = TimeComplexity.O_N,
            dataStructType = DataStructType.HASH_MAP,
            algorithmCategory = AlgorithmCategory.SLIDE_WINDOW
    )
    public static String minWindow(String s, String t) {
        if (s.length() < t.length()) return "";
        Map<Character, Integer> matchMap = new HashMap<>();
        Map<Character, Integer> windowMap = new HashMap<>();
        // 对t中的每个字符计数，并统计在一个hashmap中
        for (char ch : t.toCharArray()) {
            matchMap.put(ch, matchMap.getOrDefault(ch, 0) + 1);
        }
        // valid记录window中的有效字符是否包含了match，start记录最小子串的起点
        int valid = 0, start = 0, res = Integer.MAX_VALUE;
        // 开始滑动窗口：r为窗口的右边界的下一个位置，每次循环将r加入窗口即可
        for (int l = 0, r = 0; r < s.length(); ++r) {
            windowMap.put(s.charAt(r), windowMap.getOrDefault(s.charAt(r), 0) + 1);
            // 判断右边界对应的字符是否存在于match中，存在的话需要判断window中该字符的计数值是否达到要求了
            if (matchMap.containsKey(s.charAt(r))) {
                if (matchMap.get(s.charAt(r)).equals(windowMap.get(s.charAt(r)))) {
                    valid++;
                }
            }
            // 若window内的有效字符已经包括match了，那么就收缩窗口，更新最小长度，更新最优解
            while (valid == matchMap.size()) {
                // 窗口[l,r]的长度更小，则更新res和start
                if (r - l + 1 < res) {
                    res = r - l + 1;
                    start = l;
                }
                // 移出窗口中的左边界时，需要更新窗口中的有效字符的个数
                if (matchMap.containsKey(s.charAt(l))) {
                    if (matchMap.get(s.charAt(l)).equals(windowMap.get(s.charAt(l)))) {
                        valid--;
                    }
                }
                // l移出窗口
                windowMap.put(s.charAt(l++), windowMap.get(s.charAt(l++)) - 1);
            }
        }
        return res == Integer.MAX_VALUE ? "" : s.substring(start, res);
    }


    public static void main(String[] args) {
        Map<Character, Integer> windowMap = new HashMap();
        windowMap.put('b', 1);
        String t = "a";
        String s = "a";
        System.out.println(minWindow(s, t));
    }
}
