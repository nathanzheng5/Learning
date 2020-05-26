package Graphs.BST;

import org.junit.Test;

import static org.junit.Assert.*;

public class BSTTest {

    @Test
    public void test() {
        Node root = new Node(10);
        root.insert(5);
        root.insert(20);
        root.insert(3);
        root.insert(9);
        root.insert(1);
        root.insert(4);
        root.insert(15);
        root.insert(25);
        root.insert(13);
        root.insert(17);
        root.insert(30);
        System.out.println();
        root.traverse();

        assertEquals(1, root.minValue());
        assertEquals(30, root.maxValue());

        assertTrue(root.contains(20));
        assertFalse(root.contains(21));

        assertEquals(5, root.LCA(4, 9).value);
        assertEquals(15, root.LCA(13, 17).value);
        assertEquals(5, root.LCA(5, 9).value);
    }

    @Test
    public void testBalance() {
        Node root = new Node(4);
        root.left = new Node(3);
        root.left.left = new Node(2);
        root.left.left.left = new Node(1);
        root.right = new Node(5);
        root.right.right = new Node(6);
        root.right.right.right = new Node(7);

        Node balanceRoot = root.convertToBalanced();
        assertEquals(4, balanceRoot.value);
        assertEquals(2, balanceRoot.left.value);
        assertEquals(1, balanceRoot.left.left.value);
        assertEquals(3, balanceRoot.left.right.value);
        assertEquals(6, root.right.value);
        assertEquals(5, root.right.left.value);
        assertEquals(7, root.right.right.value);
    }


}
