package main.trees;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * Minimal Tree: Given a sorted (increasing order) array with unique integer elements, write an algorithm to create a binary search tree with minimal height.
 */
public class MinimalTree {
    BinarySearchTree<Integer> binarySearchTree;
    public BSTNode<Integer> createMinimalTree(int[] array) {
        if(array.length < 1) {
            return null;
        }
        int mid = array.length/2;
        BSTNode node = new BSTNode(array[mid]);
        node.setLeft(createMinimalTree(Arrays.copyOfRange(array, 0, mid)));
        node.setRight(createMinimalTree(Arrays.copyOfRange(array, mid+1, array.length)));
        return node;
    }
}



