package algorithm.collection.leetcode.slidingwindow;


import algorithm.collection.common.datastruct.tag.DifficultyLevel;
import algorithm.collection.common.datastruct.tag.QuestionTag;
import org.junit.Test;


/**
 * 输入: s = "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 *
 * 输入: s = "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 *
 * s 由英文字母、数字、符号和空格组成
 */
@QuestionTag(
        difficultyLeve = DifficultyLevel.MEDIUM,
        questionNumber = "3",
        questionTitle = "无重复字符的最长子串",
        relevateClass = LongestSubstring.class
)
class LongestSubstringTest {


    @Test
    public void testLengthOfLongestSubstring(){
        String s = "bbbbb";
        System.out.println(lengthOfLongestSubstring(s));
    }

    public static void main(String[] args) {
        String s = "bbbbb";
        System.out.println(lengthOfLongestSubstring(s));
    }

    /**
     * ASCII表包含字符、数字、小写字母和大写字母
     * @param s
     * @return
     */
    public static int lengthOfLongestSubstring(String s){
        /**
         * 窗口的字符数
         */
        if("".equals(s)){
            return 0;
        }
        int[] book = new int[128];
        int left = 0,right = 0;
        int maxSize = Integer.MIN_VALUE;
        while (right < s.length()){
            char ch = s.charAt(right);
            book[ch]++;
            /**
             * 当窗口满足条件时，更新长度，并移动left直到不满足条件为止
             */
            while (existRepeatChar(book)){
                maxSize = Math.max(maxSize,right-left);
                book = new int[128];
                book[s.charAt(right)]++;
                left = right;
            }
            right++;
        }
        return maxSize == Integer.MIN_VALUE ? 0:maxSize;
    }

    /**
     * 窗口是否存在重复字符
     *
     * @param book
     * @return
     */
    public static boolean existRepeatChar(int[] book){
        for (int count: book) {
            if(count > 1){
                return true;
            }
        }
        return false;
    }

}