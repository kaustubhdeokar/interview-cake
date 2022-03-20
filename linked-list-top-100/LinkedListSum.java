
class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

}

public class LinkedListSum {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        int carry = 0;
        int[] arr = new int[100];
        int counter = 0;

        while (l1 != null && l2 != null) {

            int val = l1.val + l2.val + carry;
            carry = val / 10;
            val = val % 10;

            arr[counter++] = val;
            l1 = l1.next;
            l2 = l2.next;

        }
        while (l2 != null) {
            int val = l2.val + carry;
            carry = val / 10;
            val = val % 10;

            arr[counter++] = val;
            l2 = l2.next;
        }
        while (l1 != null) {
            int val = l1.val + carry;
            carry = val / 10;
            val = val % 10;

            arr[counter++] = val;
            l1 = l1.next;
        }

        ListNode l3 = new ListNode(arr[0]);
        ListNode temp = l3;
        for(int i=1;i<counter;i++){
            l3.next = new ListNode(arr[i]);
            l3 = l3.next;

        }
        if(carry == 1){
            l3.next = new ListNode(1);
        }

        return temp;
    }

    public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {



        return null;
    }

    public static void main(String[] args) {
        LinkedListSum lls = new LinkedListSum();

        ListNode l1 = new ListNode(2);
        ListNode l1_2 = new ListNode(3);
        ListNode l1_3 = new ListNode(4);
        ListNode l1_4 = new ListNode(1);
        ListNode l1_5 = new ListNode(2);

        l1.next = l1_2;
        l1_2.next = l1_3;
        l1_3.next = l1_4;
        l1_4.next = l1_5;

        ListNode l2 = new ListNode(0);
        ListNode l2_1 = new ListNode(1);
        ListNode l2_2 = new ListNode(1);
        l2.next = l2_1;
        l2_1.next = l2_2;

        ListNode ans = lls.addTwoNumbers(l1, l2);
        while (ans != null) {
            System.out.println(ans.val);
            ans = ans.next;
        }

    }

}
