package Trees;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.Vector;

public class preOrder {

    private static class TreeNode {
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

    public List<Integer> preOrderr(TreeNode root){
        List<Integer> res = new ArrayList<>();

        if(root == null) return  res;

        Stack<TreeNode> stack = new Stack<>();

        stack.push(root);

        while(!stack.isEmpty()){
            TreeNode temp = stack.peek();
            stack.pop();
            res.add(temp.val);
            if(temp.right != null) {
                stack.push(temp.right);
            }
            if(temp.left != null){
                stack.push(temp.left);
            }
        }
        return res;
    }


}
