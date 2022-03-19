import java.util.*;

class Node{
    int data;
    Node left;
    Node right;
}

public class Solution{

    public static void levelOrder(Node root) {
      
        ArrayDeque<Node> queue = new ArrayDeque<>();
        queue.addLast(root);
        
        while(!queue.isEmpty()){
            Node topNode = queue.pop();
    
            System.out.print(topNode.data+" ");
    
            if(topNode!=null){
  
                if(topNode.left!=null)
                    queue.addLast(topNode.left);
        
                if(topNode.right!=null)
                    queue.addLast(topNode.right);
        
                }
        }
        
      }

    }
