import java.util.*;
public class cicleDetectionDirected{
    static class Edge{
        int src;
        int dest;
        Edge(int s,int d){
            this.src=s;
            this.dest=d;
        }
    }
    public static void createGraph(ArrayList<Edge> graph[]){
        for(int i=0;i<graph.length;i++){
            graph[i]=new ArrayList<>();
        }
        graph[0].add(new Edge(0, 2));

        graph[1].add(new Edge(1, 0));

        graph[2].add(new Edge(2,3));

        graph[3].add(new Edge(3,0));
    }
    public static boolean cycle(ArrayList<Edge> graph[],boolean vis[],int curr,boolean rec[]){
        vis[curr]=true;
        rec[curr]=true;
        for(int i=0;i<graph[curr].size();i++){
            Edge e=graph[curr].get(i);
            if(rec[e.dest]==true){
                return true;
            }
            else if(vis[e.dest]==false){
                if(cycle(graph,vis,e.dest,rec)){
                    return true;
                }
            }
        }
        rec[curr]=false;
        return false;
    }
    public static void main(String[] args) {
        int V=4;
        ArrayList<Edge> graph[]=new ArrayList[V];
        boolean vis[]=new boolean[V];
        boolean rec[]=new boolean[V];
        createGraph(graph);
        for(int i=0;i<V;i++){
            if(vis[i]==false){
                boolean isCycle=cycle(graph,vis,i,rec);
                if(isCycle){
                    System.out.println(isCycle);
                    break;
                }
            }
        }
    }
    
}
