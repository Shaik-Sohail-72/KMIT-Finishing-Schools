import java.util.*;

/* 
Time complexity: O(logN)
Space complexity: O(N)

The general amortized complexity of O(1)

A bad hashCode() implementation could result to multiple collisions, which means that in
the worst case every object goes to the same bucket, 
thus O(N) if each bucket is backed by a List.

Since Java 8, HashMap dynamically replaces the Nodes (linked list) used in each bucket 
with TreeNodes (red-black tree when a list gets bigger than 8 elements) 
resulting to a worst performance of O(logN).
*/

class MajorityElement_HashMap
{
	public static int findMajority(int[] nums)
	{
		HashMap <Integer, Integer> map = new HashMap<>();
        
        for(int i : nums) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        for(Map.Entry<Integer,Integer> i : map.entrySet()) {
            if(i.getValue() > (nums.length/2)) {
                return i.getKey();
            }
        }
        return -1;
	}

	public static void main(String[] args)
	{
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int arr[] = new int[n];
		for(int i=0;i<n;i++)
			arr[i]=sc.nextInt();

		System.out.println("The majority element is : " + findMajority(arr));
	}
}
