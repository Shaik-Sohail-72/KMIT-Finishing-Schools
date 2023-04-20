import java.util.*;
class mobileDictionary{
    public static ArrayList<ArrayList<String>> mainls=new ArrayList<> ();
    public static class Node{
        Node []children;
        boolean eow;
        Node(){
            children=new Node[26];
            for(int i=0;i<26;i++){
                children[i]=null;
            }
            this.eow=false;
        }
    }
    public static void insert(String word,Node root)
    {
        Node curr=root;
        for(int i=0;i<word.length();i++){
            int idx=word.charAt(i)-'a';
            if(curr.children[idx]==null){
               curr.children[idx]=new Node();
            }
            if(i==word.length()-1){
                curr.children[idx].eow=true;
            }
            curr=curr.children[idx];
        }
    }
    public static void search(String key,Node root){
        String s="";
        ArrayList<String> ls=new ArrayList<>();
        Node curr=root;
        int c=0;
        for(int i=0;i<key.length();i++){
            int idx=key.charAt(i)-'a';
            if(curr.children[idx]==null){     
                 ls.add("0");
                 mainls.add(ls);
                 c++;
                 return;
                 
             }
             s+=key.charAt(i);
             curr=curr.children[idx];
        }
        mainls.add(find(curr,s,ls));
    }
    public static ArrayList<String> find(Node root,String s,ArrayList<String> ls){
        Node curr=root;
       if(curr.eow==true){
          ls.add(s);
       }
       for(int i=0;i<26;i++){
           if(curr.children[i]!=null){
            System.out.println(i+" prevs "+s);
            s=s+((char)(i+'a'));
            System.out.println((char)(i+'a'));
            System.out.println("s "+s);
            find(curr.children[i],s,ls);
           }
       }
       return ls;
    }
    public static ArrayList<ArrayList<String>> displayContacts(int n, String contact[], String s){
        Node root=new Node();
        for(int i=0;i<contact.length;i++){
            insert(contact[i],root);
        }
        for(int i=1;i<=s.length();i++){
            search((s.substring(0,i)),root);
        }
        return mainls;
    }
    public static void main(String[] args){
        String arr[]={"geeikistest", "geeksforgeeks", "geeksfortest"};
        String s="geeips";
        System.out.println(displayContacts(3,arr,s));
    }
}