import java.util.*;
public class duplicateWindow {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int arr[]=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        int k=sc.nextInt();
        System.out.println(cal(n,arr,k));
    }
    public static boolean cal(int n,int arr[],int k){
        Set<Integer> s=new HashSet<>();
        for(int i=0;i<n-k;i++){
            int c=0;
            for(int j=i;j<i+k+1;j++){
                c++;
                s.add(arr[j]);
            }
            if(s.size()!=c){
                return true;
            }
            s.clear();
        }
        return false;
    }    
}
