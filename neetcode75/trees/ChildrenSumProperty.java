package trees;

public class ChildrenSumProperty {

    public static void main(String[] args) {

        Integer[] arr = {20, 8, 12, -1, -1, 3, -1, 4, -1, 5 };
        SerializeDeserialize serializeDeserialize = new SerializeDeserialize();
        TreeNode treeFromArray = serializeDeserialize.createTreeFromArray(arr);

        ChildrenSumProperty childrenSumProperty = new ChildrenSumProperty();
        boolean isTrue = childrenSumProperty.traversePostOrder(treeFromArray);

        System.out.println(isTrue);


    }

    public boolean traversePostOrder(TreeNode head) {
        if (head == null) return false;
        boolean left = traversePostOrder(head.left);
        boolean right = traversePostOrder(head.right);

        if (left || right) {
            return true;
        }

        int val = 0;
        if (head.left != null) val += head.left.val;
        if (head.right != null) val += head.right.val;

        return val == head.val;
    }


}
