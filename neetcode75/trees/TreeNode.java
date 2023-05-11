package trees;

import java.util.ArrayDeque;

public class TreeNode {

    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    public TreeNode getCompleteTree(){
        TreeNode head = new TreeNode(1);
        head.left = new TreeNode(2);
        head.right = new TreeNode(3);
        head.left.left = new TreeNode(4);
        head.left.right = new TreeNode(5);

        head.right.left = new TreeNode(6);
        head.right.right = new TreeNode(7);


        /*
                 1
               /   \
              2     3
             / \   / \
            4   5 6   7

        */
        return head;
    }



    public void traverseLevelOrder() {
        TreeNode newHead = this;
        traverseLevelOrder(newHead);
    }

    public void traverseLevelOrder(TreeNode newHead) {

        if (newHead == null) return;

        ArrayDeque<TreeNode> q = new ArrayDeque<>();
        q.add(newHead);
        int size;
        while (!q.isEmpty()) {
            size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode curr = q.remove();
                System.out.print(curr.val+" ");
                if(curr.left!=null){
                    q.add(curr.left);
                }
                if(curr.right!=null){
                    q.add(curr.right);
                }
            }
            System.out.println();
        }
    }
}
