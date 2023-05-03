import pyautogui
import time

code_to_type = """
class Solution {
    
    ArrayList<ArrayList<Integer>> graph;
    int output[];   //to store result
    
    public void addEdge(int u, int v){
        graph.get(u).add(v);
    }
    
    public void buildGraph(int[][] richer){
        for(int[] pair: richer){
            int poor= pair[1];
            int rich= pair[0];
            addEdge(poor,rich);  //adding edges from poor to rich
        }
    }
    public int[] loudAndRich(int[][] richer, int[] quiet) {
        int n= quiet.length;
        graph= new ArrayList<>();
        for(int i=0;i<n;i++){
            graph.add(new ArrayList<>());
        }
        buildGraph(richer);  //build adjacency list so that we can do dfs
        output= new int[n];
        Arrays.fill(output,-1);
        for(int i=0;i<n;i++){    //doing dfs
            if(output[i]==-1){
                dfs(i,quiet);
            }
        }
        return output;
    }
    
    public int dfs(int person, int quiet[]){
        
         if(output[person]!=-1)    //if we already know answer for this person return same answer (Memoization)
             return output[person];
        int least_quiet_person=person;   //initially the person himself is the least_quiet_person
        int least_quietness= quiet[person];
        
        for(int nbr: graph.get(person)){
            int newPerson= dfs(nbr,quiet);
            if(quiet[newPerson]<least_quietness){      //while doing dfs, if we found  a person who is more quiet we update our values
                least_quietness= quiet[newPerson];
                least_quiet_person=newPerson;
            }
        }
        output[person]=least_quiet_person;  //store the answer in output array
        return least_quiet_person;
        
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