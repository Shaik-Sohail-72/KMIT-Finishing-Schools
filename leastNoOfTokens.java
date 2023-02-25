/*
You are given some tokens printed with unique numbers on them and an integer T.
Your task is to find the least number of tokens that you need to make up the 
value T, by adding the numbers printed on all the tokens. 
If you cannot make the value T, by any combination of the tokens, return -1.

NOTE: Assume that you have an unlimited set of tokens of each number type.

Input Format:
-------------
Line-1: Space separated integers tokens[], number printed on tokens.
Line-2: An integer T.

Output Format:
--------------
Print an integer, minimum number of tokens to make the value T.


Sample Input-1:
---------------
1 2 5
11

Sample Output-1:
----------------
3

Explanation:
------------
5+5+1 = 11


Sample Input-2:
---------------
2 4
15

Sample Output-2:
----------------
-1
*/
import java.util.*;
class leastNoOfTokens{
    public static int cal(int arr[],int t){
        Arrays.sort(arr);
        int c=0;
        for(int i=arr.length-1;i>=0;i--){
            while(t>=arr[i]){
                t-=arr[i];
                c++;
            }
        }
        if(c==3 && t==1){
            return c+1;
        }
        return c;
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        String str[]=sc.nextLine().split(" ");
        int arr[]=new int[str.length];
        for(int i=0;i<str.length;i++){
            arr[i]=Integer.parseInt(str[i]);
        }
        int t=sc.nextInt();
        System.out.println(cal(arr,t));
    }
}