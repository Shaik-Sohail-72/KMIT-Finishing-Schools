import java.util.*;
class tech1{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int arr[]=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        System.out.println(cal(n,arr));
    }
    public static int cal(int n,int arr[]){
        int s1=0;
        int s2=0;
        for(int i=0;i<n;i++){
            if(i%2==0){
                s1=Math.max(s1+arr[i],s2);
            }else{
                s2=Math.max(s2+arr[i],s1);
            }
        }
        return Math.max(s1,s2);
    }
}