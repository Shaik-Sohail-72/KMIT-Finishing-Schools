/*Mr Shravan is given a word W, and W is a palindrome. Mr Shravan is 
allowed to replace only one letter in W, with any lowercase alphabet, 
such that the word W is not a palindrome again and which is the 
lexicographically smallest among all the possible options.

Examples of Lexicographical order are:
	- aaa is smaller than aab
	- abb is smaller than abc.

Return the lexicographically smallest string among all the possible options.

Input Format:
-------------
A String P, palindrome.

Output Format:
--------------
A String result.


Sample Input-1:
---------------
abcdcba

Sample Output-1:
----------------
aacdcba


Sample Input-2:
---------------
aaaa

Sample Output-2:
----------------
aaab


Sample Input-3:
---------------
aaabaaa

Sample Output-3:
----------------
aaabaab
*/

/*import java.util.*;
class Main{
    public static boolean ispal(String str){
        StringBuilder sb=new StringBuilder(str);
        String temp=sb.reverse().toString();
        if(str.equals(temp)){
            return true;
        }else{
            return false;
        }
        
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        String s=sc.next();
        String res="zzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzz";
        StringBuilder sb=new StringBuilder(s);
        for(int i=0;i<s.length();i++){
            String temp=s.replace(s.charAt(i),'a');
            if(temp.compareTo(res)<0){
                if(!ispal(temp)){
                    res=temp;
                }
            }
        }
        System.out.println(res);
    }
}*/
    
import java.util.*;
class laxi{
    public static String outstr(String s){
        StringBuilder str=new StringBuilder(s);
        for(int i=0;i<str.length()/2;i++){
            if(s.charAt(i)!='a'){
                str.setCharAt(i,'a');
                return str.toString();
            }
        }
        str.setCharAt(str.length()-1,'b');
        return str.toString();
    }
    public static void main (String[] args){
        Scanner sc=new Scanner(System.in);
        String s=sc.nextLine();
        System.out.println(outstr(s));
    }
}

      