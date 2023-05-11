package linkedlist;

public class ListNode {

    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public void print() {
        ListNode head = this;
        while (head != null) {
            System.out.print(head.val + ":");
            head = head.next;
        }
        System.out.println();
    }

    public ListNode reverseRecursively(ListNode node) {

        if (node == null) return null;
        ListNode ahead = reverseRecursively(node.next);

        if (ahead != null) {
            ahead.next = node;
        }

        return node;

    }

    public ListNode createList() {
        ListNode one = new ListNode(1);
        ListNode two = new ListNode(2);
//        ListNode three = new ListNode(3);
//        ListNode four = new ListNode(4);
//        ListNode five = new ListNode(5);
//        one.next = two;
//        two.next = three;
//        three.next = four;
//        four.next = five;
        return one;
    }

}
