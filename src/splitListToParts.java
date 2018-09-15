import java.util.ArrayList;
import java.util.List;

/**
 * Author     : WindAsMe
 * File       : splitListToParts.java
 * Time       : Create on 18-9-15
 * Location   : ../Home/JavaForLeeCode2/splitListToParts.java
 * Function   : LeetCode No.725
 */
public class splitListToParts {

    private static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    private static ListNode[] splitListToPartsResult(ListNode root, int k) {
        ListNode[] ans = new ListNode[k];
        ListNode node = root;
        // index the ans
        int index = 0;
        int len;
        List<Integer> list = new ArrayList<>();
        while (node!= null) {
            list.add(node.val);
            node = node.next;
        }
        len = list.size();
        while (list.size() != 0) {
            ListNode temp = new ListNode(list.remove(0));
            int average = len / k;
            if (average * k < len)
                average++;
            while (average > 1) {
                temp.next = new ListNode(list.remove(0));
                temp = temp.next;
                average--;
            }
            ans[index] = temp;
            index++;
        }
        return ans;
    }

    public static void print(ListNode node) {
        while (node != null) {
            System.out.println(node.val + " ");
            node = node.next;
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
        node.next.next.next.next.next.next.next = new ListNode(8);
        node.next.next.next.next.next.next.next.next = new ListNode(9);
        node.next.next.next.next.next.next.next.next.next = new ListNode(10);
        ListNode[] ans = splitListToPartsResult(node,3);
        for (ListNode node1 : ans) {
            print(node1);
        }
    }
}
