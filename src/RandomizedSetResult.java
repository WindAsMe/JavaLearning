import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Author     : WindAsMe
 * File       : RandomizedSetResult.java
 * Time       : Create on 18-9-7
 * Location   : ../Home/JavaForLeeCode2/RandomizedSetResult.java
 * Function   :
 */
public class RandomizedSetResult {

    static class RandomizedSet {

        private Set<Integer> set;
        private List<Integer> list;

        /** Initialize your data structure here. */
        public RandomizedSet() {
            set = new HashSet<>();
            list = new ArrayList<>();
        }

        /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
        public boolean insert(int val) {
            if (set.contains(val))
                return false;
            else {
                set.add(val);
                list.add(val);
                return true;
            }
        }

        /** Removes a value from the set. Returns true if the set contained the specified element. */
        public boolean remove(int val) {
            if (set.contains(val)) {
                list.remove(Integer.valueOf(val));
                set.remove(val);
                return true;
            } else
                return false;
        }

        /** Get a random element from the set. */
        public int getRandom() {
            return list.get((int)(Math.random() * list.size()));
        }
    }

    public static void main(String[] args) {
        RandomizedSet set = new RandomizedSet();
        System.out.println(set.insert(1));
        System.out.println(set.remove(2));
        System.out.println(set.insert(2));
        System.out.println(set.getRandom());
        System.out.println(set.remove(1));
        System.out.println(set.insert(2));
        System.out.println(set.getRandom());
    }
}
