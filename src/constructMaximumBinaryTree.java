/**
 * Author     : WindAsMe
 * File       : constructMaximumBinaryTree.java
 * Time       : Create on 18-8-28
 * Location   : ../Home/JavaForLeeCode2/constructMaximumBinaryTree.java
 * Function   :
 */
public class constructMaximumBinaryTree {

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    private static TreeNode constructMaximumBinaryTreeResult(int[] nums) {
        int max = -1;
        int index = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > max) {
                max = nums[i];
                index = i;
            }
        }
        TreeNode root = new TreeNode(max);
        originate(0, index, nums, root.left);
        originate(index + 1, nums.length, nums, root.right);
        return root;
    }

    // In recursion to originate
    private static void originate(int start, int end, int[] nums, TreeNode node) {
        if (end <= start)
            return;
        if (end - start == 1) {
            node = new TreeNode(nums[start]);
            return;
        }
        int max = -1;
        int index = -1;
        for (int i = start; i < end; i++) {
            if (nums[i] > max) {
                max = nums[i];
                index = i;
            }
        }
        node = new TreeNode(max);
        originate(start, index, nums, node.left);
        originate(index + 1, end, nums, node.right);
    }

    private static void dfs(TreeNode node) {
        if (node != null) {
            System.out.print(node.val + " ");
            dfs(node.left);
            dfs(node.right);
        }
    }

    public static void main(String[] args) {
        int[] tree = {3,2,1,6,0,5};
        dfs(constructMaximumBinaryTreeResult(tree));
    }

}
