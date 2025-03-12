package SingleLinkedListDelete;
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

    // Hapus node di awal
    public void deleteHead() {
        if (head == null) return;
        head = head.next;
    }

    // Hapus node di akhir
    public void deleteTail() {
        if (head == null || head.next == null) {
            head = null;
            return;
        }
        Node temp = head;
        while (temp.next.next != null) {
            temp = temp.next;
        }
        temp.next = null;
    }

    // Hapus node tertentu
    public void deleteNode(int key) {
        if (head == null) return;

        if (head.data == key) {
            head = head.next;
            return;
        }

        Node temp = head;
        Node prev = null;

        while (temp != null && temp.data != key) {
            prev = temp;
            temp = temp.next;
        }

        if (temp == null) return;

        prev.next = temp.next;
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

public class Delete {
    public static void main(String[] args) {
        SingleLinkedList list = new SingleLinkedList();
        list.insertAtEnd(10);
        list.insertAtEnd(20);
        list.insertAtEnd(30);
        list.insertAtEnd(40);
        list.display(); // Output: 10 -> 20 -> 30 -> 40 -> null

        list.deleteHead();
        list.display(); // Output: 20 -> 30 -> 40 -> null

        list.deleteTail();
        list.display(); // Output: 20 -> 30 -> null

        list.deleteNode(30);
        list.display(); // Output: 20 -> null
    }
}
