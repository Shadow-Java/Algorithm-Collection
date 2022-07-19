package src;

import java.util.HashMap;

/**
 * 给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。
 *
 * s = "leetcode"
 * 返回 0
 *
 * s = "loveleetcode"
 * 返回 2
 */
public class FirstUniqueCharacter {
    public int firstUniqChar(String s) {
        //可以利用数组的记忆化搜索int[26] count; [c-'a']++
        HashMap<Character,Integer> apha = new HashMap<>();
        for(Character c : s.toCharArray()){
            apha.put(c,apha.getOrDefault(c,0)+1);
        }
        for(int i=0;i<s.length();i++){
            if(apha.getOrDefault(s.charAt(i),0) == 1){
                return i;
            }
        }
        return -1;
    }

    public int firstUniqChar_3(String s) {
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (s.indexOf(ch) == s.lastIndexOf(ch)) {
                return i;
            }
        }
        return -1;
    }
}
