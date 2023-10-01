package binarytree;

import main.TreeNode;
import java.util.Stack;

public class KthSmallestInBST {

    public int kthSmallest(TreeNode root, int k) {

        // inorder traversal - iteratively. we maintain a queue, and we pop things out of the queue.
        //samelogic, 1st element popped is the smallest element.
        //nth popped -> nth smallest.

        Stack<TreeNode> q = new Stack<>();
        int count = 0;
        TreeNode curr = root;

        while (!q.isEmpty() || curr != null) {
            while (curr != null) {
                q.push(curr);
                curr = curr.left;
            }
            while (!q.isEmpty() && q.peek().right == null) {
                TreeNode popped = q.pop();
                count += 1;
                if (count == k) return popped.val;
            }
            if (!q.isEmpty()) {
                TreeNode popped = q.pop();
                count += 1;
                if (count == k) return popped.val;
                curr = popped.right;
            }
        }

        return -1;

    }

}
