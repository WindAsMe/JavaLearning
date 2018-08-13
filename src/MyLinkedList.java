import java.util.ArrayList;
import java.util.List;

/**
 * Author     : WindAsMe
 * File       : MyLinkedList.java
 * Time       : Create on 18-8-13
 * Location   : ../Home/JavaForLeeCode2/MyLinkedList.java
 * Function   : LeetCode No.707
 */
public class MyLinkedList {

    /**
     * Your MyLinkedList object will be instantiated and called as such:
     * MyLinkedList obj = new MyLinkedList();
     * int param_1 = obj.get(index);
     * obj.addAtHead(val);
     * obj.addAtTail(val);
     * obj.addAtIndex(index,val);
     * obj.deleteAtIndex(index);
     */
    static class Solution {

        /**
         * Initialize your data structure here.
         */
        private List<Integer> list;

        public Solution() {
            list = new ArrayList<>();
        }

        /**
         * Get the value of the index-th node in the linked list. If the index is invalid, return -1.
         */
        public int get(int index) {
            return list.get(index) == null ? -1 :  list.get(index);
        }

        /**
         * Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list.
         */
        public void addAtHead(int val) {
            list.add(0, val);
        }

        /**
         * Append a node of value val to the last element of the linked list.
         */
        public void addAtTail(int val) {
            list.add(val);
        }

        /**
         * Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted.
         */
        public void addAtIndex(int index, int val) {
            list.add(index, val);
        }

        /**
         * Delete the index-th node in the linked list, if the index is valid.
         */
        public void deleteAtIndex(int index) {
            if (index < list.size())
                list.remove(index);
        }
    }

    public static void main(String[] args) {
        Solution linkedList = new Solution();
        linkedList.addAtHead(1);
        System.out.println(linkedList.list.toString());
        linkedList.addAtTail(3);
        System.out.println(linkedList.list.toString());
        linkedList.addAtIndex(1,2);   //链表变为1-> 2-> 3
        System.out.println(linkedList.list.toString());
        System.out.println(linkedList.get(1));            //返回2
        linkedList.deleteAtIndex(1);  //现在链表是1-> 3
        System.out.println(linkedList.list.toString());
        System.out.println(linkedList.get(1));            //返回3
    }
}

