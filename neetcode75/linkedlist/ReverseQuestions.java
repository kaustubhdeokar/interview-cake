package linkedlist;

public class ReverseQuestions {

    public ListNode reverseRecursively(ListNode node) {

        ListNode[] listNodes = reverseRecursively(node, null);
        System.out.println(listNodes[0].val);
        System.out.println(listNodes[1].val);

        listNodes[0].next = null;

        return listNodes[1];
    }

    public ListNode[] reverseRecursively(ListNode node, ListNode head) {

        if (node == null) return null;
        ListNode[] listNodes = reverseRecursively(node.next, head);

        if (listNodes == null) {
            head = node;
        }

        if(listNodes!=null && listNodes[1]!=null){
            head = listNodes[1];
        }

        if (listNodes != null) {
            listNodes[0].next = node;
        }

        return new ListNode[]{node, head};

    }


    public static void main(String[] args) {

        ReverseQuestions rev = new ReverseQuestions();
        ListNode listNode = new ListNode();
        ListNode head = listNode.createList();
        ListNode reversed = rev.reverseRecursively(head);
        reversed.print();
    }

}
