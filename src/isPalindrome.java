 /**
 * Author     : WindAsMe
 * File       : isPalindrome.java
 * Time       : Create on 18-6-11
 * Location   : ../Home/JavaForLeeCode2/isPalindrome.java
 * Function   :
 */
public class isPalindrome {

    private static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    private static boolean isPalindromeResult(ListNode head) {
        ListNode node = head;
        int length = 0;
        while (node != null) {
            length ++;
            node = node.next;
        }
        int mid = length / 2;
        int left = mid - ((length + 1) % 2);
        int right = mid;
        System.out.println("left:" + left + "  right:" + right);
        while (left > -1 && right < length + 1) {
            ListNode leftPointer = head;
            ListNode rightPointer = head;
            for (int i = 0 ; i < left ; i ++ ) {
                leftPointer = leftPointer.next;
                rightPointer = rightPointer.next;
            }
            for (int i = left ; i < right ; i ++ ) {
                rightPointer = rightPointer.next;
            }
            System.out.println("left node value:" + leftPointer.val + "  " + "right node value:" + rightPointer.val);
            if (leftPointer.val == rightPointer.val) {
                left --;
                right ++;
            } else {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(3);
        node.next.next.next = new ListNode(3);
        node.next.next.next.next = new ListNode(2);
        node.next.next.next.next.next = new ListNode(1);
        System.out.println(isPalindromeResult(node));

    }
}
