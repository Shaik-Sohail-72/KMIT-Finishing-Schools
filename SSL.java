import java.util.*;
class Node{
    int data;
    Node next;
    public Node(int d){
        data=d;
        next=null;
    }
}
class ssl{
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
    void display(){
        Node temp=hptr;
        while(temp!=null){
            System.out.print(temp.data+" ");
            temp=temp.next;
        }
    }
    void insertbeg(int dt){
        Node nptr=new Node(dt);
        nptr.next=hptr;
        hptr=nptr;
    }
    void insertpos(int d,int p){
        Node temp=hptr;
        Node nptr=new Node(d);
        for(int i=0;i<p-1;i++){
            temp=temp.next;
        }
        nptr.next=temp.next;
        temp.next=nptr;
    }
    void dltend(){
        Node temp=hptr;
        while(temp.next.next!=null){
            temp=temp.next;
        }
        temp.next=null;
    }
    void dltpos(int p){
        if(p==0){
            hptr=hptr.next;
        }else{
            Node temp=hptr;
            for(int i=0;i<p-1;i++){
                temp=temp.next;
            }
            temp.next=temp.next.next;
        }
    }
    void dltd(int d){
        if(hptr.data==d){
            hptr=hptr.next;
        }else{
            Node temp=hptr;
            while(temp!=null && temp.next.data!=d){
                temp=temp.next;
            }
            temp.next=temp.next.next;
        }
    }
    int len=0;
    void length(){
        Node temp=hptr;
        while(temp!=null){
            len++;
            temp=temp.next;
        }
        System.out.println("length : "+len);
    }
    void midele(){
        Node temp=hptr;
        for(int i=0;i<len/2;i++){
            temp=temp.next;
        }
        System.out.println("mid ele "+temp.data);
    }
    void mideleslowfast(){
        Node slow=hptr;
        Node fast=hptr;
        while(fast!=null && fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
        }
        System.out.println("mid ele "+slow.data);
    }
    void sum(){
        Node temp=hptr;
        int s=0;
        while(temp!=null){
            s+=temp.data;
            temp=temp.next;
        }
        System.out.println("sum "+s);
    }
    void sittingarng(){
        Node temp=hptr;
        System.out.println("\nalternate numbers ");
        while(temp!=null || temp.next!=null){
            System.out.print(temp.data+" ");
            temp=temp.next.next;
        }
    }
    void minmax(){
        Node temp=hptr;
        int min=Integer.MAX_VALUE;
        int max=Integer.MIN_VALUE;
        while(temp!=null){
            if(temp.data<min){
                min=temp.data;
            }
            if(temp.data>max){
                max=temp.data;
            }
            temp=temp.next;
        }
        System.out.println("\nmin : "+min+" max : "+max);
    }
    Node hptr1=null;
    void ascinsert(int d){
        Node nptr=new Node(d);
        if(hptr1==null){
            hptr1=nptr;
        }else if(hptr1.data>d){
            nptr.next=hptr1;
            hptr1=nptr;
        }else{
            Node temp=hptr1;
            while(temp.next!=null && temp.next.data<nptr.data){
                temp=temp.next;
            }
            nptr.next=temp.next;
            temp.next=nptr;
        }
    }
    void display1(){
        Node temp=hptr1;
        System.out.println("data in increasing order");
        while(temp!=null){
            System.out.print(temp.data+" ");
            temp=temp.next;
        }
    }
    void search(int s){
        if(hptr.data==s){
            System.out.println("element found at index 0");
        }else{
            int c=0;
            int f=0;
            Node temp=hptr;
            while(temp!=null){
                if(temp.data==s){
                    f=1;
                    break;
                }else{
                    temp=temp.next;
                    c++;
                }
            }
            if(f==0){
                System.out.println("ele not found");
            }else{
                System.out.println("ele found at "+c);
            }
        }
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter size : ");
        int n=sc.nextInt();
        ssl s=new ssl();
        for(int i=0;i<n;i++){
            int ele=sc.nextInt();
            s.append(ele);
        }
        //s.display();
        //s.append(2854);
        //s.insertbeg(45);
        //s.insertpos(25, 2);
        //s.dltend();
        //s.dltpos(0);
        //s.dltd(5);
        //s.length();
        //s.midele();
        //s.mideleslowfast();
        //s.sum();
        //s.sittingarng();
        //s.minmax();
        //s.search(5);
        /*s.ascinsert(10);
        s.ascinsert(20);
        s.ascinsert(15);
        s.ascinsert(9);*/
        System.out.println("\nAfter operation : ");
        s.display();
        //s.display1();
    }
}