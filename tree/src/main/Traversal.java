package main;

import java.util.ArrayDeque;

public class Traversal {

    public boolean enablePrinting = false;


    public Traversal(boolean enablePrinting) {
        this.enablePrinting = enablePrinting;
    }

    public void traversePreOrder(TreeNode head) {
        if (head == null) return;
        print(head.val + " ");
        traversePreOrder(head.left);
        traversePreOrder(head.right);
    }

    public void levelOrder(TreeNode head) {
        ArrayDeque<TreeNode> q = new ArrayDeque<>();
        q.add(head);


        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode pop = q.pop();

                if (enablePrinting) System.out.print(pop.val + " ");

                if (pop.left != null) {
                    q.add(pop.left);
                }
                if (pop.right != null) {
                    q.add(pop.right);
                }
            }
            System.out.println();
        }

    }

    private void print(String s) {
        if (enablePrinting) {
            System.out.print(s);
        }
    }
}
