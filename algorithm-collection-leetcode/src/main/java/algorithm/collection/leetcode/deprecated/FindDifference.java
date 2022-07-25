package algorithm.collection.leetcode.deprecated;

import java.util.ArrayList;
import java.util.List;

/**
 *给定两个字符串 s 和 t，它们只包含小写字母。
 *
 * 字符串 t 由字符串 s 随机重排，然后在随机位置添加一个字母。
 *
 * 请找出在 t 中被添加的字母。
 *
 * 输入：s = "abcd", t = "abcde"
 * 输出："e"
 * 解释：'e' 是那个被添加的字母。
 */
public class FindDifference {
    //解法一：用list存储所有字符 然后包含则删除  最后取第一个
    public char findTheDifference(String s, String t) {
        List<Character> aphla = new ArrayList<>();
        for(int i=0;i<t.length();i++){
            aphla.add(t.charAt(i));
        }
        for(int i=0;i<s.length();i++){
            Character item = s.charAt(i);
            if(aphla.contains(s.charAt(i))){
                aphla.remove(item);
            }
        }
        return aphla.get(0);
    }
    //解法二：将所给的字符串转换为字符数组，求字符数组的int和，作差，再转回char，返回
}
