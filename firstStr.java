/*Mr.chary is playing with strings, he has one main string and one substring he has to find the first occurance of given substring in the main string. Help him by writing a java program using trie datastructure.
input : mainstring and substring
output : index if substring is found and -1 if substring is not found

example 1:
input = keshavmemorialinstitueoftechnology
mem
output =6
explanation "mem" starts at index 6
example 2:
input = keshavmemorialjuniorcollege
col
output = 20
*/
import java.util.*;
class Node{
    Node children[];
    Node(){
        children=new Node[26];
        for(int i=0;i<26;i++){
            children[i]=null;
        }
    }
}
class Solution{
    static Node root=new Node();
    public static void insert(String word){
        Node curr=root;
        for(int i=0;i<word.length();i++){
            int idx=word.charAt(i)-'a';
            if(curr.children[idx]==null){
                curr.children[idx]=new Node();
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
            curr=curr.children[idx];
        }
        return true;
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        String str=sc.next();
        String pat=sc.next();
        int res=-1;
        for(int i=0;i<str.length();i++){
            insert(str.substring(i));
            if(search(pat)){
                res=i;
                break;
            }
        }
        System.out.println(res);
    }
}