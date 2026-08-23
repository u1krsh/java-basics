package LinkedLists;

public class DLL {

    Node head;
    public void insertFirst(int val){
        Node node = new Node(val);
        node.next = head;
        node.prev = null;
        if (head != null) {
            head.prev = node;
        }
        head = node;
    }
    public void print(){
        Node curr = head;
        System.out.print("null->");
        while(curr != null){
            System.out.print(curr.val+ "<->");
            curr = curr.next;
        }
        System.out.println("null");
    }


    public void printRev(){
        Node curr = head;
        Node last  = null;
        while(curr != null){
            last = curr;
            curr = curr.next;
        }

        while (last != null){
            System.out.print(last.val+"<->");
            last= last.prev;
        }
        System.out.println("null");
    }
    public void insertLast(int val){

        if(head==null){
            insertFirst(val);
        }

        Node node = new Node(val);
        Node curr = head;
        while(curr.next != null){
            curr = curr.next;
        }
        curr.next = node;
        node.next = null;
        node.prev = curr;

    }


    public void insertAt(int val,  int ind){
        Node curr =head;
        Node node = new Node(val);
        if(ind==0) {insertFirst(val); return;}
        for(int i =1;i<ind;i++){
            curr = curr.next;
        }
        node.next = curr.next;
        node.prev = curr;
        if (curr.next != null) curr.next.prev = node;
        curr.next = node;
    }



    private class Node{
        int val;
        Node next;
        Node prev;

        public Node(int val) {
            this.val = val;
        }

        public Node(int val, Node next, Node prev) {
            this.val = val;
            this.next = next;
            this.prev = prev;
        }
    }
}
