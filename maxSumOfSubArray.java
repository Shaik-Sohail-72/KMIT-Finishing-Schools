/*
There is an integer array of N heights. You have to pick a certain number of heights
from the array every time. Find the maximum  sum of all the heights picked 
every time that meets the following conditions:
    - The length of the subarray is L, and
    - All the heights of the subarray picked are distinct.

Return the maximum subarray sum of all the height subarrays that meet the 
conditions. If no heights subarray meets the conditions, return 0.

- A subarray is a contiguous non-empty sequence of elements within an array.

Input Format:
-------------5
Line-1: Two space separated integers, N and L
Line-2: N space separated integers, height[].

Output Format:
--------------
Print an integer result.


Sample Input-1:
---------------
7 3
7 7 7 1 5 4 2

Sample Output-1:
----------------
13

Explanation: 
------------
The subarrays of length 3 of height array are:
    - [7,7,7] this subarray does not meet the requirement because the 7 is repeated.
    - [7,7,1] this subarray does not meet the requirement because the 7 is repeated.
    - [7,1,5] this subarray meets the requirements and its sum is 13.
    - [1,5,4] this subarray meets the requirements and its sum is 10.
    - [5,4,2] this subarray meets the requirements and its sum is 11. 

Return 13 because it is the maximum subarray sum of all the subarrays 
that meet the conditions


Sample Input-2:
---------------
3 3
7 7 7

Sample Output-2:
----------------
0

Explanation:
------------
The subarrays of length 3 of height array are:
- [7,7,7] which does not meet the requirements because the element 7 is repeated.

Return 0 because no subarrays meet the conditions.

*/
import java.util.*;
class maxSumOfSubArray{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int k=sc.nextInt();
        int arr[]=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        List<Integer> mainls=new LinkedList<>();
        Set<Integer> st=new HashSet<>();
        for(int i=0;i<n-k+1;i++){
            int s=0;
            for(int j=i;j<i+k;j++){
                st.add(arr[j]);
                s+=arr[j];
            }
            if(st.size()==k){
                mainls.add(s);
            }
            st.clear();
        }
        Collections.sort(mainls);
        if(mainls.size()!=0){
        System.out.println(mainls.get(mainls.size()-1));}
        else{
            System.out.println(0);
        }
    }
}