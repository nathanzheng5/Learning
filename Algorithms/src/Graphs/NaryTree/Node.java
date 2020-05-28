package Graphs.NaryTree;

import java.util.ArrayList;
import java.util.List;

class Node {

    final String value;
    List<Node> children = new ArrayList<>();

    public Node(String value) {
        this.value = value;
    }

    public void addChild(Node node) {
        children.add(node);
    }

    @Override
    public String toString() {
        return value;
    }
}
