import java.util.*;
class Node{
    int data;
    Node next;
    public Node(int d){
        data=d;
        next=null;
    }
}
public class singleLinkedList{
    Node hptr=null;
    void append(int d){
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
    void deleteDuplicates() {
        List<Integer> ls=new ArrayList<>();
        Node temp=hptr;
        while(temp.next!=null){
            if(temp.next.data==temp.data){
                ls.add(temp.data);
                temp.next=temp.next.next;
            }else{
                temp=temp.next;
            }
        }
        for(int i:ls){
            int ele=i;
            if(hptr.data==ele){
                hptr=hptr.next;
            }else{
                Node temp1=hptr;
                if(temp1!=null && temp1.next.data!=ele){
                    temp1=temp1.next;
                }else{
                temp1.next=temp1.next.next;}
            }
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
        singleLinkedList s=new singleLinkedList();
        System.out.print("Enter size : ");
        int n=sc.nextInt();
        for(int i=0;i<n;i++){
            s.append(sc.nextInt());
        }
        s.deleteDuplicates();
        s.display();
    }
}