package Trees;

import java.util.LinkedList;
import java.util.Queue;

public class NextLevelOrder {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }


    public TreeNode findSucess(TreeNode root, int val){
        if(root == null){
            return null;
        }

        Queue<TreeNode> queue= new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()){
            int levelSize = queue.size();
            TreeNode curr = queue.poll();
            if(curr.left != null) queue.offer(curr.left);
            if(curr.right != null) queue.offer(curr.right);
            if(curr.val == val ){
                break;
            }
        }
        return queue.peek();
    }
}
