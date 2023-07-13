/*Given two strings string1 and string2, return true if string1 can be constructed by using the letters from string2 and false otherwise.
Each letter in string2 can only be used once in string1.
input format = two strings
output format = true or false
Example 1:
Input: string1 = "a", string2 = "b"
Output: false

Example 2:

Input: "aa"
"ab"
Output: false

Example 3:

Input:"aa"
"aab"
Output: true
*/
import java.util.*;
class strBuild{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        String s1=sc.next();
        String s2=sc.next();
        System.out.println(find(s1,s2));
    }
    public static boolean find(String s1,String s2){
        List<Character> ls=new ArrayList<>();
        if(s1.length()>s2.length()){
            return false;
        }
        for(int i=0;i<s2.length();i++){
            ls.add(s2.charAt(i));
        }
        for(int i=0;i<s1.length();i++){
            if(ls.contains(s1.charAt(i))){
                ls.remove(Character.valueOf(s1.charAt(i)));
            }else{
                return false;bora
            }
        }
        return true;
    }
}