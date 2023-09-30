package binarytree;

import main.TreeNode;
import java.util.Scanner;

public class BinaryTreeImpl {

    public TreeNode createTreeAccordingToUserInput() {

        return begin();

    }

    public TreeNode begin() {

        System.out.println("beginning creating a tree.Enter root value");
        Scanner scanner = new Scanner(System.in);
        int value = scanner.nextInt();
        return createTree(new TreeNode(value));
    }

    public TreeNode createTree(TreeNode root) {

        System.out.println("root value:" + root.val);
        System.out.println("Do you want to create a left node, y/n");
        Scanner scanner = new Scanner(System.in);
        if (scanner.next().equalsIgnoreCase("y")) {
            System.out.println("Enter value.");
            int data = scanner.nextInt();
            root.left = new TreeNode(data);
            createTree(root.left);
        }

        System.out.println("root value:" + root.val);
        System.out.println("Do you want to create a right node, y/n");
        scanner = new Scanner(System.in);
        if (scanner.next().equalsIgnoreCase("y")) {
            System.out.println("Enter value.");
            int data = scanner.nextInt();
            root.right = new TreeNode(data);
            createTree(root.right);
        }

        return root;

    }

}
