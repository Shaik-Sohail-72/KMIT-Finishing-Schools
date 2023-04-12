import pyautogui
import time

code_to_type = """
class Solution {
    public int slidingPuzzle(int[][] board) {
        // List<String> ls = new ArrayList<>();
        Set<String> set = new HashSet<>();
        Queue<int [][]> q = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        for(int i =0;i<2;i++){
            for(int j=0;j<3;j++){
                sb.append(board[i][j]);
            }
        }
        String result = "123450";
        set.add(sb.toString());
        q.add(board);
        int steps=0;
        while(!q.isEmpty()){
            int size = q.size();
            for(int k =0;k<size;k++){
                int [][] arr =q.poll();
                StringBuilder s = new StringBuilder();
                int i1=0;
                int j1=0;
                for(int i =0;i<2;i++){
                    for(int j=0;j<3;j++){
                        s.append(arr[i][j]);
                        if(arr[i][j]==0){
                            i1=i;
                            j1=j;
                        }
                    }
                }
                // System.out.println(q+" "+s.toString());
                if(s.toString().equals(result)){
                    return steps;
                } 
                else{
                   
                   

                
                // System.out.println(Arrays.deepToString(arr));
                if(isValid(i1+1,j1)){
                    StringBuilder s1 =new StringBuilder();
                    int [][] temp = new int[2][3];
                    for(int i =0;i<2;i++){
                        for(int j =0;j<3;j++){
                            temp[i][j]=arr[i][j];
                        }
                    }
                    int t = temp[i1][j1];
                    temp[i1][j1]=temp[i1+1][j1];
                    temp[i1+1][j1]=t;
                    for(int i =0;i<2;i++){
                        for(int j =0;j<3;j++){
                            s1.append(temp[i][j]);
                        }
                    }
                        
                    
                    if(!set.contains(s1.toString())){
                        set.add(s1.toString());
                        q.add(temp);
                    }
                }
                if(isValid(i1-1,j1)){
                    StringBuilder s1 =new StringBuilder();
                    int [][] temp = new int[2][3];
                    for(int i =0;i<2;i++){
                        for(int j =0;j<3;j++){
                            temp[i][j]=arr[i][j];
                        }
                    }
                    int t = temp[i1][j1];
                    temp[i1][j1]=temp[i1-1][j1];
                    temp[i1-1][j1]=t;
                    for(int i =0;i<2;i++){
                        for(int j =0;j<3;j++){
                            s1.append(temp[i][j]);
                        }
                    }
                        
                    
                    if(!set.contains(s1.toString())){
                        set.add(s1.toString());
                        q.add(temp);
                    }
                }
                if(isValid(i1,j1+1)){
                    StringBuilder s1 =new StringBuilder();
                    int [][] temp = new int[2][3];
                    for(int i =0;i<2;i++){
                        for(int j =0;j<3;j++){
                            temp[i][j]=arr[i][j];
                        }
                    }
                    int t = temp[i1][j1];
                    temp[i1][j1]=temp[i1][j1+1];
                    temp[i1][j1+1]=t;
                    for(int i =0;i<2;i++){
                        for(int j =0;j<3;j++){
                            s1.append(temp[i][j]);
                        }
                    }
                        
                    
                    if(!set.contains(s1.toString())){
                    set.add(s1.toString());
                        q.add(temp);
                    }
                }
                if(isValid(i1,j1-1)){
                    StringBuilder s1 =new StringBuilder();
                    int [][] temp = new int[2][3];
                    for(int i =0;i<2;i++){
                        for(int j =0;j<3;j++){
                            temp[i][j]=arr[i][j];
                        }
                    }
                    int t = temp[i1][j1];
                    temp[i1][j1]=temp[i1][j1-1];
                    temp[i1][j1-1]=t;
                    for(int i =0;i<2;i++){
                        for(int j =0;j<3;j++){
                            s1.append(temp[i][j]);
                        }
                    }
                        
                    
                    if(!set.contains(s1.toString())){
                        set.add(s1.toString());
                        q.add(temp);
                    }
                }
                

                
            }
        }
        steps++;
    }
    return -1;
}
public boolean isValid(int i , int j){
    if((i>=0 && i<2) && (j>=0 && j<3)){
        return true;
    }
    return false;
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