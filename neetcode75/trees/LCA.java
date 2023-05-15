package trees;

public class LCA {

    public static void main(String[] args) {

        TreeNode head = new TreeNode().createTree2();
        LCA lca = new LCA();

        TreeNode lcaNode = lca.calculateLCA(head, TreeNode.eighty, TreeNode.hundred);
        System.out.println("LCA Node: " + lcaNode.val);

        lcaNode = lca.calculateLCA(head, TreeNode.sixty, TreeNode.ninety);
        System.out.println("LCA Node: " + lcaNode.val);
    }

    private TreeNode calculateLCA(TreeNode head, TreeNode eighty, TreeNode hundred) {

        if (head == null) return null;

        if (head == eighty || head == hundred) {
            return head;
        }

        TreeNode left = calculateLCA(head.left, eighty, hundred);

        TreeNode right = calculateLCA(head.right, eighty, hundred);

        if (left != null && right != null) {
            return head;
        }

        if (left != null) {
            return left;
        } else {
            return right;
        }


    }


}
