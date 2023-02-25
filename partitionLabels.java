/* You are given a string s. We want to partition the string into 
as many parts as possible so that each letter appears in at most 
one part.

Note that the partition is done so that after concatenating 
all the parts in order, the resultant string should be s.

Return a list of integers representing the size of these parts.

 

Example 1:
Input: ababcbacadefegdehijhklij
Output: [9, 7, 8]

Explanation:
The partition is "ababcbaca", "defegde", "hijhklij".
This is a partition so that each letter appears in at most one part.
A partition like "ababcbacadefegde", "hijhklij" is incorrect, because it splits s into less parts.

Example 2:
Input: eccbbbbdec
Output: [10]

Example 3:
Input: abacadcklmklmxyyzx
Output: [7, 6, 5]

*/

    
import java.util.*;
class partitonLabel{
    public static void main (String[] args){
        Scanner obj=new Scanner(System.in);
        String s=obj.next();
        System.out.println(partitionstring(s));
    }
     public static List<Integer> partitionstring(String s){
       HashMap<Character,Integer> map=new HashMap<>();
       ArrayList<Integer> ls=new ArrayList<>();
       for(int i=0;i<s.length();i++){
           map.put(s.charAt(i),i);
       }
       int ind=-1;
       int max=0;
       for(int i=0;i<s.length();i++){
               max=Math.max(max,map.get(s.charAt(i)));
               if(max==i){
                ls.add(max-ind);
                ind=max;
           }
       }
      return ls; 
    }
}

  

      

