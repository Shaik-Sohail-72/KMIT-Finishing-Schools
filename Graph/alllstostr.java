import java.util.*;
class alllstostr{
    public static void main(String[] args){
        int arr[][]={{4,3,1},{3,2,4},{3},{4},{}};
        System.allPathsSourceTarget(arr));
    }
    public static void allPathsSourceTarget(int[][] graph) {
        
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        temp.add(0);
        dfs(graph,ans,temp,0);
    }
    
   public static void dfs(int[][] graph, List<List<Integer>> ans, List<Integer> temp, int start){
       
        if(start == graph.length-1){
            ans.add(new ArrayList<>(temp));
            return;
        }
        
        for(int i : graph[start]){
            temp.add(i);
            dfs(graph,ans,temp,i);
            temp.remove(temp.size()-1);  
        }
        
    }
}