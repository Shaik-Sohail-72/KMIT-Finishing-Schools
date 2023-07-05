/*Raj is a Hockey player who plays domestic matches , Inorder to qualify for the nationals he has to score a 'target' no of goals.He can play any number of matches, goals scored in every match is noted as an array.Indentify the minimum no of matches whose number of Goals scored sums upto the 'target' number.
Example :
Input: target = 7, nums = [2,3,1,2,4,3]
Output: 2
Explanation: Raj scored [4,3] goals in these couple of matches to achieve the sum target.

Input format:
Line-1: Length of the array
Line-2: Array
Line-3: Target integer
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
        int t=sc.nextInt();
        int k=1;
        while(k<=n){
            for(int i=0;i<n-k+1;i++){
                int s=0;
                for(int j=i;j<i+k;j++){
                    s+=arr[j];
                }
                if(s==t){
                    System.out.println(k);
                    System.exit(0);
                }
                if(s<t && k==n){
                    System.out.println(0);
                }
            }
            k++;
        }
    }
}