/**
 * Author     : WindAsMe
 * File       : hasCycle.java
 * Time       : Create on 18-6-2
 * Location   : ../Home/JavaForLeeCode2/hasCycle.java
 * Function   : LeeCode No.141
 */
public class hasCycle {


    private static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    private static boolean hasCycleResult(ListNode head) {
        int count = 0;
        while (count < 9999){
            if (head == null){
                return false;
            } else {
                head = head.next;
                count += 1;
            }
        }
        return true;
    }
}
