/*In your apartment election counting is going on for socity president, and committe asked you to prepare a program to find which candidate has got the majoirty. You will be given an intger array you have to select which number appears more than ?n / 2? times. 
input format : integer number n
               n number of integers
output format : integer 
Note:- if array doesnot have a number repeated more than ?n / 2? times then return -1
       
Example 1:
Input:3
3 2 3
Output: 3
Example 2:
Input:7
2 2 1 1 1 2 2
Output: 2
*/

import java.util.*;
class Main
{
    public static int findMajority(int[] nums)
    {
        HashMap <Integer, Integer> map = new HashMap<>();
        
        for(int i : nums) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        for(Map.Entry<Integer,Integer> i : map.entrySet()) {
            if(i.getValue() > (nums.length/2)) {
                return i.getKey();
            }
        }
        return -1;
    }

    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int arr[] = new int[n];
        for(int i=0;i<n;i++)
            arr[i]=sc.nextInt();

        System.out.println(findMajority(arr));
    }
}



    