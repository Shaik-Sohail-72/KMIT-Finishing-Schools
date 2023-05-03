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
import java.util.*;
class listOfList{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int V=sc.nextInt();
        int E=sc.nextInt();
        List<List<Integer>> mainls=new ArrayList<>();
        for(int i=0;i<V;i++){
            List<Integer> ls=new ArrayList<>();  // Creating empty list
            mainls.add(ls); // Adding empty lists in mainls. If V=7 then addding 7 empty lists. [[],[],[],[],[],[],[]]
        }
        System.out.println(mainls);  // Just debug print
        for(int i=0;i<E;i++){
            int src=sc.nextInt();  // Reading source
            int des=sc.nextInt();  // Reading destination
            mainls.get(src).add(des);  // Get source index list from mainls and add destination in that list. 
            mainls.get(des).add(src);  // Get destination index list from mainls and add source in that list because graph is undeirected.
        }
        System.out.println(mainls);    // Just debug print


        // print 4's neighbour
        for(int i: mainls.get(4)){  //get 4th index list from mainls and read each element and print it.
            System.out.print(i+" ");
        }
    }
}