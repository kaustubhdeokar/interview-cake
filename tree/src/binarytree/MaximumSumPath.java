package binarytree;

import main.TreeNode;

public class MaximumSumPath {

    // Fcking hell.
    // 78/91

    public int maxPathSum(TreeNode root) {

        int[] maxSum = {Integer.MIN_VALUE};

        int maxPathSum = maxPathSum(root, maxSum);

        return Integer.max(maxPathSum, maxSum[0]);


    }

    public int maxPathSum(TreeNode root, int[] maxSum) {

        if (root == null) return 0;

        int leftSum = maxPathSum(root.left, maxSum);
        int rightSum = maxPathSum(root.right, maxSum);

        //System.out.println("root:"+root.val+" leftSum:"+leftSum+" rightSum:"+rightSum);

        if (root.val >= 0) {
            maxSum[0] = Integer.max(maxSum[0],
                    Integer.max(root.val, Integer.max(leftSum, Integer.max(rightSum, leftSum + rightSum)) + root.val));
            //System.out.println("maxSum:"+maxSum[0]);
        } else {
            //System.out.println("maxSum:"+maxSum[0]);
            maxSum[0] = Integer.max(maxSum[0], Integer.max(leftSum, rightSum) + root.val);
        }

        int maxYet = Integer.max(root.val, Integer.max(leftSum, rightSum) + root.val);
        //System.out.println("maxyet:"+ maxYet);
        return maxYet;
    }
}
