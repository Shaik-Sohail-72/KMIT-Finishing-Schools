/*In a school, the students are given an array of strings words[]. Students have 
to find the longest string in words[] such that every prefix of it is also in words.

For example, let words = ["a", "app", "ap","appl", "apply"]. The string "apply" 
has prefixes "ap","app","appl" and "a", all of which are in words.

Your task is the find and return the longest string in words as described above.

If there is more than one string with the same length, return the lexicographically
smallest one, and if no string exists, return "".

Input Format
-------------
Line1: string separated by spaces
 
Output Format
--------------
string 

Sample Input-1:
---------------
k kmi km kmit

Sample Output-1:
----------------
kmit

Explanation:
------------
"kmit" has prefixes "kmi", "km", "k" and all of them appear in words.


Sample Input-2:
---------------
t tanker tup tupl tu tuple tupla

Sample Output-2:
----------------
tupla

Explanation:
------------
Both "tuple" and "tupla" have all their prefixes in words.
However, "tupla" is lexicographically smaller, so we return that.


Sample Input-3:
---------------
abc bc ab abcd

Sample Output-3:
----------------
""
*/
import java.util.*;
class Main{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        String arr[]=sc.nextLine().split(" ");
        System.out.println(cal(arr));
    }
    public static String cal(String words[]) {
        String ans = "";
        Set<String> wordset = new HashSet();
        for (String word: words){
            wordset.add(word);
        }
        for (String word: words) {
            if (word.length() > ans.length() || word.length() == ans.length() && word.compareTo(ans) < 0) {
                boolean good = true;
                for (int k = 1; k < word.length(); ++k) {
                    if (!wordset.contains(word.substring(0, k))) {
                        good = false;
                        break;
                    }
                }
                if(good){
                    ans = word;
                }
            }    
        }
        return ans;
    }
}

      