import java.util.*;
public class tech2 {
    static class Pair{
        int i;
        int j;
        Pair(int i,int j){
            this.i=i;
            this.j=j;
        }
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int m=sc.nextInt();
        int n=sc.nextInt();
        int i=sc.nextInt();
        int j=sc.nextInt();
        boolean vis[][]=new boolean[m][n];
        bfs(vis,m,n,i,j);
    }
    public static boolean isVal(boolean vis[][],int i,int j){
        if(i<0 || i>=vis.length || j<0 || j>=vis[0].length){
            return false;
        }
        return true;
    }
    public static void bfs(boolean vis[][],int m,int n,int r,int c){
        Queue<Pair> q=new LinkedList<>();
        q.add(new Pair(r,c));
        while(!q.isEmpty()){
            Pair curr=q.remove();
            int i=curr.i;
            int j=curr.j;
            if(vis[i][j]==false){
                vis[i][j]=true;
                if(isVal(vis,i-1,j)){
                    q.add(new Pair(i-1,j));
                }
                if(isVal(vis,i,j-1)){
                    q.add(new Pair(i,j-1));
                }
            }
        }
        int ver=0;
        int hor=0;
        for(int i=0;i<m;i++){
            if(vis[i][0]==true){
                ver++;
            }
        }
        for(int j=0;j<n;j++){
            if(vis[0][j]==true){
                hor++;
            }
        }
        System.out.println(ver+hor+1);
    }
}
