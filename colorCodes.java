/*
There are numerous possible combinations of HTML colour codes, and each one is 
given a specific identification number. Each codes[i] in the list,  
is an HTML colour code that was chosen by the web designer. The list may 
contain duplicate codes.

The web designer's customer made the decision to eliminate P number of 
consecutive codes from the list. However, the web designer wants to preserve as 
many distinctive colour codes as he can. Find out how many unique colour codes 
the web designer can preserve, and print the count of unique color codes.


Input Format:
-------------
Line-1: Comma separated integers, codes[], HTML color codes
Line-2: An integer P.

Output Format:
--------------
Print an integer result.


Sample Input-1:
---------------
2,3,2,6,3,3,7,1
4

Sample Output-1:
----------------
4

Explanation: 
------------
The unique color codes he can preserve are, [2,3,7,1]
by removing [2,6,3,3].


Sample Input-2:
---------------
1,2,1,2,3,3,2,1,2,1
6

Sample Output-2:
----------------
2

Explanation: 
------------
The unique color codes he can preserve are, [2,1,2,1] or [1,2,1,2]
by removing 6 contiguous codes.
*/

    
import java.util.*;
class colorCodes{
    public static void main (String[] args){
        Scanner obj=new Scanner(System.in);
        String s=obj.nextLine();
        int n=obj.nextInt();
        String[] arr=s.split(",");
        int m=0;
        Set<String> st=new HashSet<>();
        LinkedList<String> mainls=new LinkedList<>();
        for(int i=0;i<arr.length;i++){
            mainls.add(arr[i]);
        }
        LinkedList<String> ls1=new LinkedList<>();
        for(int i=0;i<(arr.length-n)+1;i++){
            ls1.clear();
            ls1.addAll(mainls);
            for(int j=i;j<i+n;j++){
                String ele=arr[j];
                ls1.remove(String.valueOf(ele));
            }
            st.clear();
            st.addAll(ls1);
            if(st.size()>m){
                m=st.size();
            }
        }
        System.out.println(m);
    }
}

  