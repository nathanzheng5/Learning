package Graphs;

import java.util.ArrayList;
import java.util.List;

public class BSTNode extends BTNode {

    public BSTNode(int value) {
        super(value);
    }

    public void insert(int value) {
        if (value < this.value) {
            if (left == null) {
                left = new BSTNode(value);
            } else {
                left.insert(value);
            }
        } else {
            if (right == null) {
                right = new BSTNode(value);
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
        BSTNode current = this;
        while (current.left != null) {
            current = current.left;
        }
        return current.value;
    }

    public int maxValue() {
        BSTNode current = this;
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

    public BSTNode LCA(int n1, int n2) {
        if (value > n1 && value > n2) {
            return left != null ? left.LCA(n1, n2) : null;
        }
        if (value < n1 && value < n2) {
            return right != null ? right.LCA(n1, n2) : null;
        }
        return this;
    }

    public BSTNode convertToBalanced() {
        List<BSTNode> orderedNodes = new ArrayList<>();
        collectNodes(orderedNodes);
        return build(orderedNodes, 0, orderedNodes.size() - 1);
    }

    private BSTNode build(List<BSTNode> list, int startI, int endI) {
        if (startI > endI) {
            return null;
        }
        int midI = (startI + endI) / 2;
        BSTNode root = list.get(midI);
        root.left = build(list, startI, midI - 1);
        root.right = build(list, midI + 1, endI);
        return root;
    }

    private void collectNodes(List<BSTNode> list) {
        if (left != null) {
            left.collectNodes(list);
        }
        list.add(this);
        if (right != null) {
            right.collectNodes(list);
        }
    }


}
