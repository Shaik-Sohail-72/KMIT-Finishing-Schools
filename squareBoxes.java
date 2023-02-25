import java.util.*;
class squareBoxes{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int m=sc.nextInt();
        char[][] grid= new char[m][m];
        for (int i = 0; i < m; i++) {
            String line = sc.next();
            for (int j = 0; j < m; j++) {
                grid[i][j] = line.charAt(j);
            }
        }
        cal(grid);
    }
    public static void cal(char[][] grid){
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]=='O'){
                    if(helper(i,j,grid)){
                        grid[i][j]='X';
                    }
                }
            }
        }
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid.length; j++) {
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }
    }
    public static boolean helper(int i,int j,char grid[][]){
        if(i<0 || i>=grid.length || j<0 || j>=grid[0].length || (grid[i][j]=='O' &&(i==0||j==0 ||i==grid.length ||j==grid[0].length))){
            return false;
        }
        if(grid[i][j]=='X'){
            return true;
        }else{
            grid[i][j]='X';
        }
        boolean l=helper(i-1,j,grid);
        boolean r=helper(i+1,j,grid);
        boolean u=helper(i,j-1,grid);
        boolean d=helper(i,j+1,grid);
        return l && r&& u&& d;
    }
}