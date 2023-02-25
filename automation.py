import pyautogui
import time

code_to_type = """
public List<String> decodeString(String s) {
public static int minOperations(int n) {
    int count = 0;
    while (n != 0) {
        int p = 1;
        while (p * 2 <= n) {
            p *= 2;
        }
        if (p > 0) {
            n -= p;
            count++;
        } else {
            n += p;
            count++;
        }
    }
    return count;
}
"""


time.sleep(10)
def avoid_auto_complete():
    pyautogui.hotkey('esc', 'space', 'backspace', 'enter', 'space', 'ctrl', 'left')
lines = list(code_to_type.split("\n"))
for line in lines:
        pyautogui.typewrite(line, interval=0)
        avoid_auto_complete()