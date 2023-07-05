/*There is a 1-based binary matrix where 0 represents land and 1 represents water. You are given integers row and col representing the number of rows and columns in the matrix, respectively.

Initially on day 0, the entire matrix is land. However, each day a new cell becomes flooded with water. You are given a 1-based 2D array cells, where cells[i] = [ri, ci] represents that on the ith day, the cell on the rith row and cith column (1-based coordinates) will be covered with water (i.e., changed to 1).

You want to find the last day that it is possible to walk from the top to the bottom by only walking on land cells. You can start from any cell in the top row and end at any cell in the bottom row. You can only travel in the four cardinal directions (left, right, up, and down).

Return the last day where it is possible to walk from the top to the bottom by only walking on land cells.

 

Example 1:



Input: row = 2, col = 2, cells = [[1,1],[2,1],[1,2],[2,2]]
Output: 2 
Explanation: The above image depicts how the matrix changes each day starting from day 0.
The last day where it is possible to cross from top to bottom is on day 2.
Example 2:


Input: row = 2, col = 2, cells = [[1,1],[1,2],[2,1],[2,2]]
Output: 1
Explanation: The above image depicts how the matrix changes each day starting from day 0.
The last day where it is possible to cross from top to bottom is on day 1.
Example 3:


Input: row = 3, col = 3, cells = [[1,2],[2,1],[3,3],[2,2],[1,1],[1,3],[2,3],[3,2],[3,1]]
Output: 3
Explanation: The above image depicts how the matrix changes each day starting from day 0.
The last day where it is possible to cross from top to bottom is on day 3.
 

Constraints:

2 <= row, col <= 2 * 104
4 <= row * col <= 2 * 104
cells.length == row * col
1 <= ri <= row
1 <= ci <= col
All the values of cells are unique.*/



import java.util.*;
class Main {
    public boolean isPossible(int m, int n, int t, int[][] cells) {
        int[][] grid = new int[m + 1][n + 1]; 
        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}}; 

        for (int i = 0; i < t; i++) {
            grid[cells[i][0]][cells[i][1]] = 1; 
        }

        Queue<int[]> queue = new LinkedList<>();
        
        for (int i = 1; i <= n; i++) {
            if (grid[1][i] == 0) {
                queue.offer(new int[]{1, i}); 
                grid[1][i] = 1; 
            }
        }
        
        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            int r = cell[0], c = cell[1]; 
            for (int[] dir : directions) {
                int nr = r + dir[0], nc = c + dir[1]; 
                
                if (nr > 0 && nc > 0 && nr <= m && nc <= n && grid[nr][nc] == 0) {
                    grid[nr][nc] = 1; 
                    
                    if (nr == m) {
                        return true; 
                    }
                    
                    queue.offer(new int[]{nr, nc});
                }
            }
        }
        
        return false;
    }

    public int latestDayToCross(int row, int col, int[][] cells) {
        int left = 0, right = row * col, latestPossibleDay = 0;
        
        while (left < right - 1) {
            int mid = left + (right - left) / 2; 
            
            if (isPossible(row, col, mid, cells)) {
                left = mid; 
                latestPossibleDay = mid; 
            } else {
                right = mid; 
            }
        }
        
        return latestPossibleDay;
    }
    public static void main(String []args){
        Scanner sc=new Scanner(System.in);
        int r=sc.nextInt();
        int ro=sc.nextInt();
        int c=sc.nextInt();
        int arr[][]=new int[r][2];
        for(int i=0;i<r;i++)
        {
            for(int j=0;j<2;j++)
            {
                arr[i][j]=sc.nextInt();
            }
        }
        System.out.println(new Main().latestDayToCross(ro,c,arr));

    }
}




     