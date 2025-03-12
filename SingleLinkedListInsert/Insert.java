package SingleLinkedListInsert;

class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class SingleLinkedList {
    Node head;

    // Tambah di awal
    public void insertAtHead(int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
    }

    // Tambah di akhir
    public void insertAtEnd(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        }
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;
    }

    // Tambah di tengah (setelah node tertentu)
    public void insertAfter(int key, int data) {
        Node temp = head;
        while (temp != null && temp.data != key) {
            temp = temp.next;
        }
        if (temp == null) return;
        Node newNode = new Node(data);
        newNode.next = temp.next;
        temp.next = newNode;
    }

    // Tampilkan linked list
    public void display() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }
}

public class Insert {
    public static void main(String[] args) {
        SingleLinkedList list = new SingleLinkedList();
        list.insertAtEnd(10);
        list.insertAtEnd(20);
        list.insertAtEnd(30);
        list.display(); // Output: 10 -> 20 -> 30 -> null

        list.insertAtHead(5);
        list.display(); // Output: 5 -> 10 -> 20 -> 30 -> null

        list.insertAfter(20, 25);
        list.display(); // Output: 5 -> 10 -> 20 -> 25 -> 30 -> null
    }
}
