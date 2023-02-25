/*There is a party happening in Novotel. There are N guests in the party.
There is a detective in the party and he/she is among one of the guests.
The guests are identified with unique ID's starts from 1 to N.

The rules to identify the detective are:
	- Every guest in the party knows the detective.
	- The detective knows no one in the party.
	- There is only one guest who satisfy both rule-1 and rule-2

You are given two integers N and R and the relations as an array, relations[], where relation[i]={guest-i, guest-j}, indicates guest-i knows h=guest-j.
Your task is to find the detective among the guests in the party and print the ID of the detective, Otherwise print -1.

Input Format:
-------------
Line-1: Two integers N and R, the number of guests and relations in the party.
Next R lines: contains 2 space-separated integers, relation[i]

Output Format:
--------------
Print an integer, the id of the detective.


Sample Input-1:
---------------
3 2		// N and R values
1 3
2 3

Sample Output-1:
----------------
3


Sample Input-2:
---------------
3 3
1 2
2 3
3 1

Sample Output-2:
----------------
-1*/
import java.util.*;
class findDetective{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int r=sc.nextInt();
        int rel[][]=new int[r][r];
        for(int i=0;i<r;i++){
            for(int j=0;j<2;j++){
                rel[i][j]=sc.nextInt();
            }
        }
        System.out.println(cal(n,rel));
    }
    public static int cal(int n, int[][] rel) {
            int[] arr = new int[n+1];
            for(int[] det:rel){
                arr[det[0]]--;
                arr[det[1]]++;
            }
            for(int i=0;i<arr.length;i++){
                if(arr[i]==n-1){
                    return i;
                }
            }
            return -1;
    }
}