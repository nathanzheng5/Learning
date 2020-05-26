package Graphs.BT;

import java.util.ArrayList;
import java.util.List;

class Node {

    final int value;
    Node left;
    Node right;

    public Node(int value) {
        this.value = value;
    }

    public int maxDepth() {
        int leftDepth = left != null ? left.maxDepth() : 0;
        int rightDepth = right != null ? right.maxDepth() : 0;
        return Math.max(leftDepth, rightDepth) + 1;
    }

    public Node LCA(int t1, int t2) {
        if (value == t1 || value == t2) {
            return this;
        }
        Node leftLCA = left != null ? left.LCA(t1, t2) : null;
        Node rightLCA = right != null ? right.LCA(t1, t2) : null;
        if (leftLCA != null && rightLCA != null) {
            return this;
        }
        return leftLCA != null ? leftLCA : rightLCA;
    }

    public void printPaths() {
        List<Node> path = new ArrayList<>();
        printPaths(path);
    }

    private void printPaths(List<Node> path) {
        path.add(this);
        if (isLeaf()) {
            print(path);
        } else {
            if (left != null) {
                left.printPaths(path);
            }
            if (right != null) {
                right.printPaths(path);
            }
        }
        path.remove(this);
    }

    private static void print(List<Node> path) {
        StringBuilder sb = new StringBuilder("Path: ");
        path.forEach(node -> sb.append(node.value).append("->"));
        String pathString = sb.toString().trim();
        if (pathString.endsWith("->")) {
            pathString = pathString.substring(0, pathString.length() - 2);
        }
        System.out.println(pathString);
    }

    public boolean isLeaf() {
        return left == null && right == null;
    }

    public static boolean hasPathSum(Node node, int sum) {
        if (node == null) {
            return sum == 0;
        }
        int subSum = sum - node.value;
        return hasPathSum(node.left, subSum) || hasPathSum(node.right, subSum);
    }
}
