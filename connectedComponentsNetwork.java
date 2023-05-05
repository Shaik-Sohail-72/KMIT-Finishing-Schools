/*
There are n computers numbered from 0 to n - 1 connected by ethernet cables connections forming a network where connections[i] = [ai, bi]
 represents a connection between computers ai and bi. Any computer can reach any other computer directly or indirectly through the network.

You are given an initial computer network connections. You can extract certain cables between two directly connected computers, and place them between any pair of disconnected computers to make them directly connected.

Return the minimum number of times you need to do this in order to make all the computers connected. If it is not possible, return -1.
input = number of nodes n 
number of edges m
m number of edges 
output = integer 

sample cases:
input =
4
3
0 1
0 2
1 2
output = 1
case 2:
input = 6
5
0 1
0 2
0 3
1 2
1 3
output = 2
 */
import java.util.*;
class Main{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int V=sc.nextInt();
        int E=sc.nextInt();
        List<List<Integer>> adj=new ArrayList<>();
        for(int i=0;i<V;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<E;i++){
            int src=sc.nextInt();
            int dest=sc.nextInt();
            adj.get(src).add(dest);
            adj.get(dest).add(src);
        }
        boolean vis[]=new boolean[V];
        int c=0;
        for(int i=0;i<V;i++){
            if(vis[i]==false){
                
                dfs(adj,vis,i);
                c++;
            }
        }
        if(E<V-1){
            System.out.println(-1);
        }
        else{
            System.out.println(c-1);
        }
    }
    public static void dfs(List<List<Integer>> adj,boolean vis[],int curr){
        vis[curr]=true;
        for(int neigh:adj.get(curr)){
            if(vis[neigh]==false){
                dfs(adj,vis,neigh);
            }
        }
    }
}