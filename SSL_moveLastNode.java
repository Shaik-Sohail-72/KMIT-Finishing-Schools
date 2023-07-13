/*Write a function that moves the last node to the front in a given Singly Linked List.

Examples:

Input: 1->2->3->4->5
Output: 5->1->2->3->4

Input: 3->8->1->5->7->12
Output: 12->3->8->1->5->7  */

import java.util.*;
class Node{
    int data;
    Node next;
    public Node(int d){
        data=d;
        next=null;
    }
}
class SSL_moveLastNode{
    static Node hptr=null;
    public static void append(int d){
        if(hptr==null){
            Node temp=new Node(d);
            hptr=temp;
        }else{
            Node temp=hptr;
            while(temp.next!=null){
                temp=temp.next;
            }
            Node nptr=new Node(d);
            temp.next=nptr;
        }
    }
    public static void display(){
        Node temp=hptr;
        while(temp!=null){
            System.out.print(temp.data+" ");
            temp=temp.next;
        }
    }
    public static void moveLastNodeToFront() {
        if (hptr.next == null) {
            return;
        }
        Node curr = hptr;
        Node secondLastNode = null;
        while (curr.next != null) {
            secondLastNode = curr;
            curr = curr.next;
        }
        secondLastNode.next = null;
        curr.next = hptr;
        hptr = curr;
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter size : ");
        int n=sc.nextInt();
        for(int i=0;i<n;i++){
            int ele=sc.nextInt();
            append(ele);
        }
        System.out.println("\nLInked list");
        display();
        moveLastNodeToFront();
        System.out.println("\nList after moving the last node to the front:");
        display();
    }
}