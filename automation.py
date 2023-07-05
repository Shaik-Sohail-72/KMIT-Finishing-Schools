import pyautogui
import time

code_to_type = """
import java.util.*;
class Solution {
    public boolean isPossible(int m, int n, int t, int[][] cells) {
        int[][] grid = new int[m + 1][n + 1]; // Grid representation
        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}}; // Possible directions

        for (int i = 0; i < t; i++) {
            grid[cells[i][0]][cells[i][1]] = 1; // Mark cells from the given list as blocked
        }

        Queue<int[]> queue = new LinkedList<>();
        
        for (int i = 1; i <= n; i++) {
            if (grid[1][i] == 0) {
                queue.offer(new int[]{1, i}); // Start BFS from the top row
                grid[1][i] = 1; // Mark the cell as visited
            }
        }
        
        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            int r = cell[0], c = cell[1]; // Current cell coordinates
            
            for (int[] dir : directions) {
                int nr = r + dir[0], nc = c + dir[1]; // Neighbor cell coordinates
                
                if (nr > 0 && nc > 0 && nr <= m && nc <= n && grid[nr][nc] == 0) {
                    grid[nr][nc] = 1; // Mark the neighbor cell as visited
                    
                    if (nr == m) {
                        return true; // Found a path to the bottom row
                    }
                    
                    queue.offer(new int[]{nr, nc}); // Add the neighbor cell to the queue for further exploration
                }
            }
        }
        
        return false; // Unable to find a path to the bottom row
    }

    public int latestDayToCross(int row, int col, int[][] cells) {
        int left = 0, right = row * col, latestPossibleDay = 0;
        
        while (left < right - 1) {
            int mid = left + (right - left) / 2; // Calculate the mid-day
            
            if (isPossible(row, col, mid, cells)) {
                left = mid; // Update the left pointer to search in the upper half
                latestPossibleDay = mid; // Update the latest possible day
            } else {
                right = mid; // Update the right pointer to search in the lower half
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
		System.out.println(new Solution().latestDayToCross(ro,c,arr));

	}
}


   
"""


time.sleep(10)
def avoid_auto_complete():
    pyautogui.hotkey('esc', 'space', 'backspace', 'enter', 'space', 'ctrl', 'left')
lines = list(code_to_type.split("\n"))
for line in lines:
        pyautogui.typewrite(line, interval=0)
        avoid_auto_complete()