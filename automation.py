import pyautogui
import time

code_to_type = """
import java.util.*;
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


"""


time.sleep(10)
def avoid_auto_complete():
    pyautogui.hotkey('esc', 'space', 'backspace', 'enter', 'space', 'ctrl', 'left')
lines = list(code_to_type.split("\n"))
for line in lines:
        pyautogui.typewrite(line, interval=0)
        avoid_auto_complete()