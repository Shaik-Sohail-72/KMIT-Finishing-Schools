/*There are N cities, and M routes[], each route is a path between two cities.
routes[i] = [city1, city2], there is a travel route between city1 and city2.
Each city is numbered from 0 to N-1.
 
There are one or more Regions formed among N cities. 
A Region is formed in such way that you can travel between any two cities 
in the region that are connected directly and indirectly.
 
Your task is to findout the number of regions formed between N cities. 
 
Input Format:
-------------
Line-1: Two space separated integers N and M, number of cities and routes
Next M lines: Two space separated integers city1, city2.
 
Output Format:
--------------
Print an integer, number of regions formed.
 
 
Sample Input-1:
---------------
5 4
0 1
0 2
1 2
3 4
 
Sample Output-1:
----------------
2
 
 
Sample Input-2:
---------------
5 6
0 1
0 2
2 3
1 2
1 4
2 4
 
Sample Output-2:
----------------
1
 
Note: Look HINT for explanation.
*/
import java.util.*;
class connectedComponents{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int V=sc.nextInt();
        int E=sc.nextInt();
        List<List<Integer>> adjls=new ArrayList<>();
        for(int i=0;i<V;i++){
            adjls.add(i,new ArrayList<>());
        }
        for(int i=0;i<E;i++){
            int src=sc.nextInt();
            int des=sc.nextInt();
            adjls.get(src).add(des);
            //adjls.get(des).add(src);
        }
        System.out.println(connectedcomp(V,adjls));
    }
    public static void dfs(int v,boolean visited[],List<List<Integer>> adjls){
        visited[v]=true;
        for(int ele:adjls.get(v)){
            if(!visited[ele]){
                dfs(ele,visited,adjls);
            }
        }
    }
    public static int connectedcomp(int V,List<List<Integer>> adjls){
        int c=0;
        boolean[] visited=new boolean[V];
        for(int i=0;i<V;i++){
            if(!visited[i]){
                dfs(i,visited,adjls);
                c++;
            }
        }
        return c;
    }
}