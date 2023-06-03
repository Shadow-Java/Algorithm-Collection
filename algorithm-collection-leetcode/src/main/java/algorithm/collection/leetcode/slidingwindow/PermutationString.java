package algorithm.collection.leetcode.slidingwindow;

import algorithm.collection.common.datastruct.tag.AlgorithmCategory;
import algorithm.collection.common.datastruct.tag.DataStructType;
import algorithm.collection.common.datastruct.tag.DifficultyLevel;
import algorithm.collection.common.datastruct.tag.MethodTag;
import algorithm.collection.common.datastruct.tag.QuestionTag;
import algorithm.collection.common.datastruct.tag.SegmentLevel;
import algorithm.collection.common.datastruct.tag.TimeComplexity;

import java.util.Map;

/**
 * 给你两个字符串s1和s2 ，写一个函数来判断 s2 是否包含 s1的排列。如果是，返回 true ；否则，返回 false 。
 * <p>
 * 换句话说，s1 的排列之一是 s2 的 子串
 * <p>
 * 输入：s1 = "ab" s2 = "eidbaooo"
 * 输出：true
 * 解释：s2 包含 s1 的排列之一 ("ba").
 * <p>
 * 输入：s1= "ab" s2 = "eidboaoo"
 * 输出：false
 * <p>
 * s1 和 s2 仅包含小写字母
 *
 * @author shadow
 * @create 2023-05-28 16:55
 **/
@QuestionTag(
        questionNumber = "567",
        questionTitle = "字符串的排列",
        difficultyLeve = DifficultyLevel.MEDIUM,
        desc = "给你两个字符串s1和s2 ，写一个函数来判断 s2 是否包含 s1的排列。如果是，返回 true ；否则，返回 false 。",
        questionLink = "https://leetcode.cn/problems/permutation-in-string/",
        algorithmCategory = AlgorithmCategory.DOUBLE_POINTER,
        relevateClass = {MinimumWindowSubstring.class},
        segmentLevel = SegmentLevel.SENSORY_MEMORY,
        timeComplexity = TimeComplexity.O_N,
        dataStructTypes = {DataStructType.HASH_MAP, DataStructType.ARRAY_LIST}
)
public class PermutationString {

    /**
     * 使用滑动窗口，窗口的子串就是包含s1的字符，且窗口的长度是固定的
     * <p>
     * 1.指针如何移动
     * 2.窗口是如何判断包含s1的子串
     *
     * @param s1
     * @param s2
     * @return
     */
    @MethodTag(
            questionNumber = "567",
            methodLink = "https://leetcode.cn/problems/minimum-window-substring/solution/tong-su-qie-xiang-xi-de-miao-shu-hua-dong-chuang-k/",
            timeComplexity = TimeComplexity.O_N,
            dataStructType = DataStructType.ARRAY_LIST,
            algorithmCategory = AlgorithmCategory.SLIDE_WINDOW
    )
    public static boolean checkInclusion(String s1, String s2) {
        //匹配串
        char[] pattern = s1.toCharArray();
        //文本串
        char[] text = s2.toCharArray();

        int pLen = s1.length();
        int tLen = s2.length();
        //匹配串的出现频率
        int[] pFreq = new int[26];
        //窗口串的频率
        int[] winFreq = new int[26];

        for (int i = 0; i < pLen; i++) {
            //因为只有英文字符，所以可以用偏移量，总共且只有26个字符
            pFreq[pattern[i] - 'a']++;
        }
        //匹配串需要的字符数 去重的
        int pCount = 0;
        for (int i = 0; i < 26; i++) {
            if (pFreq[i] > 0) {
                pCount++;
            }
        }

        int left = 0;
        int right = 0;
        // 当滑动窗口中的字符的种类数与 s1 中对应相等的时候才计数
        int winCount = 0;
        while (right < tLen) {
            //当前的字符中有匹配串
            if (pFreq[text[right] - 'a'] > 0) {
                //窗口的字符计数加一
                winFreq[text[right] - 'a']++;
                //当滑动窗口中某个字符出现的频率与匹配串字符出现的频率相同则加1
                if (winFreq[text[right] - 'a'] == pFreq[text[right] - 'a']) {
                    winCount++;
                }
            }

            while (pCount == winCount) {
                if (right - left + 1 == pLen) {
                    return true;
                }
                //当窗口的种类数包含的匹配串的字符种类数，left指针需要向右移动，直到长度一致，这样能保证是连续的子串
                if (pFreq[text[left] - 'a'] > 0) {
                    winFreq[text[left] - 'a']--;
                    if (winFreq[text[left] - 'a'] < pFreq[text[left] - 'a']) {
                        winCount--;
                    }
                }
                left++;
            }
            right++;
        }
        return false;
    }

    public static void main(String[] args) {
        String s1 = "aa", s2 = "eidboaoo";
        boolean res = checkInclusion(s1, s2);
        System.out.println(res);
    }


    /**
     * @param s1
     * @param s2
     * @return s1是s2的子串，且长度相等
     */
    public boolean isSubString(String s1, String s2) {
        return true;
    }

    /**
     * 窗口s2包含s1的子串：s1的字符种类数等于win的字符种类数，且win的长度等于s1的长度
     * <p>
     * ex：s1 = "abc"   win = "abfcd"   统计s2的wincount=s1.length，win的字符个数与s1一致
     * 1.win的字符种类数与匹配串的字符种类数相同(wincount)
     * 2.win的长度和匹配串的长度相同
     *
     * @param s1
     * @param map
     * @return
     */
    public static boolean isSubString(String s1, Map<Character, Integer> map) {
        int[] book = new int[128];
        for (char ch : s1.toCharArray()) {
            book[ch - 'a']++;
        }
        for (int i = 0; i < book.length; i++) {
            char ch = (char) ('a' + i);
            if (book[i] > 0) {
                if (!map.containsKey(ch) || !map.get(ch).equals(book[i])) {
                    return false;
                }
            }
        }
        return true;
    }

}
