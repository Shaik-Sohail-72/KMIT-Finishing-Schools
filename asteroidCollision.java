/*We are given an array asteroids of integers representing asteroids in a row.
For each asteroid, the absolute value represents its size, and the sign represents its direction (positive meaning right, negative meaning left). Each asteroid moves at the same speed.

Find out the state of the asteroids after all collisions. If two asteroids meet, the smaller one will explode. If both are the same size, both will explode. Two asteroids moving in the same direction will never meet.

Example 1:

Input: Size=3
asteroids = 5 10 -5
Output: [5,10]
Explanation: The 10 and -5 collide resulting in 10. The 5 and 10 never collide.

Example 2:
Input: Size=2 
asteroids = 8 -8
Output: []
Explanation: The 8 and -8 collide exploding each other.

Example 3:
Input:Size=3 
asteroids = 10 2 -5
Output: [10]
Explanation: The 2 and -5 collide resulting in -5. The 10 and -5 collide resulting in 10.
 
Constraints:
2 <= asteroids.length <= 10^4
-1000 <= asteroids[i] <= 1000
asteroids[i] != 0*/

import java.util.*;
class Main{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int arr[]=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        Stack<Integer> st=new Stack<>();
        for(int i=0;i<n;i++){
            if(arr[i]>0){
                st.push(arr[i]);
            }else{
                while(!st.isEmpty() && st.peek()>0 && st.peek()<Math.abs(arr[i])){
                    st.pop();
                }
                if(st.isEmpty() || st.peek()<0 ){
                    st.push(arr[i]);
                }else if(st.peek()==Math.abs(arr[i])){
                    st.pop();
                }
            }
        }
        List<Integer> ls=new ArrayList<>();
        while(!st.isEmpty()){
            ls.add(st.pop());
        }
        Collections.sort(ls);
        System.out.println(ls);
    }
}