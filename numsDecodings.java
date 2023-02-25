/*A message containing letters from A-Z can be encoded into numbers 
using the following mapping:

'A' -> "1"
'B' -> "2"
...
'Z' -> "26"
To decode an encoded message, all the digits must be grouped then 
mapped back into letters using the reverse of the mapping above 
(there may be multiple ways). For example, "11106" can be mapped 
into:

"AAJF" with the grouping (1 1 10 6)
"KJF" with the grouping (11 10 6)

Note that the grouping (1 11 06) is invalid because "06" 
cannot be mapped into 'F' since "6" is different from "06".

Given a string s containing only digits, 
return the decoded Strings.

Example 1:
Input: s = "12"
Output:AB 
L
Explanation: "12" could be decoded as "AB" (1 2) or "L" (12).
Example 2:

Input: s = "226"
Output: BBF
VF
BZ

Explanation: "226" could be decoded as "BZ" (2 26), "VF" (22 6), or "BBF" (2 2 6).
Example 3:
Input: s = "06"
Output: F

Explanation: "06" cannot be mapped to "F" because of the 
leading zero ("6" is different from "06").
*/
import java.util.*;
class numsDecodings{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        String s=sc.next();
        System.out.println(decodeString(s));
    }

public static List<String> decodeString(String s) {
    List<String> result = new ArrayList<>();
    if (s == null || s.isEmpty()) {
        return result;
    }
    
    int n = s.length();
    int[] dp = new int[n + 1];
    dp[0] = 1;
    dp[1] = s.charAt(0) == '0' ? 0 : 1;
    
    for (int i = 2; i <= n; i++) {
        int oneDigit = Integer.parseInt(s.substring(i - 1, i));
        int twoDigits = Integer.parseInt(s.substring(i - 2, i));
        
        if (oneDigit >= 1 && oneDigit <= 9) {
            dp[i] += dp[i - 1];
        }
        
        if (twoDigits >= 10 && twoDigits <= 26) {
            dp[i] += dp[i - 2];
        }
    }
    
    if (dp[n] == 0) {
        return result;
    }
    
    StringBuilder sb = new StringBuilder();
    decodeStringHelper(s, n, dp, sb, result);
    
    return result;
}

private static void decodeStringHelper(String s, int i, int[] dp, StringBuilder sb, List<String> result) {
    if (i == 0) {
        result.add(sb.toString());
        return;
    }
    
    int oneDigit = Integer.parseInt(s.substring(i - 1, i));
    int twoDigits = i >= 2 ? Integer.parseInt(s.substring(i - 2, i)) : 0;
    
    if (oneDigit >= 1 && oneDigit <= 9) {
        sb.insert(0, (char)('A' + oneDigit - 1));
        decodeStringHelper(s, i - 1, dp, sb, result);
        sb.deleteCharAt(0);
    }
    
    if (twoDigits >= 10 && twoDigits <= 26) {
        sb.insert(0, (char)('A' + twoDigits - 1));
        decodeStringHelper(s, i - 2, dp, sb, result);
        sb.deleteCharAt(0);
    }
}
}

  