package Graphs;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class NodeMap {
    Map<Node, Map<Node, Integer>> distanceMap = new HashMap<>();

    void addNode(Node node) {
        distanceMap.put(node, new HashMap<>());
    }

    void addDistance(Node node1, Node node2, int distance) {
        node1.neighbors.add(node2);
        node2.neighbors.add(node1);
        distanceMap.get(node1).put(node2, distance);
        distanceMap.get(node2).put(node1, distance);
    }

    int distanceBetween(Node node1, Node node2) {
        assert distanceMap.containsKey(node1);
        assert distanceMap.get(node1).containsKey(node2);
        return distanceMap.get(node1).get(node2);
    }

    Set<Node> allNodes() {
        return distanceMap.keySet();
    }

}
