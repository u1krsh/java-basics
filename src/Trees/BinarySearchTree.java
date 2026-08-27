package Trees;

public class BinarySearchTree {

    private Node root;
    public BinarySearchTree(){

    }
    private static class Node{
        int val;
        Node left;
        Node right;
        int height;

        public Node(int val) {
            this.val = val;
        }

        public int getVal(){
            return val;
        }
    }
    public int returnHeight(Node node){
        if(node == null) return -1;
        return node.height;
    }

    public boolean isEmpty(){
        return root == null;
    }


    public void print(){
        print(root, "Root Node: ");
    }

    private void print(Node node, String details){
        if(node==null) return;

        System.out.println(details+node.val);
        print(node.left, "Left Child of: " + node.getVal() + " : ");
        print(node.right, "Right Child of: " + node.getVal() + " : ");

    }

    public void insert(int val){
        root = insert(val, root);
    }

    private Node insert(int val, Node node){

        if(node==null)  {
            node = new Node(val);
            return node;
        }
        if(val < node.val){
            node.left = insert(val,node.left);
        }
        if(val > node.val){
            node.right = insert(val,node.right);
        }
        node.height = Math.max(returnHeight(node.left), returnHeight(node.right)+1);
        return node;
    }

    public boolean isBalanced(){
        return isBalanced(root);
    }
    private boolean isBalanced(Node node){
        if(node == null) return true;

        return Math.abs(returnHeight(node.left)-returnHeight(node.right)) <= 1 && isBalanced(node.left) && isBalanced(node.right);
    }

    public void populate(int[] nums){
        for(int i =0; i< nums.length;i++){
            this.insert(nums[i]);
        }
    }

}
