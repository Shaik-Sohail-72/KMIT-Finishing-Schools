import java.util.*;
class swapBit{
    public static void main(String[] args){
        int x=5;
        int y=9;
        x=x^y;
        y=x^y;
        x=x^y;
        System.out.println(x+" "+y);
        String a=Integer.toBinaryString(x);
        System.out.println(a);
        String b=Integer.toBinaryString(y);
        System.out.println(b);
        /*String c=(x&y);
        System.out.println(c);*/
    }
}