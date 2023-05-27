package algorithm.collection.leetcode.slidingwindow;

import algorithm.collection.common.datastruct.tag.AlgorithmCategory;
import algorithm.collection.common.datastruct.tag.DataStructType;
import algorithm.collection.common.datastruct.tag.DifficultyLevel;
import algorithm.collection.common.datastruct.tag.QuestionTag;
import algorithm.collection.common.datastruct.tag.TimeComplexity;

/**
 * 76. 最小覆盖子串
 *
 * 如果一个数组问题可以用动态规划解，但又可以使用滑动窗口解决，那么往往滑动窗口的效率更高。<br/>
 * 滑动窗口使用双指针解决问题，所以一般也叫双指针算法，因为两个指针间形成一个窗口
 *
 * 什么情况适合用双指针呢？一般双指针是暴力算法的优化版，所以：
 * 如果题目较为简单，且是数组或链表问题，往往可以尝试双指针是否可解。
 * 如果数组存在规律，可以尝试双指针。
 * 如果链表问题限制较多，比如要求 O(1) 空间复杂度解决，也许只有双指针可解。
 * 也就是说，当一个问题比较有规律，或者较为简单，或较为巧妙时，可以尝试双指针（滑动窗口）解法。
 * @author shadow
 * @create 2023-05-18 00:42
 **/
@QuestionTag(
        difficultyLeve = DifficultyLevel.EASY,
        questionNumber = "76",
        questionTitle = "最小覆盖子串",
        questionLink = "https://leetcode.cn/problems/minimum-window-substring/",
        algorithmCategory = AlgorithmCategory.DEPTH_FIRST_SEARCH,
        timeComplexity = TimeComplexity.O_N
        )
public class MinimumWindowSubstring {

}
