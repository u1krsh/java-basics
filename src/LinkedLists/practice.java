package LinkedLists;

public class practice {
    private Node head;
    private class Node{
        private int val;
        private Node next;


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
        node.next = head;
        head = node;

    }

    public void insertAtEnd(int val){
        Node node = new Node(val);
        Node curr = head;
        while(curr.next != null){
            curr = curr.next;
        }
        curr.next = node;

    }


    public void insertAtInd(int val, int ind){
        Node node = new Node(val);

        if(ind == 0){
            insertAtBegin(val);
            return;
        }
        Node curr = head;
        for (int i = 1;i < ind;i++){
            curr = curr.next;
        }
        node.next = curr.next.next;
        curr.next = node;

    }
    public void print(){
        Node curr = head;
        while(curr != null){
            System.out.print(curr.val + "->");
            curr = curr.next;
        }
        System.out.println("END");
    }

}
