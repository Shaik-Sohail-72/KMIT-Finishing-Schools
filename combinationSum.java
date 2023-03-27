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
class combinationSum{
    public static ArrayList<ArrayList<Integer>> combinationSum(ArrayList<Integer> arr, int target){
        ArrayList<ArrayList<Integer> > mainls= new ArrayList<>();
        ArrayList<Integer> ls = new ArrayList<>();
        Set<Integer> set = new HashSet<>(arr);
        arr.clear();
        arr.addAll(set);
        Collections.sort(arr);
        findNumbers(mainls, arr, target,0,ls);
        return mainls;
    }
    public static void findNumbers(ArrayList<ArrayList<Integer>> mainls,ArrayList<Integer> arr, int target,int index,ArrayList<Integer> ls){ 
        if (target == 0){
            System.out.println(ls);
            //mainls.add(new ArrayList<>(ls));
            mainls.add(ls);
        }else{
            for (int i=index; i < arr.size(); i++){
                if ((target - arr.get(i)) >= 0) {
                    ls.add(arr.get(i));
                    findNumbers(mainls, arr, target - arr.get(i),i,ls);
                    ls.remove(arr.get(i));
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