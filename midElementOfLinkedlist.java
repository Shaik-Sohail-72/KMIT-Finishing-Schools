import java.util.*;
class Node{
    int data;
    Node next;
    public Node(int d){
        data=d;
        next=null;
    }
}
public class midElementOfLinkedlist{
    Node hptr=null;
    void append(int d){
        Node nptr=new Node(d);
        if(hptr==null){
            hptr=nptr;
        }else{
            Node temp=hptr;
            while(temp.next!=null){
                temp=temp.next;
            }
            temp.next=nptr;
        }
    }
	int c=0;
    void display(){
        System.out.println("Data : ");
        Node temp=hptr;
        while(temp!=null){
            System.out.print(temp.data+" ");
			c++;
            temp=temp.next;
        }
    }
	void midele(){
		Node temp=hptr;
		for(int i=0;i<c/2;i++){
			temp=temp.next;
		}
		System.out.println("\nmid element : "+temp.data);
	}
	void midele_slowfast(){
		Node fastptr=hptr;
		Node slowptr=hptr;
		while(fastptr!=null && fastptr.next!=null){
			fastptr=fastptr.next.next;
			slowptr=slowptr.next;
		}
		System.out.println("mid ele using slowfast pointer : "+slowptr.data);
	}
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        midElementOfLinkedlist s=new midElementOfLinkedlist();
        System.out.print("Enter size : ");
        int n=sc.nextInt();
        for(int i=0;i<n;i++){
            s.append(sc.nextInt());
        }
        s.display();
		s.midele();
		s.midele_slowfast();
    }
}