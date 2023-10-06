/*Geek is very fond of patterns. Once, his teacher gave him a square pattern to solve. He gave Geek an integer n and asked him to build a pattern.

Help Geek to build a star pattern.

 

Example 1:

Input: 5

Output:
* * * * *
* * * * *
* * * * *
* * * * *
* * * * *
 

Your Task:

You don't need to input anything. Complete the function printSquare() which takes  an integer n  as the input parameter and print the pattern.

Constraints:

1<= N <= 20*/

/*
Steps for patterns:
1. For the outer loop, count the number of lines.
2. For the inner loop, focus on the columns, and connect them somehow to the rows.
3. Print them "*" inside the inner for loop
4. Observe symmetry (optional)
*/
class Solution {
    void printSquare(int n) {
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                System.out.print("*"+" ");
            }
            System.out.println();
        }
    }
}