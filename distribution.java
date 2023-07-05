/*Microsoft is issuing shares to it's employees are rated based on their performance. There are n employees and each employee is assigned a rating value given in the integer array ratings. And the following two constraints are to be followed when issuing shares
requirements:
1.Each employee must have at least one share.
2.Employee with a higher rating get more shares than their neighbors.

Return the minimum number of shares you need to have to distribute to the employees.
input format = number n
n number of integers
output = integer number
Sample cases: 

Example 1:

Input: ratings = [1,0,2]
Output: 5
Explanation: You can allocate to the first, second and third emploeyee with 2, 1, 2 shares respectively.
Example 2:

Input: ratings = [1,2,2]
Output: 4
Explanation: You can allocate to the first, second and third employee with 1, 2, 1 shares respectively.
The third employee gets 1 share because it satisfies the above two conditions.
 

Constraints:

n == ratings.length
1 <= n <= 2 * 104
0 <= ratings[i] <= 2 * 104*/

import java.util.Scanner;

public class Main {
    public static int minimumShares(int[] ratings) {
        int n = ratings.length;
        int[] shares = new int[n];
        shares[0] = 1;

        for (int i = 1; i < n; i++) {
            if (ratings[i] > ratings[i - 1]) {
                shares[i] = shares[i - 1] + 1;
            } else {
                shares[i] = 1;
            }
        }

        for (int i = n - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1] && shares[i] <= shares[i + 1]) {
                shares[i] = shares[i + 1] + 1;
            }
        }

        int totalShares = 0;
        for (int share : shares) {
            totalShares += share;
        }

        return totalShares;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        int[] ratings = new int[n];
        for (int i = 0; i < n; i++) {
            ratings[i] = scanner.nextInt();
        }

        int minShares = minimumShares(ratings);
        System.out.println( minShares);
    }
}



    