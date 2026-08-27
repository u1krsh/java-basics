package Trees;

import java.util.Scanner;

public class BinaryTree {

    private  Node root;
    public BinaryTree(){

    }
    private static class Node{
        int val;
        Node left;
        Node right;

        public Node(int val) {
            this.val = val;
        }

        public Node(int val, Node left, Node right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    //insert elements

    public void populate(Scanner scanner){
        System.out.println("Enter the root node value");
        int value = scanner.nextInt();
        root = new Node(value);
        populate(scanner,root);
    }

    private void populate(Scanner scanner, Node node){
        System.out.println("Do you want to enter left of" + node.val);
        boolean left = scanner.nextBoolean();
        if(left){
            System.out.println("Enter the value");
            int leftVal = scanner.nextInt();
            node.left = new Node(leftVal);
            populate(scanner,node.left);
        }
        System.out.println("Do you want to enter right of" + node.val);
        boolean right = scanner.nextBoolean();
        if(right){
            System.out.println("Enter the value");
            int rightVal = scanner.nextInt();
            node.right = new Node(rightVal);
            populate(scanner,node.right);
        }
    }


    public void print(){
        print(root, " ");
    }

    private void print(Node node, String indent){
        if(node == null) return;
        System.out.println(indent+node.val);
        print(node.left,indent + '\t');
        print(node.right,indent+'\t');
    }


    public void pprint(){
        pprint(root,0);
    }

    private void pprint(Node node , int level){
        if(node == null) return;

        pprint( node.right, level+1);
        if(level != 0 ){
            for (int i = 0;i<level-1;i++){
                System.out.print("|\t\t");
            }

            System.out.println("|------>"+ node.val);

        }
        else {
            System.out.println(node.val);
        }
        pprint(node.left, level+1);
    }



}
