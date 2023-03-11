/*The Valid shortcuts of a string "abcd", are as follows:
abcd, abcd, a1cd, ab1d, abc1, 2cd, a2d, ab2, 1b1d, 1bc1,a1c1, 
1b2, 2c1, 3d, a3, 4

You are given a string S and shortcut string  SC, 
Your task is to find out whether the string matches with the 
given shortcut or not.
if matched print true, else false.

Note:
String S contains only lowercase letters and String SC contains 
only lowercase letters and digits.

Input Format:
-------------
Two space separated Strings S and SC

Output Format:
--------------
Print a boolean value
Sample Input-1:
---------------
internationalization i12iz4n

Sample Output-1:
----------------
true

Sample Input-2:
---------------
apple a2e

Sample Output-2:
----------------
false
*/
import java.util.*;
class validWord{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        String str=sc.next();
        String abr=sc.next();
        System.out.println(cal(str,abr));
    }
    public static boolean cal(String str,String abr){
        int i=0;
        int j=0;
        while(i<str.length() && j<abr.length()){
            if(Character.isLetter(abr.charAt(j))){
                if(str.charAt(i)!=abr.charAt(j))
                    return false;
                    i++;
                    j++;
            }else{
                int sum=0;
                while(j<abr.length() && Character.isDigit(abr.charAt(j))){
                    sum*=10;
                    sum+=Character.getNumericValue(abr.charAt(j++));
                }
                i+=sum;
            }
        }
        if(i!=str.length() || j!=abr.length()){
            return false;
        }
        return true;
    }
}