package binarytree;

import com.sun.source.tree.Tree;
import main.TreeNode;

public class ConstructFromInorderPreorder {


    /*
                   10
                20     50
             30  40  60  70

    */

    public void constructTreeFromTraversals(int[] preorder, int[] inorder) {

        int[] preorderIdx = {0};
        int[] inorderLimits = {0, inorder.length};

        TreeNode root = null;
        root = constructTreeFromTraversals(root, preorder, inorder, preorderIdx, inorderLimits);

    }

    public TreeNode constructTreeFromTraversals(TreeNode root, int[] preorder, int[] inorder, int[] preorderIdx, int[] inorderLimits) {

        if (inorderLimits[0] > inorderLimits[1]) {
            return null;
        }
        int preorderIdxIn_InorderArr = -1;
        if (preorderIdx[0] >= preorder.length) {
            return root;
        }
        else{
            int val = preorder[preorderIdx[0]];
            preorderIdx[0]+=1;
            root = new TreeNode(val);
            preorderIdxIn_InorderArr = findValueInInorder(val, inorder);
        }

 




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


    }


}
