/**
 * Author     : WindAsMe
 * File       : reverseKGroup.java
 * Time       : Create on 18-8-31
 * Location   : ../Home/JavaForLeeCode2/reverseKGroup.java
 * Function   : LeetCode No.25
 */
public class reverseKGroup {

    private static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    // If the space has no limitation:
    // Use the array, operate and attach
    private static ListNode reverseKGroupResult(ListNode head, int k) {
        int n = 0 ;
        ListNode temp = head ;
        ListNode previousHead = head ;
        while (temp != null) {
            n ++ ;
            temp = temp.next ;
        }
        if (k <= 1 || k > n)
            return head ;
        temp = head ;
        ListNode pre = head.next ;
        for ( int i = 1; i < k; i ++) {
            ListNode t = pre ;
            pre = pre.next ;
            t.next = temp ;
            temp = t ;
        }
        previousHead.next = reverseKGroupResult(pre, k) ;
        head = temp ;
        return head ;
    }

    public static void main(String[] args) {

    }
}
