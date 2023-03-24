import pyautogui
import time

code_to_type = """
 public class Main {
 public static void main(String[] args){
         Scanner sc=new Scanner(System.in);
         String s1=sc.next();
         String s2=sc.next();
         String s3=sc.next();
         System.out.println(is_Interleave(s1,0,s2,0,s3,0,)
     }
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s3.length() != s1.length() + s2.length()) {
            return false;
        }
        boolean dp[][] = new boolean[s1.length() + 1][s2.length() + 1];
        for (int i = 0; i <= s1.length(); i++) {
            for (int j = 0; j <= s2.length(); j++) {
                if (i == 0 && j == 0) {
                    dp[i][j] = true;
                } else if (i == 0) {
                    dp[i][j] = dp[i][j - 1] && s2.charAt(j - 1) == s3.charAt(i + j - 1);
                } else if (j == 0) {
                    dp[i][j] = dp[i - 1][j] && s1.charAt(i - 1) == s3.charAt(i + j - 1);
                } else {
                    dp[i][j] = (dp[i - 1][j] && s1.charAt(i - 1) == s3.charAt(i + j - 1)) || (dp[i][j - 1] && s2.charAt(j - 1) == s3.charAt(i + j - 1));
                }
            }
        }
        return dp[s1.length()][s2.length()];
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