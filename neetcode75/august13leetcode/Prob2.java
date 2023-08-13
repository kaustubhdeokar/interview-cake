package august13leetcode;

public class Prob2 {

    class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }

    public Node createList2() {
        Node one = new Node(9);
        Node two = new Node(8);
        Node three = new Node(7);

        one.next = two;
        two.next = three;

        return one;

    }

    public Node reverse(Node head) {
        Node prev = null;
        Node curr = head;
        Node next = head.next;

        while (curr != null) {
            curr.next = prev;
            prev = curr;
            curr = next;
            if (next != null) next = next.next;
        }
        return prev;
    }

    public static void main(String[] args) {

        Prob2 prob2 = new Prob2();
        Node list2 = prob2.createList2();
        prob2.calculateDouble(list2);

    }

    private Node calculateDouble(Node list2) {
        Node reverseHead = reverse(list2);
        Node ptrToReverseHead = reverseHead;
        Node prev = null;
        int carryOver = 0;
        while (reverseHead != null) {
            int data = reverseHead.data;
            data = data * 2 + carryOver;
            reverseHead.data = data % 10;
            carryOver = data / 10;
            prev = reverseHead;
            reverseHead = reverseHead.next;
        }
        if (carryOver == 1) {
            prev.next = new Node(carryOver);
        }

        Node doubledHead = reverse(ptrToReverseHead);

        while (doubledHead != null) {
            System.out.println(doubledHead.data);
            doubledHead = doubledHead.next;
        }

        return ptrToReverseHead;
    }
}
