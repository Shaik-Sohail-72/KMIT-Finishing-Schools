/*Example - 1 :
4 4

1 2 3 4
5 6 7 8
9 10 11 12
13 14 15 16

1 2 5 3 6 9 4 7 10 13 8 11 14 12 15 16

Example - 2 :
5 6

1 2 3 4 5 6
7 8 9 10 11 12 
13 14 15 16 17 18
19 20 21 22 23 24
25 26 27 28 29 30

1 2 7 3 8 13 4 9 14 19 5 10 15 20 25 6 11 16 21 26 12 17 22 27 18 23 28 24 29 30

*/
import java.util.*;
class bfstempmat{
	static class Pair{
		int i;
		int j;
		Pair(int i,int j){
			this.i=i;
			this.j=j;
		}
	}
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		int m=sc.nextInt();
		int n=sc.nextInt();
		int grid[][]=new int[m][n];
		for(int i=0;i<m;i++){
			for(int j=0;j<n;j++){
				grid[i][j]=sc.nextInt();
			}
		}
		boolean vis[][]=new boolean[m][n];
		bfs(grid,vis,0,0);
	}
    static int dr[]={-1,0,1,0};
    static int dc[]={0,1,0,-1};
	public static boolean isValid(int[][] grid,int i,int j){
		if(i<0 || i>=grid.length || j<0 || j>=grid[0].length){
			return false;
		}
		return true;
	}
	public static void bfs(int[][] grid,boolean vis[][],int row,int col){
		Queue<Pair> q=new LinkedList<>();
		q.add(new Pair(row, col));
		while(!q.isEmpty()){
			Pair curr=q.remove();
            int neighx=curr.i;
            int neighy=curr.j;
            for(int i=0;i<4;i++){
                int r=neighx+dr[i];
                int c=neighy+dc[i];
                if(isValid(grid,r,c) && vis[r][c]==false){
                    System.out.print(grid[r][c]+" ");
                    vis[r][c]=true;
                }
            }
			/*if(vis[neighx][neighy]==false){
				System.out.print(grid[neighx][neighy]+" ");
				vis[neighx][neighy]=true;
				if(isValid(grid,neighx-1,neighy)){
					q.add(new Pair(neighx-1,neighy));
				}
				if(isValid(grid,neighx,neighy+1)){
					q.add(new Pair(neighx,neighy+1));
				}
				if(isValid(grid,neighx+1,neighy)){
					q.add(new Pair(neighx+1,neighy));
				}
				if(isValid(grid,neighx,neighy-1)){
					q.add(new Pair(neighx,neighy-1));
				}
			}*/
		}
	}
}