package Graphs.BST;

import java.util.ArrayList;
import java.util.List;

class Node {
    public final int value;
    public Node left;
    public Node right;

    public Node(int value) {
        this.value = value;
    }

    public void insert(int value) {
        if (value < this.value) {
            if (left == null) {
                left = new Node(value);
            } else {
                left.insert(value);
            }
        } else {
            if (right == null) {
                right = new Node(value);
            } else {
                right.insert(value);
            }
        }
    }

    public void traverse() {
        if (left != null) {
            left.traverse();
        }
        System.out.println(value);
        if (right != null) {
            right.traverse();
        }
    }

    public int minValue() {
        Node current = this;
        while (current.left != null) {
            current = current.left;
        }
        return current.value;
    }

    public int maxValue() {
        Node current = this;
        while (current.right != null) {
            current = current.right;
        }
        return current.value;
    }

    public boolean contains(int value) {
        if (value == this.value) {
            return true;
        } else if (value < this.value) {
            if (left == null) {
                return false;
            } else {
                return left.contains(value);
            }
        } else {
            if (right == null) {
                return false;
            } else {
                return right.contains(value);
            }
        }
    }

    public Node LCA(int n1, int n2) {
        if (value > n1 && value > n2) {
            return left != null ? left.LCA(n1, n2) : null;
        }
        if (value < n1 && value < n2) {
            return right != null ? right.LCA(n1, n2) : null;
        }
        return this;
    }

    public Node convertToBalanced() {
        List<Node> orderedNodes = new ArrayList<>();
        collectNodes(orderedNodes);
        return build(orderedNodes, 0, orderedNodes.size() - 1);
    }

    private Node build(List<Node> list, int startI, int endI) {
        if (startI > endI) {
            return null;
        }
        int midI = (startI + endI) / 2;
        Node root = list.get(midI);
        root.left = build(list, startI, midI - 1);
        root.right = build(list, midI + 1, endI);
        return root;
    }

    private void collectNodes(List<Node> list) {
        if (left != null) {
            left.collectNodes(list);
        }
        list.add(this);
        if (right != null) {
            right.collectNodes(list);
        }
    }


}
