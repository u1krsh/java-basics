package LinkedLists;

import org.w3c.dom.Node;

public class CLL {
    private Node head;
    private Node tail;


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
    }

    public void insertAtBegin(int val){
        Node node = new Node(val);

        if(head == null){
            head = node;
            tail = node;
            return;
        }
        tail.next = node;
        node.next= head;
        head = node;


    }

    public void  insertAtEnd(int val){
        Node node = new Node(val);
        if(tail==null){
            insertAtBegin(val);
            return;
        }
        tail.next = node;
        node.next = head;
        tail = node;

    }


    public void insertAtInd(int val, int ind){
        if(ind ==0) {
            insertAtBegin(val);
            return;
        }
        Node node = new Node(val);

        Node curr = head;
        for(int i = 1; i<ind;i++){
            curr = curr.next;
        }
        node.next = curr.next;
        curr.next = node;
    }

    public int delete(int ind){
        if(head==null) return -1;

        if(ind == 0){
            int val = head.val;
            if(head.next == head){ // only one node
                head = null;
            } else {
                Node last = head;
                while(last.next != head) last = last.next; // find tail
                head = head.next;
                last.next = head;
            }
            return val;
        }

        Node curr = head;
        for(int i = 1; i < ind; i++){
            curr = curr.next;
        }
        int val = curr.next.val;
        curr.next = curr.next.next;
        return val;
    }

    public void print(){
        Node curr = head;
        if(head != null){
            do{
                System.out.print(curr.val + "->");
                curr = curr.next;
            }while (curr != head);
        }
        System.out.println("head");

    }


}
