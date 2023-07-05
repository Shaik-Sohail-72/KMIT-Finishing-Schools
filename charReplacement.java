/*Ms.Sathvika is preparing for ielts, as part of this she has to solve 
different problems on strings. Now she is working on a problem which states that, if two strings say s and t are given, return true if s can be formed from t by deleting some (can be none) of the characters without distrubing the relative positions of the remaining characters Otherwise return false. Help sathvika by writing a program to solve the above problem.

Example 1: 
Input: s = "abc", t = "ahbgdc"
Output: true

Example 2:
Input = abc
ahcbde
output = false 
explanation : ahcbde is not having the sequence of characters abc.

Example 3:
Input:axc 
ahbgdc
Output: false


*/
import java.util.*;
class Main{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        String s1=sc.next();
        String s2=sc.next();
        int i=0;
        int j=0;
        while(i<s1.length() && j<s2.length()){
            if(s1.charAt(i)==s2.charAt(j)){
                i++;
                j++;
            }else if(s1.charAt(i)!=s2.charAt(j)){
                j++;
            }
        }
        if(i==s1.length()){
            System.out.println(true);
        }else{
            System.out.println(false);
        }
    }
}