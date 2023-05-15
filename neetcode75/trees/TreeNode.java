package trees;

import java.util.ArrayDeque;

public class TreeNode {

    int val;
    TreeNode left;
    TreeNode right;
    public static TreeNode eighty;
    public static TreeNode hundred;
    public static TreeNode sixty;
    public static TreeNode ninety;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    public TreeNode getTree1() {
        TreeNode head = new TreeNode(1);
        head.left = new TreeNode(2);
        head.right = new TreeNode(3);
        head.right.left = new TreeNode(4);

        /*
            1
           / \
          2   3
             /
            4
        * */

        return head;
    }

    public TreeNode getCompleteTree() {
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


    public TreeNode createTree2() {
        TreeNode ten = new TreeNode(10);
        TreeNode twenty = new TreeNode(20);
        TreeNode thirty = new TreeNode(30);

        ten.left = twenty;
        ten.right = thirty;

        TreeNode forty = new TreeNode(40);
        TreeNode fifty = new TreeNode(50);

        twenty.left = forty;
        twenty.right = fifty;

        sixty = new TreeNode(60);
        ninety = new TreeNode(90);
        forty.left = sixty;
        forty.right = ninety;

        TreeNode seventy = new TreeNode(70);
        fifty.right = seventy;
        eighty = new TreeNode(80);
        sixty.left = eighty;

        hundred = new TreeNode(100);
        seventy.right = hundred;

        return ten;
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
                System.out.print(curr.val + " ");
                if (curr.left != null) {
                    q.add(curr.left);
                }
                if (curr.right != null) {
                    q.add(curr.right);
                }
            }
            System.out.println();
        }
    }
}
