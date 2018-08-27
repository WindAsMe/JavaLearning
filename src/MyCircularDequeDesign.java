import java.util.ArrayList;
import java.util.List;

/**
 * Author     : WindAsMe
 * File       : MyCircularDequeDesign.java
 * Time       : Create on 18-8-27
 * Location   : ../Home/JavaForLeeCode2/MyCircularDequeDesign.java
 * Function   : LeetCode No.641
 */
public class MyCircularDequeDesign {

    class MyCircularDeque {

        /** Initialize your data structure here. Set the size of the deque to be k. */
        private List<Integer> list;
        private int capacity;

        public MyCircularDeque(int k) {
            list = new ArrayList<>();
            capacity = k;
        }

        /** Adds an item at the front of Deque. Return true if the operation is successful. */
        public boolean insertFront(int value) {
            if (list.size() <= capacity - 1) {
                list.add(value);
                return true;
            } else
                return false;
        }

        /** Adds an item at the rear of Deque. Return true if the operation is successful. */
        public boolean insertLast(int value) {
            if (list.size() <= capacity - 1) {
                list.add(list.size() - 1, value);
                return true;
            } else
                return false;
        }

        /** Deletes an item from the front of Deque. Return true if the operation is successful. */
        public boolean deleteFront() {
            if (list.size() > 0) {
                list.remove(0);
                return true;
            } else
                return false;
        }

        /** Deletes an item from the rear of Deque. Return true if the operation is successful. */
        public boolean deleteLast() {
            if (list.size() > 0) {
                list.remove(list.size() - 1);
                return true;
            } else
                return false;
        }

        /** Get the front item from the deque. */
        public int getFront() {
            return list.remove(0);
        }

        /** Get the last item from the deque. */
        public int getRear() {
            return list.remove(list.size() - 1);
        }

        /** Checks whether the circular deque is empty or not. */
        public boolean isEmpty() {
            return list.size() == 0;
        }

        /** Checks whether the circular deque is full or not. */
        public boolean isFull() {
            return list.size() == capacity;
        }
    }

/**
 * Your MyCircularDeque object will be instantiated and called as such:
 * MyCircularDeque obj = new MyCircularDeque(k);
 * boolean param_1 = obj.insertFront(value);
 * boolean param_2 = obj.insertLast(value);
 * boolean param_3 = obj.deleteFront();
 * boolean param_4 = obj.deleteLast();
 * int param_5 = obj.getFront();
 * int param_6 = obj.getRear();
 * boolean param_7 = obj.isEmpty();
 * boolean param_8 = obj.isFull();
 */
}
