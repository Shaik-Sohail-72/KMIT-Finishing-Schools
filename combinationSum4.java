/*Given an array of distinct integers candidates and a target integer target, return a list 
of all unique combinations of candidates where the chosen numbers target to target. You may 
return the combinations in any order.

The same number may be chosen from candidates an unlimited number of times. Two 
combinations are unique if the 
frequency
 of at least one of the chosen numbers is different.

The test cases are generated such that the number of unique combinations that target up to 
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
Output: []*/
import java.util.*;
class combinationSum4{
    public static ArrayList<ArrayList<Integer>> combinationSum(ArrayList<Integer> mainls, int target){
        ArrayList<ArrayList<Integer> > ans= new ArrayList<>();
        ArrayList<Integer> ls = new ArrayList<>();
        Set<Integer> set = new HashSet<>(mainls);
        mainls.clear();
        mainls.addAll(set);
        Collections.sort(mainls);
        findNumbers(ans, mainls, target, ls);
        return ans;
    }
    public static void findNumbers(ArrayList<ArrayList<Integer>> ans,ArrayList<Integer> mainls, int target,ArrayList<Integer> ls){ 
        if (target == 0){
            ans.add(new ArrayList<>(ls));
        }else{
            for (int i=0; i < mainls.size(); i++){
                if ((target - mainls.get(i)) >= 0) {
                    ls.add(mainls.get(i));
                    findNumbers(ans, mainls, target - mainls.get(i),ls);
                    ls.remove(mainls.get(i));
                }
            }
        }
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        ArrayList<Integer> ls=new ArrayList<>();
        for(int i=0;i<n;i++){
            int ele=sc.nextInt();
            ls.add(ele);
        }
        int k=sc.nextInt();
        System.out.println(combinationSum(ls, k));
    }
}