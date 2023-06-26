import java.util.*;
class per{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int arr[]=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        int k=sc.nextInt();
        List<Integer> ls=new ArrayList<>();
        for(int i=0;i<n-k+1;i++){
            int min=0;
            for(int j=i;j<i+k;j++){
                if(arr[j]<0){
                    min=Math.min(min,arr[j]);
                }
            }
            ls.add(min);
        }
        int res[]=new int[ls.size()];
        for(int i=0;i<ls.size();i++){
            res[i]=ls.get(i);
        }
        System.out.println(Arrays.toString(res));
    }
}