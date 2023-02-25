/*
In Turkey, an ice cream parlour gives an offer to a lucky kid.
The parlour keeps N ice cream cups in a row, and there are different flavours 
of icecreams, where i-th cup filled with the flavour[i] type of ice cream.

The kid can pick the continuous set of ice cream cups, where the cups are filled
with icecreams of utmost two different flavours. The kid wants to 
pick the maximum number of ice cream cups from the row.

You will be given the integer array, flavours[] of size N.
Your task is to help the kid to pick the maximum number of ice cream cups 
with at most two different flavours.


Input Format:
-------------
Line-1: An integer, number of icecreams.
Line-2: N space separated integers, flavours[] 

Output Format:
--------------
Print an integer result, maximum number of icecream cups can be picked.


Sample Input-1:
---------------
10
1 2 3 1 1 3 3 2 3 2

Sample Output-1:
----------------
5

Explanation:
------------
The kid can pick the continuous set of icecream cups as follows: 3 1 1 3 3
Where the cups are filled with two different flavours, 1 and 3.



Sample Input-2:
---------------
10
2 1 1 3 2 1 3 0 0 3

Sample Output-2:
----------------
4
*/
    
import java.util.*;
class iceCreams{
    public static void main (String[] args) {
        Scanner obj=new Scanner(System.in);
        int a=obj.nextInt();
        int[] arr=new int[a];
        for(int i=0;i<a;i++)
        {
            arr[i]=obj.nextInt();
        }
        int max=0;
        int c=1;
        int sum=0;
        int i=0,j=0;
        HashMap<Integer,Integer> map=new HashMap<>();
        while(i<a){
            if(map.containsKey(arr[i])){
                map.put(arr[i],map.get(arr[i])+1);
                i++;
                }
                else{
                    map.put(arr[i],c);
                    i++;
                }
                if(map.size()>2){
                    map.clear();
                    j++;
                    i=j;
                }
                max=Math.max(max,sum(map));
            }
        System.out.println(max);
    }
public static int sum(HashMap<Integer,Integer> map){
    int sum=0;
    for(int value:map.values()){
        sum+=value;
    }
       return sum;
    }
} 



     