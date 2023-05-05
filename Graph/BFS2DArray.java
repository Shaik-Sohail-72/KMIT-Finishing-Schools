import java.util.*;
class BFS2DArray{
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
			if(vis[curr.i][curr.j]==false){
				System.out.print(grid[curr.i][curr.j]+" ");
				vis[curr.i][curr.j]=true;
				if(isValid(grid,curr.i-1,curr.j)){
					q.add(new Pair(curr.i-1,curr.j));
				}
				if(isValid(grid,curr.i,curr.j+1)){
					q.add(new Pair(curr.i,curr.j+1));
				}
				if(isValid(grid,curr.i+1,curr.j)){
					q.add(new Pair(curr.i+1,curr.j));
				}
				if(isValid(grid,curr.i,curr.j-1)){
					q.add(new Pair(curr.i,curr.j-1));
				}
			}
		}
	}
}