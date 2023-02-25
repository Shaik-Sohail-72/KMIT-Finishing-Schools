/*Mr Subodh is given an array arr[] of M integers between 0 to 10000.
And he is also given another integer P.
Subodh has to update each integer in the arr[]:
Subodh is allowed to update the arr[i], as follows:
	- arr[i] = arr[i] + P (or) arr[i] = arr[i] - P.

Subodh has to find the update score as the difference between 
maximum element in the arr[] to the minimum element arr[] after all the
elements in the arr[] updated. and return the minimum update score.

Input Format:
-------------
Line-1: Two space separated integers M and P.
Line-2: M space separated integers, integer > 0.

Output Format:
--------------
Print an integer result.

Sample Input-1:
---------------
3 2
2 6 3

Sample Output-1:
----------------
1

Explanation: 
------------
Update the array as [4, 4, 5]. The score is maximum(arr) - minimum(arr)
=> 5 - 4 = 1.


Sample Input-2:
---------------
4 3
1 11 8 4

Sample Output-2:
----------------
4

Explanation: 
------------
Update the array as [4, 8, 5, 7]. The score is maximum(arr) - minimum(arr) 
=> 8 - 4 = 4
*/

/*import java.util.*;
class Main{
    public static void cal(int array[],int p){
        int temp=p*2;
        for(int i=0;i<array.length;i++){
            if(array[i]>temp){
                array[i]=array[i]-p;
            }
            else{
                array[i]=array[i]+p;
            }
        }
        Arrays.sort(array);
        System.out.println(array[array.length-1]-array[0]);
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int p=sc.nextInt();
        int arr[]=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        cal(arr,p);
    }
}*/

/*8
import java.util.*;
class Main
{
    public static void main (String[] args)
    {
        Scanner scobj=new Scanner(System.in);
        int m=scobj.nextInt();
        int p=scobj.nextInt();
        int[] arr=new int[m];
        int[] b=new int[m];
        int max=Integer.MIN_VALUE;
        int min=Integer.MAX_VALUE;
        for(int i=0;i<m;i++)
        {
            arr[i]=scobj.nextInt();
            max=Math.max(max,arr[i]);
            min=Math.min(min,arr[i]);
        }
        int r=(max+min)/2;
        int m1=Integer.MIN_VALUE;
        int m2=Integer.MAX_VALUE;
        
        for(int i=0;i<m;i++)
        {
            if(arr[i]<=r)
            {
                b[i]=arr[i]+p;
                m1=Math.max(m1,b[i]);
                m2=Math.min(m2,b[i]);
            }
            else
            {
                b[i]=arr[i]-p;
                m1=Math.max(m1,b[i]);
                m2=Math.min(m2,b[i]);
            }
        }
        System.out.println(m1-m2);
    }
}

*/
import java.util.*;
class smallestRange{
    static int helper(int [] arr, int p){
        Arrays.sort(arr);
        int len = arr.length-1;
        int max = arr[len]-p;
        int min = arr[0]+p;
        int res = arr[len]-arr[0] ;
        for(int i=0;i<=len-1;i++){
            int curmax= Math.max(max,arr[i]+p);
            int curmin= Math.min(min,arr[i+1]-p);
            res = Math.min(res,curmax-curmin);
        }
        return res;
    }
    public static void main(String []args){
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int p = sc.nextInt();
        int [] arr = new int[m];
        for(int i=0;i<m;i++){
            arr[i]=sc.nextInt();
        }
        System.out.println(helper(arr,p));
    }
    
}