import java.util.*;
class bridges{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int V=sc.nextInt();
        int E=sc.nextInt();
        List<List<Integer>> adj=new ArrayList<>();
        for(int i=0;i<V;i++){
            adj.add(new ArrayList<>()); 
        } 
        for(int i=0;i<E;i++){
            int src=sc.nextInt();  
            int des=sc.nextInt(); 
            adj.get(src).add(des);   
            adj.get(des).add(src);  
        }
        int dt[]=new int[V];
        int low[]=new int[V];
        int time=0;
        boolean vis[]=new boolean[V];
        for(int i=0;i<V;i++){
            if(vis[i]==false){
                dfs(adj,vis,i,dt,low,time,-1);
            }
        }
    }
    public static void dfs(List<List<Integer>> adj,boolean vis[],int curr,int dt[],int low[],int time,int par){
        vis[curr]=true;
        dt[curr]=low[curr]=++time;
        for(int neigh:adj.get(curr)){
            if(neigh==par){
                continue;
            }else if(vis[neigh]==true){
                low[curr]=Math.min(low[curr],dt[neigh]);
            }else{
                dfs(adj,vis,neigh,dt,low,time,curr);
                low[curr]=Math.min(low[curr],low[neigh]);
                if(dt[curr]<low[neigh]){
                    System.out.println("Bridge is : "+curr+" ------ "+neigh);
                }
            }
        }
    }
}