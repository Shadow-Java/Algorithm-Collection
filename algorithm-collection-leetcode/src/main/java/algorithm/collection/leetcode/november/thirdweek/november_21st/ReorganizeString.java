package algorithm.collection.leetcode.november.thirdweek.november_21st;

import java.util.List;

/**
 * 767. 重构字符串
 * 给定一个字符串 s ，检查是否能重新排布其中的字母，使得两相邻的字符不同。
 * <p>
 * 返回 s 的任意可能的重新排列。若不可行，返回空字符串 "" 。
 * <p>
 * 示例 1:
 * <p>
 * 输入: s = "aab"
 * 输出: "aba"
 * 示例 2:
 * <p>
 * 输入: s = "aaab"
 * 输出: ""
 *
 * @author shadow
 * @create 2025-03-24 23:31
 **/
public class ReorganizeString {

    String str = "";

    public String reorganizeString(String s) {
        dfs(s, "", new boolean[s.length()]);
        return str;
    }


    /**
     * 超出时间限制
     * @param s
     * @param onPath
     * @param visited
     */
    public void dfs(String s, String onPath, boolean[] visited) {
        if (onPath.length() == s.length()) {
            str = new String(onPath);
            return;
        }
        if(false) {
            return;
        }
        for (int i = 0; i < s.length(); i++) {
            if(visited[i]) {//因为要回溯，到处转
                continue;
            }
            if(onPath.isEmpty()  || onPath.charAt(onPath.length()-1) != s.charAt(i)) {
                onPath += s.charAt(i);
                visited[i] = true;
                dfs(s, onPath, visited);
                onPath = onPath.substring(0, onPath.length()-1);
                visited[i] = false;
            }
        }
    }

}
