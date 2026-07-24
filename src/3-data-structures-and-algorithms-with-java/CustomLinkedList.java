public class CustomLinkedList {
    public static void main(String[] args) {

        Node head = new Node(10);

        // head.display_list();

        head.add_last(20);
        head.add_last(40);
        head.add_last(50);

        head.display_list();

        
    }
}

class Node{
    int data;
    Node next;

    Node(){

    }

    Node(int data){
        this.data = data;
        this.next = null;
    }

    void add_last(int data){
        Node temp = this;
        while(temp.next != null){
            temp = temp.next;
        }
        temp.next = new Node(data);
        return;
    }

    void display_list(){
        Node temp = this;
        while(temp != null){
            System.out.print(temp.data+" ");
            temp = temp.next;
        }
    }
}
