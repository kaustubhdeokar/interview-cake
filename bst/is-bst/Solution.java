class TreeNode {

    int value;
    TreeNode left;
    TreeNode right;

    TreeNode(int value) {
        this.value = value;
    }

}

public class Solution {

    TreeNode head;

    public void insert(int data) {
        head = insert(head, data);
    }

    private TreeNode insert(TreeNode head, int data) {
        if (head == null) {
            head = new TreeNode(data);
        }
        if (head.value > data) {
            head.left = insert(head.left, data);
        }
        if (head.value < data) {
            head.right = insert(head.right, data);
        }
        return head;
    }

    public void inorderWD(TreeNode head) {
        inorderWithDepth(head, 0);
    }

    private void inorderWithDepth(TreeNode head, int i) {
        if (head != null) {
            inorderWithDepth(head.left, i + 1);
            if (head.left == null && head.right == null) {
                //leaf node.
                System.out.println(head.value + "" + i);
            }
            inorderWithDepth(head.right, i + 1);
        }
    }


    public boolean isBST(TreeNode head) {

        boolean bst = isBST(head, Integer.MIN_VALUE, Integer.MAX_VALUE);

        return false;
    }

    private boolean isBST(TreeNode head, int leftLimit, int rightLimit) {

        if(head!=null){
            if(head.left!=null && (head.left.value > head.value || head.left.value < leftLimit)){
                return false;
            }
            if(head.right!=null && (head.right.value < head.value || head.right.value > rightLimit)){
                return false;
            }
            return isBST(head.left,leftLimit,head.value) && isBST(head.right,head.value, rightLimit);
        }
        return true;
    }

    public void inorder(TreeNode head) {
        if (head != null) {
            inorder(head.left);
            System.out.println(head.value);
            inorder(head.right);
        }
    }

    public static void main(String[] args) {

        Tree tree = new Tree();
        tree.insert(5);
        tree.insert(3);
        tree.insert(4);
        tree.insert(7);
        tree.insert(6);
        tree.insert(2);
        tree.insert(1);
        tree.insert(8);

        tree.inorderWD(tree.head);


    }

}
