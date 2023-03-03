/*Given a string s consisting of lowercase English letters, return the first letter to appear twice.

Note:

A letter a appears twice before another letter b if the second occurrence of a is before the second occurrence of b.
s will contain at least one letter that appears twice.

input = abacab
output= a
input = aaccbbdd
output = a
*/
import java.util.*;
class Main{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        String str=sc.next();
        cal(str);
    }
    public static void cal(String str){
        Set<Character> s=new HashSet<>();
        for(int i=0;i<str.length();i++){
            if(s.contains(str.charAt(i))){
                System.out.println(str.charAt(i));
                break;
            }else{
                s.add(str.charAt(i));
            }
        }
    }
}