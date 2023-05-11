package linkedlist;

public class RemoveNthNodeFromEnd {

    public ListNode removeNthFromEnd(ListNode head, int n) {

        ListNode resultPtr = head;
        ListNode prev = head;
        ListNode nthNode = head;
        ListNode nthNodePrev = null;
        int i = 0;

        while (prev != null) {
            prev = prev.next;
            if (i >= n) {
                nthNodePrev = nthNode;
                nthNode = nthNode.next;
            }
            i += 1;
        }
        if (nthNodePrev != null) {
            nthNodePrev.next = nthNode.next;
            //System.out.println("nthnodeprev:"+nthNodePrev.val);
        } else if (nthNode != null) {
            //System.out.println("nthNode:"+nthNode.val);
            return nthNode.next;
        }

        //System.out.println(nthNode.val);

        return resultPtr;
    }

    public static void main(String[] args) {

        RemoveNthNodeFromEnd remove = new RemoveNthNodeFromEnd();
        ListNode head = createList();
        ListNode result = remove.removeNthFromEnd(head, 1);
        result.print();

        head = createList();
        result = remove.removeNthFromEnd(head, 5);
        result.print();

    }

    private static ListNode createList() {
        ListNode one = new ListNode();
        one = one.createList();
        return one;
    }

}
