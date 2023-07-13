/*you are visiting a vegetable market, one vegetable shop is giving an offer to the customers that they place tomotos in grid of size m X n, each cell in this shop has an integer representing the number of tomotos in that cell,0 if it is empty.

Return the maximum number of tomotos you can collect under the conditions:

Every time you are located in a cell you will collect all tomotos in that cell.
From your position, you can walk one step to the left, right, up, or down.
You can't visit the same cell more than once.
Never visit a cell with 0 .
You can start and stop collecting tomotos from any position in the grid that has some tomotos.
input format :m and n size of grid
              m*n number of integers
output format : an integer value 
Sample test cases:
case =1
input =3 3
0 6 0
5 8 7
0 9 0
output =24  
Explanation : 9->8->7
case = 2
input =5 3
1 0 7
2 0 6
3 4 5
0 3 0
9 0 20
output =28
Explanation : 1->2->3->4->5->6->7

*/
import java.util.Scanner;

public class getMaximum {
    private static int maxm;

    public static int find(int[][] grid) {
        maxm = 0;
        int rows = grid.length;
        int cols = grid[0].length;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] != 0) {
                    dfs(grid, i, j, 0);
                }
            }
        }

        return maxm;
    }

    private static void dfs(int[][] grid, int i, int j, int currentSum) {
        int rows = grid.length;
        int cols = grid[0].length;

        if (i < 0 || i >= rows || j < 0 || j >= cols || grid[i][j] == 0) {
            maxm = Math.max(maxm, currentSum);
            return;
        }

        int tomatoes = grid[i][j];
        grid[i][j] = 0; 

        dfs(grid, i + 1, j, currentSum + tomatoes); 
        dfs(grid, i - 1, j, currentSum + tomatoes); 
        dfs(grid, i, j + 1, currentSum + tomatoes); 
        dfs(grid, i, j - 1, currentSum + tomatoes); 

        grid[i][j] = tomatoes;  
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        int n = scanner.nextInt();

        int[][] grid = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = scanner.nextInt();
            }
        }

        int maxm = find(grid);
        System.out.println(maxm);
    }
}
