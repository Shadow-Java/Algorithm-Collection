package algorithm.collection.leetcode.november.secondweek.november_17st;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 2266. 统计打字方案数
 * Alice 在给 Bob 用手机打字。数字到字母的 对应 如下图所示。
 * 为了 打出 一个字母，Alice 需要 按 对应字母 i 次，i 是该字母在这个按键上所处的位置。
 *
 * 比方说，为了按出字母 's' ，Alice 需要按 '7' 四次。类似的， Alice 需要按 '5' 两次得到字母  'k' 。
 * 注意，数字 '0' 和 '1' 不映射到任何字母，所以 Alice 不 使用它们。
 * 但是，由于传输的错误，Bob 没有收到 Alice 打字的字母信息，反而收到了 按键的字符串信息 。
 *
 * 比方说，Alice 发出的信息为 "bob" ，Bob 将收到字符串 "2266622" 。
 * 给你一个字符串 pressedKeys ，表示 Bob 收到的字符串，请你返回 Alice 总共可能发出多少种文字信息 。
 *
 * 由于答案可能很大，将它对 109 + 7 取余 后返回
 *
 * 示例 1：
 *
 * 输入：pressedKeys = "22233"
 * 输出：8
 * 解释：
 * Alice 可能发出的文字信息包括：
 * "aaadd", "abdd", "badd", "cdd", "aaae", "abe", "bae" 和 "ce" 。
 * 由于总共有 8 种可能的信息，所以我们返回 8 。
 *
 * 示例 2：
 *
 * 输入：pressedKeys = "222222222222222222222222222222222222"
 * 输出：82876089
 * 解释：
 * 总共有 2082876103 种 Alice 可能发出的文字信息。
 * 由于我们需要将答案对 109 + 7 取余，所以我们返回 2082876103 % (109 + 7) = 82876089 。
 * @author shadow
 * @create 2025-02-12 22:34
 **/
public class CountTexts {

    public static void main(String[] args) {
        CountTexts countTexts = new CountTexts();
        System.out.println(countTexts.countTexts("22233"));
    }


    public static Map<String,String> dict = new HashMap<>();
    static {
        dict.put("0","");
        dict.put("1","");
        dict.put("2","abc");
        dict.put("3","def");
        dict.put("4","ghi");
        dict.put("5","jkl");
        dict.put("6","mno");
        dict.put("7","pqrs");
        dict.put("8","tuv");
        dict.put("9","wxyz");
    }
    int[] nums;
    public int countTexts(String pressedKeys) {
        nums = new int[pressedKeys.length()];
        Arrays.fill(nums, 1);
        for (int i = 1; i < pressedKeys.length(); i++) {
            if (pressedKeys.charAt(i) == pressedKeys.charAt(i - 1)) {
                nums[i] = nums[i-1]+1;
            }
        }
        return dfs(pressedKeys.length()-1,pressedKeys);
    }

    public int dfs(int i, String pressedKeys) {
        if (i <= 0) {
            return i == 0 ? 1 : 0;
        }
        String str = dict.get(String.valueOf(pressedKeys.charAt(i)));
        int count = 0;
        for (int j = 1; j <= str.length(); j++) {
            if (nums[i] >= j) {
                count = (count + dfs(i - j, pressedKeys)) % 1_000_000_007;
            }
        }
        return count;
    }

}
