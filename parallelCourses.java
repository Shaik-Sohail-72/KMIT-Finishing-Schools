/*EA Sports, developed a video game. They designed a game in such a way that, 
there are L number of levels from 1 to L. There are D number of dependencies
where each dependency[m] = [ Xm, Ym ], represents a prerequisite relationship,
that is, in order to play level-Ym, you must have completed the level-Xm.

In one day you can complete any number of levels as long as you 
have completed all the prerequisites levels in the game. 

You cannot play a level-Ym which has some prerequisite level-Xm on same day.

Write a method to return the minimum number of days to complete all the levels
in the game. If there is no way to complete all the levels, return -1.


Input Format:
-------------
Line-1: An integer L, number of levels.
Line-2: An integer D, number of dependencies.
Next D lines: Two space separated integers, Xm and Ym.

Output Format:
--------------
An integer, the minimum number of days to complete all the levels in the game.


Sample Input-1:
---------------
3
2
1 3
2 3

Sample Output-1:
----------------
2

Explanation-1:
--------------
On the first day, levels 1 and 2 are completed. 
On the second day, level-3 is completed.


Sample Input-2:
---------------
3
3
1 2
2 3
3 1

Sample Output-2:
----------------
-1

Explanation-2:
-------------
No level can be completed because they depend on each other.

 */


 import java.util.*;
 class Test
   {
         private static final int UNVISITED = 0;
         private static final int VISITING = 1;
         private static final int VISITED = 2;
         private static int[] longestPath;
         private static int[] states;
         public static void main(String[] args)
         {
         Scanner obj=new Scanner(System.in);
         int m=obj.nextInt();
         int n=obj.nextInt();
         int[][] arr=new int[n][2];
         for(int i=0;i<n;i++)
         {
         for(int j=0;j<2;j++)
         {
         arr[i][j]=obj.nextInt();
         }
         }
         System.out.println(minimumSemesters(m,arr));
         }
         public  static int minimumSemesters(int N, int[][] relations) {
 
             Map<Integer, Set<Integer>> graph = constructGraph(N, relations);
             longestPath = new int[N + 1];
             states = new int[N + 1];
 
             for(int course = 1; course <= N; course++) {
                 if(states[course] == UNVISITED) {
                     if(dfs(graph, course)) {
                         return -1;
                     }
                 }
             }
             int ans = 0;
             for(int course = 1; course <= N; course++) {
                 ans = Math.max(ans, longestPath[course]);
             }
             return ans;
         }
 
         private static Map<Integer, Set<Integer>> constructGraph(int N, int[][] relations) {
             Map<Integer, Set<Integer>> graph = new HashMap<>();
             for(int i = 1; i <= N; i++) {
                 graph.put(i, new HashSet<>());
             }
             for(int i = 0 ; i < relations.length; i++) {
                 graph.get(relations[i][0]).add(relations[i][1]);
             }
             return graph;
         }
 
         private static boolean dfs(Map<Integer, Set<Integer>> graph, int course) {
             if(states[course] == VISITED) {
                 return false;
             } else if(states[course] == VISITING) { 
                 return true;
             }
             states[course] = VISITING;
             for(int neighbor : graph.get(course)) {
                 if(dfs(graph, neighbor)) {
                     return true;
                 }
             }
             for(int neighbor : graph.get(course)) {
                 longestPath[course] = Math.max(longestPath[course], longestPath[neighbor]);
             }
             longestPath[course]++;
             states[course] = VISITED;
             return false;
         }
   }
 
 
 
 
    
  