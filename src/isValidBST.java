/**
 * Author     : WindAsMe
 * File       : isValidBST.java
 * Time       : Create on 18-5-31
 * Location   : ../Home/JavaForLeeCode2/isValidBST.java
 * Function   : LeeCode No.98
 */
public class isValidBST {

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    private static boolean isValidBSTResult(TreeNode root) {
        if (root == null){
            return false;
        } else if (root.left == null && root.right == null){
            return true;
        } else {
            return isSimpleValid(root) && isValueVaild(root.left, root.val) && isValueVaild(root.right, root.val);
        }
    }

    //
    private static boolean isSimpleValid(TreeNode root){

        boolean markLeft = true;
        boolean markRight = true;
        if (root.left != null) {
            if (root.left.val < root.val ) {
                markLeft = isSimpleValid(root.left);
            } else {
                return false;
            }
        }
        if (root.right != null) {
            if (root.right.val > root.val) {
                markRight = isSimpleValid(root.right);
            } else {
                return false;
            }
        }
        return markLeft && markRight;
    }


    // Value save the root's father value
    private static boolean isValueVaild(TreeNode root, int value){

        boolean mark1 = true;
        boolean mark2 = true;
        if (root.left != null){
            if (root.left.val > value){
                return false;
            } else {
                mark1 = isValueVaild(root.left, root.val);
            }
        }

        if (root.right != null){
            if (root.right.val > value){
                return false;
            } else {
                mark2 = isValueVaild(root.right, root.val);
            }
        }
        return mark1 && mark2;
    }

    public static void main(String[] args){
        TreeNode root = new TreeNode(0);
        root.left = new TreeNode(-1);
//        root.right = new TreeNode(6);
//        root.right.left = new TreeNode(3);
//        root.right.right = new TreeNode(7);

        System.out.println(isValidBSTResult(root));
    }
}
