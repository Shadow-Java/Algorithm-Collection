package algorithm.collection.leetcode.deprecated;

import java.util.*;

/**
 * O(1) 时间插入、删除和获取随机元素 - 允许重复
 * 设计一个支持在平均 时间复杂度 O(1) 下， 执行以下操作的数据结构。
 *
 * 注意: 允许出现重复元素。
 *
 * insert(val)：向集合中插入元素 val。
 * remove(val)：当 val 存在时，从集合中移除一个 val。
 * getRandom：从现有集合中随机获取一个元素。每个元素被返回的概率应该与其在集合中的数量呈线性相关。
 *
 * // 初始化一个空的集合。
 * RandomizedCollection collection = new RandomizedCollection();
 *
 * // 向集合中插入 1 。返回 true 表示集合不包含 1 。
 * collection.insert(1);
 *
 * // 向集合中插入另一个 1 。返回 false 表示集合包含 1 。集合现在包含 [1,1] 。
 * collection.insert(1);
 *
 * // 向集合中插入 2 ，返回 true 。集合现在包含 [1,1,2] 。
 * collection.insert(2);
 *
 * // getRandom 应当有 2/3 的概率返回 1 ，1/3 的概率返回 2 。
 * collection.getRandom();
 *
 * // 从集合中删除 1 ，返回 true 。集合现在包含 [1,2] 。
 * collection.remove(1);
 *
 * // getRandom 应有相同概率返回 1 和 2 。
 * collection.getRandom();
 *
 */
class RandomizedCollection {
    private List<Integer> value;
    private Map<Integer, Set<Integer>> set;//key为插入的值，set为id的集合

    /** Initialize your data structure here. */
    public RandomizedCollection() {
        value = new ArrayList<>();
        set = new HashMap<Integer,Set<Integer>>();
    }

    /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element.
     *list插入时是O(1)，但是需要遍历整个list判断是否存在，以此用hashmap存储字段的id，只需要将数字插入到最后
     *迷惑的点：该情况假想的是一开始都没有数据存储在集合里，即一开始就用自己定义的规则
     */
    public boolean insert(int val) {
        //将数字的id提取出来，插入到最后一位
        value.add(val);
        Set<Integer> ids = set.getOrDefault(val,new HashSet<Integer>()); //提取插入值的所有id
        ids.add(value.size()-1);//插入最后一位，记录id
        set.put(val,ids);//将提取的ids插入到原来的hashmap
        return ids.size()==1;//如果只插入一个说明之前不包含，大于2说明包含 true是包含
    }
    /**
     * getOrDefault(val,new HashSet<Integer>())  map中存在key就获取对应的value，不存在则ids为new HashSet<Integer>()
     */

    /** Removes a value from the collection. Returns true if the collection contained the specified element. */
    public boolean remove(int val) {
        if(!set.containsKey(val)){
            return false;
        }
        Iterator<Integer> it = set.get(val).iterator();
        int i = it.next();
        int lastNum = value.get(value.size() - 1);
        value.set(i, lastNum);
        set.get(val).remove(i);
        set.get(lastNum).remove(value.size() - 1);
        if (i < value.size() - 1) {
            set.get(lastNum).add(i);
        }
        if (set.get(val).size() == 0) {
            set.remove(val);
        }
        value.remove(value.size() - 1);
        return true;

    }

    /** Get a random element from the collection. */
    public int getRandom() {
        return value.get((int) (Math.random() * value.size()));//获取id的随机值
    }
}

/**
 * Your RandomizedCollection object will be instantiated and called as such:
 * RandomizedCollection obj = new RandomizedCollection();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */

