import java.util.*;

/**
 * Author     : WindAsMe
 * File       : findFrequentTreeSum.java
 * Time       : Create on 18-8-7
 * Location   : ../Home/JavaForLeeCode2/findFrequentTreeSum.java
 * Function   : LeetCode No.508
 */
public class findFrequentTreeSum {

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    private static int[] findFrequentTreeSumResult(TreeNode root) {
        if (root == null)
            return new int[0];
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        dfs(root, map);
        int occur = 0;
        for (Map.Entry<Integer, Integer> temp : map.entrySet())
            occur = temp.getValue() > occur ? temp.getValue() : occur;
        for (Map.Entry<Integer, Integer> temp : map.entrySet()) {
            if (temp.getValue() == occur)
                list.add(temp.getKey());
        }
        int[] ans = new int[list.size()];
        for (int i = 0; i < list.size(); i++)
            ans[i] = list.get(i);
        return ans;
    }

    private static void dfs(TreeNode node, Map<Integer, Integer> map) {
        if (node != null) {
            int[] sum = new int[1];
            account(node, sum);
            map.merge(sum[0], 1, (a, b) -> a + b);
            dfs(node.left, map);
            dfs(node.right, map);
        }
    }

    private static void account(TreeNode node, int[] sum) {
        if (node != null) {
            sum[0] += node.val;
            account(node.left, sum);
            account(node.right, sum);
        }
    }

    public static void main(String[] args) {
        TreeNode node = new TreeNode(5);
        node.left = new TreeNode(2);
        node.right = new TreeNode(-5);
        System.out.println(Arrays.toString(findFrequentTreeSumResult(node)));
    }
}
