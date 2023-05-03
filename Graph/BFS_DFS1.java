/*
Sample Input-1:
---------------
6 7 // Number of vertices = 5 and Number of Edges = 4
0 1
0 2
1 3
2 4
3 4
3 5
4 5
*/
import java.util.*;
class BFS_DFS1{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int V=sc.nextInt();
        int E=sc.nextInt();
        List<List<Integer>> mainls=new ArrayList<>();
        for(int i=0;i<V;i++){
            List<Integer> ls=new ArrayList<>();  
            mainls.add(ls); 
        }
        for(int i=0;i<E;i++){
            int src=sc.nextInt();  
            int des=sc.nextInt();  
            mainls.get(src).add(des);  
            mainls.get(des).add(src); 
        }
        
        boolean vis1[]=new boolean[V];
        boolean vis2[]=new boolean[V];
        System.out.println("BFS ");
        bfs(mainls,vis1,0);
        System.out.println();
        System.out.println("DFS ");
        dfs(mainls,vis2,0);
    }
    public static void bfs(List<List<Integer>> mainls,boolean vis1[],int start){
        Queue<Integer> q=new LinkedList<>();
        q.add(start);
        while(!q.isEmpty()){
            int curr=q.remove();
            if(vis1[curr]==false){
                System.out.print(curr+" ");
                vis1[curr]=true;
                for(int i:mainls.get(curr)){
                    q.add(i);
                }
            }
        }
    }
    public static void dfs(List<List<Integer>> mainls,boolean vis2[],int curr){
        vis2[curr]=true;
        System.out.print(curr+" ");
        for(int i:mainls.get(curr)){
            if(vis2[i]==false){
                dfs(mainls,vis2,i);
            }
        }
    }
}