/* Given a string s, .reverse only all the vowels in the 
string and return it.

The vowels are 'a', 'e', 'i', 'o', and 'u', and they can 
appear in both lower and upper cases, more than once.

Example 1:
Input: hello
Output: holle

Example 2:
Input: Keshavmemorial
Output: Kashivmomerael

Example 3:
Input: variations
Output: voriatians

*/
import java.util.*;
class reverseVowels{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        String s=sc.next();
        System.out.println(cal(s));
    }
    public static String cal(String s){
        StringBuilder sb=new StringBuilder(s);
        int i=0;
        int j=s.length()-1;
        List<Character> ls=new ArrayList<>();
        ls.add('a');ls.add('e');ls.add('i');ls.add('o');ls.add('u');
        while(i<=j){
            if(ls.contains(s.charAt(i)) && ls.contains(s.charAt(j))){
                sb.setCharAt(i,s.charAt(j));
                sb.setCharAt(j,s.charAt(i));
                i++;
                j--;
            }else if(ls.contains(s.charAt(i)) && !ls.contains(s.charAt(j))){
                j--;
            }else if(!ls.contains(s.charAt(i)) && ls.contains(s.charAt(j))){
                i++;
            }else{
                i++;
                j--;
            }
        }
        return sb.toString();
    }
}