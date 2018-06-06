import java.util.ArrayList;
import java.util.List;

/**
 * Author     : WindAsMe
 * File       : reverseList.java
 * Time       : Create on 18-6-4
 * Location   : ../Home/JavaForLeeCode2/reverseList.java
 * Function   : LeeCode No.
 */
public class reverseList {


    private static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    private static ListNode reverseListResult(ListNode head) {
        if (head == null) {
            return null;
        } else {
            List<Integer> list = new ArrayList<>();
            while (head != null) {
                list.add(head.val);
                head = head.next;
            }

            ListNode node = new ListNode(list.get(list.size() - 1));
            ListNode result = node;
            for (int i = list.size() - 2 ; i >= 0 ; i -- ) {
                node.next = new ListNode(list.get(i));
                node = node.next;
            }
            return result;
        }
    }


    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(3);
        node.next.next.next = new ListNode(4);
        node.next.next.next.next = new ListNode(5);
        node.next.next.next.next.next = new ListNode(6);
        node.next.next.next.next.next.next = new ListNode(7);

        ListNode result = reverseListResult(node);
        while (result != null) {
            System.out.println(result.val + " ");
            result = result.next;
        }

    }
}