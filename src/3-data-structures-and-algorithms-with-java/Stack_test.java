
import java.util.Deque;
import java.util.ArrayDeque;
public class Stack_test {
    public static void main(String[] args) {
        Deque <String> stack = new ArrayDeque<>();

        stack.push("Sukanta");
        stack.push("Vaishni");

        System.out.println("Stack Top: "+stack.peek());

        stack.push("Anurag");
        String popped_value = stack.pop();
        System.out.println("Popped Value: "+popped_value);
        System.out.println("Stack Top: "+ stack.peek());
        System.out.println("This person is always on top.");
    }
}
