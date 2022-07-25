package intermittent.lying.continuous.progress.deprecated;

/**
 * 题目：不使用任何内建的哈希表库设计一个哈希集合（HashSet）
 * 题解：set集合就是没有重复值，会自动去重
 * 定义一个Boolean数组，下标为key值，add则为true，remove则为false
 */
public class DesignHashSet {
    boolean[] node = new boolean[1000009];

    /** Initialize your data structure here. */
    public DesignHashSet() {

    }

    public void add(int key) {
        node[key] = true;
    }

    public void remove(int key) {
        node[key] = false;
    }

    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        if(node[key] == true){
            return true;
        }
        return false;
    }
}
