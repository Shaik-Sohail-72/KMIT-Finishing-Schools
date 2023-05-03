/*Vihaar is working with strings. 
He is given two strings A and B, and another string T,
where the length of A and B is same.

You can find the relative groups of letters from A and B,
using the following rule set:
- Equality rule: 'p' == 'p'
- Symmetric rule: 'p' == 'q' is same as 'q' == 'p'
- Transitive rule: 'p' == 'q' and 'q' == 'r' indicates 'p' == 'r'.

Vihaar has to form the relatively smallest string of T,
using the relative groups of letters.

For example, if A ="pqr" and B = "rst" , 
then we have 'p' == 'r', 'q' == 's', 'r' == 't' .

The relatives groups formed using above rule set are as follows: 
[p, r, t] and [q,s] and  String T ="tts", then relatively smallest string is "ppq".

You will be given the strings A , B and T.
Your task is to help Vihaar to find the relatively smallest string of T.


Input Format:
-------------
Three space separated strings, A , B and T

Output Format:
--------------
Print a string, relatively smallest string of T.


Sample Input-1:
---------------
kmit ngit mgit

Sample Output-1:
----------------
ggit

Explanation: 
------------
The relative groups using A nd B are [k, n], [m, g], [i], [t] and
the relatively smallest string of T is "ggit"


Sample Input-2:
---------------
attitude progress apriori

Sample Output-2:
----------------
aaogoog

Explanation: 
------------
The relative groups using A nd B are [a, p], [t, r, o], [i, g] and [u, e, d, s]
the relatively smallest string of T is "aaogoog"
*/

import java.util.*;
class Main
{ 
    static int[] parent=new int[26];
    public static void main (String[] args) 
    {
        Scanner obj=new Scanner(System.in);
        String s=obj.next();
        String t=obj.next();
        String str=obj.next();
        System.out.println(smallestString(s,t,str));
    }
    public static String smallestString(String s,String t,String str)
    {
        for(int i=0;i<26;i++)
        {
            parent[i]=i;
        }
        for(int i=0;i<s.length();i++)
        {
            union(s.charAt(i)-'a',t.charAt(i)-'a');
        }
        String ans="";
        for(char c:str.toCharArray())
        {
            ans+=(char)(find(c-'a')+'a');
        }
        return ans;
    }
    static int find(int x)
   {
       if(parent[x]==x)
       {
           return x;
       }
    
       return parent[x]=find(parent[x]);
      
   }
   static void union(int x,int y)
   {
       int xroot=find(x);
       int yroot=find(y);
       if(xroot==yroot)
       {
           return;
       }
       if(xroot<yroot)
       {
           parent[yroot]=xroot;
       }
       else
       {
           parent[xroot]=yroot;
       }
   }
}



    