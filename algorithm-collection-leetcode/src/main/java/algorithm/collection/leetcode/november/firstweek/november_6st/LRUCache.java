package algorithm.collection.leetcode.november.firstweek.november_6st;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

/**
 * @author shadow
 * @create 2024-11-06 21:00
 **/
public class LRUCache {

    private Deque<Integer> deque;
    private Map<Integer,Integer> map;
    private Integer capacity;

    public LRUCache(int capacity) {
        deque = new ArrayDeque<>();
        this.capacity = capacity;
        map = new HashMap<>();
    }

    public int get(int key) {
        if(!map.containsKey(key)) {
            return -1;
        }
        deque.remove(key);
        deque.offerLast(key);
        return map.get(key);
    }

    public void put(int key, int value) {
        Integer size = map.size();
        if(size >= capacity) {
            //最近未使用的key
            Integer key1 = deque.pollFirst();
            map.remove(key1);
        }
        map.put(key,value);
        deque.offerLast(key);
    }

}
