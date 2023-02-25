/*Mr. Dhanush has provided the string NUM, which solely contains digits.
He is looking for substrings that are numbers and have an equal number of 
distinct digits in each of them. It follows the rule if the number is 123123, 
but not if the number is 12312.

Your task is to assist Mr. Dhanush in determining the number of distinct 
substrings (numbers) of NUM that adhere to the mentioned rule.


Input Format:
-------------
A string NUM, consist of diits [0-9]

Output Format:
--------------
Print an integer result.


Sample Input-1:
---------------
6767

Sample Output-1:
----------------
5

Explanation: 
------------
The list of words are: 6,7,67,76,6767


Sample Input-2:
---------------
2345432

Sample Output-2:
----------------
16

Explnation:
-----------
The list of words are: 2,3,4,5,23,34,45,54,43,32,234,345,543,432,2345,5432
*/

import java.util.*;
class uniqueSubstring{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        String s=sc.next();
        int n=s.length();
        int k=1;
        Set<String> st=new HashSet<>();
        while(k<=n){
            for(int i=0;i<n-k+1;i++){
                String res="";
                Map<Character,Integer> m=new HashMap<>();
                for(int j=i;j<i+k;j++){
                    res+=s.charAt(j);
                    if(!m.containsKey(s.charAt(j))){
                        m.put(s.charAt(j),1);
                    }else{
                        m.put(s.charAt(j),m.get(s.charAt(j))+1);
                    }
                }
                int t=m.get(res.charAt(0));
                int f=1;
                for(Map.Entry<Character,Integer> e:m.entrySet()){
                    if(e.getValue()!=t){
                        f=0;
                    }
                }
                if(f==1){
                    st.add(res);
                }
            }
            k++;
        }
        System.out.println(st.size());
    }
}
  

     