package test.tree;

import main.trees.BSTNode;
import main.trees.BinarySearchTree;
import main.trees.MinimalTree;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class TreeTest {


    @Test
    public void testMinimalTree() {
        MinimalTree tree = new MinimalTree();
        int[] array = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
        BSTNode t = tree.createMinimalTree(array);
        BinarySearchTree bst = new BinarySearchTree(t);
        ArrayList<Integer> inOrderList = bst.inOrderTraversal();
        List<Integer> list = Arrays.stream(array)
                .boxed()
                .collect(Collectors.toList());
        Assert.assertEquals(list, inOrderList);
    }

    @Test
    public void testListLinkedList() {
        BinarySearchTree<Integer> binarySearchTree = new BinarySearchTree<Integer>(10);
        BSTNode l1 = binarySearchTree.addLeftChild(binarySearchTree.getRoot(), 5);
        BSTNode r1 = binarySearchTree.addRightChild(binarySearchTree.getRoot(), 15);
        binarySearchTree.addLeftChild(l1, 4);
        binarySearchTree.addRightChild(l1,7);
        binarySearchTree.addLeftChild(r1, 12);
        binarySearchTree.addRightChild(r1, 18);

        List<LinkedList<BSTNode>> list = binarySearchTree.getListOfDepths();
        Assert.assertEquals(1, list.get(0).size());
        Assert.assertEquals(2, list.get(1).size());
        Assert.assertEquals(4, list.get(2).size());
    }
}
