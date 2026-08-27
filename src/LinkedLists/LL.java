package LinkedLists;

import java.util.List;

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

    // remove dupes
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

    //merge sorted

    public static LL mergeSorted(LL first, LL second){
        Node head1 = first.head;
        Node head2 = second.head;

        LL answer = new LL();
        while(head1 != null && head2 != null){
            if(head1.val < head2.val){
                answer.insertAtend(head1.val);
                head1 = head1.next;
            }
            else{
                answer.insertAtend(head2.val);
                head2 = head2.next;
            }
        }

        while(head1 != null){
            answer.insertAtend(head1.val);
            head1 = head1.next;
        }
        while (head2 != null){
            answer.insertAtend(head2.val);
            head2 = head2.next;
        }
        return answer;
    }



    // hasCycle

    public  boolean hasCycle(){
        Node hare = head;

        Node turtle= head;

        while(hare != null && hare.next != null){
            turtle = turtle.next;
            hare = hare.next.next;
            if(hare == turtle){
                return true;
            }
        }
        return false;
    }

    //cycle length

    public int lengthCycle(Node head){
        Node hare = head;

        Node turtle= head;

        while(hare != null && hare.next != null){
            turtle = turtle.next;
            hare = hare.next.next;
            if(hare == turtle){
                Node temp = turtle;
                int lenght = 0;
                do{
                    temp = temp.next;
                    lenght++;
                }while (temp != turtle);
                return lenght;

            }
        }
        return 0;
    }

    public Node cycleStartNode(){
        Node hare = head;
        int length = 0;
        Node turtle= head;

        while(hare != null && hare.next != null){
            turtle = turtle.next;
            hare = hare.next.next;
            if(hare == turtle){

                length = lengthCycle(turtle);
                break;
            }
        }
        // find start

        Node first = head;
        Node second = head;

        while(length > 0){
            second = second.next;
            length--;
        }
        //keep moving both forward

        while(first != second){
            first = first.next;
            second= second.next;
        }
        return first;

    }


    public boolean isHappy (int n){
        int slow = n;
        int fast = n;

        do{
            slow = findSquare(slow);
            fast = findSquare(findSquare(fast));
        }while(slow != fast);

        if(slow==1) return true;
        else return false;


    }

    private int findSquare(int n){
        int ans = 0;
        while(n>0){
            int remo = n %10;
            ans += remo * remo;
            n = n/10;
        }
        return ans;
    }

    private void revereRecurion(Node node){
        if(node == tail){
            head = tail;
            return;
        }
        revereRecurion(node.next);
        tail.next = node;
        tail = node;
        tail.next = null;
    }
    //inplace reveral


    public void revereItr(){
        if(size<2){
            return;
        }
        Node prev = null;
        Node pres = head;
        Node nex = pres.next;

        while(pres != null){
            pres.next = prev;
            prev = pres;
            pres = nex;
            if(nex != null){
                nex=nex.next;
            }
        }
        head = prev;
    }


    //reverse linked list II

    public Node reverseBetween(Node head, int left, int right) {

        if(left==right) return head;

        //skip the first n-1 nodes
        Node curr = head;
        Node prev = null;
        for(int i = 0 ;curr != null && i<left-1;i++){
            prev = curr;
            curr = curr.next;
        }
        Node last = prev;
        Node newEnd = curr;


        //reverse between left and right
        Node nex = curr.next;
        for(int i = 0;curr != null && i<(right-left)+1;i++){
            curr.next = prev;
            prev = curr;
            curr = nex;
            if(nex != null) {
                nex = nex.next;
            }
        }

        if(last != null){
            last.next = prev;
        }
        else{
            head = prev;
        }

        newEnd.next = curr;

        return head;
    }
    public Node middleNode(Node head) {
        Node hare = head;
        Node turtle = head;
        while(hare != null && hare.next != null){
            turtle = turtle.next;
            hare = hare.next.next;
        }

        return turtle;
    }
    public Node reverseList(Node head) {
        if(head==null) return null;
        Node prev = null;
        Node pres = head;
        Node nex = pres.next;

        while(pres != null){
            pres.next = prev;
            prev = pres;
            pres = nex;
            if(nex != null){
                nex=nex.next;
            }
        }
        return prev ;
    }
    //pallindrome
    public boolean isPalindrome(Node head) {
        Node mid = middleNode(head);
        Node headSecond = reverseList(mid);
        Node temp = headSecond;
        while (head != null && headSecond != null){
            if(head.val != headSecond.val){
                break;
            }
            head=head.next;
            headSecond = headSecond.next;
        }
        reverseList(temp);
        return head == null || headSecond == null;
    }


    //reorder list
    public void reorderList(Node head) {
        if(head==null || head.next == null) return;

        Node mid = middleNode(head);
        Node hs = reverseList(mid);
        Node hf = head;
        while(hf != null && hs != null) {
            Node temp1 = hf.next;
            hf.next = hs;
            hf = temp1;

            temp1 = hs.next;
            hs.next = hf;
            hs = temp1;
        }
        if(hf != null){
            hf.next = null;
        }
    }


    //reorder

    public Node reverseKGroup(Node head, int k) {
        if(k <= 1 || head == null){
            return head;
        }
        Node curr = head;
        Node prev = null;
        while (true) {

            Node last = prev;
            Node newEnd = curr;


            //reverse between left and right
            Node nex = curr.next;
            for (int i = 0; curr != null && i < k ; i++) {
                curr.next = prev;
                prev = curr;
                curr = nex;
                if (nex != null) {
                    nex = nex.next;
                }
            }

            if (last != null) {
                last.next = prev;
            } else {
                head = prev;
            }

            newEnd.next = curr;
            if(curr == null){
                break;
            }

            prev = newEnd;
        }
        return head;
    }

}
