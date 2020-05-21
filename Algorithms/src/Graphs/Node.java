package Graphs;

import java.util.ArrayList;
import java.util.List;

public class Node {
    final String value;
    List<Node> neighbors = new ArrayList<>();

    public Node(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}
