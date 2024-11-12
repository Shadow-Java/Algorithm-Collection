package algorithm.collection.leetcode.november.secondweek.november_11st;

import java.util.ArrayList;
import java.util.List;

/**
 * 17. 电话号码的字母组合
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
 *
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 *
 * 输入：digits = "23"
 * 输出：["ad","ae","af","bd","be","bf","cd","ce","cf"]
 *
 * 输入：digits = ""
 * 输出：[]
 *
 * 输入：digits = "2"
 * 输出：["a","b","c"]
 *
 * @author shadow
 * @create 2024-11-11 22:44
 **/
public class LetterCombinations {

    private String letterMap[] = {
            " ",    //0
            "",     //1
            "abc",  //2
            "def",  //3
            "ghi",  //4
            "jkl",  //5
            "mno",  //6
            "pqrs", //7
            "tuv",  //8
            "wxyz"  //9
    };

    private ArrayList<String> res;

    /**
     * 怎么想象成二叉树结构，两个数字组合，那么其中一个数字的所有字母为父节点，另一个数字的所有字母为子节点
     * @param digits
     * @return
     */
    public List<String> letterCombinations(String digits) {

        res = new ArrayList<String>();
        if(digits.equals(""))
            return res;
        //选择第一个数字
        findCombination(digits, 0, "");
        return res;
    }

    private void findCombination(String digits, int index, String s){
        //index指的是树的深度
        if(index == digits.length()){
            res.add(s);
            return;
        }
        //选择第i个数字
        Character c = digits.charAt(index);
        //当前index对应的子节点数，比如当点的数字2 = ‘abc’
        String letters = letterMap[c - '0'];
        for(int i = 0 ; i < letters.length() ; i ++) {//每个数字都有letters.length()种情况
            findCombination(digits, index+1, s + letters.charAt(i));
        }
    }


}
