/*Ganesh is working on numbers,
He is given a list of integers 1,2,3,...,N, the list is indexed from 1 to N.

Now he can shuffle the list in whatever way he want.
Shuffled list is said to be valid, if one of the following is true for i-th position in the list.
	- The integer at the i-th position is divisible by i.
	- 'i' is divisible by the integer at the i-th position.

Now your task is to find out, How many valid shuffles can Ganesh do?

Input Format:
-------------
An integer N, where N<=20.

Output Format:
--------------
Print an integer, number of ways ganesh can shuffle.


Sample Input:
---------------
2

Sample Output:
----------------
2

Explanation:
------------
The first shuffled list is [1, 2]:
Integer at the 1st position (i=1) is 1, and 1 is divisible by i (i=1).
Integer at the 2nd position (i=2) is 2, and 2 is divisible by i (i=2).

The second shuffled list is [2, 1]:
Integer at the 1st position (i=1) is 2, and 2 is divisible by i (i=1).
Integer at the 2nd position (i=2) is 1, and i (i=2) is divisible by 1.
*/
import java.util.*;

public class BeautifulArrangement {
    public int countArrangement(int N) {
        // arr[0] is reserved for sum
        int[] array = new int[N + 1];
        settle(N, array);
        return array[0];
    }
    
    private void settle(int n, int[] array) {
        if (n == 1) {
            // 1 could be settled anywhere, sum++
            array[0] ++;
            return;
        }
        for (int i = 1; i < array.length; i ++) {
           // check i is not occupied and fit n
            if (array[i] == 0 && (n % i == 0 || i % n == 0)) {
                // n is settled to i
                array[i] = n;
               // get n - 1 settled
                settle(n - 1, array);
               // backtrack
                array[i] = 0;
            }
        }
    }
    
	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		System.out.println(new BeautifulArrangement().countArrangement(n));		
	}
}
