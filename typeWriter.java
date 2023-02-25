/*Aruna is a typewriter, typing a document on her laptop. Suddenly her system got
hacked and whatever she types as words are displayed in reverse and with simple 
braces. She types only lowercase letters.

In order to get the actual words, Aruna has to reverse each word starting with 
the word which is in innermost most braces and remove those braces.
Help Aruna to get actual words.

Constraints:
------------
  - 0 <= word.length <= 2000
  - Word only contains lower case English characters and parentheses.
    It's guaranteed that all braces are balanced.


Input Format:
-------------
Line-1: a string represents an encoded word.

Output Format:
--------------
return the original string.


Sample Input-1:
---------------
(pqrs)

Sample Output-1:
----------------
srqp


Sample Input-2:
---------------
(uoy(are)woh)

Sample Output-2:
----------------
howareyou

Explanation
------------
Initially "are" will be revesed as "era".
Then (uoyerawoh) will be reversed.
*/

/*
import java.util.*;
class Test
{
    public static void main (String[] args)
    {
        Scanner obj=new Scanner(System.in);
        int a=obj.nextInt();
        int b=obj.nextInt();
        ArrayList<Integer> list=new ArrayList<Integer>();
        for(int i=0;i<a;i++)
        {
            list.add(obj.nextInt());
        }
        System.out.println(mincost(list,a,b));
    }
    
    public static int mincost(ArrayList<Integer> list,int a,int b)
    {
        int sum=0;
        int k=0;
        Collections.sort(list);
        
        int in=a-1;
        while(in>=0)
        {
            int c=0;
            while(b>c && in>=0)
            {
                sum+=(1+k)*list.get(in);
                c++;
                in--;
            
            }
            k++;
        }
        return sum;
    }
}*/

import java.util.*;
class Main{    
    public static void main (String[] args){
        Scanner obj=new Scanner(System.in);
        String s=obj.nextLine();
        Stack<Character> st=new Stack<Character>();
        StringBuilder sb1=new StringBuilder();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)!=')'){
                st.push(s.charAt(i));
            }
            else{
                StringBuilder sb=new StringBuilder();
                while(!st.isEmpty() && st.peek()!='('){
                   sb.append(st.pop());
               }
               st.pop();
               for(int k=0;k<sb.length();k++){
                st.push(sb.charAt(k));
               }
            }
        }
        while(!st.isEmpty()){
            sb1.append(st.pop());
        }
        System.out.println(sb1.reverse().toString()); 
    }
}

  