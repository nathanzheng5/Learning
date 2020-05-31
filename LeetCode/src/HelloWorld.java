import java.util.PriorityQueue;

public class HelloWorld {
    public static void main(String[] args) {
        PriorityQueue<Integer> q = new PriorityQueue<>();
        q.offer(1);
        q.offer(3);
        q.offer(2);
        q.offer(5);
        q.offer(4);
        Integer entry = q.poll();
        while (entry != null) {
            System.out.println(entry);
            entry = q.poll();
        }
    }
}
