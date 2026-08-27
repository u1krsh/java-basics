package Trees;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        BinaryTree bin = new BinaryTree();
//        bin.populate(sc);
//        bin.pprint();

        BinarySearchTree bst = new BinarySearchTree();
        int[] nums ={3,5,4,5,7,2,9,0};
        bst.populate(nums);
        bst.print();
    }
}
