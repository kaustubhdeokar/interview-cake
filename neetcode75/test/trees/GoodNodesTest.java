package trees;

import org.junit.Assert;
import org.junit.Test;


public class GoodNodesTest {

    private final ArrayToTree m_arrayToTree = new ArrayToTree();
    private final GoodNodes m_goodNodes = new GoodNodes();

    @Test
    public void testGoodNodesForTree() {
        Integer[] arr = {-1, 5, -2, 4, 4, 2, -2, null, null, -4, null, -2, 3, null, -2, 0, null, -1, null, -3, null, -4, -3, 3, null, null, null, null, null, null, null, 3, -3};
        TreeNode tree = m_arrayToTree.createTree(arr);
        int result = m_goodNodes.goodNodes(tree);
        Assert.assertEquals("Does not match expected result", 5, result);
    }

    @Test
    public void testGoodNodesForTreeWithSingleNode() {
        Integer[] arr = {-1};
        TreeNode tree = m_arrayToTree.createTree(arr);
        int result = m_goodNodes.goodNodes(tree);
        Assert.assertEquals("Does not match expected result", 1, result);
    }

    @Test
    public void testGoodNodesForTreeWithNodesHavingEqualValue() {
        Integer[] arr = {3, 1, 4, 3, null, 1, 5};
        TreeNode tree = m_arrayToTree.createTree(arr);
        int result = m_goodNodes.goodNodes(tree);
        Assert.assertEquals("Does not match expected result", 4, result);
    }
}