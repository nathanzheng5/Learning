import java.util.HashMap;
import java.util.Map;

public class LRUCache {

    Node head;
    Node tail;
    final Map<Integer, Node> map = new HashMap<>();
    final int MAX_SIZE;

    public LRUCache(int MAX_SIZE) {
        this.MAX_SIZE = MAX_SIZE;
    }

    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }

        Node node = map.get(key);
        removeNode(node);
        offerNode(node);

        return node.value;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            node.value = value;

            removeNode(node);
            offerNode(node);

        } else {
            if (map.size() >= MAX_SIZE) {
                if (head != null) {
                    map.remove(head.key);
                    removeNode(head);
                }
            }

            Node node = new Node(key, value);
            offerNode(node);
            map.put(key, node);
        }
    }

    private void offerNode(Node node) {

        node.prev = tail;
        if (tail != null) {
            tail.next = node;
        }
        node.next = null;
        tail = node;

        if (head == null) {
            head = node;
        }
    }

    private void removeNode(Node node) {
        if (node.prev != null) {
            node.prev.next = node.next;
        } else {
            head = node.next;
        }

        if (node.next != null) {
            node.next.prev = node.prev;
        } else {
            tail = node.prev;
        }
    }

    class Node {
        final int key;
        int value;
        Node prev;
        Node next;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }


}
