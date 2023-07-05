/*Ms. Devika is playing number games, she come across a different problem and she is seeking your help to solve that problem. The problems statement is, there is an integer array nums, and an integer k. nums comprises of only 0's and 1's. In one move, we have to choose two adjacent indices and swap their values.Return the minimum number of moves required so that nums array has k consecutive 1's.
The following are the constraints
1 <= nums.length <= 105
nums[i] is 0 or 1.
1 <= k <= sum(nums)

input format : integer number( say n)
               n number of integers (only 0 and 1)
			   integer value (say k)
output = integer number
Example 1:
Input: nums = [1,0,0,1,0,1], k = 2
Output: 1
Explanation: In 1 move, nums could be [1,0,0,0,1,1] and have 2 consecutive 1's.

Example 2:
Input: 8
1
0
0
0
0
0
1
1
3
Output: 5
Explanation: In 5 moves, the leftmost 1 can be shifted right until nums = [0,0,0,0,0,1,1,1].

Example 3:
Input: 4
1
1
0
1
2
Output: 0
Explanation: nums already has 2 consecutive 1's.*/
import java.util.*;
class Main {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int arr[]=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        int k=sc.nextInt();
        System.out.println(minMoves(arr,k));
    }
    public static int minMoves(int[] nums, int k) {
        if(k == 1)
            return 0;
        List<Integer> ones_indices = new ArrayList<>();
        for(int i = 0; i < nums.length; i++) 
            if(nums[i] == 1)
                ones_indices.add(i);
        int totalOnes = ones_indices.size();
        List<Integer> pre_sum = new ArrayList<>(totalOnes);
        pre_sum.add(ones_indices.get(0));
        
        for(int i = 1; i < totalOnes; i++) 
            pre_sum.add(ones_indices.get(i) + pre_sum.get(i-1));
        
        int ans = Integer.MAX_VALUE;
        
        for(int mid = (k-1)/2 ; mid < totalOnes - k/2; mid++) {
            int radius = (k-1)/2;
            int right = k%2 == 0 ? pre_sum.get(mid+radius+1) - pre_sum.get(mid) - ones_indices.get(mid) :       // even case
                                   pre_sum.get(mid+radius) - pre_sum.get(mid);                                  // odd case
            int left =  (mid == 0 ? 0 : pre_sum.get(mid-1)) - (mid-radius == 0 ? 0 : pre_sum.get(mid-radius-1));
            int save = (radius+1)*radius + (k%2 == 0 ? radius+1 : 0);
            ans = Math.min(ans, right - left - save);
        }
        return ans;
    }
}   


   
