package binarytree;

import main.TreeNode;

import java.util.ArrayDeque;

public class SerializeDeserialize {

    public TreeNode createTreeFromArray(Integer[] arr) {

        ArrayDeque<TreeNode> q = new ArrayDeque<>();

        if (arr.length == 0 || arr[1] == -1)
            return null;
        TreeNode head = new TreeNode(arr[0]);
        q.add(head);
        int arrPtr = 1;

        while (!q.isEmpty() || arrPtr < arr.length) {

            int size = q.size();

            for (int i = 0; i < size; i++) {
                TreeNode peek = q.remove();

                int num = arr[arrPtr];
                arrPtr += 1;
                if (num != -1) {
                    peek.left = new TreeNode(num);
                    q.add(peek.left);
                } else {
                    peek.left = null;
                }

                num = arr[arrPtr];
                arrPtr += 1;
                if (num != -1) {
                    peek.right = new TreeNode(num);
                    q.add(peek.right);
                } else {
                    peek.right = null;
                }

            }
        }

        return head;
    }

}
