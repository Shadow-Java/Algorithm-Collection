package algorithm.collection.leetcode.slidingwindow;

import algorithm.collection.common.datastruct.tag.AlgorithmCategory;
import algorithm.collection.common.datastruct.tag.DataStructType;
import algorithm.collection.common.datastruct.tag.DifficultyLevel;
import algorithm.collection.common.datastruct.tag.MethodTag;
import algorithm.collection.common.datastruct.tag.QuestionTag;
import algorithm.collection.common.datastruct.tag.TimeComplexity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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


    /**
     * 令 n 为字符串 s 的长度，m 为数组 words 的长度（单词的个数），w 为单个单词的长度。
     *
     * 由于 words 里面每个单词长度固定，而我们要找的字符串只能恰好包含所有的单词，因此我们要找的目标子串的长度为 m×wm \times wm×w。
     *
     * 那么一个直观的思路是：
     *
     * 1.使用哈希表 map 记录 words 中每个单词的出现次数
     * 2.枚举 s 中的每个字符作为起点，往后取得长度为 m×wm \times wm×w 的子串 sub
     * 3.使用哈希表 cur 统计 sub 每个单词的出现次数（每隔 w 长度作为一个单词）
     * 4.比较 cur 和 map 是否相同
     * 注意：在步骤 333 中，如果发现 sub 中包含了 words 没有出现的单词，可以直接剪枝
     *
     * @param s
     * @param words
     * @return
     */
    public List<Integer> anotherWay(String s, String[] words) {
        int n = s.length(), m = words.length, w = words[0].length();
        Map<String, Integer> map = new HashMap<>();
        for (String word : words) map.put(word, map.getOrDefault(word, 0) + 1);
        List<Integer> ans = new ArrayList<>();
        out:for (int i = 0; i + m * w <= n; i++) {
            Map<String, Integer> cur = new HashMap<>();
            String sub = s.substring(i, i + m * w);
            for (int j = 0; j < sub.length(); j += w) {
                String item = sub.substring(j, j + w);
                if (!map.containsKey(item)) continue out;
                cur.put(item, cur.getOrDefault(item, 0) + 1);
            }
            if (cur.equals(map)) ans.add(i);
        }
        return ans;
    }



    @MethodTag(
            methodLink = "https://leetcode.cn/problems/substring-with-concatenation-of-all-words/solutions/3825/chuan-lian-suo-you-dan-ci-de-zi-chuan-by-powcai/",
            questionNumber = "30",
            timeComplexity = TimeComplexity.O_N,
            dataStructType = DataStructType.DEDED_DOUBLE_QUEUE,
            algorithmCategory = AlgorithmCategory.DOUBLE_POINTER
    )
    public List<Integer> findSubstring(String s, String[] words) {
        /*
        滑动窗口+双HashMap优化
        关键在于只需要遍历0-wordLen-1为起始索引的子串,然后遍历边维护符合条件res
        具体逻辑可以看代码,核心就是动态维护根据cur的数目动态查找合法子串
        时间复杂度:O(N),空间复杂度:O(N)
        */
        List<Integer> res = new ArrayList<>();
        // 阴间案例
        if(s == null || s.length() == 0 || words == null || words.length == 0) {
            return res;
        }
        // s的长度
        int len = s.length();
        // 单词总个数
        int wordNum = words.length;
        // 每个单词长度
        int wordLen = words[0].length();
        // words总长度
        int totalLen = wordNum * wordLen;
        // 长度不符合预期
        if(totalLen > len) {
            return res;
        }
        // 存储words的单词和个数
        Map<String, Integer> allWords = new HashMap<>();
        for(String word : words) {
            // 找不到当前单词肯定没有
            if(s.indexOf(word) == -1) {
                return res;
            }
            allWords.put(word, allWords.getOrDefault(word, 0) + 1);
        }
        // 只需要遍历wordLen种起点:0~wordLen-1
        for(int i = 0; i < wordLen; i++) {
            // 左右指针以及当前窗口中符合的单词个数
            int left = i, right = i, count = 0;
            // 存储[left,right)内符合条件的单词及其数量
            Map<String, Integer> hasWords = new HashMap<>();
            // right移动的右边界为len(含)
            while(right + wordLen <= len) {
                // 当前要考虑的单词部分[right,right+wordLen)
                String cur = s.substring(right, right + wordLen);
                // 选了当前单词就要移动右指针
                right += wordLen;
                if(allWords.containsKey(cur)) {
                    // 1.allWords里有cur,说明是合法的,可以加入
                    hasWords.put(cur, hasWords.getOrDefault(cur, 0) + 1);
                    // 有效单词数+1
                    count++;
                    // 有一种特殊情况是有cur,但其数目超过了上限,需要一直舍弃左边的直至合法
                    while(hasWords.get(cur) > allWords.get(cur)) {
                        // 要移除的单词
                        String del = s.substring(left, left + wordLen);
                        // 更新haswords
                        hasWords.put(del, hasWords.get(del) - 1);
                        // 同时移动左指针
                        left += wordLen;
                        // count数目-1
                        count--;
                    }
                }else {
                    // 2.allWords里有没cur,说明cur是不合法的,得将left指针移动到新的1right后面
                    left = right;
                    // 清空hasWords
                    hasWords.clear();
                    // 清空count
                    count = 0;
                }
                // 每当count更新一次就判断是否符合预期
                if(count == wordNum) res.add(left);
            }
        }
        return res;
    }

}
