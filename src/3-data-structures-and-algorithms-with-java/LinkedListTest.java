
import java.util.LinkedList;

public class LinkedListTest {
    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<>();
        list.add("Sukanta");
        list.add("Vaishni");
        list.addFirst("Anurag");
        list.add("Shrishti");
        list.addLast("Sweta");

        for (String string : list) {
            System.out.println(string);
        }


        // list.add()

    }
}
