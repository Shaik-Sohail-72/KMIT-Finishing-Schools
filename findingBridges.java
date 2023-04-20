/*Hulk and Thor become best friends now. 
Hulk lives in the P-th house while Thor lives in the N-th house. 
Hulk has decided to meet Thor every day. After going for many days, 
he notices that there are few streets such that he passes every time 
he goes to meet Thor, no matter which path he takes.

You have been given a grid of N houses in the form of undirected graph. 
Houses are numbered from 1 to N.
For each I-th query, you have been given P (Hulk's house). 
You have to say how many streets are there which he encounters in every path 
he takes to go from P to N. If there is no such street, print "-1".
Also, note P can be equal to N.

Input Format:
-------------
Line-1: Two space separated integers N and M, Number of houses, number of streets.
Next M lines: contain two space-separated integers u and v, 
		denoting a street between house-u and house-v.
Next line: contains an integer P.

Output Format:
--------------
Print an integer, number of streets in that path.


Sample Input-1:
---------------
4 3
1 2
1 3
2 4
1

Sample Output-1:
----------------
2

Explanation:
------------
There is only one path 1->2->4. so answer = 2


Sample Input-2:
---------------
4 3
1 2
1 3
2 4
4

Sample Output-2:
----------------
-1

Explanation:
------------
There is no path as they both live in the same house 4.
So answer = -1.
*/

import java.util.*;
class Main
{
    static int timer=0;
    public static void dfs(int curr, int n, int visited[], int parent[], int disc[], int low[], int ans[], HashMap<Integer,ArrayList<Integer>> adj)
    {
        visited[curr]=1;
        disc[curr]=low[curr]=timer;
        timer++;
        for(int neigh:adj.get(curr))
        {
            if(visited[neigh]==0)
            {
                parent[neigh]=curr;
                dfs(neigh, n, visited, parent, disc, low, ans, adj);
                low[curr]=Math.min(low[curr],low[neigh]);
                if(low[neigh]>disc[curr])
                {
                    ans[neigh]=1;
                }
            }
            else if(parent[curr]!=neigh)
            {
                low[curr]=Math.min(low[curr],disc[neigh]);
            }
        }
    }
    public static void findBridgesFromRoot(int curr, int visited[], int ans[], HashMap<Integer,ArrayList<Integer>> adj)
    {
        visited[curr]=1;
        for(int neigh:adj.get(curr))
        {
            if(visited[neigh]==0)
            {
                ans[neigh]=ans[neigh]+ans[curr];
                findBridgesFromRoot(neigh, visited, ans, adj);
            }
        }
    }
    public static void findBridges(int n, int p, HashMap<Integer,ArrayList<Integer>> adj)
    {
        int visited[]=new int[n+1];
        int parent[]=new int[n+1];
        int disc[]=new int[n+1];
        int low[]=new int[n+1];
        int ans[]=new int[n+1];
        dfs(n, n, visited, parent, disc, low, ans, adj);
        Arrays.fill(visited,0);
        findBridgesFromRoot(n, visited, ans, adj);
        if(ans[p]==0)
        {
            System.out.println(-1);
        }
        else
        {
            System.out.println(ans[p]);
        }
    }
    
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int m=sc.nextInt();
        HashMap<Integer,ArrayList<Integer>> adj=new HashMap<Integer,ArrayList<Integer>>();
        for(int i=1;i<=n;i++)
        {
            adj.put(i,new ArrayList<Integer>());
        }
        for(int i=0;i<m;i++)
        {
            int a=sc.nextInt();
            int b=sc.nextInt();
            ArrayList<Integer> temp1=adj.get(a);
            ArrayList<Integer> temp2=adj.get(b);
            temp1.add(b);
            temp2.add(a);
            adj.put(a,temp1);
            adj.put(b,temp2);
        }
        int p=sc.nextInt();
        findBridges(n, p, adj);
    }    
}

  