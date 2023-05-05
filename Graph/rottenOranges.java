import java.util.*;
class rottenOranges{
    class Pair{
        int i;
        int j;
        Pair(int i,int j){
            this.i=i;
            this.j=j;
        }
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int arr[][]=new int[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                arr[i][j]=sc.nextInt();
            }
        }
        System.out.println(find(arr));
    }
    public static boolean isValid(int[][] grid,int i,int j){
        if(i<0 || i>=grid.length || j<0 || j>=grid[0].length){
            return false;
        }
        return true;
    }
    public static int find(int[][] grid){
        Queue<Pair> q=new LinkedList<>();
        int time=-1;
        int noOfFreshOrg=0;
        int noOfRottenOrg=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==2){
                    gird[i][j]=-1;--------p7-----
                }
            }
        }
    }
}




int orangesRotting(vector<vector<int>>& grid) {
    // Code here
    int n=grid.size();
    int m=grid[0].size();
    int time=-1;
    
    queue<pair<int,int>> que;
    int noOfFreshOrg=0;
    int noOfRottenOrg=0;
    
    for(int i=0; i<n; i++){
        for(int j=0; j<m; j++){
            if(grid[i][j]==2){
                que.push({i,j});
                grid[i][j]=-1;
                noOfRottenOrg++;
            }
            else if(grid[i][j]==1) noOfFreshOrg++;
        }
    }
    
    if(noOfFreshOrg==0) return 0;
    else if(noOfRottenOrg==0 && noOfFreshOrg!=0) return -1;
    else if(noOfRottenOrg!=0 && noOfFreshOrg==0) return 0;
    
    
    int orgRottenLater=0;
    while(!que.empty()){
        
        time++;
        int size=que.size();
        
        for(int p=0; p<size; p++){
            
            int i=que.front().first;
            int j=que.front().second;
            
            // up
            if(i-1>=0 and grid[i-1][j] ==1){
                que.push({i-1,j});
                grid[i-1][j]=-1;
                orgRottenLater++;
                
            }
            
            // down
            if(i+1<n and grid[i+1][j] ==1){
                
                que.push({i+1,j});
                grid[i+1][j]=-1;
                orgRottenLater++;
            }
            
            // left
            if(j-1>=0  and grid[i][j-1] ==1){
                
                que.push({i,j-1});
                grid[i][j-1]=-1;
                orgRottenLater++;
            }
            
            // right
            if(j+1<m  and grid[i][j+1] ==1){
                
                que.push({i,j+1});
                grid[i][j+1]=-1;
                orgRottenLater++;
            }
            
            que.pop();
        }
    }
    
    if(noOfFreshOrg!=orgRottenLater) return -1;
    
    return time;
}