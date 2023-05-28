package algorithm.collection.leetcode.slidingwindow;

import algorithm.collection.common.datastruct.tag.AlgorithmCategory;
import algorithm.collection.common.datastruct.tag.DataStructType;
import algorithm.collection.common.datastruct.tag.DifficultyLevel;
import algorithm.collection.common.datastruct.tag.QuestionTag;
import algorithm.collection.common.datastruct.tag.TimeComplexity;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * 给定一个字符串s和一个字符串数组words。words中所有字符串 长度相同。
 *
 * s中的 串联子串 是指一个包含words中所有字符串以任意顺序排列连接起来的子串。
 *
 * 例如，如果words = ["ab","cd","ef"]， 那么"abcdef"，"abefcd"，"cdabef"，"cdefab"，"efabcd"， 和"efcdab" 都是串联子串。"acdbef" 不是串联子串，因为他不是任何words排列的连接。
 * 返回所有串联字串在s中的开始索引。你可以以 任意顺序 返回答案。
 *
 *
 * 输入：s = "barfoothefoobarman", words = ["foo","bar"]
 * 输出：[0,9]
 * 解释：因为 words.length == 2 同时 words[i].length == 3，连接的子字符串的长度必须为 6。
 * 子串 "barfoo" 开始位置是 0。它是 words 中以 ["bar","foo"] 顺序排列的连接。
 * 子串 "foobar" 开始位置是 9。它是 words 中以 ["foo","bar"] 顺序排列的连接。
 * 输出顺序无关紧要。返回 [9,0] 也是可以的。
 *
 * @author shadow
 * @date 2023/5/27 10:58
 * @since 1.0
 */
@QuestionTag(
        questionNumber = "30",
        questionTitle = "串联所有单词的子串",
        difficultyLeve = DifficultyLevel.HARD,
        desc = "给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。",
        questionLink = "https://leetcode.cn/problems/substring-with-concatenation-of-all-words/",
        algorithmCategory = AlgorithmCategory.DOUBLE_POINTER,
        timeComplexity = TimeComplexity.O_N,
        dataStructTypes = {DataStructType.HASH_MAP,DataStructType.ARRAY_LIST}
)
public class SubstringConcatenationofAllWords {

    public List<Integer> findSubstring(String s, String[] words) {
        return new ArrayList<>();
    }

}
