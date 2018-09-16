import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Author     : WindAsMe
 * File       : findDuplicateSubtrees.java
 * Time       : Create on 18-9-16
 * Location   : ../Home/JavaForLeeCode2/findDuplicateSubtrees.java
 * Function   : LeetCode No.652
 */
public class findDuplicateSubtrees {

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    private static List<TreeNode> findDuplicateSubtreesResult(TreeNode root) {
        List<TreeNode> res = new ArrayList<>();
        create(root,new HashMap<>(),res);
        return res;

    }
    private static String create(TreeNode cur, Map<String,Integer> map, List<TreeNode> res){
        if (cur == null)
            return "#";
        String serial = cur.val + "," + create(cur.left, map, res) + create(cur.right, map, res);
        if(map.getOrDefault(serial, 0) == 1)
            res.add(cur);
        map.put(serial,map.getOrDefault(serial, 0) + 1);
        return serial;
    }


    private static void dfs(TreeNode node) {
        if (node != null) {
            System.out.print(node.val + " ");
            dfs(node.left);
            dfs(node.right);
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);

        root.right = new TreeNode(3);
        root.right.left = new TreeNode(2);
        root.right.right = new TreeNode(4);
        root.right.left.left = new TreeNode(4);

        List<TreeNode> list = findDuplicateSubtreesResult(root);
        System.out.println("size: " + list.size());
        for (TreeNode node : list) {
            dfs(node);
            System.out.println();
        }
    }
}
