import java.util.*;
class city{
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
        int node;
        int cost;
        Pair(int n,int c){
            this.node=n;
            this.cost=c;
        }
        @Override
        public int compareTo(Pair p2){
            return this.cost-p2.cost;
        }

    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int arr[]=new int[6];
        for(int i=0;i<6;i++){
            arr[i]=sc.nextInt();
        }
        ArrayList<Edge> graph[]=new ArrayList[4];
        for(int i=0;i<4;i++){
            graph[i]=new ArrayList<>();
        }
        graph[0].add(new Edge(0,1,arr[0]));
        graph[0].add(new Edge(0,2,arr[1]));
        graph[0].add(new Edge(0,3,arr[2]));
        
        graph[1].add(new Edge(1,3,arr[3]));
        graph[1].add(new Edge(1,2,arr[4]));
        graph[2].add(new Edge(2,3,arr[5]));
        
        graph[1].add(new Edge(1,0,arr[0]));
        graph[2].add(new Edge(2,0,arr[1]));
        graph[3].add(new Edge(3,0,arr[2]));

        graph[3].add(new Edge(3,1,arr[3]));
        graph[2].add(new Edge(2,1,arr[4]));
        graph[3].add(new Edge(3,2,arr[5]));

        dijk(graph, 0, 4);
    }
    public static void dijk(ArrayList<Edge> graph[],int src,int V){
        PriorityQueue<Pair> pq=new PriorityQueue<>();
        int dist[]=new int[V];
        for(int i=0;i<V;i++){
            if(i!=src){
                dist[i]=Integer.MAX_VALUE;
            }
        }
        boolean vis[]=new boolean[V];
        //bfs
        pq.add(new Pair(0, 0));
        while(!pq.isEmpty()){
            Pair curr=pq.remove();
            if(vis[curr.node]==false){
                vis[curr.node]=true;
                for(int i=0;i<graph[curr.node].size();i++){
                    Edge e=graph[curr.node].get(i);
                    int u=e.src;
                    int v=e.dest;
                    if(dist[u]+e.wt < dist[v]){
                        dist[v]=dist[u]+e.wt;
                        pq.add(new Pair(v, dist[v]));
                    }
                    
                }
            }
        }
        for(int i=0;i<V;i++){
            System.out.print(dist[i]+" ");
        }
    }
}