/*You are given an array of strings tokens that represents an arithmetic expression in a Reverse Polish Notation.

Evaluate the expression. Return an integer that represents the value of the expression.

Note that:

The valid operators are '+', '-', '*', and '/'.
Each operand may be an integer or another expression.
The division between two integers always truncates toward zero.
There will not be any division by zero.
The input represents a valid arithmetic expression in a reverse polish notation.
The answer and all the intermediate calculations can be represented in a 32-bit integer.
input format = n intger number
               n number of strings contains numbers and operators
output format = integer number
sample case 
case =1
input =5
5
1 2 + 3 *
output =9
case =2
input =5
4 13 5 / +
output =6
*/

import java.util.*;
 
public class RPN{
    public static int eval(String[] tokens){
        int i = 0;
        int lastNum = -1;
        while (i < tokens.length) {
            if ("/*+-".contains(tokens[i])) {
                int val1= Integer.valueOf(tokens[lastNum - 1]);
                int val2 = Integer.valueOf(tokens[lastNum]);
                int ans = 0;
                if (tokens[i].equals("*"))
                    ans = val1 * val2;
                else if (tokens[i].equals("/"))
                    ans = val1 / val2;
                else if (tokens[i].equals("+"))
                    ans = val1 + val2;
                else if (tokens[i].equals("-"))
                    ans = val1 - val2;
                tokens[lastNum - 1] = Integer.toString(ans);
                lastNum--;
            }
            else {
                lastNum++;
                tokens[lastNum] = tokens[i];
            }
            i++;
        }
        return Integer.valueOf(
            tokens[lastNum]);
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        String arr[]=new String[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.next();
        }
        int res = eval(arr);
        System.out.println(res);
    }
}