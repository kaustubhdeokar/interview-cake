package trees;

import java.util.ArrayDeque;
import java.util.ArrayList;

public class SerializeDeserialize {

    public static void main(String[] args) {

        SerializeDeserialize serializeDeserialize = new SerializeDeserialize();
        Integer[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};

        TreeNode treeFromArray = serializeDeserialize.createTreeFromArray(arr);

        Traversal traversal = new Traversal();
        ArrayList<Integer> integers = traversal.performLevelOrderTraversal(treeFromArray);
        System.out.println(integers);

    }

    public Integer[] createArrayFromTree(TreeNode tree) {
        TreeNode head = tree;

        Traversal traversal = new Traversal();
        ArrayList<Integer> levelOrder = traversal.performLevelOrderTraversal(head);
        Integer[] integers = levelOrder.toArray(new Integer[0]);
        return integers;
    }

    public TreeNode createTreeFromArray(Integer[] array) {

        if (array.length == 0) {
            return null;
        }

        TreeNode head = new TreeNode(array[0]);
        ArrayDeque<TreeNode> q = new ArrayDeque<>();
        q.add(head);

        int ptr = 1;
        while (!q.isEmpty() && ptr < array.length) {
            TreeNode currNode = q.remove();

            int currVal = array[ptr];
            if (currVal != -1) {
                TreeNode left = new TreeNode(currVal);
                currNode.left = left;
                q.add(left);
            } else {
                currNode.left = null;
            }

            ptr += 1;
            if(ptr >= array.length) break;

            currVal = array[ptr];
            if (currVal != -1) {
                TreeNode left = new TreeNode(currVal);
                currNode.right = left;
                q.add(left);
            } else {
                currNode.right = null;
            }

            ptr += 1;
        }
        return head;
    }

}
