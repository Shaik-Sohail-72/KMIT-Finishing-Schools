
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
class DLL_reverse_ksize {
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
    public static void revDisplay(Node tptr) {
        Node temp = tptr;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.prev;
        }
        System.out.println();
    }

    public static Node  reverse(Node hptr, int k) {
        Node current = hptr;
        Node newHead = null;
        Node newTail = null;

        // Reverse first k nodes of the doubly linked list
        int count = 0;
        while (current != null && count < k) {
            Node nextNode = current.next;

            // Reverse the links of the current node
            current.next = current.prev;
            current.prev = nextNode;

            // Update the new head and tail pointers
            newHead = current;
            newTail = hptr;

            // Move to the next node
            hptr = current;
            current = nextNode;

            count++;
        }

        // Update the links for the rest of the list
        if (current != null) {
            tptr.next = current;
            current.prev = tptr;
        } else {
            tptr.next = null;
        }

        // Update the new tail pointer
        tptr = newTail;
        return tptr;
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
        System.out.println("Enter k size");
        int k=sc.nextInt();
        Node nhptr=reverse(hptr,k);
        System.out.println("New double linked list with reverse groups");
        forwardDisplay(nhptr);
        revDisplay(nhptr);

    }
}
