/*Given a string s, find the length of the longest 
substring
 without repeating characters.
Example 1:

Input: s = "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3.

Example 2:

Input: s = "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.
Example 3:

Input: s = "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3.
Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
Constraints:
0 <= s.length <= 5 * 104
s consists of English letters, digits, symbols and spaces.
 */

import java.util.*;
class Test
{
    public static void main (String[] args) 
    {
        Scanner obj=new Scanner(System.in);
        String s=obj.nextLine();
        int cnt=1;
        String temp="";
        for(char c:s.toCharArray())
        {
            String cur=String.valueOf(c);
            if(temp.contains(cur))
            {
                temp=temp.substring(temp.indexOf(cur)+1);
            }
                temp=temp+String.valueOf(cur);
                cnt=Math.max(cnt,temp.length());
        }
       System.out.println(cnt);
    }
}
