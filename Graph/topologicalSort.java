import java.util.ArrayList;
import java.util.Stack;
public class topologicalSort{
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
        graph[2].add(new Edge(2,3));

        graph[3].add(new Edge(3,1));

        graph[4].add(new Edge(4, 0));
        graph[4].add(new Edge(4, 1));

        graph[5].add(new Edge(5, 0));
        graph[5].add(new Edge(5, 2));
        // graph[0].add(new Edge(0, 1));
        // graph[0].add(new Edge(0, 2));

        // graph[1].add(new Edge(1, 2));

        // graph[2].add(new Edge(2, 3));





    }
    public static void topSort(ArrayList<Edge> graph[],boolean vis[],int curr,Stack<Integer> stack){
        vis[curr]=true;
        for(int i=0;i<graph[curr].size();i++){
            Edge e=graph[curr].get(i);
            if(vis[e.dest]==false){
                topSort(graph, vis, e.dest, stack);
            }  
        }
        stack.push(curr);
    }
    public static void main(String[] args) { 
        int V=6                                                                                                                                                                               ;
        ArrayList<Edge> graph[]=new ArrayList[V];
        boolean vis[]=new boolean[V];
        createGraph(graph);
        Stack<Integer> stack=new Stack<>();
        for(int i=0;i<V;i++){
            if(vis[i]==false){
                topSort(graph, vis, i,stack);
            }
        }
        while(!stack.empty()){
            System.out.print(stack.pop()+" ");
        }
    }
    
}
