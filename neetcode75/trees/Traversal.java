package trees;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.ArrayList;

public class Traversal {

    public static boolean enablePrinting = false;

    public static void main(String[] args) {

        TreeNode treeNode = new TreeNode();
        TreeNode completeTree = treeNode.getCompleteTree();
        Traversal traversal = new Traversal();

        System.out.println("Level order traversal:");
        traversal.performLevelOrderTraversal(treeNode.getTree1());

    }

    /**
     * Has applications in b-tree indexes. and topological sorting.
     */
    public void traversePreOrder(TreeNode head) {
        if (head == null) return;
        print(head.val + " ");
        traversePreOrder(head.left);
        traversePreOrder(head.right);
    }

    /**
     * it traverses its children first and then comes to root node.
     * hence one of the application can be in the garbage collection where it clears it's children first and then comes towards parent.
     */
    public void traversePostOrder(TreeNode head) {
        if (head == null) return;
        traversePostOrder(head.left);
        traversePostOrder(head.right);
        print(head.val + " ");
    }


    public void traverseInorder(TreeNode head) {
        if (head == null) return;
        traverseInorder(head.left);
        print(head.val + " ");
        traverseInorder(head.right);
    }

    public ArrayList<Integer> performLevelOrderTraversal(TreeNode head) {

        if (head == null) return null;

        ArrayList<TreeNode> list = new ArrayList<>();
        list.add(head);
        int listPtr = 0;

        ArrayList<Integer> levelOrderTraversal = new ArrayList<>();

        while (listPtr < list.size()) {

            int currWindowSize = list.size() - listPtr;

            for (int i = 0; i < currWindowSize; i++) {

                TreeNode top = list.get(listPtr);
                listPtr += 1;

                if (top != null && top.val == -1) {
                    print("null ");
                    levelOrderTraversal.add(-1);
                } else {
                    levelOrderTraversal.add(top.val);
                    print(top.val + " ");
                    populateListForChild(list, top, top.left);
                    populateListForChild(list, top, top.right);
                }
            }
            printNewLine();
        }
        return levelOrderTraversal;
    }

    private void print(@Nullable String s) {
        if (enablePrinting) {
            System.out.print(s);
        }
    }

    private void printNewLine() {
        if (enablePrinting) {
            System.out.println();
        }
    }

    private void populateListForChild(ArrayList<TreeNode> list, @Nonnull TreeNode parent, @Nullable TreeNode child) {
        if (parent.val == -1) {
            list.add(null);
            return;
        }

        if (child == null) {
            list.add(new TreeNode(-1));
        } else {
            list.add(child);
        }
    }


}
