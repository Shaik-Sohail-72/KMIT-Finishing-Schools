/*Chitti(ROBO) is busy in turning the people into chittis(ROBOS) by surrounding them.
In a room there are n*n boxes occupied by ROBOS and people.
   1.A person will be turned into ROBO if he is surrounded by all ROBOs. 
   2.A person will not be turned into ROBO if he is on the edge of the room
     and all the connected people to him (directly or indirectly) are also not to be turned.
 Return the n*n boxes after conversion.
 
Input Format
-------------
Line-1:integer n represent the n*n boxes of the room..
Next n lines:Each line of string consists of combination of 'X'(represents ROBO) and 'O'(represents a person)
   
Output Format:
--------------
Print n*n space seperated values after conversion.
  
   
Sample Input-1:
---------------
4
X X X X
X O O X
X X O X
O X X X
   
Sample Output-1:
----------------
X X X X 
X X X X 
X X X X 
O X X X 
   
Explanation:
------------
The people at second row and third row are converted to ROBOs as they are surrounded by ROBOs.
But the person at fourth row is safe as he is on edge.
  
   
Sample Input-2:
---------------
5
X O O O X
X X X X X
X O X X X
X X X O X
O X X X X
  
Sample Output-2:
----------------
X O O O X 
X X X X X 
X X X X X 
X X X X X 
O X X X X 


*/
import java.util.*;
class robo{
    public static boolean isValid(char grid[][],int i,int j){
        if(i<0 ||i>=grid.length || j<0 || j>=grid[0].length  || (grid[i][j]==0 && (i==0||i==grid.length-1 || j==0 || j==grid[0].length-1))){
            return false;
        }
        if(grid[i][j]=='O' && (i==0||i==grid.length-1 || j==0 || j==grid[0].length-1)){
            return false;
        }
        return true;
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        char grid[][]=new char[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                String s=sc.next();
                grid[i][j]=s.charAt(0);
            }
        }
        /*for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                System.out.print(isValid(grid, i, j)+" ");
            }
            System.out.println();
        }*/
    }
    public static boolean dfs(char grid[][],int i,int j){
        if(grid[j][j]=='X'){
            return true;
        }
        else{
            if(isValid(grid, i-1, j) && )
        }
        return false;

    }
}















































/*import java.util.*;
class Test{
    static void dfs(int row, int col,int vis[][],char mat[][],int delrow[],int delcol[]){
        vis[row][col] = 1; 
        int n = mat.length;
        int m = mat[0].length;
        for(int i = 0;i<4;i++){
            int nrow = row + delrow[i];
            int ncol = col + delcol[i]; 
            if(nrow >=0 && nrow <n && ncol >= 0 && ncol < m && vis[nrow][ncol] == 0 && mat[nrow][ncol] == 'O'){
                dfs(nrow, ncol, vis, mat, delrow, delcol); 
            }
        }
    }
    static char[][] fill(int n, int m, char mat[][]){
        int delrow[] = {-1, 0, +1, 0};
        int delcol[] = {0, 1, 0, -1}; 
        int vis[][] = new int[n][m]; 
        for(int j = 0 ; j<m;j++) {
            if(vis[0][j] == 0 && mat[0][j] == 'O') {
                dfs(0, j, vis, mat, delrow, delcol); 
            }
            if(vis[n-1][j] == 0 && mat[n-1][j] == 'O') {
                dfs(n-1,j,vis,mat, delrow, delcol); 
            }
        }
        for(int i = 0;i<n;i++) {
            if(vis[i][0] == 0 && mat[i][0] == 'O') {
                dfs(i, 0, vis, mat, delrow, delcol); 
            }
            if(vis[i][m-1] == 0 && mat[i][m-1] == 'O') {
                dfs(i, m-1, vis, mat, delrow, delcol); 
            }
        }
        for(int i = 0;i<n;i++) {
            for(int j= 0 ;j<m;j++) {
                if(vis[i][j] == 0 && mat[i][j] == 'O') 
                    mat[i][j] = 'X'; 
            }
        }
        
        return mat;
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        char a[][]=new char[n][n];
        for(int i=0;i<n;i++){
            String s=sc.next();
            for(int j=0;j<n;j++){
                a[i][j]=s.charAt(j);
            }
        }
        Test ob = new Test();
        char[][] ans = ob.fill(n,n,a);
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                System.out.print(ans[i][j]+" ");
            }
            System.out.println();
        }
    }
}

*/






































/*

/* 
import java.util.*;

class Robo {
   static int[][] dir = {{1,0}, {0,1}, {-1,0}, {0,-1}};
    
    public static void solve(char[][] board) {
        int m = board.length;
        if(board == null || board.length == 0) return;
        int n = board[0].length;
        int border = m * n;
        UnionFindSet uf = new UnionFindSet(border + 1);
        for(int x = 0; x < m; x++) {
            for(int y = 0; y < n; y++) {
                if(board[x][y] != 'O') continue;
                int cur = x * n + y;
                
                if(x == 0 || x == m - 1 || y == 0 || y == n - 1) {
                    uf.union(border, cur);
                    continue;
                }
                
                for(int[] d: dir) {
                    int nextX = x + d[0];
                    int nextY = y + d[1];
                    if(nextX >= 0 && nextX < m && nextY >= 0 && nextY < n && board[nextX][nextY] == 'O') {
                        int next = nextX * n + nextY;
                        uf.union(next, cur);
                    }
                }
            }
        }
        
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(board[i][j] == 'O' && uf.find(i * n + j) != uf.find(border)) {
                    board[i][j] = 'X';
                }
            }
        }
    }
    public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		char[][] board=new char[n][n];
		for(int i=0;i<n;i++)
			board[i]=sc.next().toCharArray();
				solve(board);	
		for(int i=0;i<n;i++){
		for(int j=0;j<n;j++){
			System.out.print(board[i][j]+" ");
			}
			System.out.println();
		}
	}

}

class UnionFindSet {
	int[] parents;
	int[] ranks;
	
	public UnionFindSet(int n) {
		parents = new int[n];
		ranks = new int[n];
		for(int i = 0; i < n; i++) parents[i] = i;
	}
	
   int find(int x) {
		if(x != parents[x]) x = find(parents[x]);
		return parents[x];
	}
	
	boolean union(int x, int y) {
		int px = find(x);
		int py = find(y);
		if(px == py) return false;
		if(ranks[px] > ranks[py]) {
			parents[py] = px;
			ranks[px] ++;
		} else{
			parents[px] = py;
			ranks[py] ++;
		}
		return true;
	}
}


=== testcases ===
case =1
input =5
XOOOX
XOXXX
XOXXX
XXXOX
OXXXX
output =X O O O X 
X O X X X 
X O X X X 
X X X X X 
O X X X X 
 
case =2
input =3
OOO
XOX
XXX
output =O O O
X O X 
X X X 
 
case =3
input =6
XXXXXX
OXXXXX
OOXXXX
XOXXXX
XXXOXX
XXXXXX
output =X X X X X X 
O X X X X X 
O O X X X X 
X O X X X X 
X X X X X X 
X X X X X X 
 
case =4
input =4
XXXX
XXOX
XXOX
XOXX
 
output =X X X X 
X X X X 
X X X X 
X O X X 
 
case =5
input =3
XOO
OOX
XXO
output =X O O 
O O X 
X X O 
 
case =6
input =2
XO
OX
output =X O 
O X 
 
case =7
input =4
XOOO
OXXX
XXXO
OOOO
output =X O O O 
O X X X 
X X X O 
O O O O 
 
case =8
input =7
XXXXXXO
XOXXXXX
OOXXXXX
XXOOOXX
XXXXXXX
OOXXXXX
XXXXXXX
output =X X X X X X O 
X O X X X X X 
O O X X X X X 
X X X X X X X 
X X X X X X X 
O O X X X X X 
X X X X X X X 

*/