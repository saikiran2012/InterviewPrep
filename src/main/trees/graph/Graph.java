package main.trees.graph;

import main.StackAndQueue.Queue;
import main.trees.Node;

import java.util.ArrayList;
import java.util.Iterator;

public class Graph<T extends Comparable<T>> {
    private Node[] nodes;
    ArrayList<T> vistedArray;

    public Graph(int disjointedGraphCount) {
        nodes = new Node[disjointedGraphCount];
        vistedArray = new ArrayList<T>();
    }
    public void intialize(Node[] nodes) {
        this.nodes = nodes;
    }

    public void addNode(Node vertex, Node[] adjacent) {
        for (Node node : nodes) {
            if(node == vertex) {
                node.addChildren(node, adjacent);
                return;
            }
            addChildren(vertex, adjacent, node);
        }
    }

    private void addChildren(Node vertex, Node[] adjacent, Node node) {
        ArrayList children = node.getChildren();
        Iterator itr = children.iterator();
        while (itr.hasNext()) {
            Node n = (Node)itr.next();
            if(n.compareTo(vertex) == 0){
                n.addChildren(adjacent);
                return;
            }
            if(n.getChildren() != null) {
                addChildren(vertex, adjacent, n);
            }
        }
    }

    public Node createFirstVertex(T data) {
        Node node = new Node(data);
        nodes[0] = node;
        return node;
    }

    public Node getRoot(int i) {
        return nodes[i];
    }

    public void dfs(Node root) {
        if (root == null || root.isVisited()) return;
        visit(root);
        root.setVisited(true);
        if(root.getChildren() == null) return;
        ArrayList<Node> children = root.getChildren();
        Iterator<Node> itr = children.iterator();
        while (itr.hasNext()) {
            Node n = itr.next();
            if(!n.isVisited()) {
                dfs(n);
            }
        }
    }

    private void visit(Node root) {
        vistedArray.add((T)root.getData());
    }

    public ArrayList<T> getVistedArray() {
        return vistedArray;
    }

    public void clearVisitedArray() {
        vistedArray = new ArrayList<T>();
    }

    public void clearVisitedNodes(Node root) {
        if (root == null) return;
        root.setVisited(false);
        if(root.getChildren() == null) return;
        ArrayList<Node> children = root.getChildren();
        Iterator<Node> itr = children.iterator();
        while (itr.hasNext()) {
            Node n = itr.next();
            if(n.isVisited()) {
                clearVisitedNodes(n);
            }
        }
    }

    public void bfs() {
        Queue<Node> queue = new Queue<Node>();
        for(Node n: nodes) {
            queue.add(n);
        }

        while (!queue.isEmpty()) {
            Node n = queue.remove();
            n.setVisited(true);
            visit(n);
            ArrayList<Node> children = n.getChildren();
            if(children == null) continue;
            Iterator<Node> itr = children.iterator();
            while (itr.hasNext()) {
                queue.add(itr.next());
            }
        }
    }
}
