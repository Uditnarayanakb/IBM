import java.util.LinkedList;
import java.util.Queue;

public class Queue_test {
    public static void main(String[] args) {
        Queue <String> queue = new LinkedList<>();

        queue.offer("Suku");
        queue.offer("Vaishni");

        System.out.println(queue.peek());
        System.out.println(queue.poll());
        System.out.println(queue.peek());
    }
}
