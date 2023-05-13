import java.util.*;
class temp{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        System.out.println(find(n));
    }
    public static List<String> find(int n){
        LinkedList<String> list=new LinkedList<>();
        if(n<=0){
            return list;
        }
        dfs(n,0,"",list);
        return list;
    }
    public static void dfs(int left,int right,String res,List<String> list){
        if(left==0 && right==0){
            list.add(res);
            return;
        }
        if(left>0){
            dfs(left-1,right+1,res+"(",list);
            System.out.println(left-1);
        }
        if(right>0){
            dfs(left,right-1,res+")",list);
        }
    }
}