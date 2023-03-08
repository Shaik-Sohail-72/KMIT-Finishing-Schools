/*Mr.Sathya is playing with numbers he converts the decimal to binary and try to find number of positions at which the corresponding
bits are different. Help sathya by giving solution to the problem to find sum of bits differences between all the pairs of the 
integers in given numbers.
Input
Number of integers and List of integers
output
Return the sum of bit differences between all the pairs of the integers.
Example 1:

Input:
3
4 14 2
Output:4 14
4 2
14 2
6
Explanation: In binary representation, the 4 is 0100, 14 is 1110, and 2 is 0010 (just
showing the four bits relevant in this case).
The answer will be:
HammingDistance(4, 14) + HammingDistance(4, 2) + HammingDistance(14, 2) = 2 + 2 + 2 = 6.

Example 2:
Input: 
3
4 14 4
Output: 4 14
4 4
14 4
4*/

/*

Calculate the XOR of two numbers.
Count the number of set bits.

*/
import java.util.*;
class totalHammingDistance{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int arr[]=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        System.out.println(cal(n,arr));
    }
    public static int cal(int n,int arr[]){
        int sum=0;
        for(int i=0;i<n;i++){
            List<Integer> ls=new ArrayList<>();
            for(int j=i+1;j<n;j++){
                System.out.println(arr[i]+" "+arr[j]);
                sum+=countOne(arr[i]^arr[j]);
            }
        }
        return sum;
    }
    public static int countOne(int n){
        int count=0;
        while(n>0){
            count+=n&1;
            n>>=1;
        }
        return count;
    }
}