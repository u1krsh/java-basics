import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class practice {
    private Node head;


 private class Node{
     int val;
     Node next;

     public Node(int val) {
         this.val = val;
     }

     public Node(int val, Node next) {
         this.val = val;
         this.next = next;
     }


     public Node removeDupes(Node head){
         if(head == null) return head;

         Node curr = head;

         while(curr.next != null){
             if(curr.val == curr.next.val){
                 curr.next = curr.next.next;
             }
             else{
                 curr = curr.next;
             }
         }
        return head;
     }

     private int length(Node head){
         if(head == null) return 0;

         Node hare = head;
         Node turtle = head;

         while(hare != null && hare.next != null){
             hare = hare.next.next;
             turtle = turtle.next;
         }

         if(hare == turtle){
             Node curr = hare;
             int lenght = 0;
             do{
                 curr = curr.next;
                 lenght++;
             }while (curr != turtle);
             return lenght;
         }
         return 0;
     }

     public Node detectCycle(Node head) {
        if(head == null) return null;
        Node hare = head;
        Node turtle = head;
        int lenght = 0;
        while(hare != null && hare.next != null){
            hare = hare.next.next;
            turtle = turtle.next;

            if(turtle == hare){
                lenght = length(turtle);
                break;
            }
        }
        Node first = head;
        Node second = head;
        while(lenght > 0){
            second = second.next;
            lenght--;
        }
        while (first != second){
            first = first.next;
            second = second.next;
        }
        return first;

     }



 }
}
