package main;

import main.TreeNode;

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

    private void print(String s) {
        if (enablePrinting) {
            System.out.print(s);
        }
    }
}
