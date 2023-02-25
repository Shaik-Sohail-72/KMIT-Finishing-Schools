import java.util.*;
public class temp1{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int k=sc.nextInt();
        String s=String.valueOf(n);
        int arr[]=new int[s.length()];
        if(arr.length==k){
            System.out.print(0);
            System.exit(0);
        }
        for(int i=0;i<s.length();i++){
            arr[i]=Character.getNumericValue(s.charAt(i));
        }
        Stack<Integer> stk=new Stack<>();
        for(int i=0;i<arr.length;i++){
            if(k>0 && !stk.isEmpty() && stk.peek()>arr[i]){
               // System.out.println("stk"+stk.pop());
               stk.pop();
                k--;
            }
            stk.push(arr[i]);
        }
        while(k>0){
            stk.pop();
            k--;
        }
        StringBuilder res=new StringBuilder();
        while(!stk.isEmpty()){
            res.append(new StringBuilder(String.valueOf(stk.pop())));
        }
        res=res.reverse();
        int i=0;
        while(Character.getNumericValue(res.charAt(i))==0){
            res.deleteCharAt(i);
        }
        System.out.print(res);
    }
}