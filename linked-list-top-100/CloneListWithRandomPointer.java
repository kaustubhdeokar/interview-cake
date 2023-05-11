import java.util.HashMap;

public class CloneListWithRandomPointer{


    class Node{
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    public Node copyRandomList(Node head) {
        
    //1. mapping of node to clone node. 

        HashMap<Node, Node> mapNodeToNewNode = new HashMap<>();
        Node temp = head;
        while(temp!=null){
            mapNodeToNewNode.put(temp, new Node(temp.val));
            temp = temp.next;
        }
    
    //2. creating mappings as old.

        temp = head;
        while(temp!=null){
            Node clone = mapNodeToNewNode.get(temp);
            clone.next = mapNodeToNewNode.get(temp.next);
            clone.random = mapNodeToNewNode.get(temp.random);
            temp = temp.next;
        }
    
    return mapNodeToNewNode.get(head);

    }

}