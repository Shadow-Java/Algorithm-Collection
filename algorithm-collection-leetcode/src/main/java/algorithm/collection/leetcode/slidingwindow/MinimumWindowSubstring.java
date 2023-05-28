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
 *
 * 给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。
 *
 * 输入：s = "ADOBECODEBANC", t = "ABC"
 * 输出："BANC"
 * 解释：最小覆盖子串 "BANC" 包含来自字符串 t 的 'A'、'B' 和 'C'。
 *
 * 输入：s = "a", t = "a"
 * 输出："a"
 * 解释：整个字符串 s 是最小覆盖子串。
 *
 * 如果一个数组问题可以用动态规划解，但又可以使用滑动窗口解决，那么往往滑动窗口的效率更高。<br/>
 * 滑动窗口使用双指针解决问题，所以一般也叫双指针算法，因为两个指针间形成一个窗口
 *
 * 什么情况适合用双指针呢？一般双指针是暴力算法的优化版，所以：
 * 如果题目较为简单，且是数组或链表问题，往往可以尝试双指针是否可解。
 * 如果数组存在规律，可以尝试双指针。
 * 如果链表问题限制较多，比如要求 O(1) 空间复杂度解决，也许只有双指针可解。
 * 也就是说，当一个问题比较有规律，或者较为简单，或较为巧妙时，可以尝试双指针（滑动窗口）解法。
 * @author shadow
 * @create 2023-05-18 00:42
 **/
@QuestionTag(
        difficultyLeve = DifficultyLevel.HARD,
        questionNumber = "76",
        questionTitle = "最小覆盖子串",
        desc = "",
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
                if (s == null || s.length() == 0 || t == null || t.length() == 0){
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
                desc = "错误的解法：重要在于左指针怎么更新",
                methodLink = "https://leetcode.cn/problems/minimum-window-substring/solution/tong-su-qie-xiang-xi-de-miao-shu-hua-dong-chuang-k/",
                timeComplexity = TimeComplexity.O_N,
                dataStructType = DataStructType.HASH_MAP,
                algorithmCategory = AlgorithmCategory.SLIDE_WINDOW
        )
        public static String minWindow(String s, String t){
                Map<Character,Integer> map = new HashMap<>();
                int left = 0;
                //窗口大小
                int minSize = Integer.MAX_VALUE;
                //窗口的string
                String res = "";
                //目标的字符集
                Set<Character> set = new HashSet<>();
                for (char c: t.toCharArray()) {
                        set.add(c);
                }
                //窗口的字符和每个字符对应的数量
                Map<Character,Integer> windowMap = new HashMap();
                for (int right=0;right<s.length();right++){
                        char rightCh = s.charAt(right);
                        int length = right-left+1;
                        windowMap.put(rightCh,windowMap.getOrDefault(rightCh,0)+1);
                        if(isSubString(windowMap,t)){
                              while (isSubString(windowMap,t)){
                                      char leftCh = s.charAt(left);
                                      if(windowMap.get(leftCh) == 1){
                                              windowMap.put(leftCh,0);
                                      }else{
                                              windowMap.put(leftCh,windowMap.get(leftCh)-1);
                                      }
                                     left++;
                              }
                              minSize = Math.min(minSize,length);
                              res = s.substring(left-1,right+1);
                        }
                }
                return res;
        }

        public static boolean isSubString(Map<Character, Integer> windowMap, String t){
                int[] count = new int[26];
                for(char ch : t.toCharArray()){
                        int index = ch - 'a';
                        count[index]++;
                }
                for (int i = 0;i<count.length;i++){
                       if(count[i] > 0){
                               char ch = (char)(i+'a');
                               if(windowMap.get(ch) != count[i]){
                                       return false;
                               }
                       }
                }
                return true;
        }

        public static void main(String[] args) {
                Map<Character,Integer> windowMap = new HashMap();
                windowMap.put('b',1);
                String t = "a";
                String s = "a";
                System.out.println(minWindow(s,t));
        }
}
