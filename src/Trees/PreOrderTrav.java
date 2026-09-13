package Trees;

import java.util.Stack;

// ROOT LEFT RIGHT
public class PreOrderTrav {
    Node root;
    public static class Node{
        int val;
        Node left, right;

        public Node(int val) {
            this.val = val;
            Node left, right = null;
        }
    }

    public void preOrder(){
        if(root == null) return;

        Stack<Node> stack = new Stack<>();
        Node curr = root;

        while(curr != null || stack.size() > 0){
            while(curr != null){
                stack.push(curr);
                System.out.print(curr.val + " ");
                curr = curr.left;
            }

            curr = stack.pop();
            curr = curr.right;
        }


    }


    public static void main(String args[])
    {

        // creating a binary tree and
        // entering the nodes
        PreOrderTrav tree = new PreOrderTrav();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.preOrder();
    }
}
