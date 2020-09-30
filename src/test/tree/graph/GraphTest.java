package test.tree.graph;

import main.trees.Node;
import main.trees.graph.Graph;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

public class GraphTest {
    Graph<String> graph;

    @Before
    public void intializeGraph() {
        graph = new Graph(1);
        Node n = graph.createFirstVertex("a");
        Node n1 = new Node("b");
        Node n12 = new Node("c");
        graph.addNode(n, new Node[] {n1, n12});
        Node n21 = new Node("d");
        graph.addNode(n12, new Node[] {n21});
        Node n31 = new Node("e");
        Node n32 = new Node("f");
        graph.addNode(n21, new Node[] {n31, n32});
        Node n22 = new Node("g");
        Node n23 = new Node("h");
        graph.addNode(n1, new Node[] {n22, n23});
        graph.clearVisitedArray();
    }

    @Test
    public void dfsTest() {
        graph.dfs(graph.getRoot(0));
        ArrayList dfs = graph.getVistedArray();
        Assert.assertEquals("a",dfs.get(0));
        Assert.assertEquals("b",dfs.get(1));
        Assert.assertEquals("g",dfs.get(2));
        Assert.assertEquals("h",dfs.get(3));
        Assert.assertEquals("c",dfs.get(4));
        Assert.assertEquals("d",dfs.get(5));
        Assert.assertEquals("e",dfs.get(6));
        Assert.assertEquals("f",dfs.get(7));
    }


    @Test
    public void bfsTest() {
        graph.bfs();
        ArrayList bfs = graph.getVistedArray();
        Assert.assertEquals("a",bfs.get(0));
        Assert.assertEquals("b",bfs.get(1));
        Assert.assertEquals("c",bfs.get(2));
        Assert.assertEquals("g",bfs.get(3));
        Assert.assertEquals("h",bfs.get(4));
        Assert.assertEquals("d",bfs.get(5));
        Assert.assertEquals("e",bfs.get(6));
        Assert.assertEquals("f",bfs.get(7));
    }
}
