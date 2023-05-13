/*
You are given a string s and an integer k, a k duplicate removal consists of choosing k adjacent and equal letters from s and removing them, causing the left and the right side of the deleted substring to concatenate together.

We repeatedly make k duplicate removals on s until we no longer can.

Return the final string after all such duplicate removals have been made. It is guaranteed that the answer is unique.

Example 1:
Input: s = "abcd", k = 2
Output: "abcd"
Explanation: There's nothing to delete.

Example 2:
Input: s = "deeedbbcccbdaa", k = 3
Output: "aa"
Explanation: 
First delete "eee" and "ccc", get "ddbbbdaa"
Then delete "bbb", get "dddaa"
Finally delete "ddd", get "aa"

Example 3:
Input: s = "pbbcggttciiippooaais", k = 2
Output: "ps"
*/
import java.util.*;
class Main{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        String s=sc.next();
        int k=sc.nextInt();
        cal(s,k);
    }
    public static void cal(String s,int k){
        Stack<Character> st=new Stack<>();
        Stack<Integer> freq=new Stack<>();
        for(int i=0;i<s.length();i++){
            if(!st.isEmpty() && st.peek()==s.charAt(i)){
                freq.push(freq.peek()+1);
            }else{
                freq.push(1);
            }
            st.push(s.charAt(i));
            if(freq.peek()==k){
                for(int j=0;j<k;j++){
                    st.pop();
                    freq.pop();
                }
            }
        }
        String res="";
        while(!st.isEmpty()){
            res+=st.pop();
        }
        StringBuilder sb=new StringBuilder(res);
        sb.reverse();
        System.out.println(sb.toString());
    }
}