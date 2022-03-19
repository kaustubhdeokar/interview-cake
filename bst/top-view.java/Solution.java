	/* 
    
    class Node 
    	int data;
    	Node left;
    	Node right;
	*/
    
    static class Pair{
        Node root;
        int level;
        
        Pair(Node root,int level){
            this.root = root;
            this.level = level;
        }
    }
    
	public static void topView(Node root) {
      
      Map<Integer,Integer> mapNodesToLevel = new TreeMap<>();
      
      ArrayDeque<Pair> queue = new ArrayDeque<>();
      queue.addLast(new Pair(root,0));
      
      while(!queue.isEmpty()){
          
          Pair temp = queue.pop();
          Node node = temp.root;
          int  level = temp.level;
        
          if(node!=null){
              mapNodesToLevel.putIfAbsent(level,node.data);
              if(node.left!=null)
              queue.addLast(new Pair(node.left,level-1));
              if(node.right!=null)
              queue.addLast(new Pair(node.right,level+1));
      }
          
      }
      
      
      for(Integer key: mapNodesToLevel.values()){
          System.out.print(key+" ");
      }
    }
    

