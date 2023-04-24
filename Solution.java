import java.util.*;
class TrieNode{
    TrieNode children[];
    int freq;
    TrieNode(){
        children=new TrieNode[26];
        for(int i=0;i<26;i++){
            children[i]=null;
        }
        freq=0;
    }
}
public class Solution {
    
    static TrieNode root=new TrieNode();
    static String findPrefixes(String[] arr, int N) {
        String res[]=new String[N];
        for(int i=0;i<N;i++){
            insert(arr[i],root);
        }
        for(int i=0;i<N;i++){
            res[i]=find(arr[i],root);
        }
        return Arrays.toString(res);
    }
    static void insert(String word,TrieNode root){
        TrieNode curr=root;
        for(int i=0;i<word.length();i++){
            int idx=word.charAt(i)-'a';
            if(curr.children[idx]==null){
                curr.children[idx]=new TrieNode();
            }
            curr.children[idx].freq+=1;
            curr=curr.children[idx];
        }
    }
    static String find(String key,TrieNode root){
        TrieNode curr=root;
        String ans="";
        for(int i=0;i<key.length();i++){
            int idx=key.charAt(i)-'a';
            ans+=key.charAt(i);
            if(curr.children[idx].freq==1){
                break;
            }
            curr=curr.children[idx];
        }
        return ans;
    }
    public static void main(String[] args){
        String arr[]={"zebra", "dog", "duck", "dove"};
        System.out.println(findPrefixes(arr,4 ));
    }
};