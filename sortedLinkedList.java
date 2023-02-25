import java.util.*;
class Node{
    int data;
    Node next;
    public Node(int d){
        data=d;
        next=null;
    }
}
public class sortedLinkedList{
    Node hptr=null;
    void append(int d){
        
        if(hptr==null){
            Node temp=new Node(d);
            hptr=temp;
        }else{
            Node temp=hptr;
            Node nptr=new Node(d);
            while(temp.next!=null && temp.next.data<nptr.data){
                temp=temp.next;
            }
            nptr.next=temp.next;
            temp.next=nptr;
        }
    }
    void display(){
        System.out.println("Data : ");
        Node temp=hptr;
        while(temp!=null){
            System.out.print(temp.data+" ");
            temp=temp.next;
        }
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        sortedLinkedList s=new sortedLinkedList();
        System.out.print("Enter size : ");
        int n=sc.nextInt();
        for(int i=0;i<n;i++){
            s.append(sc.nextInt());
        }
        s.display();
    }
}