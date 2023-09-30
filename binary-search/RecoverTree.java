public class RecoverTree {

    class TreeNode {
        int data;
        TreeNode left;
        TreeNode right;
    }


    public void recoverTree(TreeNode root) {

        TreeNode[] nodes = new TreeNode[2];
        recoverTree(root, Integer.MIN_VALUE, Integer.MAX_VALUE, nodes);

    }

    public void recoverTree(TreeNode root, Integer minValue, Integer maxValue) {

    }

    public static void main(String[] args) {


    }

}
