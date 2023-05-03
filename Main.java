import java.util.*;
class Main{
    public static void main(String[] args) {
        List<Integer> ls=new ArrayList<>();
        List<Integer> ls1=new ArrayList<>();
        List<Integer> ls2=new ArrayList<>();


        List<List<Integer>> mainls=new ArrayList<>();

        ls.add(0);
        ls.add(1);
        ls.add(3);

        ls1.add(4);
        ls1.add(5);
        ls1.add(6);

        ls2.add(7);
        ls2.add(8);
        ls2.add(9);
        //System.out.println(ls);
        /*for(int i:ls){
            System.out.println(i);
        }*/

        mainls.add(ls);
        mainls.add(ls1);
        mainls.add(ls2);
        System.out.println(mainls);
        for(List<Integer> i:mainls){
            System.out.print(i+" ");
        }

    }
}