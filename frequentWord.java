/*Sridhar brought his latest Apple iPhone 12 pro. He started his conversation 
with one of his friend on WhatsApp with list of words.

Now it’s our task to find and return what are the most common words 
in the list of words he used in sorted order based on occurrence from 
largest to smallest. If any of words he used are having same occurrence 
then consider the lexicographic order.

You will be given a list of words, you need to print top P number of 
most common used words as described in the statement. 

Input Format:
-------------
Line-1: comma separated line of words, list of words.
Line-2: An integer P, number of words to display. 

Output Format:
--------------
Print P number of most common used words.


Sample Input-1:
---------------
ball,are,case,doll,egg,case,doll,egg,are,are,egg,case,are,egg,are,case
3

Sample Output-1:
----------------
[are, case, egg]



Sample Input-2:
---------------
ball,are,case,doll,egg,case,doll,egg,are,are,egg,case,are,egg,are
3

Sample Output-2:
----------------
[are, egg, case]
*/
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
class Main{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        String words[]=sc.next().split(",");
        int k=sc.nextInt();
        System.out.println(cal(words,k));
    }
    public static List<String> cal(String words[],int k){
        public List<String> topKFrequent(String[] words, int k) {
            Map<String,Integer> m=new HashMap<>();
             for(int i=0;i<words.length;i++){
                 if(!m.containsKey(words[i])){
                     m.put(words[i],1);
                 }else{
                     m.put(words[i],m.get(words[i])+1);
                 }
             }
             List<String> ls=new ArrayList<>();
             ls.addAll(m.keySet());
             Collections.sort(ls,(a,b)-> m.get(a).equals(m.get(b)) ? a.compareTo(b) : m.get(b)-m.get(a));
             for(int i=ls.size()-1;i>=k;i--){
                 ls.remove(ls.get(i));
             }
             return ls;
         }
    }
}