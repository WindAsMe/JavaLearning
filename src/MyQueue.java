import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Author     : WindAsMe
 * File       : MyQueue.java
 * Time       : Create on 18-6-7
 * Location   : ../Home/JavaForLeeCode2/MyQueue.java
 * Function   : LeeCode No.232
 */
public class MyQueue {

    private Deque<Integer> deque;
    /** Initialize your data structure here. */
    public MyQueue() {
        deque = new ArrayDeque<>();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        deque.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        return deque.pollLast();
    }

    /** Get the front element. */
    public int peek() {
        return deque.getLast();
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return deque.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */

