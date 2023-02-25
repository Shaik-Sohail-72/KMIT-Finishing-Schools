/*Given string num representing a non-negative integer num, and an integer k, return the smallest possible integer after removing k digits from num.

Example 1:
input =1432219
3
output =1219

num = "1432219", k = 3
Output: "1219"
Explanation: Remove the three digits 4, 3, and 2 to form the new number 1219 which is the smallest.


Input: num = "10200", k = 1
Output: "200"
Explanation: Remove the leading 1 and the number is 200. Note that the output must not contain leading zeroes.
Example 3:

Input: num = "10", k = 2
Output: "0"
Explanation: Remove all the digits from the number and it is left with nothing which is 0.*/

import java.util.*;
class Main{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        String str=sc.next();
        int k=sc.nextInt();
        if(str.length()==k){
            System.out.println(0);
            System.exit(0);
        }
        Stack<Integer> st=new Stack<>();
        for(int i=0;i<str.length();i++){
            if(k>0 &&!st.isEmpty() && st.peek()>cnum(str.charAt(i))){
                st.pop();
                k--;
                st.push(cnum(str.charAt(i)));
            }else{
                st.push(cnum(str.charAt(i)));
            }
        }
        while(k>0){
            st.pop();
            k--;
        }
        String res="";
        while(!st.isEmpty()){
            res+=st.pop();
        }
        StringBuilder sb=new StringBuilder(res);
        sb.reverse();
        int i=0;
        while(cnum(sb.charAt(i))==0){
            sb.deleteCharAt(i);
        }
        System.out.println(sb);
    }
    public static int cnum(char c){
        return Character.getNumericValue(c);
    }
}
