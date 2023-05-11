package trees;

public class Traversal {

    public static void main(String[] args) {

        TreeNode treeNode = new TreeNode();
        TreeNode completeTree = treeNode.getCompleteTree();
        Traversal traversal = new Traversal();

        System.out.println("Inorder: left -> print node value -> right");
        traversal.traverseInorder(completeTree);
        System.out.println("Pre order: print node value -> left -> right");
        traversal.traversePreOrder(completeTree);
        System.out.println("Post order: left child -> right child -> print node value.");
        traversal.traversePostOrder(completeTree);
    }

    /**
     Has applications in b-tree indexes. and topological sorting.
     */
    private void traversePreOrder(TreeNode head) {
        if (head == null) return;
        System.out.print(head.val + " ");
        traversePreOrder(head.left);
        traversePreOrder(head.right);
    }

    /**
     * it traverses its children first and then comes to root node.
     * hence one of the application can be in the garbage collection where it clears it's children first and then comes towards parent.

     */
    private void traversePostOrder(TreeNode head) {
        if (head == null) return;
        traversePreOrder(head.left);
        traversePreOrder(head.right);
        System.out.print(head.val + " ");
    }

    private void traverseInorder(TreeNode head) {
        if (head == null) return;
        traverseInorder(head.left);
        System.out.print(head.val + " ");
        traverseInorder(head.right);
    }


}
