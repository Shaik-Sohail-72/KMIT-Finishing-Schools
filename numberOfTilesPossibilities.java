/*There are some cubes, each cube is printed with an alphabet [A-Z].
Using these cubes, you can create non-empty distinct words.
and length of the words should be 0< length <= no.of.cubes.

You are given a string of alphabets S, 
Your task is to findout number of possible non-empty distinct words

Input Format:
-------------
A string S, consist of A-Z letters only.

Output Format:
--------------
Print an integer, number of possible non-empty distinct words.


Sample Input-1:
---------------
EGG

Sample Output-1:
----------------
8

Explanation:
--------------
The possible distinct words are "E", "G", "EG", "GG", "GE", "EGG", "GEG", "GGE".


Sample Input-2:
---------------
MADAM

Sample Output-2:
----------------
89*/

import java.util.*;
class Main
{
    public static void main (String[] args)
    {
        Scanner obj=new Scanner(System.in);
        String s=obj.next();
        HashMap<Character,Integer> hm=new HashMap<>();
        for(int i=0;i<s.length();i++)
        {
            int c=hm.getOrDefault(s.charAt(i),0);
            hm.put(s.charAt(i),c+1);
        }
        System.out.println(solve(hm));
    }
    public static int solve(HashMap<Character,Integer> map)
    {
        int sum=map.values().stream().reduce(0,Integer::sum);
        if(sum<=0)
        {
            return 0;
        }
        int ans=0;
        for(Character i:map.keySet())
        {
            if(map.get(i)<=0)
            {
                continue;
            }
            map.put(i,(map.get(i)-1));
            ans+=solve(map)+1;
            map.put(i,(map.get(i)+1));
        }
        return ans;
    }
}



    