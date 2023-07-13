/*A phrase is a palindrome if, after converting all uppercase letters into lowercase letters and removing all non-alphanumeric characters, it reads the same forward and backward. Alphanumeric characters include letters and numbers.

Given a string s, return true if it is a palindrome, or false otherwise.

 

Example 1:

Input: s = "A man, a plan, a canal: Panama"
Output: true
Explanation: "amanaplanacanalpanama" is a palindrome.
Example 2:

Input: s = "race a car"
Output: false
Explanation: "raceacar" is not a palindrome.
Example 3:

Input: s = " "
Output: true
Explanation: s is an empty string "" after removing non-alphanumeric characters.
Since an empty string reads the same forward and backward, it is a palindrome.
 

Constraints:

1 <= s.length <= 2 * 105
s consists only of printable ASCII characters.
 */


 import java.util.*;
 class Test
 {
     public static void main (String[] args)
     {
         Scanner sc=new Scanner(System.in);
         String s=sc.nextLine();
         StringBuilder sb=new StringBuilder();
         String temp="";
         for(int i=0;i<s.length();i++)
         {
             if((s.charAt(i)>='a' &&s.charAt(i)<='z') || (s.charAt(i)>='A' && s.charAt(i)<='Z'))
             {
                 sb.append(s.charAt(i));
                 temp+=s.charAt(i);
             }
         }
         sb.reverse();
         String newstr=sb.toString();
       if(newstr.equals(temp))
       {
           System.out.println("true");
       }
       else
       {
           System.out.println("false");
       }
     }
 }
