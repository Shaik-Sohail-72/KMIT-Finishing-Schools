/*
Sample Input-1:
---------------
6 7 // Number of vertices = 5 and Number of Edges = 4
0 1
0 2
1 3
2 4
3 4
3 5
4 5
*/
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
class listOfList{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int V=sc.nextInt();
        int E=sc.nextInt();
        List<List<Integer>> mainls=new ArrayList<>();
        for(int i=0;i<V;i++){
            List<Integer> ls=new ArrayList<>();  
            mainls.add(ls); 
        }
        for(int i=0;i<E;i++){
            int src=sc.nextInt();  
            int des=sc.nextInt();  
            mainls.get(src).add(des);  
            mainls.get(des).add(src); 
        }
        System.out.println(mainls);    


        // print 4's neighbour
        for(int i: mainls.get(4)){  
            System.out.print(i+" ");
        }
    }
}