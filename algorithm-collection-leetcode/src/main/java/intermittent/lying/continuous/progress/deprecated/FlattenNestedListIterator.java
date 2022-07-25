package intermittent.lying.continuous.progress.deprecated;


import Intermittent.lying.continuous.progress.common.interfaces.NestedInteger;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * 扁平化嵌套列表迭代器
 * 给你一个嵌套的整型列表。请你设计一个迭代器，使其能够遍历这个整型列表中的所有整数。
 *
 * 列表中的每一项或者为一个整数，或者是另一个列表。其中列表的元素也可能是整数或是其他列表。
 *
 * 输入: [[1,1],2,[1,1]]
 * 输出: [1,1,2,1,1]
 * 解释: 通过重复调用 next 直到 hasNext 返回 false，next 返回的元素的顺序应该是: [1,1,2,1,1]。
 *
 */
public class FlattenNestedListIterator  implements Iterator<Integer>{
    private LinkedList<Integer> ans;

    /**
     * 本题定义了一个类 NestedInteger ，这个类可以存储 int  或 List<NestedInteger> ；所以称它是一个「嵌套列表」。类似于一棵多叉树，每个节点都可以有很多子节点。
     *
     * @param nestedList
     */
    public FlattenNestedListIterator(List<NestedInteger> nestedList) {
        ans = new LinkedList<>();
        DFS(nestedList);
    }

    @Override
    public Integer next() {
        return ans.removeFirst();
    }

    @Override
    public boolean hasNext() {
        return !ans.isEmpty();
    }

    public void DFS(List<NestedInteger> nestedList){
        for(NestedInteger n : nestedList){
            if(n.isInteger()){
                ans.addLast(n.getInteger());
            }else{
                DFS(n.getList());
            }
        }
    }

}


