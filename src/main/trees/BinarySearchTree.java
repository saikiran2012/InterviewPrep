package main.trees;

import java.util.ArrayList;

public class BinarySearchTree<T> {
    BSTNode root;
    BSTNode left;
    BSTNode right;

    private ArrayList<T> visitArray;

    public BinarySearchTree(T data) {
        root = new BSTNode(data);
        left = right = null;
        visitArray = new ArrayList<T>();
    }

    public BSTNode getRoot() {
        return root;
    }

    public BSTNode addLeftChild(BSTNode parent, T data) {
        BSTNode leftChild = new BSTNode(data);
        parent.setLeft(parent, leftChild);
        return leftChild;
    }

    public BSTNode addRightChild(BSTNode parent, T data) {
        BSTNode rightChild = new BSTNode(data);
        parent.setRight(parent, rightChild);
        return rightChild;
    }

    public ArrayList<T> inOrderTraversal() {
        intializeVisitArray();
        inOrderTraversal(root);
        return visitArray;
    }

    private void inOrderTraversal(BSTNode root) {
        if(root == null) return;
        inOrderTraversal(root.getLeft());
        visit(root);
        inOrderTraversal(root.getRight());
    }

    public ArrayList<T> preOrderTraversal() {
        intializeVisitArray();
        preOrderTraversal(root);
        return visitArray;
    }

    private void preOrderTraversal(BSTNode root) {
        if(root == null) return;
        visit(root);
        inOrderTraversal(root.getLeft());
        inOrderTraversal(root.getRight());
    }

    public ArrayList<T> postOrderTraversal() {
        intializeVisitArray();
        postOrderTraversal(root);
        return visitArray;
    }

    private void postOrderTraversal(BSTNode root) {
        if(root == null) return;
        inOrderTraversal(root.getLeft());
        inOrderTraversal(root.getRight());
        visit(root);
    }

    private void intializeVisitArray() {
        visitArray = new ArrayList<T>();
    }

    private void visit(BSTNode node) {
        visitArray.add((T)node.getData());
    }
}


