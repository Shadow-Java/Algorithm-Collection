package algorithm.collection.leetcode.tree.binarysearch;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Objects;

/**
 * 序列化二叉树的一种方法是使用 前序遍历 。当我们遇到一个非空节点时，我们可以记录下这个节点的值。如果它是一个空节点，我们可以使用一个标记值记录，例如 #。
 * 例如，上面的二叉树可以被序列化为字符串 "9,3,4,#,#,1,#,#,2,#,6,#,#"，其中 # 代表一个空节点。
 *
 * 给定一串以逗号分隔的序列，验证它是否是正确的二叉树的前序序列化。编写一个在不重构树的条件下的可行算法。
 *
 * 保证 每个以逗号分隔的字符或为一个整数或为一个表示 null 指针的 '#' 。
 *
 * 你可以认为输入格式总是有效的
 *
 * 例如它永远不会包含两个连续的逗号，比如 "1,,3" 。
 * @author shadow
 * @create 2023-10-14 20:04
 **/
public class VerifyPreorderSerializationBinaryTree {

    /**
     * 类似消消乐的做法，将叶子节点（即4 # #为叶子节点）替换为空节点（#）
     * @param preorder
     * @return
     */
    public boolean isValidSerialization(String preorder) {
        //根据逗号隔开的前序遍历序列
        String[] sequences = preorder.split(",");
        Deque<String> stack = new ArrayDeque<>();
        boolean count2 = false;//表示栈内#的个数
        for (String node:sequences) {
            if("#".equals(node) && "#".equals(stack.peek())) {
                count2 = true;
            }
            stack.push(node);
            /**
             * ToDo 需要判断第三个节点不为#
             */
            while (stack.size() >=3 && count2){
                stack.pop();
                stack.pop();
                stack.pop();
                stack.push("#");
                count2 = false;
            }
        }
        return stack.size() == 1 && Objects.equals(stack.pop(), "#");
    }

    public boolean otherWay(String preorder) {
        int edge = 1;
        for(String token : preorder.split(",")){
            edge--;
            if(edge < 0) return false;
            if(!token.equals("#")) {
                edge += 2;
            }
        }
        return edge == 0;
    }

}
