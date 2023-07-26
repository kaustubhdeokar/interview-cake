package trees;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.Scanner;

public class ConstructTree {

    //idea: start from the root node and ask for each node if the user wants to enter the left or right nodes.

    public TreeNode constructTree(@Nullable TreeNode root) {

        if (root == null) {
            return null;
        }
        System.out.println("Current root:" + root.val);

        System.out.println("Do you want to have a left node ? y:n");
        Scanner scanner = new Scanner(System.in);
        String option = scanner.next();
        int value;

        if (option.equalsIgnoreCase("y")) {
            System.out.println("Enter the value");
            value = scanner.nextInt();
            root.left = new TreeNode(value);
            constructTree(root.left);
        }
        System.out.println("Current root:" + root.val);

        System.out.println("Do you want to have a right node ? y:n");
        scanner = new Scanner(System.in);
        option = scanner.next();
        if (option.equalsIgnoreCase("y")) {
            System.out.println("Enter the value");
            value = scanner.nextInt();
            root.right = new TreeNode(value);
            constructTree(root.right);
        }

        return root;


    }

    public static void main(String[] args) {

        ConstructTree ct = new ConstructTree();
        TreeNode root = new TreeNode(5);
        ct.constructTree(root);

        Traversal traversal = new Traversal();
        ArrayList<Integer> integers = traversal.performLevelOrderTraversal(root);
        System.out.println(integers);
    }


}
