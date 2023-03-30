/*You are given a binary array nums containing only the integers 0 and 1. Return the number of subarrays in nums that have more 1's than 0's. Since the answer may be very large, return it modulo 109 + 7.

A subarray is a contiguous sequence of elements within an array.

 Example 1:

Input: nums = [0,1,1,0,1]
Output: 9
Explanation:
The subarrays of size 1 that have more ones than zeros are: [1], [1], [1]
The subarrays of size 2 that have more ones than zeros are: [1,1]
The subarrays of size 3 that have more ones than zeros are: [0,1,1], [1,1,0], [1,0,1]
The subarrays of size 4 that have more ones than zeros are: [1,1,0,1]
The subarrays of size 5 that have more ones than zeros are: [0,1,1,0,1]
Example 2:

Input: nums = [0]
Output: 0
Explanation:
No subarrays have more ones than zeros.
Example 3:

Input: nums = [1]
Output: 1
Explanation:
The subarrays of size 1 that have more ones than zeros are: [1]
 

Constraints:

1 <= nums.length <= 105
0 <= nums[i] <= 1
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
        System.out.println(cal(arr,n));
    }
    public static int cal(int arr[],int n){
        int k=1;
        int c=0;
        while(k<=n){
            for(int i=0;i<n-k+1;i++){
                List<Integer> ls=new ArrayList<>();
                int c0=0;
                int c1=0;
                cal1(i,k,ls,arr);
                for(int m=0;m<ls.size();m++){
                    if(ls.get(m)==1){
                        c1++;
                    }else{
                        c0++;
                    }
                }
                if(c1>c0){
                    c++;
                }
            }
            k++;
        }
        return c;
    }
    public static void cal1(int i,int k,List<Integer> ls,int arr[]){
        for(int j=i;j<i+k;j++){
            ls.add(arr[j]);
        }
    }
}