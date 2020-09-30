package test.tree;

import main.trees.BSTNode;
import main.trees.BinarySearchTree;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

public class BSTTreeTest {
    BinarySearchTree<Integer> binarySearchTree;

    @Before
    public void initialize() {
        binarySearchTree = new BinarySearchTree<Integer>(10);
        BSTNode l1 = binarySearchTree.addLeftChild(binarySearchTree.getRoot(), 5);
        BSTNode r1 = binarySearchTree.addRightChild(binarySearchTree.getRoot(), 15);
        binarySearchTree.addLeftChild(l1, 4);
        binarySearchTree.addRightChild(l1,7);
        binarySearchTree.addLeftChild(r1, 12);
        binarySearchTree.addRightChild(r1, 18);
    }

    @Test
    public void testInOrderTraversal() {
        ArrayList inOrder = binarySearchTree.inOrderTraversal();
        Assert.assertEquals(4,inOrder.get(0));
        Assert.assertEquals(5,inOrder.get(1));
        Assert.assertEquals(7,inOrder.get(2));
        Assert.assertEquals(10,inOrder.get(3));
        Assert.assertEquals(12,inOrder.get(4));
        Assert.assertEquals(15,inOrder.get(5));
        Assert.assertEquals(18,inOrder.get(6));
    }
}
