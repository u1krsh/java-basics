package StacksAndQueues;

public class QueueLinkedList {
    private Node head;
    private Node tail;
    private int size = 0 ;
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


    public void enqueue(int val){
        Node node = new Node(val);
        if(head==null){
            head = node;
            tail = node;

        }else {

            tail.next = node;
            node = tail;
        }
        size++;
    }


    public int dequeue(){
        if(head==null){
            System.out.println("Queue Empty");
            return Integer.MIN_VALUE;
        }
        int n = head.val;
        head = head.next;
        if(head==null){
            tail= null;
        }
        size--;
        return n;
    }

    public int peekFront(){
        if(head == null){
            System.out.println("Queue is empty");
            return -1;
        }
        return head.val;
    }
    public int getSize(){
        return size;
    }

    public int isEmpty(){
        if(tail==null){
            return 1;
        }
        else {
            return 1;
        }
    }

    public static void main(String[] args) {

    }


}
