/*
Mr Shravan is given a word W, and W cosists of lowercase alphabets and '#'. 
Mr Shravan is allowed to replace the '#' with any one lowercase alphabet, 
such that the word W is a palindrome and it has to be the lexicographically
smallest among all the possible options.

Your task is to help Mr Sharavan to return the lexicographically smallest 
palindrome string among all the possible options. 
OR "invlaid" if it is not possible.

Input Format:
-------------
A String W, consists of lowercase letters and #.

Output Format:
--------------
A String result.


Sample Input-1:
---------------
r#d#v##er

Sample Output-1:
----------------
redavader


Sample Input-2:
---------------
r#d#v#cer

Sample Output-2:
----------------
invalid
*/

import java.util.*;
class laxi_palindrome{
    public static String cal(String s){
        int i=0;
        int j=s.length()-1;
        StringBuilder sb=new StringBuilder(s);
        while(i<j){
            if(s.charAt(i)!='#' && s.charAt(j)!='#' && s.charAt(i)!=s.charAt(j)){
                return "invalid";
            }else if(s.charAt(i)=='#' && s.charAt(j)=='#'){
                sb.setCharAt(i,'a');
                sb.setCharAt(j,'a');
            }else if(s.charAt(i)!='#' && s.charAt(j)=='#'){
                sb.setCharAt(j,s.charAt(i));
            }else if(s.charAt(i)=='#' && s.charAt(j)!='#'){
                sb.setCharAt(i,s.charAt(j));
            }
            i++;
            j--;
        }
        return sb.toString();
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        String s=sc.next();
        System.out.println(cal(s));
    }
}