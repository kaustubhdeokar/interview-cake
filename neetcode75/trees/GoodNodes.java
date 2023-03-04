package trees;

public class GoodNodes {

    public int goodNodes(TreeNode root) {
        return goodNodes(root, Integer.MIN_VALUE);
    }

    public int goodNodes(TreeNode root, int maxTillNow) {
        if (root == null) return 0;

        int count = 0;

        if (maxTillNow <= root.val) {
            count += 1;
        }
        int leftCount = goodNodes(root.left, Integer.max(maxTillNow, root.val));
        int rightCount = goodNodes(root.right, Integer.max(maxTillNow, root.val));

        return count + leftCount + rightCount;

    }

    public static void main(String[] args) {

    }
}
