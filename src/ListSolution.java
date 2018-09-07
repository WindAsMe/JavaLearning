/**
 * Author     : WindAsMe
 * File       : ListSolution.java
 * Time       : Create on 18-9-7
 * Location   : ../Home/JavaForLeeCode2/ListSolution.java
 * Function   : LeetCode No.382
 */
public class ListSolution {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    static class Solution {

        /** @param head The linked list's head.
        Note that the head is guaranteed to be not null, so it contains at least one node. */
        private ListNode head;
        private int length;

        public Solution(ListNode head) {
            ListNode node = head;
            int len = 0;
            while (node != null) {
                len++;
                node = node.next;
            }
            this.length = len;
            this.head = head;
        }

        /** Returns a random node's value. */
        public int getRandom() {
            ListNode node = head;
            int ran = (int)(Math.random() * length);
            while (ran != 0) {
                node = node.next;
                ran--;
            }
            return node.val;
        }
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        Solution s = new Solution(head);
        System.out.println(s.getRandom());
    }

}
