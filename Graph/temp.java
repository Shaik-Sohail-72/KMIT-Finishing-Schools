import java.util.*;
class temp{
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
    }
    static class Pair implements Comparator<Pair>{
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
	static int spanningTree(int V, int E, int edges[][]){
	    List<List<Integer>> adj=new ArrayList<>();
	    for(int i=0;i<V;i++){
	        adj.add(new ArrayList<>());
	    }
	    for(int[] arr:edges){
	        int src=arr[0];
	        int dest=arr[1];
	        int wt=arr[2];
	        adj.get(src).add(src).add(dest).add(wt);
	    }
	    /*int c=0;
	    boolean vis[]=new boolean[V];
	    Queue<Pair> q=new LinkedList<>();
	    q.add(new Pair(0,0));
	    while(!q.isEmpty()){
	        Pair curr=q.remove();
	        if(vis[curr.node]==false){
	            vis[curr.node]=true);
	            c+=curr.cost;
	            for(int  neigh[]:edge[curr.node]){
	                q.push(new Pair(n[1],))
	            }
	        }
	    }*/
	}
}