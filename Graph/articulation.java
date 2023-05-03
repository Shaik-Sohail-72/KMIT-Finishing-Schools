// O(V+E)
import java.util.*;
class articulation{
    static class Edge{
        int src;
        int dest;
        Edge(int s,int d){
            this.src=s;
            this.dest=d;
        }
    }
    public static void createGraph(ArrayList<Edge> graph[],int V){
        for(int i=0;i<V;i++){
            graph[i]=new ArrayList<>();
        }
        graph[0].add(new Edge(0,1));
        graph[0].add(new Edge(0,2));
        graph[0].add(new Edge(0,3));

        graph[1].add(new Edge(1,0));
        graph[1].add(new Edge(1,2));

        graph[2].add(new Edge(2,0));
        graph[2].add(new Edge(2,1));

        graph[3].add(new Edge(3,0));
        graph[3].add(new Edge(3,4));

        graph[4].add(new Edge(4,3));
    }
    public static void dfs(ArrayList<Edge> graph[],boolean vis[],int curr,int dt[],int low[],int time,int par,boolean ap[]){
        vis[curr]=true;
        dt[curr]=low[curr]=++time;
        int children=0;
        for(int i=0;i<graph[curr].size();i++){
            Edge e=graph[curr].get(i);
            if(e.dest==par){
                continue;
            }else if(vis[e.dest]==true){
                low[curr]=Math.min(low[curr],dt[e.dest]);
            }else{
                dfs(graph,vis,e.dest,dt,low,time,curr,ap);
                low[curr]=Math.min(low[curr],low[e.dest]);
                if(dt[curr]<=low[e.dest] && par!=-1){
                    ap[curr]=true;
                }
                children++;
            }
        }
        if(par==-1 && children>1){
            ap[curr]=true;
        }
    }
    public static void getAP(ArrayList<Edge> graph[],int V){
        int dt[]=new int[V];
        int low[]=new int[V];
        int time=0;
        boolean vis[]=new boolean[V];
        boolean ap[]=new boolean[V];
        for(int i=0;i<V;i++){
            if(vis[i]==false){
                dfs(graph,vis,i,dt,low,time,-1,ap);
            }
        }
        for(int i=0;i<V;i++){
            if(ap[i]==true){
                System.out.println("AP : "+i);
            }
        }
    }
    public static void main(String[] args) {
        int V=5;
        ArrayList<Edge> graph[]=new ArrayList[V];
        createGraph(graph,V);
        getAP(graph, V);
    }
}