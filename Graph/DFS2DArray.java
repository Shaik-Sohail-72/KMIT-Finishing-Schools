import java.util.*;
class DFS2DArray{
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
		dfs(grid,vis,0,0);
	}
	public static boolean isValid(int grid[][],int i,int j){
		if(i<0 || i>=grid.length || j<0 || j>=grid[0].length){
			return false;
		}
		return true;
	}
	public static void dfs(int[][] grid,boolean vis[][],int row,int col){
		vis[row][col]=true;
		System.out.print(grid[row][col]+" ");
		if(isValid(grid,row-1,col) && vis[row-1][col]==false){
			dfs(grid,vis,row-1,col);
		}
		if(isValid(grid,row,col+1) && vis[row][col+1]==false){
			dfs(grid,vis,row,col+1);
		}
		if(isValid(grid,row+1,col) && vis[row+1][col]==false){
			dfs(grid,vis,row+1,col);
		}
		if(isValid(grid,row,col-1) && vis[row][col-1]==false){
			dfs(grid,vis,row,col-1);
		}
	}
}