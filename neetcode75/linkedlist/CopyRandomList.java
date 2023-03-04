package linkedlist;

import org.w3c.dom.Node;

import java.util.HashMap;

public class CopyRandomList {

    public Node copyRandomList(Node head) {

        HashMap<Node, Integer> mapNodeToIdx = new HashMap<>();
        Node tempPtr = head;
        int count = 0;

        while(tempPtr!=null){
            mapNodeToIdx.put(tempPtr, count);
            count+=1;
            tempPtr = tempPtr.next;
        }
        mapNodeToIdx.put(null, count);

        int[] storeRandomNodeIdx = new int[count];
        int arrPtr = 0;
        tempPtr = head;
        while(tempPtr!=null){
            int idx = mapNodeToIdx.get(tempPtr.random);
            tempPtr = tempPtr.next;
            storeRandomNodeIdx[arrPtr] = idx;
            arrPtr+=1;
        }

        Node resultNode = new Node(0);
        Node resultPtr = resultNode;
        HashMap<Integer, Node> mapIdxToNode = new HashMap<>();
        count = 0;
        tempPtr = head;

        while(tempPtr != null){
            resultPtr.next = new Node(tempPtr.val);
            resultPtr = resultPtr.next;
            mapIdxToNode.put(count, resultPtr);
            count+=1;
            tempPtr = tempPtr.next;
        }

        tempPtr = head;
        resultPtr = resultNode.next;
        arrPtr = 0;
        while(resultPtr!=null){
            resultPtr.random = mapIdxToNode.get(storeRandomNodeIdx[arrPtr++]);
            resultPtr = resultPtr.next;
        }

        return resultNode.next;
    }
    
}
