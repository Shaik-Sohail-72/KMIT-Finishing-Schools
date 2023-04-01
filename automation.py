import pyautogui
import time

code_to_type = """
import java.util.*;
class solution{
    public static int JumpCost(int a[],int n){
        int[] dp=new int[n];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0]=0;
        for(int i=1;i<n;i++){
            if(i==1){
                dp[i]=Math.abs(a[i]-a[i-1]);
            } 
            else{
                dp[i]=Math.min(dp[i-1] + Math.abs(a[i] - a[i-1]),dp[i-2]+Math.abs(a[i]-a[i-2]));
            }
        }
        return dp[n-1];
    }
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int a[]=new int[n];
        for(int i=0;i<n;i++){
            a[i]=sc.nextInt();
        }
        System.out.println(JumpCost(a,n));
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