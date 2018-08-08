import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Author     : WindAsMe
 * File       : PeekingIterator.java
 * Time       : Create on 18-8-8
 * Location   : ../Home/JavaForLeeCode2/PeekingIterator.java
 * Function   : LeetCode No.284
 */

// Java Iterator interface reference:
// https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html

class PeekingIterator implements Iterator<Integer> {

    private List<Integer> list;
    public PeekingIterator(Iterator<Integer> iterator) {
        // initialize any member here.
        list = new ArrayList<>();
    }

    // Returns the next element in the iteration without advancing the iterator.
    public Integer peek() {
        if (list.size() != 0)
            return list.get(0);
        return null;
    }

    // hasNext() and next() should behave the same as in the Iterator interface.
    // Override them if needed.
    @Override
    public Integer next() {
        if (list.size() != 0) {
            Integer ans = list.get(0);
            list.remove(0);
            return ans;
        }
        return null;
    }

    @Override
    public boolean hasNext() {
        return list.size() != 0;
    }
}