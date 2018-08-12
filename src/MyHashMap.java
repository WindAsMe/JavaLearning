import java.util.HashMap;
import java.util.Map;

/**
 * Author     : WindAsMe
 * File       : MyHashMap.java
 * Time       : Create on 18-8-12
 * Location   : ../Home/JavaForLeeCode2/MyHashMap.java
 * Function   :
 */
public class MyHashMap {

    Map<Integer, Integer> map;
    /** Initialize your data structure here. */
    public MyHashMap() {
        map = new HashMap<>();
    }

    /** value will always be positive. */
    public void put(int key, int value) {
        map.put(key, value);
    }

    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        return map.get(key) == null ? -1 : map.get(key);
    }

    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        map.remove(key);
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */
