import java.util.ArrayList;
import java.util.List;

/**
 * Author     : WindAsMe
 * File       : maxDepth.java
 * Time       : Create on 18-8-8
 * Location   : ../Home/JavaForLeeCode2/maxDepth.java
 * Function   : LeetCode No.559
 */
public class maxDepth {

    private static class Node {
        public int val;
        public List<Node> children;
        public Node() {}
        public Node(int _val,List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    private static int maxDepthResult(Node root) {
        if (root == null)
            return 0;
        if (root.children == null)
            return 1;
        // depth[0]: max depth
        int[] depth = new int[1];
        for (Node node : root.children)
            dfs(node, 1, depth);
        return depth[0];
    }


    private static void dfs(Node node, int cur, int[] depth) {
        if (node != null) {
            cur++;
            depth[0] = Math.max(cur, depth[0]);
            if (node.children != null) {
                for (Node temp : node.children)
                    dfs(temp, cur, depth);
            }
        }
    }

    public static void main(String[] args) {
        List<Node> list1 = new ArrayList<>();
        List<Node> list2 = new ArrayList<>();

        Node node4 = new Node(5, null);
        Node node5 = new Node(6, null);
        list2.add(node4);
        list2.add(node5);

        Node node1 = new Node(3, list2);
        Node node2 = new Node(2, null);
        Node node3 = new Node(4, null);
        list1.add(node1);
        list1.add(node2);
        list1.add(node3);

        Node root = new Node(1, list1);

        System.out.println(maxDepthResult(root));
    }
}
