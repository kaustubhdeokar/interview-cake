package trees;

import java.util.ArrayDeque;
import java.util.PriorityQueue;

public class KthLargestLevelSum {

    public static void main(String[] args) {

        Integer[] arr = {5, 8, 9, 2, 1, 3, 7, 4, 6};
        ArrayToTree arrayToTree = new ArrayToTree();
        TreeNode tree = arrayToTree.createTree(arr);

        KthLargestLevelSum kthLargestLevelSum = new KthLargestLevelSum();
        int k = 2;
        System.out.println(kthLargestLevelSum.traverse(tree, k));

    }

    private long traverse(TreeNode newHead, int k) {

        ArrayDeque<TreeNode> q = new ArrayDeque<>();
        q.add(newHead);
        int size;
        PriorityQueue<Long> priorityQueue = new PriorityQueue<>((c1, c2) -> Long.compare(c1, c2));
        while (!q.isEmpty()) {
            size = q.size();
            long sum = 0;
            for (int i = 0; i < size; i++) {
                TreeNode curr = q.remove();
                sum += curr.val;
                System.out.print(curr.val + " ");
                if (curr.left != null) {
                    q.add(curr.left);
                }
                if (curr.right != null) {
                    q.add(curr.right);
                }
            }
            priorityQueue.add(sum);
            if (priorityQueue.size() > k) {
                priorityQueue.poll();
            }
            System.out.println();
        }
        if (priorityQueue.size() < k) return -1;
        return priorityQueue.peek();
    }

}
