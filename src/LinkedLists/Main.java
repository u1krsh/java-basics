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
    LinkedList.deleteSpecific(1);
    LinkedList.print();
    }
}
