import pyautogui
import time

code_to_type = """
import java.util.*;
class Test
{
static boolean bfs(int rGraph[][], int s,int t, int parent[],int V)
{
    boolean []visited = new boolean[V];
    Queue <Integer> q = new LinkedList<>();
    q.add(s);
    visited[s] = true;
    parent[s] = -1;
    while (!q.isEmpty())
    {
        int u = q.peek();
        q.remove();

        for (int v = 0; v < V; v++)
        {
            if (visited[v] == false &&
                rGraph[u][v] > 0)
            {
                q.add(v);
                parent[v] = u;
                visited[v] = true;
            }
        }
    }
    return (visited[t] == true);
}
static int findDisjointPaths(int graph[][], int s, int t,int V)
{
    int u, v;
    int [][]rGraph = new int[V][V];
    for (u = 0; u < V; u++)
        for (v = 0; v < V; v++)
            rGraph[u][v] = graph[u][v];

    int []parent = new int[V];

    int max_flow = 0; 
    while (bfs(rGraph, s, t, parent,V))
    {

        int path_flow = Integer.MAX_VALUE;

        for (v = t; v != s; v = parent[v])
        {
            u = parent[v];
            path_flow = Math.min(path_flow, rGraph[u][v]);
        }
        for (v = t; v != s; v = parent[v])
        {
            u = parent[v];
            rGraph[u][v] -= path_flow;
            rGraph[v][u] += path_flow;
        }
        max_flow += path_flow;
    }
    return max_flow;
}
public static void main(String[] args)
{
    Scanner obj=new Scanner(System.in);
      int n=obj.nextInt();
      int[][] arr=new int[n][n];
      for(int i=0;i<n;i++)
      {
      for(int j=0;j<n;j++)
      {
      arr[i][j]=obj.nextInt();
      }
      }
    int s = obj.nextInt();
    int t = obj.nextInt();
    System.out.println(findDisjointPaths(arr, s, t,n)); 
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