/*
Mr. Parandamayya is working with Strings.
He is given a String S. He has to find the palindromes in S, 
A palindrome can be a substring of S (Strictly substrings only, not subsequences).

Your task is to find the count the number of palindromes can be formed from S.

NOTE: Count each occurence of palindromes if duplicate substrings found. 

Input Format:
-------------
A string S

Output Format:
--------------
Print an integer, number of palindromes.


Sample Input-1:
---------------
divider

Sample Output-1:
----------------
9

Explanation:
-------------
Palindromes are d, i, v, i, d, e, r, ivi, divid

Sample Input-2:
---------------
abcdef

Sample Output-2:
----------------
6

Explanation:
-------------
Palindromes are a, b, c, d, e, f.
*/
    
import java.util.*;
class palindromes
{
    public static void main(String[] args){
        Scanner obj=new Scanner(System.in);
        String s=obj.nextLine();
        System.out.println(isPalindrome(s));
    }
    public static  int isPalindrome(String s){
               int n = s.length();        
               int count=0;
               for(int i=0 ; i<n; i++){
                   int low= i-1;
                   int high = i+1;
                   while(high<n && s.charAt(high)== s.charAt(i)){
                       high++;
                       count++;
                   }
                   while(low>=0 && high<n && s.charAt(low)== s.charAt(high)){
                       count++;
                       low--;
                       high++;
                   }
               }
               return count+n;
    }
}   
 


     