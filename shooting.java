/*There are some spherical balloons taped onto a flat wall that represents the XY-plane. The balloons are represented as a 2D integer array points where points[i] = [xstart, xend] denotes a balloon whose horizontal diameter stretches between xstart and xend. You do not know the exact y-coordinates of the balloons.

Arrows can be shot up directly vertically (in the positive y-direction) from different points along the x-axis. A balloon with xstart and xend is burst by an arrow shot at x if xstart <= x <= xend. There is no limit to the number of arrows that can be shot. A shot arrow keeps traveling up infinitely, bursting any balloons in its path.

Given the array points, return the minimum number of arrows that must be shot to burst all balloons.
 
Sample input: No of rows and columns , Array data.
input=4(m) 2(n)
1 2
3 4
5 6
7 8
output=4

Example 1:

Input:4 2
 points = [[10,16],[2,8],[1,6],[7,12]]
Output: 2
Explanation: The balloons can be burst by 2 arrows:
- Shoot an arrow at x = 6, bursting the balloons [2,8] and [1,6].
- Shoot an arrow at x = 11, bursting the balloons [10,16] and [7,12].
Example 2:

Input: 4 2
points = [[1,2],[3,4],[5,6],[7,8]]
Output: 4
Explanation: One arrow needs to be shot for each balloon for a total of 4 arrows.
Example 3:

Input:4 2
 points = [[1,2],[2,3],[3,4],[4,5]]
Output: 2
Explanation: The balloons can be burst by 2 arrows:
- Shoot an arrow at x = 2, bursting the balloons [1,2] and [2,3].
- Shoot an arrow at x = 4, bursting the balloons [3,4] and [4,5].
*/
import java.util.*;

class Balloon {
    int start;
    int end;

    public Balloon(int start, int end) {
        this.start = start;
        this.end = end;
    }
}

class BalloonComparator implements Comparator<Balloon> {
    @Override
    public int compare(Balloon b1, Balloon b2) {
        return b1.end - b2.end;
    }
}

public class shooting {
    public static int findMinArrowShots(int[][] points) {
        int n = points.length;
        if (n == 0) {
            return 0;
        }

        List<Balloon> balloons = new ArrayList<>();
        for (int[] point : points) {
            balloons.add(new Balloon(point[0], point[1]));
        }

        Collections.sort(balloons, new BalloonComparator());

        int shots = 1;
        int arrowPos = balloons.get(0).end;

        for (int i = 1; i < n; i++) {
            if (arrowPos < balloons.get(i).start) {
                arrowPos = balloons.get(i).end;
                shots++;
            }
        }

        return shots;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int m = scanner.nextInt();

        int[][] points = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                points[i][j] = scanner.nextInt();
            }
        }

        int minArrows = findMinArrowShots(points);
        System.out.println(minArrows);
    }
}
