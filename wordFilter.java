/*
Mr. Nivas is designing a new dictionary which searches the words in it by a prefix and a sufix
when we supply a list of words and a prefix and suffix characters it will return the index of the word in the dictionary
which has the prefix and the suffix matches with search key prefix and suffix. If there is more tan one valid index, return the largest of them. If there is no such word  then return -1

Input : number of words n
sequence of n words
prefix character
suffix character
output : index of the word matching with prefix and suffix
Example 1:
input :8
mon tue wed thu fri sat sun mon
m 
n
output : 7
explanation : prefix is 'm' and suffix is 'n'
there are two matches at index 0 and index 7, as per constraint it is returning highest index value i.e 7
example 2 :
input :6
jan feb mar apr may june
j
y
output : -1

*/
import java.util.*;
class TrieNode {
    TrieNode children[];
    boolean eow;
    public Set<String> words;
    public TrieNode() {
        children=new TrieNode[26];
        for(int i=0;i<26;i++){
            children[i]=null;
        }
        eow=false;
    }
}
class WordFilter {
    static TrieNode root=new TrieNode();
    public static void insert(String word){
        TrieNode curr=root;
        for(int i=0;i<word.length();i++){
            int idx=word.charAt(i)-'a';
            if(curr.children[idx]==null){
                curr.children[idx]=new TrieNode();
            }
            if(i==word.length()-1){
                curr.children[idx].eow=true;
            }
            curr=curr.children[idx];
        }
    }
    public static boolean search(String key,char pre,char suff){
        TrieNode curr=root;
        int preind=pre-'a';
        int suffind=suff-'a';
        if(curr.children[preind]==null){
            return false;
        }else{
            curr=curr.children[preind];
            for(int i=1;i<key.length();i++){
                int idx=key.charAt(i)-'a';
                if(curr.children[idx]==null){
                    return false;
                }
                if(i==key.length()-1 && curr.children[idx].eow==true && curr.children[suffind]!=null){
                    return true;
                }
                curr=curr.children[idx];
            }
        }
        return false;
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        String arr[]=new String[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.next();
            insert(arr[i]);
        }
        String temp=sc.next();
        char pre=temp.charAt(0);
        String temp2=sc.next();
        char suff=temp2.charAt(0);
        int res=0;
        int f=0;
        for(int i=0;i<n;i++){
            if(search(arr[i],pre,suff)){
                res=i;
                f=1;
            }
        }
        if(f==0){
            System.out.println(-1);
        }else{
            System.out.println(res);
        }
    }
}