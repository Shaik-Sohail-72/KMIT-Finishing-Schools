import pyautogui
import time

code_to_type = """
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class NumberSlidingPuzzle {

    private static final int[][] DIRECTIONS = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    public static int slidingPuzzle(int[][] board) {
        // Convert the 2D board to a 1D string representation
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                sb.append(board[i][j]);
            }
        }
        String start = sb.toString();
        String target = "123450"; // Required order

        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        queue.offer(start);
        visited.add(start);

        int steps = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String curr = queue.poll();
                if (curr.equals(target)) {
                    return steps;
                }
                int zeroIdx = curr.indexOf("0"); // Find the index of the empty square
                int row = zeroIdx / 3; // Calculate the row of the empty square
                int col = zeroIdx % 3; // Calculate the column of the empty square

                for (int[] direction : DIRECTIONS) {
                    int newRow = row + direction[0];
                    int newCol = col + direction[1];
                    if (newRow >= 0 && newRow < 3 && newCol >= 0 && newCol < 3) {
                        // Swap the empty square with its neighboring tile
                        StringBuilder newBoard = new StringBuilder(curr);
                        int neighborIdx = newRow * 3 + newCol;
                        char temp = newBoard.charAt(zeroIdx);
                        newBoard.setCharAt(zeroIdx, newBoard.charAt(neighborIdx));
                        newBoard.setCharAt(neighborIdx, temp);
                        String newBoardStr = newBoard.toString();
                        if (!visited.contains(newBoardStr)) {
                            queue.offer(newBoardStr);
                            visited.add(newBoardStr);
                        }
                    }
                }
            }
            steps++;
        }

        return -1; // If the target order cannot be achieved
    }

    public static void main(String[] args) {
        int[][] board1 = {{1, 2, 3}, {4, 5, 6}, {7, 0, 8}};
        int[][] board2 = {{1, 2, 3}, {4, 5, 6}, {8, 7, 0}};
        System.out.println(slidingPuzzle(board1)); // Output: 1
        System.out.println(slidingPuzzle(board2)); // Output: -1
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