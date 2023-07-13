/*Java Program to Check if a string is a valid shuffle of two distinct strings\
it should also follow the order

1XY2 is a valid shuffle of XY and 12
Y1X2 is not a valid shuffle of XY and 12     
Y21XX is not a valid shuffle of XY and 12*/


import java.util.*;
class validShuffle{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String str1=sc.next();
        String str2=sc.next();
        String rstr=sc.next();
        System.out.println(valid(str1,str2,rstr));
    }
    public static boolean valid(String str1,String str2,String rstr){
        int i=0;
        int j=0;
        int k=0;
        while(k<rstr.length()){
            if(i<str1.length() && str1.charAt(i)==rstr.charAt(k)){
                i++;
            }else if(j<str2.length() && str2.charAt(j)==rstr.charAt(k)){
                j++;
            }else{
                return false;
            }
            k++;
        }
        return true;
    }
}