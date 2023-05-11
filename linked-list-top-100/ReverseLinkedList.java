public class ReverseLinkedList {

    class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }

    public static void main(String[] args) {

        ReverseLinkedList rev = new ReverseLinkedList();
        Node head = rev.createList();

        Node newHead = rev.reverseList(head);

        while (newHead != null) {
            System.out.print(newHead.data + " ");
            newHead = newHead.next;
        }
    }

    public Node reverseList(Node head) {

        if (head == null || head.next == null) {
            return head;
        }

        Node newHead = reverseList(head, head.next);
        head.next = null;
        return newHead;
    }

    public Node reverseList(Node prev, Node curr) {

        while (curr != null) {
            Node next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        System.out.println("prev:" + prev.data);
        // System.out.println("curr:"+curr.data);
        return prev;

    }

    public Node createList() {
        Node one = new Node(1);
        Node two = new Node(2);
        Node three = new Node(3);
        Node four = new Node(4);
        Node five = new Node(5);

        one.next = two;
        two.next = three;
        three.next = four;
        four.next = five;

        return one;

    }

}
