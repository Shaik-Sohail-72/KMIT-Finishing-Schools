import java.util.*;
class Main{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        String str=sc.next();
        String res="";
        for(int i=0;i<str.length();i++){
            if(Character.isDigit(str.charAt(i))){
                res+=str.charAt(i);
            }
        }
        int arr[][]=new int[res.length()/2][2];
        int m=0;
        int n=0;
        for(int i=0;i<res.length();i++){
            if(i%2==0){
                arr[m++][0]=Character.getNumericValue(res.charAt(i));
            }else{
                arr[n++][1]=Character.getNumericValue(res.charAt(i));
            }
        }
        System.out.println(cal(arr,n));
    }
    public static List<List<Integer>> cal(int arr[][],int n){
        List<List<Integer>> mainls=new ArrayList<>();
        Arrays.sort(arr,(a,b)-> a[0]==b[0] ? a[1]-b[1] : b[0]-a[0]);   
        for(int i=0;i<n;i++){
            List<Integer> ls=new ArrayList<>();
            for(int j=0;j<2;j++){
                ls.add(arr[i][j]);
            }
            mainls.add(ls);
        }
        List<List<Integer>> mainls1=new LinkedList<>();
        for(List<Integer> ls:mainls){
            mainls1.add(ls.get(1),ls);
        }
        return mainls1;
    }
}