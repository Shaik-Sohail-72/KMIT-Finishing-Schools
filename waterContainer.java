/*Mr Akshay is playing with lines he is drawing lines with some height,imagin that two lines that together with the x-axis form a container, then find, with given integer heights maximum amount of water akshay can store,
You are given an integer array height of length n. There are n vertical lines drawn such that the two endpoints of the ith line are (i, 0) and (i, height[i]).
Return the maximum amount of water a container can store.
input :
number of lines n
n integer values of height of each line
output:
maximum water a container can store

Example 
case 1:
input :
9
1 8 6 2 5 4 8 3 7
output= 49
Explanation :
 first line height is 1 second line height is 8 like that last line height is 7, so akshay can store water between second line and last line with the height of 7
 distance between last and second line is 7 so maximum capacity is 7*7=49
 note : if we consider two 8 lines i.e at position 2 and 7 then the height of container is 8 and distance of container is 5 so water capacity is 8 * 5 = 40
 hence 49 is the maximum capacity returned.

Case 2:
input =9
1 2 3 4 5 6 7 8 9
output = 20
explanation :water is stored between line with height 5 and line with height 9 so height of container is 5 and width of container is 4 hence 5 * 4= 20
case 3:
input=10
1 1 1 1 1 1 1 10 8 10
output=20
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
        System.out.println(cal(arr,n));
    }
    /*public static int cal(int arr[],int n){
        int m=0;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                m=Math.max(m,Math.min(arr[i],arr[j])*(j-i));
            }
        }
        return m;
    }*/
    public static int cal(int arr[],int n){
        int i=0;
        int j=n-1;
        int max=0;
        while(i<=j){
            int minh=Math.min(arr[i],arr[j]);
            int dis=j-i;
            int m=minh*dis;
            if(m>max){
                max=m;
            }
            if(arr[i]<arr[j]){
                i++;
            }else{
                j--;
            }
        }
        return max;
    }
}