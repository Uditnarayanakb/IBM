class Doubly_linked_list{
    public static void main(String []args){
        Node head = new Node(10);
        Node node2 = new Node(20);
        Node node3 = new Node(30);
        head.next = node2;
        node2.next = node3;
        node2.prev = head;

        
        
    }
}

class Node{
    int data;
    Node prev;
    Node next;

    Node(int data){
        this.data = data;
        this.next = null;
        this.prev = null;
    }
}