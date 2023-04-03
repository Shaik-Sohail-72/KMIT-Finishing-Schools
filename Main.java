import java.util.*;
class Main{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int arr[]=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        System.out.println(cal(arr,n));
    }
    /*public static int cal(int arr[],int n){
        int m=0;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                m=Math.max(m,Math.min(arr[i],arr[j])*(j-i));
            }
        }
        return m;
    }*/
    public static int cal(int arr[],int n){
        int i=0;
        int j=n-1;
        int max=0;
        while(i<=j){
            int minh=Math.min(arr[i],arr[j]);
            int dis=j-i;
            int m=minh*dis;
            if(m>max){
                max=m;
            }
            if(arr[i]<arr[j]){
                i++;
            }else{
                j--;
            }
        }
        return max;
    }
}