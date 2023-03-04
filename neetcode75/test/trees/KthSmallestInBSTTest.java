package trees;

import org.junit.Assert;
import org.junit.Test;

public class KthSmallestInBSTTest {

    private final KthSmallestInBST m_kthSmallestInBST = new KthSmallestInBST();
    private final ArrayToTree m_arrayToTree = new ArrayToTree();

    @Test
    public void testKthSmallestElement() {

        Integer[] arr = {3, 1, 4, null, 2};
        int k = 1;
        TreeNode tree = m_arrayToTree.createTree(arr);

        int result = m_kthSmallestInBST.kthSmallest(tree, k);

        Assert.assertEquals(1, result);
    }

    @Test
    public void testKthSmallestElementII(){
        Integer[] arr = {5,3,6,2,4,null,null,1};
        int k = 3;
        TreeNode tree = m_arrayToTree.createTree(arr);

        int result = m_kthSmallestInBST.kthSmallest(tree, k);

        Assert.assertEquals(3, result);

    }

}