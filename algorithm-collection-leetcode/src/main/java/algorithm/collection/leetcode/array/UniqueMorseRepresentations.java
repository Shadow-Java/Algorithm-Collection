package algorithm.collection.leetcode.array;

import algorithm.collection.common.datastruct.tag.AlgorithmCategory;
import algorithm.collection.common.datastruct.tag.DataStructType;
import algorithm.collection.common.datastruct.tag.DifficultyLevel;
import algorithm.collection.common.datastruct.tag.MethodTag;
import algorithm.collection.common.datastruct.tag.QuestionTag;
import algorithm.collection.common.datastruct.tag.TimeComplexity;
import algorithm.collection.primary.tree.DeepWidthSearch;

import java.util.HashSet;
import java.util.Set;

/**
 * 国际摩尔斯密码定义一种标准编码方式，将每个字母对应于一个由一系列点和短线组成的字符串， 比如:
 * <p>
 * 'a' 对应 ".-" ，
 * 'b' 对应 "-..." ，
 * 'c' 对应 "-.-." ，以此类推。
 * 为了方便，所有 26 个英文字母的摩尔斯密码表如下：
 * <p>
 * [".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."]
 * 给你一个字符串数组 words ，每个单词可以写成每个字母对应摩尔斯密码的组合。
 * <p>
 * 例如，"cab" 可以写成 "-.-..--..." ，(即 "-.-." + ".-" + "-..." 字符串的结合)。我们将这样一个连接过程称作 单词翻译 。
 * 对 words 中所有单词进行单词翻译，返回不同 单词翻译 的数量。
 * <p>
 * 输入: words = ["gin", "zen", "gig", "msg"]
 * 输出: 2
 * 解释:
 * 各单词翻译如下:
 * "gin" -> "--...-."
 * "zen" -> "--...-."
 * "gig" -> "--...--."
 * "msg" -> "--...--."
 * <p>
 * 共有 2 种不同翻译, "--...-." 和 "--...--.".
 * <p>
 * 输入：words = ["a"]
 * 输出：1
 *
 * @author shadow
 * @create 2023-06-14 06:59
 **/
@QuestionTag(
        difficultyLeve = DifficultyLevel.MEDIUM,
        questionNumber = "804",
        questionTitle = "唯一摩尔斯密码词",
        relevateClass = DeepWidthSearch.class,
        desc = "国际摩尔斯密码定义一种标准编码方式，将每个字母对应于一个由一系列点和短线组成的字符串",
        questionLink = "https://leetcode.cn/problems/unique-morse-code-words/",
        timeComplexity = TimeComplexity.O_N_2,
        dataStructTypes = {DataStructType.ARRAY_LIST}
)
public class UniqueMorseRepresentations {

    @MethodTag(
            questionNumber = "804",
            methodLink = "https://leetcode.cn/problems/unique-morse-code-words/",
            timeComplexity = TimeComplexity.O_N,
            dataStructType = DataStructType.ARRAY_LIST,
            algorithmCategory = AlgorithmCategory.VIOLENCE
    )
    public int uniqueMorseRepresentations(String[] words) {
        String[] words_translat = {".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--.."};
        //返回不同单词翻译的数量
        Set<String> hashset = new HashSet<String>();
        for (int i = 0; i < words.length; i++) {
            String word = "";
            for (int j = 0; j < words[i].length(); j++) {
                int index = words[i].charAt(j) - 97;//如果不知道ASCii值，用words[i].charAt(j) - 'a'
                word += words_translat[index];
            }
            hashset.add(word);
        }
        return hashset.size();
    }

}
