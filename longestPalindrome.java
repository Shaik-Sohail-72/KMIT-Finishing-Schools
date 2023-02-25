/*
Mr. Gnanesh is working with words. He has given a list of words. 
Each word in the list contains only two lowercase letters [a-z].

He wants to create the biggest word BW, by concatenating words from the list, which 
is a palindrome too. He is allowed to use each word from the list at most once.

Return the length of the biggest word that can be formed using the list.
If it is impossible to create a such word, return 0.

Input Format:
-------------
Space separated strings, words[], two letter words.

Output Format:
--------------
Print an integer result.


Sample Input-1:
---------------
ab ba dd

Sample Output-1:
----------------
6

Explanation: 
------------
The biggest word is, ab,dd,ba => abddba, which is a palindrome.


Sample Input-2:
---------------
pq rs sr mk km pq

Sample Output-2:
----------------
8

Explanation: 
------------
The biggest word is, rs,sr,mk,km => rsmkkmsr or mkrssrkm..etc, 
which is a palindrome.


Sample Input-3:
---------------
aa bb cc

Sample Output-3:
----------------
2

*/
import java.util.*;
class longestPalindrome{
    public static void main (String[] args){
        Scanner obj=new Scanner(System.in);
        String s=obj.nextLine();
        String[] arr=s.split(" ");
        ArrayList<String> inp=new ArrayList<>();
        for(int i=0;i<arr.length;i++){
            inp.add(arr[i]);
        }
        int c=0;
       for(int i=0;i<arr.length;i++){
        for(int j=i+1;j<inp.size();j++){
            if(inp.get(i).charAt(0)==inp.get(j).charAt(1) && inp.get(i).charAt(1)==inp.get(j).charAt(0))
            {
                c+=4;
                inp.remove(j);
                inp.remove(i);
                i=0;
                break;
            }
        }
       }
       if(inp.size()!=0)
       {
       for(int i=0;i<inp.size();i++)
       {
        if(inp.get(i).charAt(0)==inp.get(i).charAt(1))
        {
            c+=2;
            break;
        }
       }
    }
       System.out.println(c);
    }
}
