import pyautogui
import time

code_to_type = """
import java.util.*;
class Test
{
    public static void main (String[] args)
    {
        Scanner obj=new Scanner(System.in);
        String s=obj.next();
        HashMap<Character,Integer> hm=new HashMap<>();
        for(int i=0;i<s.length();i++)
        {
            int c=hm.getOrDefault(s.charAt(i),0);
            hm.put(s.charAt(i),c+1);
        }
        System.out.println(solve(hm));
    }
    public static int solve(HashMap<Character,Integer> map)
    {
        int sum=map.values().stream().reduce(0,Integer::sum);
        if(sum<=0)
        {
            return 0;
        }
        int ans=0;
        for(Character i:map.keySet())
        {
            if(map.get(i)<=0)
            {
                continue;
            }
            map.put(i,(map.get(i)-1));
            ans+=solve(map)+1;
            map.put(i,(map.get(i)+1));
        }
        return ans;
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