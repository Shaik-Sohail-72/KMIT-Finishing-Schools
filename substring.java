/*Given two strings s and p, return an array of all the start indices of p's anagrams in s. You may return the answer in any order.

An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.
 

input =cbaebabacd
abc
output =0 6
Explanation:
The substring with start index = 0 is "cba", which is an anagram of "abc".
The substring with start index = 6 is "bac", which is an anagram of "abc".

input=abab
ab
output =0 1 2

Explanation:
The substring with start index = 0 is "ab", which is an anagram of "ab".
The substring with start index = 1 is "ba", which is an anagram of "ab".
The substring with start index = 2 is "ab", which is an anagram of "ab".

*/

import java.util.*;
class substring{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        String s=sc.next();
        String p=sc.next();
        Map<Character,Integer> m1=new HashMap<>();
        for(int i=0;i<p.length();i++){
            m1.put(p.charAt(i),m1.getOrDefault(p.charAt(i),1));
        }
        for(int i=0;i<s.length()-p.length()+1;i++){
            Map<Character,Integer> m2=new HashMap<>();
            for(int j=i;j<i+p.length();j++){
                m2.put(s.charAt(j),m2.getOrDefault(s.charAt(j),1));
            }
            if(m1.equals(m2)){
                System.out.print(i+" ");
            }
        }
    }
}