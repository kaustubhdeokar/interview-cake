public class ReverseInGroupsOfK {

    class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }

    public static void main(String[] args) {

        ReverseInGroupsOfK rev = new ReverseInGroupsOfK();
        Node head = rev.createList();
        Node newHead = rev.reverseList(head, 3);
        while (newHead != null) {
            System.out.print(newHead.data + " ");
            newHead = newHead.next;
        }
    }

    public Node createList() {
        Node one = new Node(1);
        Node two = new Node(2);
        Node three = new Node(3);
        Node four = new Node(4);
        Node five = new Node(5);
        Node six = new Node(6);
        Node seven = new Node(7);

        one.next = two;
        two.next = three;
        three.next = four;
        four.next = five;
        five.next = six;
        six.next = seven;

        return one;

    }



    public Node reverseList(Node head, int k) {

        if (head == null || head.next == null) {
            return head;
        }

        Node curr = head;
        Node prevFirst = null;
        Node newHead = null;

        while (curr != null) {
            Node first = curr;
            int k1 = k;
            Node prev = null;

            while (curr != null && k1 > 0) {
                Node next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;
                k1 -= 1;
            }

            if (newHead == null) {
                newHead = prev;
            } else {
                prevFirst.next = prev;
            }
            prevFirst = first;

        }

        return newHead;
    }

    public Node reverseList(Node prev, Node curr, int count) {

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
}
