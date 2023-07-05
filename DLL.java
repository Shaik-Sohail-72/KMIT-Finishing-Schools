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

class DLL {
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

    public static void display(Node hptr, Node tptr) {
        Node temp = hptr;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static void twoSum(Node hptr, int x) {
        Node left = hptr;
        Node right = tptr;

        while (left != right && right.next != left) {
            int sum = left.data + right.data;

            if (sum == x) {
                System.out.println("(" + right.data + ", " + left.data + ")");
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

        System.out.println("Enter the value of x");
        int x = sc.nextInt();

        System.out.println("Doubly linked list: ");
        display(hptr, tptr);

        System.out.println("Pairs with sum equal to " + x + ":");
        twoSum(hptr, x);
    }
}
