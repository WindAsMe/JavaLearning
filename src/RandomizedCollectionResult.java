import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Author     : WindAsMe
 * File       : RandomizedCollectionResult.java
 * Time       : Create on 18-9-9
 * Location   : ../Home/JavaForLeeCode2/RandomizedCollectionResult.java
 * Function   : LeetCode No.381
 */
public class RandomizedCollectionResult {

    static class RandomizedCollection {

        private Set<Integer> set;
        private Map<Integer, Integer> map;
        private int count;
        /** Initialize your data structure here. */
        public RandomizedCollection() {
            set = new HashSet<>();
            map = new HashMap<>();
        }

        /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
        public boolean insert(int val) {
            if (set.contains(val)) {
                map.put(val, map.get(val) + 1);
                count++;
                return false;
            } else {
                set.add(val);
                map.put(val, 1);
                count++;
                return true;
            }
        }

        /** Removes a value from the collection. Returns true if the collection contained the specified element. */
        public boolean remove(int val) {
            if (map.get(val) == null)
                return false;
            else if (map.get(val) == 1) {
                map.remove(val);
                set.remove(val);
                count--;
                return true;
            } else {
                map.put(val, map.get(val) - 1);
                count--;
                return true;
            }
        }

        /** Get a random element from the collection. */
        public int getRandom() {
            int ran = (int) (Math.random() * count);
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                ran = ran - entry.getValue();
                if (ran <= 0)
                    return entry.getKey();
            }
            return 1;
        }
    }

    public static void main(String[] args) {
        RandomizedCollection set = new RandomizedCollection();
        System.out.println(set.insert(1));
        System.out.println(set.insert(1));
        System.out.println(set.insert(2));
        System.out.println(set.getRandom());
        System.out.println(set.remove(1));
        System.out.println(set.getRandom());
    }

}
