import java.util.ArrayList;
import java.util.List;

/**
 * Author     : WindAsMe
 * File       : MinStack.java
 * Time       : Create on 18-6-2
 * Location   : ../Home/JavaForLeeCode2/MinStack.java
 * Function   : LeeCode No.155
 */
public class MinStack {

    private List<Integer> list;
    /** initialize your data structure here. */
    public MinStack() {
        list = new ArrayList<>();
    }

    public void push(int x) {
        list.add(x);
    }

    public void pop() {
        list.remove(list.size() - 1);
    }

    public int top() {
        return list.get(list.size() - 1);
    }

    public int getMin() {
        int i = 0;
        int small = list.get(0);
        while (i < list.size()){
            small = (list.get(i) < small) ? list.get(i) : small;
            i ++ ;
        }
        return small;
    }

    public static void main(String[] args){
        MinStack stack = new MinStack();
        stack.push(1);
        stack.push(2);
        stack.push(4);
        System.out.println(stack.getMin());
        System.out.println(stack.top());
        stack.pop();
        System.out.println(stack.top());
    }

}
