package trees;

import java.util.ArrayList;

public class PathToANode {

    public static void main(String[] args) {

        TreeNode head = new TreeNode().createTree2();
        PathToANode pathToANode = new PathToANode();

//        fetchPathI(head, pathToANode);

        ArrayList<TreeNode> list = new ArrayList<>();

        pathToANode.pathToANode(head, TreeNode.hundred, list);

        for (TreeNode t : list) {
            System.out.print(t.val + " ");
        }


    }

    private static void fetchPathI(TreeNode head, PathToANode pathToANode) {
        boolean[] val = {false};
        ArrayList<TreeNode> treeNodes = pathToANode.pathToNode(head, TreeNode.eighty, val);
        for (TreeNode curr : treeNodes) {
            System.out.print(curr.val + " ");
        }

        System.out.println();

        val[0] = false;

        treeNodes = pathToANode.pathToNode(head, TreeNode.hundred, val);
        for (TreeNode curr : treeNodes) {
            System.out.print(curr.val + " ");
        }
    }

    public ArrayList<TreeNode> pathToNode(TreeNode head, TreeNode target, boolean[] val) {


        ArrayList<TreeNode> list = new ArrayList<>();
        if (head == null || val[0]) return list;

        list.add(head);

        if (head == target) {
            val[0] = true;
            return list;
        }

        ArrayList<TreeNode> leftNodes = pathToNode(head.left, target, val);
        list.addAll(leftNodes);
        ArrayList<TreeNode> rightNodes = pathToNode(head.right, target, val);
        list.addAll(rightNodes);

        if (!val[0])
            list.remove(list.size() - 1);

        return list;

    }

    public boolean pathToANode(TreeNode head, TreeNode target, ArrayList<TreeNode> list) {

        if (head == null) return false;

        list.add(head);

        if (head == target) {
            return true;
        }

        if (pathToANode(head.left,target,  list) || pathToANode(head.right, target, list)) {
            return true;
        }

        list.remove(list.size() - 1);

        return false;

    }


}
