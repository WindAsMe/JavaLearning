import java.util.ArrayList;
import java.util.List;

/**
 * Author     : WindAsMe
 * File       : pathSum.java
 * Time       : Create on 18-6-1
 * Location   : ../Home/JavaForLeeCode2/pathSum.java
 * Function   : LeeCode No.113
 */
public class pathSum {

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    private static List<List<Integer>> pathSumResult(TreeNode root, int sum) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null){
            return result;
        } else if (root.left == null && root.right == null){
            if (root.val == sum){
                List<Integer> list = new ArrayList<>();
                list.add(root.val);
                result.add(list);
                return result;
            } else {
                return result;
            }
        } else {
            List<Integer> list = new ArrayList<>();
            list.add(root.val);

            addSum(root.left, result, list, root.val, sum, root.val);
            System.out.println("------------------------------");
            addSum(root.right, result, list, root.val, sum, root.val);
            return result;
        }
    }

    private static void addSum(TreeNode root, List<List<Integer>> result, List<Integer> list, int temp, int sum, int rootValue){
        if (root != null) {
            System.out.println("node value: " + root.val + " temp value: " + temp);
        }
        int add = 0;
        for (Integer i : list){
            add += i;
        }
        System.out.println("current value: " + add);
        if (root != null) {
            if (root.left == null && root.right == null) {
                if (temp + root.val == sum) {
                    System.out.println(" All empty add value: " + root.val);
                    list.add(root.val);
                    List<Integer> waitAdd = new ArrayList<>(list);

                    result.add(waitAdd);
                    list.clear();
                    list.add(rootValue);

                }
            } else {
                System.out.println("No empty add value: " + root.val);
                list.add(root.val);
                addSum(root.left, result, list, temp + root.val, sum, rootValue);
                addSum(root.right, result, list, temp + root.val, sum, rootValue);
            }
        }
    }

    public static void main(String[] args){
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(-2);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.left.left.right= new TreeNode(-1);

        root.right = new TreeNode(-3);
        root.right.left = new TreeNode(3);
        root.right.right = new TreeNode(-2);
        List<List<Integer>> result = pathSumResult(root, 2);
        for (int i = 0 ; i < result.size() ; i ++ ){
            System.out.println("here");
            for (int j = 0 ; j < result.get(i).size() ; j ++ ){
                System.out.print(result.get(i).get(j));
            }
            System.out.println();
        }
    }
}
