/*You are given an integer array matchsticks where matchsticks[i] is the length of the ith matchstick. You want to use all the matchsticks to make one square. You should not break any stick, but you can link them up, and each matchstick must be used exactly one time.

Return true if you can make this square and false otherwise.
input : integer n which gives number of match sticks
        n integer values
output : true/false
example
input = 
5
1 1 2 2 2
output = true
Explanation : we can use match sticks with length 1 to form one side and other three sides are having match sticks with length 2
example 
input = 
5
3 3 3 3 4
output = false
Explanation we cannot for swuare using all the five matchsticks
*/
import java.util.*;
public class Main {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int arr[]=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        System.out.println(makesquare(arr));
    }
    public static boolean makesquare(int[] nums) {
        if (nums == null || nums.length < 4) return false;
        int sum = 0;
        for (int num : nums) sum += num;
        if (sum % 4 != 0) return false;
        
        return dfs(nums, new int[4], 0, sum / 4);
    }
    
    private static boolean dfs(int[] nums, int[] sums, int index, int target) {
        if (index == nums.length) {
            if (sums[0] == target && sums[1] == target && sums[2] == target) {
            return true;
            }
            return false;
        }
        
        for (int i = 0; i < 4; i++) {
            if (sums[i] + nums[index] > target) continue;
            sums[i] += nums[index];
            if (dfs(nums, sums, index + 1, target)) return true;
            sums[i] -= nums[index];
        }
        
        return false;
    }
}


   