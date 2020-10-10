package main.trees.graph;

import main.StackAndQueue.Queue;
import main.trees.Node;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Route Between Nodes: Given a directed graph, design an algorithm to find out whether there is a
 * route between two nodes.
 */
public class Route {
    ArrayList<Node> route;

    public Route() {
        route = new ArrayList<Node>();
    }

    public ArrayList<Node> calculateRouteBFS(Graph graph, Node start, Node finish) {
        Queue<Node> queue = new Queue<Node>();
        ArrayList<Node> path = new ArrayList<Node>();
        queue.add(start);
        while (!queue.isEmpty()) {
            Node n = queue.remove();
            path.add(n);
            if(n == finish) {
                return calcualtePath(graph, path, finish);
            }
            if(n.getChildren() == null){
                path.remove(n);
                continue;
            }
            Iterator itr = n.getChildren().iterator();
            while (itr.hasNext()) {
                queue.add((Node)itr.next());
            }

        }
        return null;
    }

    //Use Bi-directional search to calcualte the path.
    public void CalcualteRouteBidirectionSearch(Graph graph, Node start, Node finish) {

    }

    private ArrayList<Node> calcualtePath(Graph graph, ArrayList<Node> possiblePath, Node finish) {
        ArrayList<Node> path = possiblePath;
        Iterator<Node> itr = path.iterator();
        while (itr.hasNext()) {
            Node n = (Node)itr.next();
            if(n != finish && n.getChildren() == null) {
                itr.remove();
            }
            graph.dfs(n);
            if(!graph.getVistedArray().contains(finish.getData())) {
                itr.remove();
            }
            graph.clearVisitedArray();
            graph.clearVisitedNodes(n);
        }
        return path;
    }
}
