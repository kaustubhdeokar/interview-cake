package linkedlist;

public class DLLNode {
    int data;
    DLLNode prev;
    DLLNode next;

    public DLLNode() {
    }

    public DLLNode(int data) {
        this.data = data;
    }

    public DLLNode createDLL(){

        DLLNode dllNode = new DLLNode(1);
        DLLNode dllNode2 = new DLLNode(2);
        DLLNode dllNode3 = new DLLNode(3);
        DLLNode dllNode4 = new DLLNode(4);
        DLLNode dllNode5 = new DLLNode(5);

        dllNode.next = dllNode2;
        dllNode2.prev = dllNode;

        dllNode2.next = dllNode3;
        dllNode3.prev = dllNode2;

        dllNode3.next = dllNode4;
        dllNode4.prev = dllNode3;

        dllNode4.next = dllNode5;
        dllNode5.prev = dllNode4;

        return dllNode;

    }

}
