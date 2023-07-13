/*There are several cards arranged in a row, and each card has an associated number of points. The points are given in the integer array cardPoints.

In one step, you can take one card from the beginning or from the end of the row. You have to take exactly k cards.

Your score is the sum of the points of the cards you have taken.

Given the integer array cardPoints and the integer k, return the maximum score you can obtain.

 

Example 1:

Input:7
cardPoints = 1 2 3 4 5 6 1 
k = 3
Output: 12
Explanation: After the first step, your score will always be 1. However, choosing the rightmost card first will maximize your total score. The optimal strategy is to take the three cards on the right, giving a final score of 1 + 6 + 5 = 12.

Example 2:

Input:3
cardPoints = 2 2 2 
k = 2
Output: 4
Explanation: Regardless of which two cards you take, your score will always be 4.

Example 3:

Input=7
cardPoints = 9 7 7 9 7 7 9 
k = 7
Output= 55
Explanation: You have to take all the cards. Your score is the sum of points of all cards.
 

Constraints:

1 <= cardPoints.length <= 10^5
1 <= cardPoints[i] <= 10^4
1 <= k <= cardPoints.length*/
import java.util.*;
class maxPoints{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int arr[]=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        int k=sc.nextInt();
        /*int i=0;
        int j=n-1;
        int sum=0;
        while(k>0){
            if(arr[i]>arr[j]){
                sum+=arr[i];
                i++;
            }else if(arr[j]>arr[i]){
                sum+=arr[j];
                j--;
            }else{
                sum+=arr[i];
                i++;
                j++;
            }
            k--;
        }
        System.out.println(sum);
        */

        int s1=0;
        int s2=0;
        for(int i=0;i<k;i++){
            s1+=arr[i];
        }
        for(int j=n-1;j>=n-k;j--){
            s2+=arr[j];
        }
        System.out.println(Math.max(s1,s2));
    }
}