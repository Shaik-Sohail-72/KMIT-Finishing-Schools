/*Azim likes to play the number sliding puzzle game but it takes more number of steps for solving the puzzle.
  help Azim to find the minimum number of steps in which he can finish the game.
 given a 3x3 board and the tiles in it are numbered from 1-8 and an empty square represented by 0.
 the game is completed when the numbers are arranged in Increasing order i.e
  [[1,2,3]
  [4,5,6]
  [7,8,0]]
  find the minimum number of ways to achive the required order by moving the tiles in 4 directions i.e
  up,down,right,left.only one movement is possible at every move.
 return -1 if it is not possible to achieve the order.
  
  Input:
  Input for the jumbled matrix of size 3x3;
  
  Output:
  Minimum number of steps to solve the board in Increasing order;
  Example 1:
  Input:
  1 2 3
  4 5 6
  7 0 8
  Output:
  1
  Explanation:
  swap 0 and 8 in one move.
 Example 2:
  Input:
  1 2 3
  4 5 6
  8 7 0
  Output:
  -1
  
  Explanation:
  No number of moves will make solve the board .   
*/

import java.util.*;
public class Main {
    public static int solvePuzzle(int[][] board) {
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        Queue<int[][]> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        int[][] target = {{1, 2, 3}, {4, 5, 6}, {7, 8, 0}};
        int steps = 0;
        queue.add(board);
        visited.add(Arrays.deepToString(board));
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[][] curr = queue.poll();
                if (Arrays.deepEquals(curr, target)) {
                    return steps;
                }
                int[] zeroPos = findZero(curr);
                for (int j = 0; j < 4; j++) {
                    int nx = zeroPos[0] + dx[j];
                    int ny = zeroPos[1] + dy[j];
                    if (nx >= 0 && nx < 3 && ny >= 0 && ny < 3) {
                        int[][] next = new int[3][3];
                        copy(curr, next);
                        swap(next, zeroPos, new int[]{nx, ny});
                        String state = Arrays.deepToString(next);
                        if (!visited.contains(state)) {
                            visited.add(state);
                            queue.add(next);
                        }
                    }
                }
            }
            steps++;
        }
        return -1;
    }
    public static int[] findZero(int[][] board) {
        int[] pos = new int[2];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == 0) {
                    pos[0] = i;
                    pos[1] = j;
                    return pos;
                }
            }
        }
        return pos;
    }
    public static void swap(int[][] board, int[] pos1, int[] pos2) {
        int temp = board[pos1[0]][pos1[1]];
        board[pos1[0]][pos1[1]] = board[pos2[0]][pos2[1]];
        board[pos2[0]][pos2[1]] = temp;
    }
    public static void copy(int[][] src, int[][] dest) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                dest[i][j] = src[i][j];
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[][] board = new int[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = sc.nextInt();
            }
        }
        int result = solvePuzzle(board);
        System.out.println(result);
    }
}

  