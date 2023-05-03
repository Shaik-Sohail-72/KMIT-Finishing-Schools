import java.util.*;
public class SCC_kosaraju{
    static class Edge {
        int src;
        int dest;
        public Edge(int s, int d) {
            this.src = s;
            this.dest = d;
        }
    }
    public static void createGraph(ArrayList<Edge> graph[]) {
        for(int i=0; i<graph.length; i++) {
            graph[i] = new ArrayList<Edge>();
        }
        graph[0].add(new Edge(0, 2));
        graph[0].add(new Edge(0, 3));
        graph[1].add(new Edge(1, 0));
        graph[2].add(new Edge(2, 1));
        graph[3].add(new Edge(3, 4));
    }
    public static void topSort(ArrayList<Edge> graph[],boolean vis[],int curr,Stack<Integer> st){
        vis[curr]=true;
        for(int i=0;i<graph[curr].size();i++){
            Edge e=graph[curr].get(i);
            if(vis[e.dest]==false){
                topSort(graph,vis,e.dest,st);
            }
        }
        st.push(curr);
    }
    public static void dfs(ArrayList<Edge> graph[],boolean vis[],int curr){
        vis[curr]=true;
        System.out.print(curr+" ");
        for(int i=0;i<graph[curr].size();i++){
            Edge e=graph[curr].get(i);
            if(vis[e.dest]==false){
                dfs(graph,vis,e.dest);
            }
        }
    }
    public static void kosaraju(ArrayList<Edge> graph[],int V){
        //step1: - O(V+E)
        Stack<Integer> st=new Stack<>();
        boolean vis[]=new boolean[V];
        for(int i=0;i<V;i++){
            if(vis[i]==false){
                topSort(graph,vis,i,st);
            }
        }
        //step2: - O(V+E)
        boolean transposeVis[]=new boolean[V];
        ArrayList<Edge> transpose[]=new ArrayList[V];
        for(int i=0; i<graph.length; i++) {
            transpose[i] = new ArrayList<Edge>();
        }
        for(int i=0;i<V;i++){
            for(int j=0;j<graph[i].size();j++){
                Edge e=graph[i].get(j);
                transpose[e.dest].add(new Edge(e.dest,e.src));
            }
        }
        //step3  - O(V+E)
        while(!st.isEmpty()){
            int curr=st.pop();
            if(transposeVis[curr]==false){
                dfs(transpose,transposeVis,curr);
                System.out.println();
            }
        }
    }
    public static void main(String[] args){
        int V=5;
        ArrayList<Edge> graph[]=new ArrayList[V];
        createGraph(graph);
        kosaraju(graph, V);
    }
}