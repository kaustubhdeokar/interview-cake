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

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public void traverse() {
        TreeNode newHead = this;
        traverse(newHead);

    }

    private void traverse(TreeNode newHead) {

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
