/**
 * Author     : WindAsMe
 * File       : getIntersectionNode.java
 * Time       : Create on 18-6-3
 * Location   : ../Home/JavaForLeeCode2/getIntersectionNode.java
 * Function   : LeeCode No.160
 */
public class getIntersectionNode {

    private static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }

    }
    private static ListNode getIntersectionNodeResult(ListNode headA, ListNode headB) {
        int aLength = 0;
        int bLength = 0;
        ListNode tempA = headA;
        ListNode tempB = headB;
        while (tempA != null){
            aLength += 1;
            tempA = tempA.next;
        }
        while (tempB != null){
            bLength += 1;
            tempB = tempB.next;
        }
        System.out.println(aLength + "  " + bLength);
        tempA = headA;
        tempB = headB;
        if (aLength >= bLength){
            while (aLength != bLength){
                if (tempA == tempB){
                    return tempA;
                } else {
                    tempA = tempA.next;
                    aLength--;
                }
            }
        } else {
            while (aLength != bLength){
                if (tempA == tempB){
                    return tempA;
                } else {
                    tempB = tempB.next;
                    bLength--;
                }
            }
        }
        System.out.println(aLength + "  " + bLength);
        while (aLength != 0){
            if (tempA == tempB) {
                return tempA;
            } else {
                tempA = tempA.next;
                tempB = tempB.next;
                aLength -= 1;
            }
        }

        return null;
    }

    public static void main(String[] args){
        ListNode a = new ListNode(1);
        a.next = new ListNode(2);
        a.next.next = new ListNode(5);

        ListNode b = new ListNode(3);
        b.next = new ListNode(5);

        ListNode n = getIntersectionNodeResult(a, b);
        System.out.println(n.val);
    }
}
