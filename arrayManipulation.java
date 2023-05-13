/*Starting with a 1-indexed array of zeros and a list of operations, for each operation add a value to each the array element between two given indices, inclusive. Once all operations have been performed, return the maximum value in the array.

Example
n = 10
queries = [[1,5,3],[4,8,7],[6,9,1]]
Queries are interpreted as follows:

    a b k
    1 5 3
    4 8 7
    6 9 1
Add the values of k between the indices  and  inclusive:

index->	 1 2 3  4  5 6 7 8 9 10
	[0,0,0, 0, 0,0,0,0,0, 0]
	[3,3,3, 3, 3,0,0,0,0, 0]
	[3,3,3,10,10,7,7,7,0, 0]
	[3,3,3,10,10,8,8,8,1, 0]
The largest value is 10 after all operations are performed.

Function Description

Complete the function arrayManipulation in the editor below.

arrayManipulation has the following parameters:

int n - the number of elements in the array
int queries[q][3] - a two dimensional array of queries where each queries[i] contains three integers, a, b, and k.
Returns

int - the maximum value in the resultant array
Input Format

The first line contains two space-separated integers n and m, the size of the array and the number of operations.
Each of the next  lines contains three space-separated integers a,b  and k, the left index, right index and summand.

Constraints

m <=n <=10^7
1 <=m <=2*10^5
1<= a<= b <= n
0<= k <= 10^9

Sample Input

5 3
1 2 100
2 5 100
3 4 100
Sample Output

200
Explanation

After the first update the list is 100 100 0 0 0.
After the second update list is 100 200 100 100 100.
After the third update list is 100 200 200 200 100.

The maximum value is 200.
*/
import java.util.*;
public class arrayManipulation {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int q=sc.nextInt();
        int arr[][]=new int[q][3];
        for(int i=0;i<q;i++){
            for(int j=0;j<3;j++){
                arr[i][j]=sc.nextInt();
            }
        }
        //System.out.println(brutefind(n,arr));
        System.out.println(optimalfind(n,arr));
    }
    // Bruteforce Solution  O(m*(b-a))
    public static long brutefind(int n,int[][] queries){
        int arr[]=new int[n];
        for(int i=0;i<queries.length;i++){
            int a=queries[i][0]-1;
            int b=queries[i][1]-1;
            int k=queries[i][2];
            for(int j=a;j<=b;j++){
                arr[j]+=k;
            }
        }
        long m=0;
        for(int i=0;i<n;i++){
            m=Math.max(m,arr[i]);
        }
        return m;
    }
    // Optimal Solution  O(m+n)
    /*public static long optimalfind(int n,int[][] queries){
        int arr[]=new int[n+2];
        for(int i=0;i<queries.length;i++){
            int a=queries[i][0];
            int b=queries[i][1];
            int k=queries[i][2];
            arr[a]+=k;
            arr[b+1]-=k;
        }
        long m=0;
        for(int i=1;i<=n;i++){
            arr[i]+=arr[i-1];
            m=Math.max(m,arr[i]);
        }
        return m;
    }*/
    public static long optimalfind(int n,int[][] queries){
        int arr[]=new int[n+1];
        for(int i=0;i<queries.length;i++){
            int a=queries[i][0]-1;
            int b=queries[i][1]-1;
            int k=queries[i][2];
            arr[a]+=k;
            arr[b+1]-=k;
        }
        /*long m=0;
        for(int i=1;i<=n;i++){
            arr[i]+=arr[i-1];
            m=Math.max(m,arr[i]);
        }*/
        long m=0;
        for(int i=0;i<=n;i++){
            m=Math.max(m,arr[i]);
        }
        System.out.println(Arrays.toString(arr));
        return m;
    }
}
