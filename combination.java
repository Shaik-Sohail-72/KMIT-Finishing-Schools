/*Given an array of distinct integers candidates and a target integer target, return a list 
of all unique combinations of candidates where the chosen numbers sum to target. You may 
return the combinations in any order.

The same number may be chosen from candidates an unlimited number of times. Two 
combinations are unique if the 
frequency
 of at least one of the chosen numbers is different.

The test cases are generated such that the number of unique combinations that sum up to 
target is less than 150 combinations for the given input.

 

Example 1:

Input: 4
2 3 6 7
 7
Output: [[2,2,3],[7]]
Explanation:
2 and 3 are candidates, and 2 + 2 + 3 = 7. Note that 2 can be used multiple times.
7 is a candidate, and 7 = 7.
These are the only two combinations.
Example 2:
Input: 3
2 3 5 
8
Output: [[2,2,2,2],[2,3,3],[3,5]]
Example 3:
Input: 1
2
1
Output: []
*/import java.util.*;
class combination{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        ArrayList<Integer> ls=new ArrayList<>();
        for(int i=0;i<n;i++){
            int ele=sc.nextInt();
            ls.add(ele);
        }
        int k=sc.nextInt();
        System.out.println(combinationSum(ls,k));
    }
    public static ArrayList<ArrayList<Integer>> combinationSum(ArrayList<Integer> A, int B){   
        ArrayList<ArrayList<Integer>> ans =  new ArrayList<>();
        ArrayList<Integer> op = new ArrayList<>();
        Set<Integer> set = new HashSet<>(A);
        A.clear();
        A.addAll(set);
        Collections.sort(A);
        int n = A.size();
        int sum = 0;
        int i = 0;
        combination(A, i, n, sum, B, op, ans);
        return ans; 
    }
    public static void combination(ArrayList<Integer> A, int i, int n, int sum, int target, ArrayList<Integer> op, ArrayList<ArrayList<Integer>> ans) {
        if(sum == target) ans.add(op);
        if(i == n || sum >= target) return;
        ArrayList<Integer> temp = new ArrayList<>(op);
        temp.add(A.get(i));
        combination(A, i, n, sum + A.get(i), target, temp, ans);
        combination(A, i + 1, n, sum, target, op, ans);
    }
}