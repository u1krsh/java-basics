package Trees;
//LEFT ROOT RIGHT
import java.util.Stack;

public class InOrderTrav {

    Node root;
    private static class Node{
        int val;
        Node left, right;

        public Node(int val) {
            this.val = val;
            this.left = null;
            this.right = null;
        }
    }
    public void inOrder(){

        if(root == null){
            return;
        }

        Stack<Node> stack = new Stack<>();
        Node curr = root;

        while(curr != null || stack.size() > 0 ){
            while(curr != null){
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            System.out.print(curr.val + " ");

            curr = curr.right;
        }
    }


    public static void main(String[] args) {
        InOrderTrav tree = new InOrderTrav();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.inOrder();

    }


}
