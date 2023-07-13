/*Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals, and return an array of the non-overlapping intervals that cover all the intervals in the input.

 

Example 1:

Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
Output: [[1,6],[8,10],[15,18]]
Explanation: Since intervals [1,3] and [2,6] overlap, merge them into [1,6].
Example 2:

Input: intervals = [[1,4],[4,5]]
Output: [[1,5]]
Explanation: Intervals [1,4] and [4,5] are considered overlapping.
 

Constraints:

1 <= intervals.length <= 104
intervals[i].length == 2
0 <= starti <= endi <= 104*/
import java.util.*;
class mergeIntervals{
    public static void main(String[] args){
        int m=4;
        int n=2;
        int arr[][]={{1,3},{2,6},{8,10},{15,18}};
        merge(arr);
    }
    public static void merge(int[][] arr) {
        // Sort the intervals based on the finish time
        Arrays.sort(arr, Comparator.comparingInt(interval -> interval[1]));
        
        List<int[]> mergedIntervals = new ArrayList<>();
        
        // Initialize the first interval
        int[] currentInterval = arr[0];
        mergedIntervals.add(currentInterval);
        
        for (int[] interval : arr) {
            int currentEnd = currentInterval[1];
            int nextStart = interval[0];
            int nextEnd = interval[1];
            
            // If the current interval and the next interval overlap, update the end time of the current interval
            if (nextStart <= currentEnd) {
                currentInterval[1] = Math.max(currentEnd, nextEnd);
            } else {
                // If the next interval doesn't overlap, add it as a separate interval
                currentInterval = interval;
                mergedIntervals.add(currentInterval);
            }
        }
        
        // Convert the list of merged intervals to a 2D array
        for(int[] ls:mergeIntervals){
            
        }
        
    }
}