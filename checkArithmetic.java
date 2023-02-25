/*Mr Srikanth has given a task to his students.
He has given a list of N numbers, nums[], the list contains both poitive and 
negative integers. Also given two more list of integers as start[] and end[],
where start[] list contains starting indices, and end[] contains ending indices.

Now, the students task is to check and return the boolean values as a list res[],
for each 'i' between, 0<=i<N, check that the rearrangement of sublist of nums[], 
from nums[start[i]] to nums[end[i]] forms an arithmetic series or not.

NOTE: A series is said to be arithmetic, if and only if,
nums[i+1]-nums[i]==nums[1]-nums[0], for all valid 'i' value.

i.e., 1,3,5,7,9 is a valid series.
2, 3, 5, 8, 12 is not a valid series.


Constraints:
------------
0<= start[i]<=end[i] < nums[].length


Input Format:
-------------
Line-1: comma separated integers, nums[]
Line-2: comma separated integers, start[]
Line-3: comma separated integers, end[]

Output Format:
--------------
Print a list of boolean values of length equals to start[]/end[] list.


Sample Input-1:
---------------
2,8,4,6,10,11,12,14,20,16,18,22,24
0,1,3,6,8
3,4,5,9,12

Sample Output-1:
----------------
[true,true,false,false,true]

Explanation: 
------------
The sublist from 0 to 3 is: [2, 8, 4, 6] => [2,4,6,8] is valid
The sublist from 1 to 4 is: [8, 4, 6,10] => [4,6,8,10] is valid
The sublist from 3 to 5 is: [6, 10, 11] is invalid for any arrangement.
The sublist from 6 to 9 is: [12, 14, 20, 16] is invalid
The sublist from 8 to 12 is: [20, 16, 18, 22,24] is valid
*/

import java.util.*;
class checkArithmetic{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        String nums[]=sc.next().split(",");
        String start[]=sc.next().split(",");
        String end[]=sc.next().split(",");
        int len=start.length;
        List<Boolean> mainls=new ArrayList<>();
        for(int i=0;i<len;i++){
            List<Integer> ls=new ArrayList<>();
            for(int j=Integer.parseInt(start[i]);j<=Integer.parseInt(end[i]);j++){
                ls.add(Integer.parseInt(nums[j]));
            }
            Collections.sort(ls);
            int f=1;
            for(int k=0;k<ls.size()-1;k++){
                if((ls.get(k+1)-ls.get(k))!=(ls.get(1)-ls.get(0))){
                    f=0;
                    break;
                }
            }
            if(f==1){
                mainls.add(true);
            }else if(f==0){
                mainls.add(false);
            }
        }
        System.out.println(mainls);
    }
}