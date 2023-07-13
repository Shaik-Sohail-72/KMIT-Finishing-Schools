/*Given an array of positive integers. We need to make the given array a ‘Palindrome’. The only allowed operation is”merging” (of two adjacent elements). Merging two adjacent elements means replacing them with their sum. The task is to find the minimum number of merge operations required to make the given array a ‘Palindrome’.

Example : 

Input : arr[] = {15, 4, 15}
Output : 0
Array is already a palindrome. So we
do not need any merge operation.

Input : arr[] = {1, 4, 5, 1}
Output : 1
We can make given array palindrome with
minimum one merging (merging 4 and 5 to
make 9)

Input : arr[] = {11, 14, 15, 99}
Output : 3
We need to merge all elements to make
a palindrome.


The expected time complexity is O(n).*/

import java.util.*;
public class minOperation {
    public static int minOp(int n,int arr[]){
        int i=0;
        int j=n-1;
        int ans=0;
        while(i<=j){
            if(arr[i]==arr[j]){
                i++;
                j--;
            }else if(arr[i]<arr[j]){
                i++;
                arr[i]+=arr[i-1];
                ans++;
            }else if(arr[j]<arr[i]){
                j--;
                arr[j]+=arr[j+1];
                ans++;
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int arr[]=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        System.out.println(minOp(n,arr));
    }   
}
