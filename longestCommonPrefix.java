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
    
    public String longestCommonPrefix() {
        StringBuilder prefix = new StringBuilder();
        TrieNode curr = this.root;
        
        while (curr != null && !curr.isEnd && countChildren(curr) == 1) {
            int index = getFirstChildIndex(curr);
            prefix.append(curr.children[index].val);
            curr = curr.children[index];
        }
        
        return prefix.toString(); 
    }
    
    private int countChildren(TrieNode node) {
        //write your code here
        int count = 0;
        
        for (TrieNode child : node.children) {
            if (child != null) {
                count++;
            }
        }
        
        return count;
    }
    
    private int getFirstChildIndex(TrieNode node) {
        //write your code here
        for (int i = 0; i < node.children.length; i++) {
            if (node.children[i] != null) {
                return i;
            }
        }
        
        return -1;
    }
}

class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        
        Trie trie = new Trie();
        
        for (String word : strs) {
            trie.insert(word);
        }
        
        return trie.longestCommonPrefix();
    }
	public static void main(String[] args)
	{
		Scanner sc=new Scanner(System.in);
		String[] str = sc.nextLine().trim().split(",");
		System.out.println(new Solution().longestCommonPrefix(str));
	}

}