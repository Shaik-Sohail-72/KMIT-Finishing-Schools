import pyautogui
import time

code_to_type = """
Solution in Java

 

ArrayList<Integer> rotation(int n){
       // Code Here
       ArrayList<Integer> res = new ArrayList<Integer>();
       int[] arr = new int[1001];
       Queue<Integer> q = new LinkedList<>();
       for(int i=1; i<=n; i++){
           q.add(i);
       }
       int i=1;
       while(!q.isEmpty()){
           int j=0;
           while(j<i){
               int x = q.peek();
               q.poll();
               q.add(x);
               j++;
           }
           int x = q.peek();
           if(arr[x] != 0){
               res.add(-1);
               return res;
           }
           arr[x] = i;
           q.poll();
           i++;
       }
       for(i=1; i<=n; i++)
           res.add(arr[i]);
       return res;
   }



   
   
"""


time.sleep(10)
def avoid_auto_complete():
    pyautogui.hotkey('esc', 'space', 'backspace', 'enter', 'space', 'ctrl', 'left')
lines = list(code_to_type.split("\n"))
for line in lines:
        pyautogui.typewrite(line, interval=0)
        avoid_auto_complete()