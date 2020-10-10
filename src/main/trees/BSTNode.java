package main.trees;

public class BSTNode<T> {
    private T data;
    private BSTNode left;
    private BSTNode right;
    private boolean isVisited;

    public BSTNode(T data) {
        this.data = data;
        left = right = null;
    }

    public T getData() { return data; }

    public void setLeft(BSTNode parent, BSTNode left) {
        parent.left = left;
    }

    public void setLeft(BSTNode left) {
        this.left = left;
    }

    public BSTNode getLeft() { return  left;}

    public void setRight(BSTNode parent, BSTNode right) {
        parent.right = right;
    }

    public void setRight(BSTNode right) {
        this.right = right;
    }

    public BSTNode getRight() {return right;}

    public void setVisited(boolean visited) {
        isVisited = visited;
    }

    public boolean isVisited() {
        return isVisited;
    }
}
