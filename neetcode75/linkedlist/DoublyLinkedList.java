package linkedlist;

public class DoublyLinkedList {

    private DLLNode head;
    private DLLNode tail;

    public DoublyLinkedList() {
        DLLNode dllNodeHelper = new DLLNode();
        head = dllNodeHelper.createDLL();
        setTail(head);
    }

    private void setTail(DLLNode head) {
        while (head.next != null) {
            head = head.next;
        }
        tail = head;
    }

    public static void main(String[] args) {

        //print
        DoublyLinkedList doublyLinkedList = new DoublyLinkedList();
        doublyLinkedList.print();

        //insert at beginning.
//        doublyLinkedList.insertAtBeginning(0);
//        doublyLinkedList.print();
//        doublyLinkedList.insertAtBeginning(-1);
//        doublyLinkedList.print();

        //insert at end.
//        doublyLinkedList.insertAtEnd(6);
//        doublyLinkedList.print();
//        doublyLinkedList.insertAtEnd(7);
//        doublyLinkedList.print();

        //reverse
        doublyLinkedList.reverse();
        doublyLinkedList.print();
    }

    private void reverse() {

        //  1 -> 2 -> 3
        //  1 <- 2 <- 3

        //  3 -> 2 -> 1
        //  3 <- 2 <- 1

        DLLNode curr = head.next;
        head.next = null;
        reverse(head, curr);

    }

    private void reverse(DLLNode prev, DLLNode curr) {
        while (curr != null) {
            DLLNode next = curr.next;
            curr.next = prev;
            prev.prev = curr;
            prev = curr;
            curr = next;
        }
        head = prev;
        head.prev = null; // imp.
        System.out.println("head:" + head.data);
    }

    private void insertAtEnd(int data) {

        DLLNode newNode = new DLLNode(data);

        if (head == null && tail == null) {
            head = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
        }
        tail = newNode;
    }

    private void print() {
        DLLNode head = this.head;
        System.out.print("Forward:");
        while (head.next != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
        System.out.println(head.data);
        System.out.print("Backward:");
        while (head.prev != null) {
            System.out.print(head.data + " ");
            head = head.prev;
        }
        System.out.println(head.data);
        System.out.println();
    }

    private void insertAtBeginning(int data) {

        DLLNode newHead = new DLLNode(data);
        if (head != null) {
            newHead.next = head;
            head.prev = newHead;
            newHead.prev = null;
        }
        head = newHead;

    }

}
