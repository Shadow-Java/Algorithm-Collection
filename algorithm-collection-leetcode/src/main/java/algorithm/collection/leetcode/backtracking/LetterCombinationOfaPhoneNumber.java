package algorithm.collection.leetcode.backtracking;

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
 * TODO 17
 * @author shadow
 * @create 2023-05-18 00:25
 **/
@QuestionTag(
        difficultyLeve = DifficultyLevel.MEDIUM,
        questionNumber = "17",
        questionTitle = "电话号码的字母组合",
        desc = "给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回",
        questionLink = "https://leetcode.cn/problems/letter-combinations-of-a-phone-number/description/",
        algorithmCategory = AlgorithmCategory.DEPTH_FIRST_SEARCH,
        dataStructTypes = {DataStructType.ARRAY_LIST}
)
public class LetterCombinationOfaPhoneNumber {

    @MethodTag(
            questionNumber = "17",
            methodLink = "https://leetcode.cn/problems/letter-combinations-of-a-phone-number/description/",
            dataStructType = DataStructType.ARRAY_LIST,
            algorithmCategory = AlgorithmCategory.DEPTH_FIRST_SEARCH
    )
    public List<String> letterCombinations(String digits) {
        //定义一个返回的结果集
        List<String> res = new ArrayList<>();
        //如果字符串为空，直接返回
        if(digits.length() == 0){
            return res;
        }
        //定义一个集合表示字符串的所有可能
        Map<Character,String> map = new HashMap<>(){{
            put('2',"abc");
            put('3',"def");
            put('4',"ghi");
            put('5',"jkl");
            put('6',"mno");
            put('7',"pqrs");
            put('8',"tuv");
            put('9',"wxyz");
        }};
        //定义一个存储路径的可变字符的变量
        StringBuilder path = new StringBuilder();
        //递归
        dfs(path,map,digits,0,res);
        return res;
    }
    public void dfs(StringBuilder path, Map<Character,String> map, String digits, int dept, List<String> res){
        //当递归到底层的时候，将路径上的参数加入结果集中
        if(dept == digits.length()){
            res.add(path.toString());
        }else{
            //定义一个存储字符串的数字
            char digit = digits.charAt(dept);
            //定义一个存储数字对应的所有可能字符串
            String str = map.get(digit);
            //定义一个表示字符串长度
            int len = str.length();
            //遍历字符串
            for(int i = 0; i< len; i++){
                //将字符添加进路径结果中
                path.append(str.charAt(i));
                //递归
                dfs(path, map,digits,dept+1,res);
                //剪枝
                path.deleteCharAt(dept);
            }
        }

    }

}
