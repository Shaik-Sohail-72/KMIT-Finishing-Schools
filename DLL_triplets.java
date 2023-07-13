/*Given a sorted doubly linked list of distinct nodes(no two nodes have the same data) and a value x. Count triplets in the list that sum up to a given value x.

Examples:

Input : DLL: 1 <-> 2 <-> 4 <-> 5 <-> 6 <-> 8 <-> 9
x=17
Output : 2
The triplets are :
(2, 6, 9) and (4 , 5, 8)

Input : DLL: 1 <-> 2 <-> 4 <-> 5 <-> 6 <-> 8 <-> 9
x=15
Output : 5*/
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
class DLL_triplets {
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

    public static int countTriplets(Node hptr, int x) {
        Node current = hptr;
        int count = 0;
        while (current != null) {
            Node left = current.next;
            Node right = tptr;
            while (left.data<right.data) {
                int sum = current.data + left.data + right.data;

                if (sum == x) {
                    count++;
                    left = left.next;
                    right = right.prev;
                } else if (sum < x) {
                    left = left.next;
                } else {
                    right = right.prev;
                }
            }
            current = current.next;
        }
        return count;
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


        System.out.println("Enter the value of X");
        int x = sc.nextInt();

        System.out.println("Doubly linked list in forward direction: ");
        forwardDisplay(hptr);


        int tripletCount = countTriplets(hptr, x);
        System.out.println("Number of triplets with sum equal to " + x + ": " + tripletCount);
    }
}
