import pyautogui
import time

code_to_type = """
     paste content here and run the script . 
      put the cursor to paste.                                                                                                                         
"""


time.sleep(10)
def avoid_auto_complete():
    pyautogui.hotkey('esc', 'space', 'backspace', 'enter', 'space', 'ctrl', 'left')
lines = list(code_to_type.split("\n"))
for line in lines:
        pyautogui.typewrite(line, interval=0)
        avoid_auto_complete()