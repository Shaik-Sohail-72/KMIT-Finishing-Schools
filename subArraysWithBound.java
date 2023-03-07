/*You are given an integer array nums and two integers minK and maxK.

A fixed-bound subarray of nums is a subarray that satisfies the following conditions:

The minimum value in the subarray is equal to minK.
The maximum value in the subarray is equal to maxK.
Return the number of fixed-bound subarrays.

A subarray is a contiguous part of an array.
 input = 4
  1 1 1 1 
  1
  1
  output = 10


Example 1:

Input: nums = [1,3,5,2,7,5], minK = 1, maxK = 5
Output: 2
Explanation: The fixed-bound subarrays are [1,3,5] and [1,3,5,2].
Example 2:

Input: nums = [1,1,1,1], minK = 1, maxK = 1
Output: 10
Explanation: Every subarray of nums is a fixed-bound subarray. There are 10 possible subarrays.
 
Constraints:
2 <= nums.length <= 10^5
1 <= nums[i], minK, maxK <= 10^6
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
        int min=sc.nextInt();
        int max=sc.nextInt();
        System.out.println(cal(n,arr,min,max));
    }
    public static int cal(int n,int arr[],int min,int max){
        int k=1;
        int c=0;
        while(k<=n){
            for(int i=0;i<n-k+1;i++){
                List<Integer> ls=new ArrayList<>();
                for(int j=i;j<i+k;j++){
                    ls.add(arr[j]);
                }
                Collections.sort(ls);
                if(ls.get(0)==min && ls.get(ls.size()-1)==max){
                    c++;
                }
            }
            k++;
        }
        return c;
    }
}