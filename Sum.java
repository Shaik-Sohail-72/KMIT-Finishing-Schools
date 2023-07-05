/*Given a 1-indexed array of integers numbers that is already sorted in non-decreasing order, find two numbers such that they add up to a specific target number. Let these two numbers be numbers[index1] and numbers[index2] where 1 <= index1 < index2 < numbers.length.

Return the indices of the two numbers, index1 and index2, added by one as an integer array [index1, index2] of length 2.

The tests are generated such that there is exactly one solution. You may not use the same element twice.
Example 1:
input = 4
2 7 11 15
9
output =1 2
example 2:
input = 4
2 7 11 15
22
output =2 4
 */

 import java.util.*;
class Test
{
    public static void main (String[] args)
    {
        Scanner obj=new Scanner(System.in);
        int n=obj.nextInt();
        int[] arr=new int[n];
        for(int i=0;i<n;i++)
        {
            arr[i]=obj.nextInt();
        }
        int target=obj.nextInt();
        int fp=0;
        int sp=n-1;
        while(fp<sp)
        {
            if(arr[fp]+arr[sp]==target)
            {
                System.out.print((++fp)+" "+(++sp));
                System.exit(0);
            }
            if(arr[fp]+arr[sp]<target)
            {
            fp++;
            }
            else
            {
                sp--;
            }
            
        }
    }
}