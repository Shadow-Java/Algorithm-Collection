package algorithm.collection.leetcode.slidingwindow;

import algorithm.collection.common.datastruct.tag.AlgorithmCategory;
import algorithm.collection.common.datastruct.tag.DataStructType;
import algorithm.collection.common.datastruct.tag.DifficultyLevel;
import algorithm.collection.common.datastruct.tag.MethodTag;
import algorithm.collection.common.datastruct.tag.QuestionTag;
import algorithm.collection.common.datastruct.tag.TimeComplexity;

/**
 * 如果字符串中的所有字符都相同，那么这个字符串是单字符重复的字符串。
 * <p>
 * 给你一个字符串text，你只能交换其中两个字符一次或者什么都不做，然后得到一些单字符重复的子串。返回其中最长的子串的长度。
 * 注：交换其中的两个字符一次，意思是只能动一个字符，即a与b交换就算两个字符交换一次
 * <p>
 * 输入：text = "ababa"
 * 输出：3
 * <p>
 * 输入：text = "aaabaaa"
 * 输出：6
 * <p>
 * 输入：text = "aaabbaaa"
 * 输出：4
 * <p>
 * 输入：text = "aaaaa"
 * 输出：5
 *
 * @author shadow
 * @create 2023-07-23 13:41
 **/
@QuestionTag(
        questionNumber = "1156",
        questionTitle = "单字符重复子串的最大长度",
        difficultyLeve = DifficultyLevel.MEDIUM,
        questionLink = "https://leetcode.cn/problems/swap-for-longest-repeated-character-substring/",
        algorithmCategory = AlgorithmCategory.SLIDE_WINDOW,
        timeComplexity = TimeComplexity.O_N
)
public class SwapLongestRepeatedCharacterSubstring {

    /**
     * 单字符重复子串的最大长度
     * @param text    文本
     * @return
     */
    @MethodTag(
            questionNumber = "1156",
            timeComplexity = TimeComplexity.O_N,
            dataStructType = DataStructType.ARRAY_LIST,
            algorithmCategory = AlgorithmCategory.SLIDE_WINDOW
    )
    public int maxRepOpt1(String text) {
        /**
         * 统计文本中的每次字符的出现次数
         */
        int[] cnt = new int[26];
        int n = text.length();
        for (int i = 0; i < n; ++i) {
            ++cnt[text.charAt(i) - 'a'];
        }
        /**
         * 1.指针i指向当前第一个字符，使用指针j不断地向右移动,直到j指向不同的字符，此时窗口为[i..j]，所有的字符都相等,窗口长度l=j-i
         * 2.跳过指针j指向的字符，用指针k继续向右移动，直到k指向的字符与i指向的字符不同，此时长度r=k-j-1
         * 3.得到最长的单字符重复子串长度为min(l+r+1,cnt[text[i]])
         * 4.将指针i指向j的位置
         */
        int ans = 0, i = 0;
        /**
         * i为每种字符的首个位置，ans为当前字符的交换后最长重复子串
         */
        while (i < n) {
            int j = i;
            while (j < n && text.charAt(j) == text.charAt(i)) {
                ++j;
            }
            int l = j - i;
            /**
             * 交换一次，即加1
             */
            int k = j + 1;
            while (k < n && text.charAt(k) == text.charAt(i)) {
                ++k;
            }
            int r = k - j - 1;
            ans = Math.max(ans, Math.min(l + r + 1, cnt[text.charAt(i) - 'a']));
            i = j;
        }
        return ans;
    }

}
