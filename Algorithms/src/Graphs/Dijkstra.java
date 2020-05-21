package Graphs;

import org.junit.Test;

import java.util.*;

public class Dijkstra {

    @Test
    public void test() {
        NodeMap nodeMap = new NodeMap();
        Node a = new Node("a");
        nodeMap.addNode(a);
        Node b = new Node("b");
        nodeMap.addNode(b);
        Node c = new Node("c");
        nodeMap.addNode(c);
        Node d = new Node("d");
        nodeMap.addNode(d);
        Node e = new Node("e");
        nodeMap.addNode(e);
        Node f = new Node("f");
        nodeMap.addNode(f);
        Node g = new Node("g");
        nodeMap.addNode(g);

        nodeMap.addDistance(a, f, 14);
        nodeMap.addDistance(a, c, 9);
        nodeMap.addDistance(a, b, 7);
        nodeMap.addDistance(b, c, 10);
        nodeMap.addDistance(c, f, 2);
        nodeMap.addDistance(b, d, 15);
        nodeMap.addDistance(c, d, 11);
        nodeMap.addDistance(f, e, 9);
        nodeMap.addDistance(d, e, 5);

        List<Node> path = dijkstra(nodeMap, a, e);
        System.out.println(path);
        path = dijkstra(nodeMap, e, a);
        System.out.println(path);
        path = dijkstra(nodeMap, a, d);
        System.out.println(path);
        path = dijkstra(nodeMap, a, f);
        System.out.println(path);
        path = dijkstra(nodeMap, b, e);
        System.out.println(path);
        path = dijkstra(nodeMap, a, g);
        System.out.println(path);
        path = dijkstra(nodeMap, a, a);
        System.out.println(path);

    }

    private List<Node> dijkstra(NodeMap graph, Node start, Node target) {
        Set<Node> unvisited = new HashSet<>();
        Map<Node, Integer> dist = new HashMap<>();
        Map<Node, Node> prevMap = new HashMap<>();
        graph.allNodes().forEach(node -> {
            unvisited.add(node);
            dist.put(node, Integer.MAX_VALUE);
        });

        dist.put(start, 0);
        Node current = start;
        while (!unvisited.isEmpty()) {
            // calculate tentative distances for unvisited neighbors
            for (Node neighbor : current.neighbors) {
                if (!unvisited.contains(neighbor)) {
                    continue;
                }
                int d = dist.get(current) + graph.distanceBetween(current, neighbor);
                if (d < dist.get(neighbor)) {
                    dist.put(neighbor, d);
                    prevMap.put(neighbor, current);
                }
            }

            // mark current as visited
            unvisited.remove(current);

            // set current to the unvisited node with the min tentative distance
            int minD = Integer.MAX_VALUE;
            for (Node unvisitedNode : unvisited) {
                Integer d = dist.get(unvisitedNode);
                if (d < minD) {
                    minD = d;
                    current = unvisitedNode;
                }
            }

            if (current == target || minD == Integer.MAX_VALUE) {
                break;
            }
        }

        // construct output path
        List<Node> retVal = new ArrayList<>();
        Node node = target;
        while (node != null) {
            retVal.add(node);
            node = prevMap.get(node);
        }
        Collections.reverse(retVal);
        if (retVal.get(0) == start) {
            return retVal;
        } else {
            return Collections.emptyList();
        }
    }
}
