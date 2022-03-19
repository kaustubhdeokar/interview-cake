import java.util.*;

class TreeNode {

    int value;
    TreeNode left;
    TreeNode right;

    TreeNode(int value) {
        this.value = value;
    }

}

public class Tree {

    TreeNode head;

    public void insert(int data) {
        head = insert(head, data);
    }

    private TreeNode insert(TreeNode head, int data) {
        if (head == null) {
            head = new TreeNode(data);
        }
        if (head.value > data) {
            head.left = insert(head.left, data);
        }
        if (head.value < data) {
            head.right = insert(head.right, data);
        }
        return head;
    }

    public void inorderWD(TreeNode head) {
        inorderWithDepth(head, 0);
    }

    private void inorderWithDepth(TreeNode head, int i) {
        if (head != null) {
            inorderWithDepth(head.left, i + 1);
            if (head.left == null && head.right == null) {
                //leaf node.
                System.out.println(head.value + "" + i);
            }
            inorderWithDepth(head.right, i + 1);
        }
    }


    public boolean isBST(TreeNode head) {

        boolean bst = isBST(head, Integer.MIN_VALUE, Integer.MAX_VALUE);

        return false;
    }

    private boolean isBST(TreeNode head, int leftLimit, int rightLimit) {

        if (head != null) {
            if (head.left != null && (head.left.value > head.value || head.left.value < leftLimit)) {
                return false;
            }
            if (head.right != null && (head.right.value < head.value || head.right.value > rightLimit)) {
                return false;
            }
            return isBST(head.left, leftLimit, head.value) && isBST(head.right, head.value, rightLimit);
        }
        return true;
    }

    public void inorder(TreeNode head) {
        if (head != null) {
            System.out.print(head.value + " ");
            inorder(head.left);
            inorder(head.right);
        }
    }

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> resultList = new ArrayList<>();
        postorderTraversal(root, resultList);
        return resultList;

    }

    public void postorderTraversal(TreeNode root, List<Integer> resultList) {
        if (root != null) {
            postorderTraversal(root.left, resultList);
            postorderTraversal(root.right, resultList);
            resultList.add(root.value);
        }

    }

    public List<Integer> inorderTraversal(TreeNode head) {

        List<Integer> resultList = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = head;

        while (curr != null || !stack.isEmpty()) {
            while (curr != null) {
                resultList.add(curr.value);
                stack.push(curr);
                curr = curr.left;
            }
            TreeNode top = stack.pop();
            curr = top.right;
        }
        return resultList;
    }

    class Pair {
        TreeNode node;
        Integer level;

        Pair(TreeNode node, Integer level) {
            this.node = node;
            this.level = level;
        }

    }

    public void topView(TreeNode root) {

        Map<Integer, Integer> mapNodesToLevel = new TreeMap<>();

        ArrayDeque<Pair> queue = new ArrayDeque<>();
        queue.addLast(new Pair(root, 0));

        while (!queue.isEmpty()) {

            Pair tempPair = queue.pop();
            TreeNode node = tempPair.node;
            Integer level = tempPair.level;

            if (node != null) {
                mapNodesToLevel.putIfAbsent(level, node.value);
                if (node.left != null)
                    queue.addLast(new Pair(node.left, level - 1));
                if (node.right != null)
                    queue.addLast(new Pair(node.right, level + 1));

            }

        }


        Collection<Integer> values = mapNodesToLevel.values();

        for (Integer value : values) {
            System.out.print(value + " ");
        }

    }

    public void iterate(TreeNode root, Map<Integer, Integer> map, int level) {
        if (root != null) {
            map.putIfAbsent(level, root.value);
            iterate(root.left, map, level - 1);
            iterate(root.right, map, level + 1);
        }
    }

    public void levelOrder(TreeNode head) {

        ArrayDeque<TreeNode> queue = new ArrayDeque<>();
        queue.addLast(head);
        while (!queue.isEmpty()) {
            TreeNode pop = queue.pop();
            System.out.println(pop.value);
            if (pop.left != null)
                queue.addLast(pop.left);
            if (pop.right != null)
                queue.addLast(pop.right);
        }
    }

    public boolean isBalanced(TreeNode treeRoot) {


        Set<Integer> leafHeights = new HashSet<>();

        iterateInOrder(treeRoot,leafHeights,0);


        return leafHeights.size()>2;
    }

    public void iterateInOrder(TreeNode root, Set<Integer> leafHeights,int level){

        if(root!=null){

            if(root.left==null && root.right==null){
                leafHeights.add(level);
            }

            iterateInOrder(root.left,leafHeights,level+1);
            iterateInOrder(root.right,leafHeights,level+1);


        }

    }

    public static void main(String[] args) {

        Tree tree = new Tree();

        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        for (String s1 : s.split(" ")) {
            tree.insert(Integer.parseInt(s1));
        }

//        tree.insert(50);
//        tree.insert(30);
//        tree.insert(20);
//        tree.insert(40);
//        tree.insert(80);
//        tree.insert(70);
//        tree.insert(90);

        tree.topView(tree.head);

    }


}
