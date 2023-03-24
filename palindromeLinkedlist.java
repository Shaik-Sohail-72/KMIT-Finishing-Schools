/*Cliff Shaw is working on the singly linked list.
He is given a list of boxes arranged as a singly linked list,
where each box is printed with a positive number on it.

Your task is to help Mr. Cliff to find if the given list is equivalent to 
the reverse of it or not. If yes, print "true", otherwise print "false"

Implement the class Solution:
    - boolean isPalindrome(Node n)
    
Input Format:
-------------
Line-1: space separated integers, boxes as list.

Output Format:
--------------
Print a boolean a value.


Sample Input-1:
---------------
3 6 2 6 3

Sample Output-1:
----------------
true


Sample Input-2:
---------------
3 6 2 3 6

Sample Output-2:
----------------
false

*/
import java.util.*;

/*
// Node Structure for reference
class Node{    
	int data;    
	Node next;    
		
	public Node(int data) {    
		this.data = data;    
		this.next = null;    
	}    
}    
*/

class palindromeLinkedlist{
    List<Integer> ls=new ArrayList<>();
    boolean isPalindrome(Node head) {
        Node curr=head;
        while(curr!=null){
            ls.add(curr.data);
            curr=curr.next;
        }
        Node curr2=head;
        for(int i=ls.size()-1;i>=0;i--){
            if(curr2.data!=ls.get(i)){
                return false;
            }
            curr2=curr2.next;
        }
        return true;
    }
}
