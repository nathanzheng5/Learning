package Cache;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class CacheTest {

    private static final int MAX_SIZE = 3;

    @Test
    public void test() {
        Cache cache = new Cache();
        // populate 3 entries
        System.out.println(cache.get(1));
        assertFalse(cache.lastHit);
        System.out.println(cache.get(2));
        assertFalse(cache.lastHit);
        System.out.println(cache.get(3));
        assertFalse(cache.lastHit);
        // get an existing entry
        System.out.println(cache.get(1));
        assertTrue(cache.lastHit);
        // get a new entry
        System.out.println(cache.get(4));
        assertFalse(cache.lastHit);
        // 1 was used after 2 or 3, so it should not have been evicted
        System.out.println(cache.get(1));
        assertTrue(cache.lastHit);
    }

    static class Cache {
        LinkedHashMap<Integer, Entry> cache = new LinkedHashMap<Integer, Entry>(MAX_SIZE) {
            @Override
            protected boolean removeEldestEntry(Map.Entry eldest) {
                return size() > MAX_SIZE;
            }
        };

        Store store = new Store();

        boolean lastHit = false;

        Entry get(int id) {
            if (cache.containsKey(id)) {
                System.out.println("hit");
                lastHit = true;

//                Entry entry = cache.get(id);
//                cache.remove(entry.id);
//                cache.put(entry.id, entry);
//                return entry;

                return cache.get(id);
            } else  {
                System.out.println("miss");
                lastHit = false;
                Entry entry = store.get(id);
                cache.put(entry.id, entry);
                return entry;
            }
        }
    }

    static class Entry {
        final int id;
        final String value;

        public Entry(int id, String value) {
            this.id = id;
            this.value = value;
        }

        @Override
        public String toString() {
            return value;
        }
    }

    static class Store {
        Map<Integer, Entry> store = new HashMap<>();
        Store() {
            Entry entry = new Entry(1, "one");
            store.put(entry.id, entry);
            entry = new Entry(2, "two");
            store.put(entry.id, entry);
            entry = new Entry(3, "three");
            store.put(entry.id, entry);
            entry = new Entry(4, "four");
            store.put(entry.id, entry);
            entry = new Entry(5, "five");
            store.put(entry.id, entry);
            entry = new Entry(6, "six");
            store.put(entry.id, entry);
            entry = new Entry(7, "seven");
            store.put(entry.id, entry);
            entry = new Entry(8, "eight");
            store.put(entry.id, entry);
            entry = new Entry(9, "nine");
            store.put(entry.id, entry);
            entry = new Entry(10, "ten");
            store.put(entry.id, entry);
        }

        Entry get(int id) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ignore) {}

            return store.get(id);
        }
    }

}
