/*You are given an integer array arr.
 Sort the integers in the array in ascending order by the number of 1's in their binary representation 
and in case of two or more integers have the same number of 1's you have to sort them in ascending order.

Return the array after sorting it.

Example 1:
Input: 9
0 1 2 3 4 5 6 7 8
Output: 0 1 2 4 8 3 5 6 7
Explantion: [0] is the only integer with 0 bits.
[1,2,4,8] all have 1 bit.
[3,5,6] have 2 bits.
[7] has 3 bits.
The sorted array by bits is [0,1,2,4,8,3,5,6,7]

Example 2:
Input: arr = 11 
1024 512 256 128 64 32 16 8 4 2 1 
Output: 1 2 4 8 16 32 64 128 256 512 1024
Explantion: All integers have 1 bit in the binary representation, 
you should just sort them in ascending order.
*/

import java.util.*;
class bitwiseSorting{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        Map<Integer, List<Integer>> m = new TreeMap<>();
        int n=sc.nextInt();
        for(int i=0;i<n;i++){
            int ele=sc.nextInt();
            m.computeIfAbsent(c1(ele), k -> new ArrayList<>()).add(ele);    
        }
        for(Map.Entry<Integer, List<Integer>> e:m.entrySet()){
            Collections.sort(e.getValue());
            for(int i=0;i<e.getValue().size();i++){
                System.out.print(e.getValue().get(i)+" ");
            }
        }
    }
    public static int c1(int n){
        int c=0;
        while(n>0){
            c++;
            n=n&(n-1);
        }
        return c;
    }
}

  

      