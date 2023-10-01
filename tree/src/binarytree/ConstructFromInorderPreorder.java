package binarytree;

import main.Traversal;
import main.TreeNode;

public class ConstructFromInorderPreorder {



    public TreeNode constructTreeFromTraversals(int[] preorder, int[] inorder) {

        int[] preorderIdx = {0};
        int[] inorderLimits = {0, inorder.length};

        TreeNode root = null;
        return constructTreeFromTraversals(root, preorder, inorder, preorderIdx, inorderLimits);
    }

    public TreeNode constructTreeFromTraversals(TreeNode root, int[] preorder, int[] inorder, int[] preorderIdx, int[] inorderLimits) {

        if (inorderLimits[0] > inorderLimits[1]) {
            return null;
        }
        int startLimit = inorderLimits[0];
        int endLimit = inorderLimits[1];
        int preorderIdxIn_InorderArr = -1;
        if (preorderIdx[0] >= preorder.length) {
            return null;
        } else {
            int val = preorder[preorderIdx[0]];
            preorderIdx[0] += 1;
            root = new TreeNode(val);
            preorderIdxIn_InorderArr = findValueInInorder(val, inorder);
        }

        inorderLimits[0] = startLimit;
        inorderLimits[1] = preorderIdxIn_InorderArr - 1;
        root.left = constructTreeFromTraversals(root.left, preorder, inorder, preorderIdx, inorderLimits);

        inorderLimits[0] = preorderIdxIn_InorderArr + 1;
        inorderLimits[1] = endLimit;
        root.right = constructTreeFromTraversals(root.right, preorder, inorder, preorderIdx, inorderLimits);

        return root;
    }

    private int findValueInInorder(int val, int[] inorder) {

        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == val) {
                return i;
            }
        }
        return -1;
    }


    public static void main(String[] args) {

        int[] inorderArr = {30, 20, 40, 10, 60, 50, 70};
        int[] preorderArr = {10, 20, 30, 40, 50, 60, 70};

        /*
                   10
                20     50
             30  40  60  70
        */

        ConstructFromInorderPreorder construct = new ConstructFromInorderPreorder();
        TreeNode node = construct.constructTreeFromTraversals(preorderArr, inorderArr);
        Traversal traversal = new Traversal(true);
        traversal.levelOrder(node);
    }


}
