import java.util.ArrayList;
import java.util.List;

/**
 * Author     : WindAsMe
 * File       : isSameTree.java
 * Time       : Create on 18-5-31
 * Location   : ../Home/JavaForLeeCode2/isSameTree.java
 * Function   : LeeCode No.100
 */
public class isSameTree {

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    private static boolean isSameTreeResult(TreeNode p, TreeNode q) {
        List<Integer> pValue = new ArrayList<>();
        List<Integer> qValue = new ArrayList<>();
        isSame(p, pValue);
        isSame(q, qValue);
        if (pValue.size() == qValue.size()) {
            for (int i = 0; i < pValue.size() ; i ++ ){
                System.out.println("pValue: " + pValue.get(i) + "    " + "qValue: " + qValue.get(i));
                if (pValue.get(i) != qValue.get(i)){
                    return false;
                }
            }
            return true;
        } else {
            return false;
        }
    }

    // Pre-order Iteration
    private static void isSame(TreeNode root, List<Integer> value){
        if (root != null){
            value.add(root.val);
            isSame(root.left, value);
            isSame(root.right, value);
        } else {
            value.add(0);
        }
    }

    public static void main(String[] args){
        TreeNode p = new TreeNode(1);
        p.right = new TreeNode(2);

        TreeNode q = new TreeNode(1);
        q.right = new TreeNode(2);

        System.out.println(isSameTreeResult(p, q));

    }
}
