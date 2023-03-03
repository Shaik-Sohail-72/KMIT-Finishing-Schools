`/*You are given a string s, which contains stars *.

In one operation, you can:

Choose a star in s.
Remove the closest non-star character to its left, as well as remove the star itself.
Return the string after all stars have been removed.

input= kes**hav**mem**orial
output= khmorial
*/
import java.util.*;
class Main{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        String str=sc.next();
        System.out.println(cal(str));
    }
    public static String cal(String str){
        Stack<Character> s=new Stack<>();
        for(int i=0;i<str.length();i++){
            if(str.charAt(i)=='*'){
                s.pop();
            }else{
                s.push(str.charAt(i));
            }
        }
        StringBuilder sb=new StringBuilder();
        while(!s.isEmpty()){
            sb.append(s.pop());
        }
        sb.reverse();
        return sb.toString();
    }
}