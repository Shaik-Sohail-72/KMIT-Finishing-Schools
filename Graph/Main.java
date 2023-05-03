import java.util.*;
class Main{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int V=sc.nextInt();
        int E=sc.nextInt();
        int arr[][]=new int[E][3];
        for(int i=0;i<E;i++){
            for(int j=0;j<3;j++){
                arr[i][j]=sc.nextInt();
            }
        }
        spanningTree(V,E,arr);
    }
    static class Edge{
        int src;
        int dest;
        int wt;
        Edge(int s,int d,int w){
            this.src=s;
            this.dest=d;
            this.wt=w;
        }
    }
    static class Pair implements Comparable<Pair>{
        int src;
        int dest;
        int cost;
        public Pair(int s,int d,int c){
            this.src=s;
            this.dest=d;
            this.cost=c;
        }
        @Override
        public int compareTo(Pair p2){
            return this.cost-p2.cost;
        }
    }
	static void spanningTree(int V, int E, int edges[][]){
	    ArrayList<Edge> graph[]=new ArrayList[E];
	    for(int i=0;i<V;i++){
	        graph[i]=new ArrayList<>();
	    }
	    for(int arr[]:edges){
	        int u=arr[0];
	        int v=arr[1];
	        int wt=arr[2];
	        graph[u].add(new Edge(u,v,wt));
	        graph[v].add(new Edge(v,u,wt));
	    }
        for(int i=0;i<graph.length;i++){
            for(int j=0;j<graph[i].size();j++){
                Edge e=graph[i].get(j);
                System.out.println("src "+e.src+" dest "+e.dest+" weight "+e.wt);
            }
        }
    }
}