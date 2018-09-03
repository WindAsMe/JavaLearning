import java.util.Stack;

/**
 * Author     : WindAsMe
 * File       : BSTIterator.java
 * Time       : Create on 18-9-3
 * Location   : ../Home/JavaForLeeCode2/BSTIterator.java
 * Function   : LeetCode No.173
 */
public class BSTIterator {

    // Definition for binary tree
    private class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;
         TreeNode(int x) { val = x; }
    }

    private Stack<TreeNode> stack;

    public BSTIterator(TreeNode root) {
        stack = new Stack<>();
        TreeNode n = root;
        while (n != null) {
            stack.push(n);
            n = n.left;
        }
    }
    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    /** @return the next smallest number */
    public int next() {
        TreeNode res = stack.pop();
        TreeNode n = res.right;
        while (n != null) {
            stack.push(n);
            n = n.left;
        }
        return res.val;
    }


/**
 * Your BSTIterator will be called like this:
 * BSTIterator i = new BSTIterator(root);
 * while (i.hasNext()) v[f()] = i.next();
 */
}
