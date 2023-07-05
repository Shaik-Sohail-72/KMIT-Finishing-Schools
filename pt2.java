/*Given an integer rowIndex, return the rowIndexth (0-indexed) row of the Pascal's triangle.
sample case
input=1
output=[1, 1]*/
import java.util.*;
public class Main{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int k=sc.nextInt();
        Integer[] arr = new Integer[k + 1];
        Arrays.fill(arr, 0);
        arr[0] = 1;
        
        for (int i = 1; i <= k; i++) 
            for (int j = i; j > 0; j--) 
                arr[j] = arr[j] + arr[j - 1];
        System.out.println(Arrays.asList(arr));
    }
}


   