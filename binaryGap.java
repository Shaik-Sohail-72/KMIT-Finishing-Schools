/*Given a positive integer n, find and return the longest distance 
between any two adjacent 1's in the binary representation of n.
 If there are no two adjacent 1's, return 0.

Two 1's are adjacent if there are only 0's separating them (possibly no 0's).
The distance between two 1's is the absolute difference between their bit positions. 
 For example, the two 1's in "1001" have a distance of 3.
input format:
an integer number
output format:
an integer number

Example 1:
Input:  22
Output: 2

Explanation: 22 in binary is "10110".
The first adjacent pair of 1's is "10110" with a distance of 2.
The second adjacent pair of 1's is "10110" with a distance of 1.
The answer is the largest of these two distances, which is 2.
Note that "10110" is not a valid pair since there is a 1 separating the two 1's.

Example 2:
Input:  8
Output: 0

Explanation: 8 in binary is "1000".
There are not any adjacent pairs of 1's in the binary representation of 8, so we return 0.

Example 3:
Input: 5
Output: 2
Explanation: 5 in binary is "101".
*/
import java.util.*;
class binaryGap{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int c=0;
        int curr=0;
        int maxdis=0;
        List<Integer> ls=new ArrayList<>();
        while(n>0){
            c+=n&1;
            curr++;
            n>>=1;
            if(c==1){
                c=0;
                ls.add(curr);
            }
        }
        for(int i=0;i<ls.size()-1;i++){
            int ele=Math.abs(ls.get(i)-ls.get(i+1));
            maxdis=Math.max(maxdis,ele);
        }
        System.out.println(maxdis);
        
    }
}