package main.trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

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

    public BinarySearchTree(BSTNode root) {
        this.root = root;
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

    /*
        List of Depths: Given a binary tree, design an algorithm which creates a linked list of all the nodes
        at each depth (e.g., if you have a tree with depth 0, you'll have 0 linked lists).
     */
    public List<LinkedList<BSTNode>> getListOfDepths() {
        List<LinkedList<BSTNode>> list = new ArrayList<>();
        getListLinkedList(list, this.root, 0);
        return list;
    }

    public ArrayList<T> preOrderTraversal() {
        intializeVisitArray();
        preOrderTraversal(root);
        return visitArray;
    }

    public ArrayList<T> postOrderTraversal() {
        intializeVisitArray();
        postOrderTraversal(root);
        return visitArray;
    }

    private void  getListLinkedList(List<LinkedList<BSTNode>> list, BSTNode root, int level) {
        if(root == null) return;
        if(list.size() <= level) {
            list.add(new LinkedList<>());
        }
        LinkedList linkedList = list.get(level);
        linkedList.addLast(root);
        getListLinkedList(list, root.getLeft(), level+1);
        getListLinkedList(list, root.getRight(), level+1);

    }
    private void inOrderTraversal(BSTNode root) {
        if(root == null) return;
        inOrderTraversal(root.getLeft());
        visit(root);
        inOrderTraversal(root.getRight());
    }


    private void preOrderTraversal(BSTNode root) {
        if(root == null) return;
        visit(root);
        inOrderTraversal(root.getLeft());
        inOrderTraversal(root.getRight());
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


