/*Given a square chessboard, the initial position of Knight and position of a target. Find out the minimum steps a Knight will take to reach the target position.

Note:
The initial and the target position coordinates of Knight have been given according to 1-base indexing.

 

Example 1:

Input:
N=6
knightPos[ ] = {4, 5}
targetPos[ ] = {1, 1}
Output:
3
Explanation:

Knight takes 3 step to reach from 
(4, 5) to (1, 1):
(4, 5) -> (5, 3) -> (3, 2) -> (1, 1).
 

 

Your Task:
You don't need to read input or print anything. Your task is to complete the function minStepToReachTarget() which takes the initial position of Knight (KnightPos), the target position of Knight (TargetPos), and the size of the chessboard (N) as input parameters and returns the minimum number of steps required by the knight to reach from its current position to the given target position or return -1 if its not possible.

 

Expected Time Complexity: O(N2).
Expected Auxiliary Space: O(N2).

 

Constraints:
1 <= N <= 1000
1 <= Knight_pos(X, Y), Targer_pos(X, Y) <= N*/
class Solution{
    class Pair{
        int i;
        int j;
        int cnt;
        Pair(int i,int j,int c){
            this.i=i;
            this.j=j;
            this.cnt=c;
        }
    }
    public static boolean is(int n,int i,int j){
        if(i<0 || i>=n || j<0 || j>=n){
            return false;
        }
        return true;
    }
    public int minStepToReachTarget(int KnightPos[], int TargetPos[], int N){
        Queue<Pair> q=new LinkedList<>();
        boolean vis[][]=new boolean[N][N];
        q.add(new Pair(KnightPos[0]-1,KnightPos[1]-1,0));
        while(!q.isEmpty()){
            Pair curr=q.remove();
            int i=curr.i;
            int j=curr.j;
            int cn=curr.cnt;
            if(i==TargetPos[0]-1 && j==TargetPos[1]-1){
                return cn;
            }
            if(vis[i][j]==false){
                vis[i][j]=true;
                if(is(N,i-2,j+1)){
                    q.add(new Pair(i-2,j+1,cn+1));
                }
                if(is(N,i-1,j+2)){
                    q.add(new Pair(i-1,j+2,cn+1));
                }
                if(is(N,i+1,j+2)){
                    q.add(new Pair(i+1,j+2,cn+1));
                }
                if(is(N,i+2,j+1)){
                    q.add(new Pair(i+2,j+1,cn+1));
                }
                if(is(N,i+2,j-1)){
                    q.add(new Pair(i+2,j-1,cn+1));
                }
                if(is(N,i+1,j-2)){
                    q.add(new Pair(i+1,j-2,cn+1));
                }
                if(is(N,i-1,j-2)){
                    q.add(new Pair(i-1,j-2,cn+1));
                }
                if(is(N,i-2,j-1)){
                    q.add(new Pair(i-2,j-1,cn+1));
                }
            }
        }
        return -1;
    }
}