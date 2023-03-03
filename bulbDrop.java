/*You are given two identical bulbs and you have access to a building with n floors labeled from 1 to n.

You know that there exists a floor f where 0 <= f <= n such that any bulb dropped at a floor higher than f will break, and any bulb dropped at or below floor f will not break.

In each move, you may take an unbroken bulb and drop it from any floor x (where 1 <= x <= n). If the bulb breaks, you can no longer use it. However, if the bulb does not break, you may reuse it in future moves.

Return the minimum number of moves that you need to determine with certainty what the value of f is.

 

Example 1:

Input: n = 2
Output: 2
Explanation: We can drop the first bulb from floor 1 and the second bulb from floor 2.
If the first bulb breaks, we know that f = 0.
If the second bulb breaks but the first bulb didn't, we know that f = 1.
Otherwise, if both bulbs survive, we know that f = 2.
Example 2:

Input: n = 100
Output: 14
Explanation: One optimal strategy is:
- Drop the 1st bulb at floor 9. If it breaks, we know f is between 0 and 8. Drop the 2nd bulb starting from floor 1 and going up one at a time to find f within 8 more drops. Total drops is 1 + 8 = 9.
- If the 1st bulb does not break, drop the 1st bulb again at floor 22. If it breaks, we know f is between 9 and 21. Drop the 2nd bulb starting from floor 10 and going up one at a time to find f within 12 more drops. Total drops is 2 + 12 = 14.
- If the 1st bulb does not break again, follow a similar process dropping the 1st bulb from floors 34, 45, 55, 64, 72, 79, 85, 90, 94, 97, 99, and 100.
Regardless of the outcome, it takes at most 14 drops to determine f.
 

Constraints:

1 <= n <= 1000
*/
import java.util.*;
class Main{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int k=1;
        int c=0;
        while(n>0){
            n-=k;
            c++;
            k++;
        }
        System.out.println(c);
    }
}