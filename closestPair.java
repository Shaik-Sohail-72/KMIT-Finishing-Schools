/* Two brothers want to play a game, 
The rules of the game are: one player gives two sorted lists of 
numerical elements and a number (sum). 
The opponent has to find the closest pair of elements 
to the given sum.
-> pair consists of elements from each list
Please help those brothers to develop a program, that takes 
two sorted lists as input and return a pair as output.

Input Format:
-------------
size of list_1
list_1 values
size of list_2
list_2 values
closest number

Output Format:
--------------
comma-separated pair

Sample Input-1:
---------------
4
1 4 5 7
4  
10 20 30 40
32
Sample Output-1
---------------
1,30

Sample Input-2
---------------
3
2 4 6
4
5 7 11 13
15

*/
import java.util.*;
class cloestPair{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int n1=sc.nextInt();
        int arr1[]=new int[n1];
        for(int i=0;i<n1;i++){
            arr1[i]=sc.nextInt();
        }
        int n2=sc.nextInt();
        int arr2[]=new int[n2];
        for(int i=0;i<n2;i++){
            arr2[i]=sc.nextInt();
        }
        int target=sc.nextInt();
        
        
        
        int slow=0;
        int fast=n2-1;;
        int diff=(arr1[0]+arr2[n2-1])-target;
        int ele1=arr1[0];
        int ele2=arr2[n2-1];
        for(int b=0;b<n1;b++){
            int sum=arr1[slow]+arr2[fast];
            if(sum>target){
                fast--;
            }else if(sum<target){
                slow++;
            }
            sum=arr1[slow]+arr2[fast];
            if(Math.abs(sum-target)<diff){
                diff=Math.abs(sum-target);
                ele1=arr1[slow];
                ele2=arr2[fast];
            }
        }
        System.out.println(ele1+","+ele2);
    }
}