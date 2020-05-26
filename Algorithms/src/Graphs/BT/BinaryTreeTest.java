package Graphs.BT;

import org.junit.Test;

import static org.junit.Assert.*;

public class BinaryTreeTest {

    @Test
    public void testMaxDepth() {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);

        assertEquals(3, root.maxDepth());
    }

    @Test
    public void testLCA() {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        assertEquals(2, root.LCA(4, 5).value);
        assertEquals(2, root.LCA(2, 4).value);
    }

    @Test
    public void testPrintPaths() {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        root.printPaths();
    }

    @Test
    public void testHasPathSum() {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        assertTrue(Node.hasPathSum(root, 7));
        assertTrue(Node.hasPathSum(root, 11));
        assertFalse(Node.hasPathSum(root, 2));
        assertFalse(Node.hasPathSum(root, 15));
    }
}
