/*You are given a positive integer n, you can do the following operation any number of times:

Add or subtract a power of 2 from n.
Return the minimum number of operations to make n equal to 0.

A number x is power of 2 if x == 2i where i >= 0.

 

Example 1:

Input: n = 39
Output: 3
Explanation: We can do the following operations:
- Add 20 = 1 to n, so now n = 40.
- Subtract 23 = 8 from n, so now n = 32.
- Subtract 25 = 32 from n, so now n = 0.
It can be shown that 3 is the minimum number of operations we need to make n equal to 0.
Example 2:

Input: n = 54
Output: 3
Explanation: We can do the following operations:
- Add 21 = 2 to n, so now n = 56.
- Add 23 = 8 to n, so now n = 64.
- Subtract 26 = 64 from n, so now n = 0.
So the minimum number of operations is 3.
 

Constraints:

1 <= n <= 105
*/
import java.util.*;
class minOperations{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        System.out.println(minOperations(n));
    }
    public static int minOperations(int n) {
        int x=n;
        int cnt=0;
        while(x!=0){
            int floor=(int)Math.floor(Math.log(x)/Math.log(2));
            int ceil=(int)Math.ceil(Math.log(x)/Math.log(2));
            x=Math.min(Math.abs((1<<floor)-x),Math.abs((1<<ceil)-x));
            cnt++;
        }
        return cnt;
    }
}

  