package algorithm.collection.leetcode.queue;

import algorithm.collection.common.datastruct.tag.AlgorithmCategory;
import algorithm.collection.common.datastruct.tag.DataStructType;
import algorithm.collection.common.datastruct.tag.DifficultyLevel;
import algorithm.collection.common.datastruct.tag.MethodTag;
import algorithm.collection.common.datastruct.tag.QuestionTag;
import algorithm.collection.common.datastruct.tag.TimeComplexity;
import algorithm.collection.primary.tree.DeepWidthSearch;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * s 的 旋转操作 就是将 s 最左边的字符移动到最右边；
 * 例如, 若 s = 'abcde'，在旋转一次之后结果就是'bcdea'
 *
 * 输入: s = "abcde", goal = "cdeab"
 * 输出: true
 *
 * 输入: s = "abcde", goal = "abced"
 * 输出: false
 *
 * @author shadow
 * @create 2023-06-14 06:22
 **/
@QuestionTag(
        difficultyLeve = DifficultyLevel.EASY,
        questionNumber = "796",
        questionTitle = "旋转字符串",
        relevateClass = DeepWidthSearch.class,
        desc = "给定两个字符串, s和goal。如果在若干次旋转操作之后，s能变成goal，那么返回true。",
        questionLink = "https://leetcode.cn/problems/rotate-string/",
        timeComplexity = TimeComplexity.O_N,
        dataStructTypes = {DataStructType.UNIVERSAL_QUEUE}
)
public class RotateString {

    @MethodTag(
            questionNumber = "796",
            methodLink = "https://leetcode.cn/problems/rotate-string/",
            timeComplexity = TimeComplexity.O_N,
            dataStructType = DataStructType.ARRAY_LIST,
            algorithmCategory = AlgorithmCategory.BINARY_FIND
    )
    public static boolean rotateString(String s, String goal) {
        //如果长度不等则false
        if(s.length() != goal.length()){
            return false;
        }
        //使用双端队列，因为是旋转string，依次通过count入队尾，然后加入队头
        Deque<Character> characters = new ArrayDeque<>();
        for (char c : s.toCharArray()){
            characters.add(c);
        }
        int count = s.length();
        while (!characters.isEmpty() && count > 0){
            //将当前字符数组组合成一个string
            StringBuilder stringBuilder = new StringBuilder();
            for (Character c : characters) {
                stringBuilder.append(c);
            }
            String curStr = stringBuilder.toString();
            if(curStr.equals(goal)){
                return true;
            }
            //出对头 入队尾
            char headCh = characters.pollFirst();
            characters.add(headCh);
            //总共旋转次数为string的长度
            count--;
        }
        return false;
    }


    @MethodTag(
            questionNumber = "796",
            methodLink = "https://leetcode.cn/problems/rotate-string/solution/by-ac_oier-bnkx/",
            timeComplexity = TimeComplexity.O_N,
            dataStructType = DataStructType.ARRAY_LIST,
            algorithmCategory = AlgorithmCategory.BINARY_FIND
    )
    public boolean rotateStringAnotherWay(String s, String goal) {
        /**
         * 由于每次旋转操作都是将最左侧字符移动到最右侧，因此如果 goal 可由 s 经过多步旋转而来，
         * 那么 goal 必然会出现在 s + s 中，即满足 (s + s).contains(goal)，同时为了 s 本身过长导致的结果成立，我们需要先确保两字符串长度相等
         */
        return s.length() == goal.length() && (s + s).contains(goal);
    }

    public static void main(String[] args) {
        System.out.println(rotateString("abcde","bcdea"));
    }

}
