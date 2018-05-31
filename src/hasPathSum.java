/**
 * Author     : WindAsMe
 * File       : hasPathSum.java
 * Time       : Create on 18-5-31
 * Location   : ../Home/JavaForLeeCode2/hasPathSum.java
 * Function   : LeeCode No.112
 */
public class hasPathSum {

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    private static boolean hasPathSumResult(TreeNode root, int sum) {
        return root != null && isExist(root, 0, sum);
    }

    // Temp: current value
    // Sum: Target value
    private static boolean isExist(TreeNode root, int temp, int sum){
        if (root == null){
            return false;
        } else {
            temp += root.val;
            //System.out.println("root->value: " + root.val + "  temp: " + temp);
            if (temp == sum) {
                return root.left == null && root.right == null || isExist(root.left, temp, sum) || isExist(root.right, temp, sum);
            } else {
                return isExist(root.left, temp, sum) || isExist(root.right, temp, sum);
            }
        }
    }

    public static void main(String[] args){
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(-2);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.left.left.left = new TreeNode(-1);

        root.right = new TreeNode(-3);
        root.right.left = new TreeNode(-2);
        System.out.println(hasPathSumResult(root, -1));
    }
}
