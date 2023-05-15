package trees;

/**
 * This is the longest distance between any two nodes.
 */
public class DiameterOfBinaryTree {

    public static void main(String[] args) {

        DiameterOfBinaryTree diameter = new DiameterOfBinaryTree();

        TreeNode head = new TreeNode().createTree2();

        System.out.println(diameter.calculateDiameterOfBinaryTree(head));

    }

    private int calculateDiameterOfBinaryTree(TreeNode head) {
        int[] diameter = {-1};
        calculateDiameterOfBinaryTree(head, diameter);
        return diameter[0];
    }

    private int calculateDiameterOfBinaryTree(TreeNode head, int[] diameter) {
        if (head == null) return 0;
        int left = calculateDiameterOfBinaryTree(head.left, diameter);
        int right = calculateDiameterOfBinaryTree(head.right, diameter);

        diameter[0] = Integer.max(diameter[0], 1 + left + right);

        return 1 + Integer.max(left, right);
    }

}
