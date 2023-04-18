import java.util.*;
class trie{
    static class Node{
        Node children[];
        boolean eow; 
        Node(){
            children=new Node[26];
            for(int i=0;i<26;i++){
                children[i]=null;
            }
            eow=false;
        }
    }
    static Node root=new Node();
    public static void insert(String word){
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
    public static boolean search(String key){
        Node curr=root;
        for(int i=0;i<key.length();i++){
            int idx=key.charAt(i)-'a';
            if(curr.children[idx]==null){
                return false;
            }
            if(i==key.length()-1 && curr.children[idx].eow==false){
                return false;
            } 
            curr=curr.children[idx];
        }
        return true;
        
    }
    public static boolean wordBreak(String key,int a){
        if(key.length()==0){
            return true;
        }
        for(int i=1;i<=key.length();i++){
            String firstpart=key.substring(0, i);
            String secpart=key.substring(i,key.length());
            System.out.println(firstpart+" "+secpart);
            if(search(firstpart) && wordBreak(secpart,a)){
                return true;
            }
        }
        return false;
    }
    public static boolean startsWith(String prefix){
        Node curr=root;
        for(int i=0;i<prefix.length();i++){
            int idx=prefix.charAt(i)-'a';
            if(curr.children[idx]==null){
                return false;
            }else{
                curr=curr.children[idx];
            }
        }
        return true;
    }
    public static int count(Node root){
        int c=0;
        if(root==null){
            return 0;
        }
        Node curr=root;
        for(int i=0;i<26;i++){
            if(curr.children[i]!=null){
                c+=count(curr.children[i]);
            }
        }
        return c+1;
    }
    public static void main(String[] args){
        //String words[]={"the","a","there","answer","any","by","bye","their"};
        /*String words[]={"i", "like", "sam", "sung", "samsung","mobile","ice","cream", "icecream", "man","go", "mango"};
        for(int i=0;i<words.length;i++){
            insert(words[i]);
        }*/
        //System.out.println(search("the"));
        System.out.println(wordBreak("ilikesamsung",3));
        //System.out.println(startsWith("m"));
        String str="abcdefg";
        for(int i=0;i<str.length();i++){
            String suff=str.substring(i);
            insert(suff);
        }
        System.out.println(count(root));
    }/*
    Input: s = "aabbaba"
Output: 21
Explanation: The set of distinct strings is ["a","b","aa","bb","ab","ba","aab","abb","bba","aba","aabb","abba","bbab","baba","aabba","abbab","bbaba","aabbab","abbaba","aabbaba"] */
}