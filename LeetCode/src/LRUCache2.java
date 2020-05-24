import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCache2 {

    final int MAX_SIZE;
    Map<Integer, Node> map;

    public LRUCache2(int MAX_SIZE) {
        this.MAX_SIZE = MAX_SIZE;
        map = new LinkedHashMap<Integer, Node>() {
            @Override
            protected boolean removeEldestEntry(Map.Entry eldest) {
                return map.size() > MAX_SIZE;
            }
        };
    }

    public int get(int key) {
        Node node = map.get(key);
        if (node == null) {
            return -1;
        }
        map.remove(node.key);
        map.put(node.key, node);
        return node.value;
    }

    public void put(int key, int value) {
        Node node = new Node(key, value);
        map.put(key, node);
    }

    class Node {
        final int key;
        final int value;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
}
