package LinkedLists;

public class LL {
    private Node head;
    private Node tail;
    private  int size;

    public LL() {
        this.size = 0;
    }


    public void insertFirst(int val){
        Node node = new Node(val);

        node.next = head;
        head = node;

        if(tail == null){
            tail = head;
        }

        size++;
    }

    public void print(){
        Node curr = head;
        while(curr != null){
            System.out.print(curr.val + "->");
            curr = curr.next;
        }
        System.out.println("null");
    }


    public void insertAtend(int val){
        Node node = new Node(val);
        if(tail==null){
            insertFirst(val);
        }
        tail.next = node;
        tail = node;
        size++;
    }

    public void insert(int val, int ind){
        if(ind ==0 ){
            insertFirst(val);
            return;
        }
        if(ind==size){
            insertAtend(val);
        }

        Node curr = head;
        for(int i =1;i <ind;i++){
            curr = curr.next;
        }

        Node node = new Node(curr.next,val);
        curr.next = node;
        size++;

    }

    public int deleteFirst(){
        int val = head.val;
        head = head.next;
        if(head==null){
            tail = null;
        }
        size--;
        return val;
    }

    public int deleteAtEnd(){


        if(head == null){
            System.out.println("List Empty");
        }
        int val = tail.val;

        if(head==tail){
            head =null;
            tail = null;
            return val;
        }
        Node curr = head;
        while(curr.next.next != null){
            curr = curr.next;
        }
        curr.next = null;
        tail = curr;

        return val;
    }


    public int deleteSpecific(int ind){

        if (ind == 0) return deleteFirst();
        if (ind == size - 1) return deleteAtEnd();

        Node curr = head;
        for (int i = 0; i < ind - 1; i++) {
            curr = curr.next;
        }

        int val = curr.next.val;
        curr.next = curr.next.next;
        size--;

        return val;
    }

    public void insertUsingRecursion(int val, int ind){
        head = insertUsingRecursion(val,ind,head);
    }

    private Node insertUsingRecursion(int val, int ind, Node node){
        if(ind == 0) {
            Node temp = new Node(node, val);
            size++;
            return temp;
        }
       node.next =  insertUsingRecursion(val,ind-1,node.next);
        return node;

    }

    private class Node {
        private int val;
        private Node next;

        public Node(int val) {
            this.val = val;
        }

        public Node(Node next, int val) {
            this.next = next;
            this.val = val;
        }
    }

    // Questions


    public void  removeDupes(){
        Node curr= head;
        while(curr.next != null) {
            if (curr.val == curr.next.val) {
                curr.next = curr.next.next;
                size--;
            }
            else {
                curr =curr.next;
            }

        }
        tail = curr;
        tail.next = null;
    }





}
