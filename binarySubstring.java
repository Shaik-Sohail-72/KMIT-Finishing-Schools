/*
Given a binary string s and an integer k, return true if every binary code of length k is a substring of s. Otherwise, return false.

 

Example 1:

Input: s = "00110110", k = 2
Output: true
Explanation: The binary codes of length 2 are "00", "01", "10" and "11". They can be all found as substrings at indices 0, 1, 3 and 2 respectively.
Example 2:

Input: s = "0110", k = 1
Output: true
Explanation: The binary codes of length 1 are "0" and "1", it is clear that both exist as a substring. 
Example 3:

Input: s = "0110", k = 2
Output: false
Explanation: The binary code "00" is of length 2 and does not exist in the array.
 

Constraints:

1 <= s.length <= 5 * 105
s[i] is either '0' or '1'.
1 <= k <= 20
*/
import java.util.*;
class p1{
    public static int isSub(String s1,String s2){
        return s2.indexOf(s1);
    }
    public static List<String> getlist(int k){
        List<String > l= new ArrayList<>();
        l.add("0");
        l.add("1");
        for(int i = 0 ; i < k-1 ; i++){
            List<String> t = new ArrayList<>();
            for(String str :l){
                t.add(str+"0");
                t.add(str+"1");
            }
            l=t;
        }
        return l;
    }
    public static boolean check(String s,int k){
        List<String>l=getlist(k);
        for(int i=0;i<l.size();i++){
            //System.out.println(l.get(i)+" "+isSub(l.get(i),s));
            if(isSub(l.get(i),s)==-1) return false;
        }
        return true;
    }
    public static void main(String args[]){
        Scanner in=new Scanner(System.in);
        String s=in.next();
        int k=in.nextInt();
        System.out.println(check(s,k));
       
    }
}