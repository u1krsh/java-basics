package Trees;

import java.util.Arrays;

public class LC105ConBinTree {
    class TreeNode{
        int val;
        TreeNode left, right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length == 0) return null;

        int root = preorder[0];
        int idx = 0;

        for(int i =0; i<inorder.length;i++){
            if(inorder[i] == root) idx = i;
        }

        TreeNode node = new TreeNode(root);
        node.left = buildTree(Arrays.copyOfRange(preorder, 1, idx+1), Arrays.copyOfRange(inorder, 0, idx));
        node.right = buildTree(Arrays.copyOfRange(preorder, idx+1, preorder.length), Arrays.copyOfRange(inorder, idx+1, inorder.length));

        return node;
    }

}
