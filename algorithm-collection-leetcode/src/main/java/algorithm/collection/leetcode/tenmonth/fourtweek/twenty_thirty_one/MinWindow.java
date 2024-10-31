package algorithm.collection.leetcode.tenmonth.fourtweek.twenty_thirty_one;

/**
 * 给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。
 * 注意：
 *
 * 对于 t 中重复字符，我们寻找的子字符串中该字符数量必须不少于 t 中该字符数量。
 * 如果 s 中存在这样的子串，我们保证它是唯一的答案。
 *
 * 输入：s = "ADOBECODEBANC", t = "ABC"
 * 输出："BANC"
 * 解释：最小覆盖子串 "BANC" 包含来自字符串 t 的 'A'、'B' 和 'C'。
 *
 * 输入：s = "a", t = "a"
 * 输出："a"
 * 解释：整个字符串 s 是最小覆盖子串。
 *
 * 输入: s = "a", t = "aa"
 * 输出: ""
 * 解释: t 中两个字符 'a' 均应包含在 s 的子串中，
 * 因此没有符合条件的子字符串，返回空字符串。
 *
 * @author shadow
 * @create 2024-10-31 22:49
 **/
public class MinWindow {


    public String minWindow_V2(String S, String t) {
        char[] s = S.toCharArray();
        int m = s.length;
        int ansLeft = -1;
        int ansRight = m;
        int[] cntS = new int[128]; // s 子串字母的出现次数
        int[] cntT = new int[128]; // t 中字母的出现次数
        for (char c : t.toCharArray()) {
            cntT[c]++;
        }

        int left = 0;
        for (int right = 0; right < m; right++) { // 移动子串右端点
            cntS[s[right]]++; // 右端点字母移入子串
            while (isCovered(cntS, cntT)) { // 涵盖
                if (right - left < ansRight - ansLeft) { // 找到更短的子串
                    ansLeft = left; // 记录此时的左右端点
                    ansRight = right;
                }
                cntS[s[left]]--; // 左端点字母移出子串
                left++;
            }
        }
        return ansLeft < 0 ? "" : S.substring(ansLeft, ansRight + 1);
    }

    private boolean isCovered(int[] cntS, int[] cntT) {
        for (int i = 'A'; i <= 'Z'; i++) {
            if (cntS[i] < cntT[i]) {
                return false;
            }
        }
        for (int i = 'a'; i <= 'z'; i++) {
            if (cntS[i] < cntT[i]) {
                return false;
            }
        }
        return true;
    }


    /**
     * 超时
     * @param s
     * @param t
     * @return
     */
    public String minWindow(String s, String t) {
        int min = Integer.MAX_VALUE;
        int n = t.length();
        String ans = "";

        for(int i=0;i<s.length();i++) {
            char ch = s.charAt(i);
            String res = String.valueOf(ch);
            for(int j=i;j<s.length();j++) {
                if(j > i) {
                    res += s.charAt(j);
                }
                if(res.length() >= n && isSubStr(res,t)) {
                    if(res.length() < min) {
                        ans = res;
                    }
                    min = Math.min(min,res.length());
                }
            }
        }
        return ans;
    }

    public boolean isSubStr(String subStr,String t) {
        int[] dict = new int[64];
        for(int i=0;i<t.length();i++) {
            dict[t.charAt(i)-'A']++;
        }
        for(int i=0;i<subStr.length();i++) {
            dict[subStr.charAt(i)-'A']--;
        }
        for(int i=0;i<64;i++) {
            if(dict[i] > 0 ) {
                return false;
            }
        }
        return true;
    }

}
