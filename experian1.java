
import java.util.*;
class experian1{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        String str=sc.next();
        System.out.println(find(str));
    }
    public static String find(String s){
        int i=0;
        int j=s.length()-1;
        StringBuilder sb=new StringBuilder(s);
        while(i<j){
            if(s.charAt(i)!='?' && s.charAt(j)!='?' && s.charAt(i)!=s.charAt(j)){
                return "NO";
            }else if(s.charAt(i)=='?' && s.charAt(j)=='?'){
                sb.setCharAt(i, 'a');
                sb.setCharAt(j,'a');
            }else if(s.charAt(i)!='?' && s.charAt(j)=='?'){
                sb.setCharAt(j, s.charAt(i));
            }else if(s.charAt(i)=='?' && s.charAt(j)!='?'){
                sb.setCharAt(i, s.charAt(j));
            }
            i++;
            j--;
        }
        return sb.toString();
    }
}