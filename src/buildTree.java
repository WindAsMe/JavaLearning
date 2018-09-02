/**
 * Author     : WindAsMe
 * File       : buildTree.java
 * Time       : Create on 18-9-2
 * Location   : ../Home/JavaForLeeCode2/buildTree.java
 * Function   :
 */
public class buildTree {

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    private static TreeNode buildTreeResult(int[] preorder, int[] inorder) {
        return build(0, 0, inorder.length - 1, preorder, inorder);
    }
    private static TreeNode build(int prestart,int instart,int inend,int[] preorder,int[] inorder){
        if(prestart>preorder.length-1||instart>inend)
            return null;
        TreeNode root=new TreeNode(preorder[prestart]);
        int inindex=0;
        for(int i=instart;i<=inend;i++){
            if(inorder[i]==root.val){
                inindex=i;
                break;
            }
        }
        root.left=build(prestart+1,instart,inindex-1,preorder,inorder);
        root.right=build(prestart+inindex-instart+1,inindex+1,inend,preorder,inorder);
        return root;
    }
}
