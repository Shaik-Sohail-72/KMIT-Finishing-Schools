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
        int m=obj.nextInt();
        int[] arr1=new int[n];
        int[] arr2=new int[m];
        HashMap<String,Integer> hm=new HashMap<>();
        for(int i=0;i<n;i++)
        {
            arr1[i]=obj.nextInt();
        }
        for(int j=0;j<m;j++)
        {
            arr2[j]=obj.nextInt();
        }
        System.out.println(countmax(arr1,0,arr2,0,hm));
    }
    
    public static int countmax(int[] arr1,int i,int[] arr2,int j,HashMap<String,Integer> hm)
    {
        int c=0;
        String key=i+"value"+j;
        if(i==arr1.length ||j==arr2.length)
        {
            return 0;
        }
        if(hm.containsKey(key))
        {
            return hm.get(key);
        }
        if(arr1[i]==arr2[j])
        {
            c=1+countmax(arr1,i+1,arr2,j+1,hm);
        }
        else
        {
            c+=Math.max((countmax(arr1,i,arr2,j+1,hm)),(countmax(arr1,i+1,arr2,j,hm)));
           
        }
        hm.put(key,c);
        return c;
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