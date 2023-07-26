package binarysearchtree;

public class TreeNode {

    int data;
    TreeNode left;
    TreeNode right;

    public TreeNode(int data) {
        this.data = data;
    }

    public TreeNode() {

    }

    public TreeNode insert(TreeNode head, int data) {
        if (head == null) {
            head = new TreeNode(data);
            return head;
        } else if (head.data > data) {
            head.left = insert(head.left, data);
        } else {
            head.right = insert(head.right, data);
        }
        return head;
    }

    public static void main(String[] args) {

        TreeNode treeNode = new TreeNode();
        TreeNode head = treeNode.constructTreeI();
        treeNode.inorderTraversalWithPrev(head, null);

    }

    TreeNode constructTreeI() {
        TreeNode head = new TreeNode(4);
        head.insert(head, 2);
        head.insert(head, 1);
        head.insert(head, 3);

        head.insert(head, 6);
        head.insert(head, 5);
        head.insert(head, 7);

        return head;
    }

    private void inorderTraversal(TreeNode head) {
        if (head == null) {
            return;
        }
        inorderTraversal(head.left);
        System.out.print(head.data + " ");
        inorderTraversal(head.right);
    }

    private void inorderTraversalWithPrev(TreeNode head, TreeNode prev) {
        if (head == null) return;

        inorderTraversalWithPrev(head.left, head);
        if (prev == null) {
            System.out.println("head:" + head.data + " prev: null");
        } else {
            System.out.println("head:" + head.data + " prev:" + prev.data);
        }
        inorderTraversalWithPrev(head.right, head);
    }



    private void preOrder(TreeNode head) {
        if (head == null) return;

        System.out.println(head.data);
        preOrder(head.left);
        preOrder(head.right);
    }


}
