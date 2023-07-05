import java.util.Scanner;

class Node {
    int data;
    Node prev;
    Node next;

    Node(int data) {
        this.data = data;
        this.prev = null;
        this.next = null;
    }
}

public class DoublyLinkedList {
    private Node head;
    private Node tail;

    public DoublyLinkedList() {
        head = null;
        tail = null;
    }

    public void insert(int data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
    }

    public void display() {
        Node current = head;

        if (current == null) {
            System.out.println("Doubly linked list is empty.");
            return;
        }

        System.out.print("Doubly linked list: ");

        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }

        System.out.println();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DoublyLinkedList doublyLinkedList = new DoublyLinkedList();

        System.out.println("Enter positive numbers (enter -1 to stop): ");

        while (true) {
            int number = scanner.nextInt();

            if (number == -1) {
                break;
            }

            doublyLinkedList.insert(number);
        }

        doublyLinkedList.display();
    }
}
