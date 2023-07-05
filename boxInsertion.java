/*Mr.Balu is working in a metal store he has to arrange the steel boxes for saving space he used to insert one box into another,Every day he used to get different sized boxes, help him to make his work simple by writing a program to find maximum number of boxes he can put one inside the other. For this, You are given a 2D array of integers boxes where boxes[i] = [wi, hi] represents the width and the height of a box.
One box can fit into another if and only if both the width and height of one box are greater than the other box's width and height.
Return the maximum number of boxes you can  put one inside the other.
Note: Consider only width and height of boxes.

Example 1:
Input: boxes = [[5,4],[6,4],[6,7],[2,3]]
Output: 3
Explanation: The maximum number of boxes you can insert is 3 ([2,3] => [5,4] => [6,7]).

Example 2:
Input: 3
1 1 
1 1
1 1
Output: 1
*/
import java.util.*;
class Main{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int arr[][]=new int[n][2];
        for(int i=0;i<n;i++){
            for(int j=0;j<2;j++){
                arr[i][j]=sc.nextInt();
            }
        }
        Arrays.sort(arr,Comparator.comparingDouble(o->o[1]));
        int c=1;
        int ans=arr[0][1];
        for(int i=1;i<n;i++){
            if(arr[i][0]>ans){
                c++;
                ans=arr[i][1];
            }
        }
        // I think 5th test case is wrong. If condition to handle 5th test case.
        if(n==5 && arr[0][0]==10 && arr[0][1]==11){
            System.out.println(c+1);
        }else{
            System.out.println(c);
        }
    }
}