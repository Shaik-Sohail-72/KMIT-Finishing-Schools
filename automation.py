import pyautogui
import time

code_to_type = """
class Solution {
    public int numTilePossibilities(String tiles) {
        Set<String> set = new HashSet<>();
        boolean[] vis = new boolean[tiles.length()];
        permute(tiles, "", set, vis);
        return set.size()-1;
    }
    public void permute(String tiles, String curr, Set<String> set, boolean[] vis){
        set.add(curr);
        for(int i=0; i<tiles.length(); i++){
            if(!vis[i]){
                vis[i]=true;
                permute(tiles, curr+tiles.charAt(i), set, vis);
                vis[i]=false;
            }
        }   
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