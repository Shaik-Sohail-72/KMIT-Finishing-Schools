import pyautogui
import time

code_to_type = """
import java.util.*;
class Test
{
    public static void main (String[] args) 
    {
        Scanner obj=new Scanner(System.in);
        int n=obj.nextInt();
        int k=obj.nextInt();
        System.out.println(findSurvivor(n,k));
    }
    public static int findSurvivor(int n,int k)
    {
        if(n==1)
        {
            return 1;
        }
        ArrayList<Integer> list=new ArrayList<>();
        for(int i=1;i<=n;i++)
        {
            list.add(i);
        }
        int ind=0;
        while(list.size()>1)
        {
            ind=(ind+k-1)%(list.size());
            list.remove(ind);
        }
        return list.get(0);
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