/*Given an integer array arr, return the number of distinct bitwise ORs of all the non-empty subarrays of arr.

The bitwise OR of a subarray is the bitwise OR of each integer in the subarray. 
The bitwise OR of a subarray of one integer is that integer.

A subarray is a contiguous non-empty sequence of elements within an array.
input:- number of integers and list of integers
output:- Return the number of distinct bitwise ORs of all the non-empty subarrays.

Example 1:

Input: 1
0
Output: 1
Explanation: There is only one possible result: 0.
Example 2:
Input: 3
1 1 2
Output: 3
Explanation: The possible subarrays are [1], [1], [2], [1, 1], [1, 2], [1, 1, 2].
These yield the results 1, 1, 2, 1, 3, 3.
There are 3 unique values, so the answer is 3.

Example 3:
Input:3
1 2 4
Output: 6
Explanation: The possible results are 1, 2, 3, 4, 6, and 7.
*/

import java.util.*;
class bitwoseOr{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int arr[]=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        int k=1;
        Set<Integer> mainset=new HashSet<>();
        while(k<=n){
            for(int i=0;i<n-k+1;i++){
                List<Integer> ls=new ArrayList<>();
                for(int j=i;j<i+k;j++){
                    ls.add(arr[j]);
                }
                int ele=0;
                for(int q=0;q<ls.size();q++){
                    ele=ele|ls.get(q);
                }
                mainset.add(ele);
            }
            k++;
        }
        System.out.println(mainset.size());
    }
}