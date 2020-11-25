package SourceCode.src;

/**
 * 给你一个字符串 s ，请你根据下面的算法重新构造字符串：
 *
 * 从 s 中选出 最小 的字符，将它 接在 结果字符串的后面。
 * 从 s 剩余字符中选出 最小 的字符，且该字符比上一个添加的字符大，将它 接在 结果字符串后面。
 * 重复步骤 2 ，直到你没法从 s 中选择字符。
 * 从 s 中选出 最大 的字符，将它 接在 结果字符串的后面。
 * 从 s 剩余字符中选出 最大 的字符，且该字符比上一个添加的字符小，将它 接在 结果字符串后面。
 * 重复步骤 5 ，直到你没法从 s 中选择字符。
 * 重复步骤 1 到 6 ，直到 s 中所有字符都已经被选过。
 * 在任何一步中，如果最小或者最大字符不止一个 ，你可以选择其中任意一个，并将其添加到结果字符串。
 *
 * 输入：s = "aaaabbbbcccc"
 * 输出："abccbaabccba"
 * 解释：第一轮的步骤 1，2，3 后，结果字符串为 result = "abc"
 * 第一轮的步骤 4，5，6 后，结果字符串为 result = "abccba"
 * 第一轮结束，现在 s = "aabbcc" ，我们再次回到步骤 1
 * 第二轮的步骤 1，2，3 后，结果字符串为 result = "abccbaabc"
 * 第二轮的步骤 4，5，6 后，结果字符串为 result = "abccbaabccba"
 *
 */
public class IncreasingDecreasingString {
    /**
     * 利用桶的概念，将字符存在数组中，只需要从左到右遍历，再从右向左遍历
     * @param s
     * @return
     */
    public String sortString(String s) {
        int[] alphabet = new int[26];//字母表
        for(int i=0;i<s.length();i++){
            alphabet[s.charAt(i)-'a']++;//存入的是大小，不需要hashmap
        }
        int index =0;char[] res = new char[s.length()];
        while(index < s.length()){
            for(int i = 0;i<26;i++){//向左走
                if(alphabet[i] > 0){
                    res[index++] = (char)(i+'a');
                    alphabet[i]--;//复制一次，减少一次
                }
            }
            for(int i = 25;i >= 0;i--){//向左走
                if(alphabet[i] > 0){
                    res[index++] = (char)(i+'a');
                    alphabet[i]--;
                }
            }
        }
        return new String(res);//数组变string

    }
}
