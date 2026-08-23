package LinkedLists;

public class Main {
    public static void main(String[] args) {
    LL LinkedList = new LL();

    LinkedList.insertFirst(6);
    LinkedList.insertFirst(5);
    LinkedList.insertAtend(7);
    LinkedList.insert(69,2);

    LinkedList.print();
    LinkedList.deleteAtEnd();
    LinkedList.insertUsingRecursion(2,3);
    LinkedList.insert(2,3);
    LinkedList.print();
    LinkedList.removeDupes();
    LinkedList.print();

//        DLL Double = new DLL();
//        Double.insertFirst(2);
//        Double.insertFirst(4);
//        Double.insertLast(9);
//        Double.print();
//        Double.insertAt(20,2);
//        Double.print();
//        Double.printRev();

//        CLL circ = new CLL();
//
//        circ.insertAtBegin(2);
//        circ.insertAtBegin(1);
//        circ.insertAtBegin(0);
//        circ.insertAtEnd(3);
//        circ.insertAtInd(7,2);
//        circ.print();
//        circ.delete(2);
//        circ.print();


    }
}
