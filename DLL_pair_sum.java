/*Given a sorted doubly linked list of positive distinct elements, the task is to find pairs in a doubly-linked list whose sum is equal to given value x, without using any extra space? 

Example:  

Input : head : 1 <-> 2 <-> 4 <-> 5 <-> 6 <-> 8 <-> 9
        x = 7
Output: (1, 6), (2, 5)
The expected time complexity is O(n) and auxiliary space is O(1).*/

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
class DLL_pair_sum {
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

    public static void findPairs(Node hptr, int x) {
        Node left = hptr;
        Node right = tptr;
        while (left.data<right.data) {
            int sum = left.data + right.data;

            if (sum == x) {
                System.out.println("(" + left.data + ", " + right.data + ")");
                left = left.next;
                right = right.prev;
            } else if (sum < x) {
                left = left.next;
            } else {
                right = right.prev;
            }
        }
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

        System.out.println("Enter the value of X for pair sum");
        int x1 = sc.nextInt();


        System.out.println("Doubly linked list in forward direction: ");
        forwardDisplay(hptr);


        System.out.println("Pairs with sum equal to " + x1 + ":");
        findPairs(hptr, x1);
    }
}
