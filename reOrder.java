/*
Given an array nums with n objects colored red, white, or blue, sort them in-place so that objects of the same color are adjacent, with the colors in the order red, white, and blue.

We will use the integers 0, 1, and 2 to represent the color red, white, and blue, respectively.

You must solve this problem without using the library's sort function and use two pointer approach.
sample cases
example 1
input = 8
0 1 2 0 1 2 2 1
output = 0 0 1 1 1 2 2 2
example 2
input = 5
1 2 1 2 1
output = 1 1 1 2 2
*/
import java.util.*;
class Main{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int arr[]=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        order(arr,n);
    }
    public static void order(int arr[],int n){
        int l=0;
        int m=0;
        int h=n-1;
        while(m<=h){
            if(arr[m]==0){
                int temp=arr[l];
                arr[l]=arr[m];
                arr[m]=temp;
                l++;
                m++;
            }else if(arr[m]==1){
                m++;
            }else{
                int temp=arr[m];
                arr[m]=arr[h];
                arr[h]=temp;
                h--;
            }
        }
        for(int i=0;i<n;i++){
            System.out.print(arr[i]+" ");
        }
    }
}