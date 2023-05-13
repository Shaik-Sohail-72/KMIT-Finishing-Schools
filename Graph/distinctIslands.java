import java.util.*;
class distinctIslands{
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
        int arr[][]=new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                arr[i][j]=sc.nextInt();
            }
        }
        int c=0;
        boolean vis[][]=new boolean[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(isValid(arr,i,j) && vis[i][j]==false && arr[i][j]==0){
                    dfs(arr,vis,i,j);
                    c++;
                }
            }
        }
        System.out.println(c);
    }
    public static boolean isValid(int grid[][],int i,int j){
        if(i<0 ||i>=grid.length || j<0 || j>=grid[0].length){
            return false;
        }
        if(grid[i][j]==0 && (i==0|| j==0 || i==grid.length-1 || j==grid[0].length-1)){
            return false;
        }
        return true;
    }
    public static void dfs(int[][] grid,boolean vis[][],int row,int col){
		vis[row][col]=true;
		if(isValid(grid,row-1,col) && vis[row-1][col]==false && grid[row-1][col]==0){
			dfs(grid,vis,row-1,col);
		}
		if(isValid(grid,row,col+1) && vis[row][col+1]==false && grid[row][col+1]==0){
			dfs(grid,vis,row,col+1);
		}
		if(isValid(grid,row+1,col) && vis[row+1][col]==false && grid[row+1][col]==0){
			dfs(grid,vis,row+1,col);
		}
		if(isValid(grid,row,col-1) && vis[row][col-1]==false && grid[row][col-1]==0){
			dfs(grid,vis,row,col-1);
		}
	}
}