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
import java.util.*;
class Main{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        String arr[]=sc.next().split(",");
        int n=sc.nextInt();
        System.out.println(cal(arr,n));
    }
    public static List<String> cal(String arr[],int n){
        Map<String,Integer> m=new HashMap<>();
        for(int i=0;i<arr.length;i++){
            if(!m.containsKey(arr[i])){
                m.put(arr[i],1);
            }else{
                m.put(arr[i],m.get(arr[i])+1);
            }
        }
        List<String> ls=new ArrayList<>();
        ls.addAll(m.keySet());
        Collections.sort(ls,(a,b)-> m.get(a).equals(m.get(b)) ? a.compareTo(b) : m.get(b)-m.get(a));
        List<String> mainls=new ArrayList<>();
        for(int i=0;i<n;i++){
            mainls.add(ls.get(i));
        }
        return mainls;
    }
}