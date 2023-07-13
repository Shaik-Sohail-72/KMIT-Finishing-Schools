/*
Write a Java program that prompts the user to enter the size of the doubly linked list and the elements of the list. The program then constructs the doubly linked list based on the user input.

Next, the program displays the elements of the doubly linked list in both forward and backward directions.
Test Case 1:

Input:
Enter the size: 5
Enter the elements: 10 20 30 40 50

Expected Output:
Doubly linked list in forward direction:
10 20 30 40 50
Doubly linked list in backward direction:
50 40 30 20 10

Test Case 2:

Input:
Enter the size: 3
Enter the elements: 1 2 3

Expected Output:
Doubly linked list in forward direction:
1 2 3
Doubly linked list in backward direction:
3 2 1*/
import java.util.Scanner;
class Node {
    int data;
    Node next;
    Node prev;
    public Node(int d) {
        data = d;
        next = null;
        prev = null;
    }
}
class DLL_forward_backward {
    static Node hptr = null;
    static Node tptr = null;

    public static void append(int d) {
        if (hptr == null) {
            Node temp = new Node(d);
            hptr = tptr = temp;
        } else {
            Node temp = hptr;
            while (temp.next != null) {
                temp = temp.next;
            }
            Node nptr = new Node(d);
            temp.next = nptr;
            nptr.prev = temp;
            tptr = nptr;
        }
    }

    public static void forwardDisplay(Node hptr) {
        Node temp = hptr;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static void backwardDisplay(Node tptr) {
        Node temp = tptr;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.prev;
        }
        System.out.println();
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size");
        int n = sc.nextInt();
        System.out.println("Enter the elements");
        for (int i = 0; i < n; i++) {
            int ele = sc.nextInt();
            append(ele);
        }

        System.out.println("Doubly linked list in forward direction: ");
        forwardDisplay(hptr);

        System.out.println("Doubly linked list in backward direction: ");
        backwardDisplay(tptr);
    }
}
