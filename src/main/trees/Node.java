package main.trees;

import java.util.ArrayList;

// Tree Node
public class Node<T extends Comparable<T>> implements Comparable<Node<T>> {
    private T data;
    private boolean visited;
    private ArrayList<Node> children;

    public Node(T data) {
        this.data = data;
        children = null;
    }

    public void addChild(Node parent, Node child) {
        if (parent.children == null) {
            parent.children = new ArrayList();
        }
        parent.children.add(child);
    }

    public void addChildren(Node parent, Node[] children) {
        for (Node child : children) {
            addChild(parent, child);
        }
    }

    public void addChildren(Node[] children) {
        addChildren(this, children);
    }

    public T getData() {
        return data;
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    public ArrayList<Node> getChildren() {
        return children;
    }

    @Override
    public int compareTo(Node<T> o) {
        return data.compareTo(o.data);
    }
}
