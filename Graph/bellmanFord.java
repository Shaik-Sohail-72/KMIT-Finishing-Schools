import java.util.*;
public class bellmanFord {
    static class Edge {
        int src;
        int dest;
        int wt;
        public Edge(int s, int d, int w) {
            this.src = s;
            this.dest = d;
            this.wt = w;
        }
    }
    static void createGraph(ArrayList<Edge> graph[]) {
        for(int i=0; i<graph.length; i++) {
            graph[i] = new ArrayList<>();
        }
        /*graph[0].add(new Edge(0, 1, 2));
        graph[0].add(new Edge(0, 2, 4));
        graph[1].add(new Edge(1, 2, -4));
        graph[2].add(new Edge(2, 3, 2));
        graph[3].add(new Edge(3, 4, 4));
        graph[4].add(new Edge(4, 1, -10));*/
        /*graph[0].add(new Edge(0, 1, -1));
        graph[1].add(new Edge(1, 2, -2));
        graph[2].add(new Edge(2, 0, -3));*/
        //[[0,1,5],[1,0,3],[1,2,-1],[2,0,1]]
        graph[0].add(new Edge(0, 1, 5));
        graph[1].add(new Edge(1, 0, 3));
        graph[1].add(new Edge(1, 2, -1));
        graph[2].add(new Edge(2, 0, 1));
    }
    public static void ford(ArrayList<Edge> graph[],int src,int V){
        int dist[]=new int[V];
        for(int i=0;i<V;i++){
            if(i!=src){
                dist[i]=100000000;
            }
        }
        System.out.println(Arrays.toString(dist));
        for(int k=0;k<V-1;k++){
            for(int i=0;i<V;i++){
                for(int j=0;j<graph[i].size();j++){
                    Edge e=graph[i].get(j);
                    int u=e.src;
                    int v=e.dest;
                    if(dist[u]+e.wt<dist[v]){
                        System.out.println(dist[u]+" "+e.wt);
                        dist[v]=dist[u]+e.wt;
                    }
                }
            }
            System.out.println(Arrays.toString(dist));
        }
        // bellman negative cycle detections
        for(int i=0;i<V;i++){
            for(int j=0;j<graph[i].size();j++){
                Edge e=graph[i].get(j);
                int u=e.src;
                int v=e.dest;
                if(dist[u]!=Integer.MAX_VALUE && dist[u]+e.wt<dist[v]){
                    System.out.println("Negative weight cycle");
                }
            }
        }
        
    }
    public static void main(String[] args){
        int V=3;
        ArrayList<Edge> graph[]=new ArrayList[V];
        createGraph(graph);
        ford(graph, 2, V);
    }
}