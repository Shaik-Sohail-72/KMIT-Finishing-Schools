/*You are given an m x n grid where each cell can have one of three values:

0 representing an empty cell,
1 representing a fresh orange, or
2 representing a rotten orange.
Every minute, any fresh orange that is 4-directionally adjacent to a rotten orange becomes rotten.

Return the minimum number of minutes that must elapse until no cell has a fresh orange. If this is impossible, return -1.

Input=3 3
2 1 1
1 1 0
0 1 1
Output=4

Example 1:
Input: grid = [[2,1,1],[1,1,0],[0,1,1]]
Output: 4

Example 2:
Input: grid = [[2,1,1],[0,1,1],[1,0,1]]
Output: -1
Explanation: The orange in the bottom left corner (row 2, column 0) is never rotten, because rotting only happens 4-directionally.

Example 3:
Input: grid = [[0,2]]
Output: 0
Explanation: Since there are already no fresh oranges at minute 0, the answer is just 0.
 
Constraints:
m == grid.length
n == grid[i].length
1 <= m, n <= 10
grid[i][j] is 0, 1, or 2.*/
import java.util.*;
class Main{
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
        System.out.println(find(grid,m,n));
    }
    public static boolean isValid(int grid[][],int i,int j){
        if(i<0 ||i>=grid.length ||j<0 ||j>=grid[0].length || grid[i][j]==0){
            return false;
        }
        return true;
    }
    public static int find(int[][] grid,int m,int n) {
        if(grid.length==0){
            return 0;
        }
        Queue<Pair> q=new LinkedList<>();
        int days=0;
        int total=0;
        int rotcnt=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==2){
                    q.add(new Pair(i,j));
                }
                if(grid[i][j]!=0){
                    total++;
                }
            }
        }
        if(total==0){
            return 0;
        }
        while(!q.isEmpty()){
            int s=q.size();
            rotcnt+=s;
            for(int i=0;i<s;i++){
                Pair curr=q.remove();
                if(isValid(grid,curr.i-1,curr.j) && grid[curr.i-1][curr.j]==1){
                    grid[curr.i-1][curr.j]=2;
                    q.add(new Pair(curr.i-1,curr.j));
                }
                if(isValid(grid,curr.i,curr.j+1) && grid[curr.i][curr.j+1]==1){
                    grid[curr.i][curr.j+1]=2;
                    q.add(new Pair(curr.i,curr.j+1));
                }
                if(isValid(grid,curr.i+1,curr.j) && grid[curr.i+1][curr.j]==1){
                    grid[curr.i+1][curr.j]=2;
                    q.add(new Pair(curr.i+1,curr.j));
                }
                if(isValid(grid,curr.i,curr.j-1) && grid[curr.i][curr.j-1]==1){
                    grid[curr.i][curr.j-1]=2;
                    q.add(new Pair(curr.i,curr.j-1));
                }
            }
            if(!q.isEmpty()){
                days++;
            }
        }
        if(total==rotcnt){
            return days;
        }else{
            return -1;
        }
    }
}