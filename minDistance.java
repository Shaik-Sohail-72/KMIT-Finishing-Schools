/*Given two strings word1 and word2, return the minimum number of operations required to convert word1 to word2.

You have the following three operations permitted on a word:

Insert a character
Delete a character
Replace a character
 
Example 1:
Input: word1 = "horse", word2 = "ros"
Output: 3
Explanation: 
horse -> rorse (replace 'h' with 'r')
rorse -> rose (remove 'r')
rose -> ros (remove 'e')

Example 2:
Input: word1 = "intention", word2 = "execution"
Output: 5
Explanation: 
intention -> inention (remove 't')
inention -> enention (replace 'i' with 'e')
enention -> exention (replace 'n' with 'x')
exention -> exection (replace 'n' with 'c')
exection -> execution (insert 'u')
 
Constraints:

0 <= word1.length, word2.length <= 500
word1 and word2 consist of lowercase English letters.*/
import java.util.*;
class Main {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        String s=sc.next();
        String t=sc.next();
        System.out.println(editDistance(s,t));
    }
    public static  int editDistance(String s, String t) {
        
        int dp[][]=new int[s.length()][t.length()];
        for(int[] arr:dp){
            Arrays.fill(arr,-1);
        }
        
        return helper(s,t,s.length()-1,t.length()-1,dp);
        
    }
    
    
    public static int helper(String s,String t,int i,int j,int dp[][]){
        
        if(i==-1&&j==-1)return 0;
        if(i==-1){
            return j+1;
        }
        if(j==-1){
            return i+1;
        }
        
        
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        
        
        if(s.charAt(i)==t.charAt(j)){
            dp[i][j]=helper(s,t,i-1,j-1,dp);
        }
        else{
            dp[i][j]=1+Math.min(helper(s,t,i-1,j,dp),Math.min(helper(s,t,i,j-1,dp),helper(s,t,i-1,j-1,dp)));
        }
        
        return dp[i][j];
    }
}



    