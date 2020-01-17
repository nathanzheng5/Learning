package Graphs;

import java.util.ArrayList;
import java.util.List;

public class Node {
    private final int value;
    private final List<Node> edges;

    public Node(int value) {
        this.value = value;
        edges = new ArrayList<>();
    }

    public void addEdge(Node node) {
        edges.add(node);
    }

    public boolean removeEdge(Node node) {
        return edges.remove(node);
    }

    public void clearEdges(Node node) {
        edges.clear();
    }
}
