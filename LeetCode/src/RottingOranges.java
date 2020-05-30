import java.util.*;

public class RottingOranges {

    public static void main(String[] args) {
        int[][] grid = {{0,0,1,2},{2,0,1,1}};
        int i = new RottingOranges().orangesRotting(grid);
        System.out.println(i);
    }

    public int orangesRotting(int[][] grid) {
        Map<Coordinate, Node> graph = buildGraph(grid);
        if (graph.isEmpty()) {
            return 0;
        }
        List<Node> freshNodes = new ArrayList<>();
        List<Node> rottenNodes = new ArrayList<>();
        graph.values().forEach(node -> {
            if (node.rotten) {
                rottenNodes.add(node);
            } else {
                freshNodes.add(node);
            }
        });
        if (freshNodes.isEmpty()) {
            return 0;
        }
        if (rottenNodes.isEmpty()) {
            return -1;
        }
        int maxSteps = 0;
        for (Node node : graph.values()) {
            if (!node.rotten) {
                int steps = bfs(node);
                if (steps < 0) {
                    return -1;
                }
                if (steps > maxSteps) {
                    maxSteps = steps;
                }
            }
        }
        return maxSteps;
    }

    private int bfs(Node node) {
        Map<Node, Integer> levels = new HashMap<>();
        Queue<Node> queue = new LinkedList<>();
        queue.add(node);
        levels.put(node, 0);
        Set<Node> visited = new HashSet<>();
        Node foundNode = null;
        while (!queue.isEmpty()) {
            Node current = queue.poll();
            visited.add(current);
            if (current.rotten) {
                foundNode = current;
                break;
            }
            current.neighbors.stream().filter(neighbor -> !visited.contains(neighbor)).forEach(unvisitedNeighbor -> {
                queue.add(unvisitedNeighbor);
                levels.put(unvisitedNeighbor, levels.get(current) + 1);
            });
        }
        return foundNode != null ? levels.get(foundNode) : -1;
    }

    private Map<Coordinate, Node> buildGraph(int[][] grid) {
        Map<Coordinate, Node> graph = new LinkedHashMap<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                Coordinate coordinate = new Coordinate(i, j);
                Node node = graph.get(coordinate);
                if (node == null) {
                    int value = grid[i][j];
                    if (value > 0) {
                        node = new Node(value, coordinate);
                        graph.put(coordinate, node);
                    }
                }
                if (node != null) {
                    // search down
                    int x = i + 1;
                    int y = j;
                    if (x < grid.length && y < grid[x].length) {
                        int value = grid[x][y];
                        if (value > 0) {
                            Coordinate downCoordinate = new Coordinate(x, y);
                            Node downNode = graph.get(downCoordinate);
                            if (downNode == null) {
                                downNode = new Node(value, downCoordinate);
                                graph.put(downCoordinate, downNode);
                            }
                            node.neighbors.add(downNode);
                            downNode.neighbors.add(node);
                        }
                    }
                    // search right
                    x = i;
                    y = j + 1;
                    if (x < grid.length && y < grid[x].length) {
                        int value = grid[x][y];
                        if (value > 0) {
                            Coordinate rightCoordinate = new Coordinate(x, y);
                            Node rightNode = graph.get(rightCoordinate);
                            if (rightNode == null) {
                                rightNode = new Node(value, new Coordinate(x, y));
                                graph.put(new Coordinate(x, y), rightNode);
                            }
                            node.neighbors.add(rightNode);
                            rightNode.neighbors.add(node);
                        }
                    }
                }
            }
        }
        return graph;
    }

    private class Node {
        private final boolean rotten;
        private final Coordinate coordinate;
        private List<Node> neighbors = new ArrayList<>();

        public Node(int value, Coordinate coordinate) {
            this.rotten = value == 2;
            this.coordinate = coordinate;
        }

        @Override
        public String toString() {
            return "[" + coordinate.i + ", " + coordinate.j + "] " + (rotten ? "rotten" : "fresh");
        }
    }

    private class Coordinate {
        private final int i;
        private final int j;

        public Coordinate(int i, int j) {
            this.i = i;
            this.j = j;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o instanceof Coordinate) {
                Coordinate that = (Coordinate) o;
                return this.i == that.i && this.j == that.j;
            }
            return false;
        }

        @Override
        public int hashCode() {
            return Objects.hash(i, j);
        }

        List<Coordinate> getNeighbors(int MAX_I, int MAX_J) {
            List<Coordinate> retVal = new ArrayList<>();
            if (i - 1 >= 0) {
                retVal.add(new Coordinate(i - 1, j));
            }
            if (i + 1 <= MAX_I) {
                retVal.add(new Coordinate(i + 1, j));
            }
            if (j - 1 >= 0) {
                retVal.add(new Coordinate(i, j - 1));
            }
            if (j + 1 < MAX_J) {
                retVal.add(new Coordinate(i, j + 1));
            }
            return retVal;
        }
    }

}
