/*There is a board game played by children, the rules for this board game are as follows. 
The board is made up of an m x n board of cells, where each cell has an initial state: live (represented by a 1) or dead (represented by a 0). Each cell interacts with its eight neighbors (horizontal, vertical, diagonal) using the following four rules (taken from the above Wikipedia article):
Any live cell with fewer than two live neighbors dies as if caused by under-population.
Any live cell with two or three live neighbors lives on to the next generation.
Any live cell with more than three live neighbors dies, as if by over-population.
Any dead cell with exactly three live neighbors becomes a live cell, as if by reproduction.
The next state is created by applying the above rules simultaneously to every cell in the current state, where births and deaths occur simultaneously. Given the current state of the m x n board board, return the next state.
Write a program to this board game
Input format : two integers rows ans columns
               m*n number of 0 or 1
output format : m*n number of 0 or 1
Example1 :
input =4
3
0 1 0
0 0 1
1 1 1
0 0 0
output =
0 0 0
1 0 1
0 1 1
0 1 0
case = 2:
input = 2
2
1 1
1 0
output =
1 1
1 1*/


import java.util.*;                                                
class boardGame{
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		int m=sc.nextInt();
		int n=sc.nextInt();
		int board[][]=new int[m][n];
        int newgrid[][]=new int[m][n];
		for(int i=0;i<m;i++){
			for(int j=0;j<n;j++){
				board[i][j]=sc.nextInt();
			}
		}
		find(board,m,n,newgrid);
		for(int i=0;i<m;i++){
			for(int j=0;j<n;j++){
				System.out.print(newgrid[i][j]+" ");
			}
            System.out.println();
		}
	}
	public static boolean isValid(int board[][],int i,int j){
		if(i<0 || i>=board.length || j<0 || j>=board[0].length){
			return false;
		}
		return true;
	}
    public static void find(int board[][],int m,int n,int newgrid[][]){
        for(int i=0;i<m;i++){
			for(int j=0;j<n;j++){
				int c=neighbors(board,i,j);
                if(board[i][j]==1){
                    if(c<2 || c>3){
                        newgrid[i][j]=0;
                    }else if(c==2 || c==3){
                        newgrid[i][j]=1;
                    }else{
                        newgrid[i][j]=board[i][j];
                    }
                }else if(board[i][j]==0){
                    if(c==3){
                        newgrid[i][j]=1;
                    }else{
                        newgrid[i][j]=board[i][j];
                    }
                }
			}
		}
    }
    public static int neighbors(int board[][],int i,int j){
        int c=0;
        if(isValid(board,i-1,j) && board[i-1][j]==1){
			c++;
		}
		if(isValid(board,i,j+1) && board[i][j+1]==1){
			c++;
		}
		if(isValid(board,i+1,j) && board[i+1][j]==1){
			c++;
		}
		if(isValid(board,i,j-1) && board[i][j-1]==1){
			c++;
		}
        if(isValid(board,i-1,j-1) && board[i-1][j-1]==1){
			c++;
		}
        if(isValid(board,i-1,j+1) && board[i-1][j+1]==1){
			c++;
		}
        if(isValid(board,i+1,j+1) && board[i+1][j+1]==1){
			c++;
		}
        if(isValid(board,i+1,j-1) && board[i+1][j-1]==1){
			c++;
		}
        return c;
    }
}