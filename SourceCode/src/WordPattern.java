package SourceCode.src;

import java.util.HashMap;

/**
 * 给定一种规律 pattern 和一个字符串 str ，判断 str 是否遵循相同的规律。
 *
 * 这里的 遵循 指完全匹配，例如， pattern 里的每个字母和字符串 str 中的每个非空单词之间存在着双向连接的对应规律。
 *
 * 输入: pattern = "abba", str = "dog cat cat dog"
 * 输出: true
 *
 * 输入:pattern = "abba", str = "dog cat cat fish"
 * 输出: false
 */
public class WordPattern {
    /**
     * 两个字典查找对应的单词
     * @param pattern
     * @param s
     * @return
     */
    public boolean wordPattern(String pattern, String s) {
        HashMap<Character,String> dictionary = new HashMap<>();
        HashMap<String,Character> dictionary2 = new HashMap<>();
        String[] words = s.split("\\s+");//正则表达式根据空格分割字符创
        int index = 0;
        if(pattern.length() != words.length) return false;
        for(Character c : pattern.toCharArray()){
            if(dictionary.get(c) != null && !dictionary.get(c).equals(words[index])){
                return false;
            }
            if(dictionary2.get(words[index]) != null && !dictionary2.get(words[index]).equals(c))
                return false;
            if(dictionary.get(c) == null){
                //双注册
                dictionary.put(c,words[index]);
                dictionary2.put(words[index],c);
            }
            index++;
        }
        return true;
    }

}
