import java.util.Stack;

/**
 * Author     : WindAsMe
 * File       : isSymmetric.java
 * Time       : Create on 18-6-1
 * Location   : ../Home/JavaForLeeCode2/isSymmetric.java
 * Function   : LeeCode No.101
 */
public class isSymmetric {

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
    private static boolean isSymmetricResult(TreeNode root) {
        if (root == null){
            return true;
        } else if (root.left == null && root.right == null){
            return true;
        } else if (root.left != null && root.right != null){
            Stack<TreeNode> leftStack = new Stack<>();
            Stack<TreeNode> rightStack = new Stack<>();
            leftStack.push(root.left);
            rightStack.push(root.right);
            while (!(leftStack.empty() || rightStack.empty())){
                TreeNode leftTemp = leftStack.pop();
                TreeNode rightTemp = rightStack.pop();

                System.out.println("here");
                System.out.println("left:" + leftTemp.val + " right:" + rightTemp.val);
                if (leftTemp.val != rightTemp.val){
                    return false;
                } else {

                    if (leftTemp.left != null) {
                        leftStack.push(leftTemp.left);
                    } else {
                        if (rightTemp.right != null){
                            return false;
                        }
                    }

                    if (leftTemp.right != null){
                        leftStack.push(leftTemp.right);
                    } else {
                        if (rightTemp.left != null){
                            return false;
                        }
                    }



                    if (rightTemp.right != null){
                        rightStack.push(rightTemp.right);
                    } else {
                        if (leftTemp.left != null){
                            return false;
                        }
                    }

                    if (rightTemp.left != null) {
                        rightStack.push(rightTemp.left);
                    } else {
                        if (leftTemp.right != null){
                            return false;
                        }
                    }
                }
            }
            return leftStack.empty() && rightStack.empty();
        }
        // Has left no right or has right no left
        return false;
    }

    public static void main(String[] args){
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.right.left = new TreeNode(3);
        System.out.println(isSymmetricResult(root));
    }
}
