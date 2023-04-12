/*Mr.Uday is trying to develop a software which reads array of strings from user and gives the longest common prefix of those strings, if no common prefix then it will give empty string. help uday to develop program.


input : array of strings seperated by ','
output : longest common prefix.
Example 1:
Input: flower,flow,flight
Output: fl

Example 2:
Input:dog,racecar,car
Output: 
Explanation: There is no common prefix among the input strings.

Note: USE TRIE DATASTRUCTURE
      STRING SHOULD CONTAIN ONLY LOWER CASE ALPHABETS(a to z  only)

*/

import java.util.*;
class TrieNode {
    char val;
    boolean isEnd;
    TrieNode[] children;
    
    public TrieNode() {
        this.children = new TrieNode[26];
    }
    
    public TrieNode(char c) {
        this();
        this.val = c;
    }
}

class Trie {
    private TrieNode root;
    
    public Trie() {
        this.root = new TrieNode();
    }
    
    public void insert(String word) {
        TrieNode curr = this.root;
        
        for (char c : word.toCharArray()) {
            if (curr.children[c - 'a'] == null) {
                curr.children[c - 'a'] = new TrieNode(c);
            }
            
            curr = curr.children[c - 'a'];
        }
        
        curr.isEnd = true;
    }
    
    public String longestCommonPrefix(String[] strs) {
        //write your code here
        if(strs.length == 0)
            return "";
        
        Trie t = new Trie();
        for (String s : strs)
            t.insert(s);
        
        System.out.println(t.search(strs[0], strs.length));
    
    /*private int countChildren(TrieNode node) {
        //write your code here
    }
    
    private int getFirstChildIndex(TrieNode node) {
        //write your code here
    }*/
    public void search(String s, int N){
        TrieNode node = root;
        for (int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            
            if(node.children[c-'a'] != null ){
                node = node.children[c-'a'];
            }else {
                System.out.println(s.substring(0, i));
            }
        }
        System.out.println(s);
    }
}

class Main {

	public static void main(String[] args)
	{
		Scanner sc=new Scanner(System.in);
		String[] str = sc.nextLine().split(",");
		System.out.println(new Main().longestCommonPrefix(str));
	}

}
