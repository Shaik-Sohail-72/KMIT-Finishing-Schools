/*shobraj is  a professional robber planning to rob houses along a street. Each house has a 
certain amount of money stashed, the only constraint stopping him from robbing each of 
them is that adjacent houses have security systems connected and it will automatically 
contact the police if two adjacent houses were broken into on the same night.

Given an integer array nums representing the amount of money of each house, return the 
maximum amount of money he can rob tonight without alerting the police.

 

Example 1:

Input: 
4
1 2 3 1
Output: 4
Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
Total amount you can rob = 1 + 3 = 4.
Example 2:

Input: 5 
2 7 9 3 1
Output: 12
Explanation: Rob house 1 (money = 2), rob house 3 (money = 9) and rob house 5 (money = 1).
Total amount you can rob = 2 + 9 + 1 = 12.
*/
import java.util.*;
class Main{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int arr[]=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        System.out.println(cal(n,arr));
    }
    public static int cal(int n,int arr[]){
        int s1=0;
        int s2=0;
        for(int i=0;i<n;i++){
            if(i%2==0){
                s1=Math.max(s1+arr[i],s2);
            }else{
                s2=Math.max(s2+arr[i],s1);
            }
        }
        return Math.max(s1,s2);
    }
}