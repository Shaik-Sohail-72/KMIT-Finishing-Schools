import pyautogui
import time

code_to_type = """
class Solution {
    public int minOperations(int n) {
        int x=n;
        int cnt=0;
        while(x!=0){
            int floor=(int)Math.floor(Math.log(x)/Math.log(2));
            int ceil=(int)Math.ceil(Math.log(x)/Math.log(2));
            x=Math.min(Math.abs((1<<floor)-x),Math.abs((1<<ceil)-x));
            cnt++;
        }
        return cnt;
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