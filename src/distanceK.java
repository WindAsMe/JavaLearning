import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Author     : WindAsMe
 * File       : distanceK.java
 * Time       : Create on 18-8-26
 * Location   : ../Home/JavaForLeeCode2/distanceK.java
 * Function   : LeetCode No.863
 */
public class distanceK {

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    private static List<Integer> distanceKResult(TreeNode root, TreeNode target, int K) {
        List<Integer> list = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        // if the node in left: dis is > 0
        // if the node in right: dis is < 0
        map.put(root.val, 0);
        format(root.left, map, 1, true);
        format(root.right, map, -1, false);
        System.out.println(map.toString());
        int dis = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getKey() == target.val) {
                dis = entry.getValue();
                break;
            }
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (Math.abs(entry.getValue() - dis) == K)
                list.add(entry.getKey());
        }
        return list;
    }

    private static void format(TreeNode node, Map<Integer, Integer> map, int dis, boolean left) {
        if (node != null) {
            if (left) {
                map.put(node.val, dis);
                format(node.left, map, dis + 1, true);
                format(node.right, map, dis + 1, true);
            } else {
                map.put(node.val, dis);
                format(node.left, map, dis - 1, false);
                format(node.right, map, dis - 1, false);
            }
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5);
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);
        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(4);

        root.right = new TreeNode(1);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(8);

        TreeNode target = new TreeNode(5);
        System.out.println(distanceKResult(root, target, 2));
    }
}
