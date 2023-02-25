/*Given an integer array nums and an integer k, return the k most frequent elements. 

Note: If the frequency of the elements are same then pick the element with higher value.

Example 1:
input =6
1 1 1 2 2 3
2
output =1 2

explanation
nums = [1,1,1,2,2,3], k = 2
Output: [1,2]

Input: nums = [1], k = 1
Output: [1]
 

Constraints:

1 <= nums.length <= 105
-104 <= nums[i] <= 104
k is in the range [1, the number of unique elements in the array].
It is guaranteed that the answer is unique.*/
import java.util.*;
class topKFrequentItems{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int arr[]=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        int k=sc.nextInt();
        Map<Integer,Integer> m=new TreeMap<>();
        for(int i=0;i<n;i++){
            if(!m.containsKey(arr[i])){
                m.put(arr[i],1);
            }else{
                m.put(arr[i],m.get(arr[i])+1);
            }
        } 
        int arr1[][]=new int[m.size()][2];
        int i=0;
        for(Map.Entry<Integer,Integer> e: m.entrySet()){
            arr1[i][0]=e.getKey();
            arr1[i][1]=e.getValue();
            i++;
        }
        Arrays.sort(arr1,Comparator.comparingDouble(o ->o[1]));
        int ind=arr1.length-1;
        for(int q=0;q<k;q++){
            System.out.println(arr1[ind--][0]+" ");
        }
    }
}