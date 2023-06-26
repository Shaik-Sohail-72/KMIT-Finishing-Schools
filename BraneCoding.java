import java.util.*;
public class BraneCoding {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int arr[]=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        Map<Integer,Integer> m=new HashMap<>();
        for(int i=0;i<n;i++){
            if(!m.containsKey(arr[i])){
                m.put(arr[i],1);
            }else{
                m.put(arr[i],m.get(arr[i])+1);
            }
        }
        List<Integer> ls=new ArrayList<>();
        ls.addAll(m.keySet());

        // Descending order frequency
        /* Collections.sort(ls,(a,b)->{
            return m.get(a)-m.get(b);
        }); */

        // Ascending order frequency
        /*Collections.sort(ls,(a,b)->{
            return m.get(b)-m.get(a);
        });*/

        // Descending order frequency and Lexicographically smallest comes first if frequencies are same else descending order frequency
        Collections.sort(ls,(a,b)-> m.get(a).equals(m.get(b)) ? a.compareTo(b) : m.get(b)-m.get(a));
        
        System.out.println(ls);
    }
}
/* input:  8
5 5 5 4 4 4 1 1 
output: [4, 5, 1] */ 