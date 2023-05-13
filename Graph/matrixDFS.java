/*Example - 1:
Input : 4 4

1 2 3 4
5 6 7 8
9 10 11 12
13 14 15 16

Output : 1 2 3 4 8 12 16 15 11 7 6 10 14 13 9 5 

Example - 2:
Input : 5 6

1 2 3 4 5 6
7 8 9 10 11 12 
13 14 15 16 17 18
19 20 21 22 23 24
25 26 27 28 29 30

Output : 1 2 3 4 5 6 12 18 24 30 29 23 17 11 10 16 22 28 27 21 15 9 8 14 20 26 25 19 13 7
*/
import java.util.*;                                                
class matrixDFS{
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
	public static void dfs(int[][] grid,boolean vis[][],int i,int j){
		vis[i][j]=true;
		System.out.print(grid[i][j]+" ");
		if(isValid(grid,i-1,j) && vis[i-1][j]==false){
			dfs(grid,vis,i-1,j);
		}
		if(isValid(grid,i,j+1) && vis[i][j+1]==false){
			dfs(grid,vis,i,j+1);
		}
		if(isValid(grid,i+1,j) && vis[i+1][j]==false){
			dfs(grid,vis,i+1,j);
		}
		if(isValid(grid,i,j-1) && vis[i][j-1]==false){
			dfs(grid,vis,i,j-1);
		}
	}
}