package src;

import java.util.Arrays;

public class DesignHashMap {

    int[] hashmap;
    /** Initialize your data structure here. */
    public DesignHashMap() {
        hashmap = new int[1000001];
        Arrays.fill(hashmap,-1);
    }

    /** value will always be non-negative. */
    public void put(int key, int value) {
        hashmap[key] = value;
    }

    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        return hashmap[key];
    }

    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        hashmap[key] = -1;
    }

}
