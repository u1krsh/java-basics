package StacksAndQueues;





public class StackLinkedList {
    Node head;
    int size = 0;
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

     public void push(int val){
        Node node = new Node(val);
        node.next = head;
        head = node;
        size++;
     }

     public int pop(){
        if(head == null){
            System.out.println("Stack Empty");
            return Integer.MIN_VALUE;
        }
        int n = head.val;
        head = head.next;
         size--;
         return n;
     }

     public int peek(){
        if(head == null){
            System.out.println("Stack Empty");
        }
        return head.val;
     }

     public int isEmpty(){
        if(head == null){
            return 1;
        }
        return 0;
     }

     public int getSize(){
        return size;
     }

    public static void main(String[] args) {
        StackLinkedList stack = new StackLinkedList();

        stack.push(2);
        stack.push(67);
        stack.push(69);
        System.out.println(stack.pop());
        System.out.println(stack.peek());
        System.out.println(stack.isEmpty());
        System.out.println(stack.getSize());
    }
}
