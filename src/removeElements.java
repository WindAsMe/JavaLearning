/**
 * Author     : WindAsMe
 * File       : removeElements.java
 * Time       : Create on 18-5-28
 * Location   : ../Home/JavaForLeeCode2/removeElements.java
 * Function   : LeeCode No.203
 */
public class removeElements {

    private static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    private static ListNode removeElementsResult(ListNode head, int val) {

        // Like Cpp pointer *
        ListNode point = head;

        // In iteration
        ListNode before = head;

        // Certain the start position
        ListNode start = head;

        // For exception
        if (head == null){
            return null;
        }
        if (head.next == null){
            if (head.val == val){
                return null;
            } else {
                return head;
            }
        }

        // Make the start position certain
        while (start.val == val ){
            if (start.next != null){
                point = start.next;
                start = start.next;
            } else {
                return null;
            }
        }

        // Head is in front of before
        head = head.next;
        while (head != null){
            if (head.val == val){
                before.next = head.next;
                head = head.next;
            } else {
                head = head.next;
                before = before.next;
            }
        }
        return point;
    }

    public static void main(String[] args){
        ListNode node = new ListNode(1);
        node.next = new ListNode(1);
        node.next = new ListNode(1);
        node.next.next = new ListNode(3);
//        node.next.next.next = new ListNode(1);
//        node.next.next.next.next = new ListNode(5);
//        node.next.next.next.next.next = new ListNode(3);

        ListNode result = removeElementsResult(node, 1);
        while (result != null){
            System.out.println(result.val);
            result = result.next;
        }
    }
}
