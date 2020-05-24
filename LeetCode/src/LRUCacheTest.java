import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LRUCacheTest {

    @Test
    public void test() {
        int MAX_SIZE = 10;
        LRUCache cache1 = new LRUCache(MAX_SIZE);
        long start1 = System.currentTimeMillis();
        for (int i = 0; i < 1e8; i++) {
            cache1.put(i, i);
            assertEquals(i, cache1.get(i));
        }
        System.out.println("cache 1 takes " + (System.currentTimeMillis() - start1));

        LRUCache2 cache2 = new LRUCache2(MAX_SIZE);
        long start2 = System.currentTimeMillis();
        for (int i = 0; i < 1e8; i++) {
            cache2.put(i, i);
            assertEquals(i, cache2.get(i));
        }
        System.out.println("cache 2 takes " + (System.currentTimeMillis() - start2));
    }

}
