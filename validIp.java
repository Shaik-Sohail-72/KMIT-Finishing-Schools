/*
Bob Khan is working with various number systems.
He has created two kinds of addressing systems to share information 
between any two electronic devices.

Addresses in Type-I has following properties:
	- This addressing has four parts, each part is called as 'octet'
	- each octet can have a decimal value between 0 to 255 only
	- each part is separated by periods(.) 
	- Leading 0's are not allowed.
	- each part should conatins atmost 3 digits.

if any octet in the 4 parts, is not satisfying the rules
specified said to be  "invalid" addressing.


Addresses in Type-II has following properties:
	- This addressing has eight parts, each part is called as 'hextet'
	- each hextext can have a hexadecimal value between 0 to ffff only
	- each part is separated by colons (:) 
	- each part should conatins atmost 4 alphanumerics, 
	  as per hexademial number system.

if any hextet in the 8 parts, is not satisfying the rules
specified said to be "Invalid" addressing.
		
You will be given an address as a string	addr.
Your task is to find, whether the given address "addr" belongs to which asddress type.
And return "Type-I" if belongs to "Type-I" Addressing, 
return "Type-II" if belongs to "Type-II" Addressing, 
return "Invalid" if not belongs to either "Type-I"  or "Type-II"Addressing.


Input Format:
-------------
A string, an address addr.

Output Format:
--------------
Print a string output, as mentioned in above statement.


Sample Input-1:
---------------
213.234.45.12

Sample Output-1:
----------------
Type-I


Sample Input-2:
---------------
abcd:ef12:3456:7:dce8:fab9:1:0cda

Sample Output-2:
----------------
Type-II


Sample Input-3:
---------------
abcd:ef12:3456:7:0dce8:fab9:1:0cda

Sample Output-3:
----------------
Invalid


Sample Input-4:
---------------
123.234.34@.31

Sample Output-4:
----------------
Invalid


*/
/*import java.util.*;
class Main{
    public static boolean isIpV4(String s){
        if(s.length()<7)return false;
        if(s.charAt(0)=='.')return false;
        if(s.charAt(s.length()-1)=='.')return false;
        String arr[]=s.split("\\.");
        for(String i : arr){
            if(i.charAt(0)=='0') return false;
            int temp=Integer.parseInt(i);
            if(temp<0 && temp>255) return false;
        }
        return true;
    }
    public static boolean isIpV6(String s){
        if(s.length()<39) return false;
        if(s.charAt(0)==':') return false;
        if(s.charAt(s.length()-1)=='.')return false;
        String arr[]=s.split(":");
        for(String i:arr){
            if(i.length()!=4) return false;
        }
        return true;
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        String s=sc.next();
        if(isIpV4(s)){
            System.out.println("Type-I");
        }else if(isIpV4(s)){
            System.out.println("Type-II");
        }else{
            System.out.println("Invalid");
        }
    }
}*/
import java.util.*;
class validIp{
    public static void ty1(String a){
        String b[]=a.split("\\.");
        int c=0,d=0;
        if(b.length!=4){
            d++;
        }
        else{
            for(int i=0;i<b.length;i++){
                int j=0;
                try{
                    j=Integer.parseInt(b[i]);
                }
                catch(NumberFormatException e){
                    d++;
                }
                if(j<0 || j>255 || !b[i].equals(String.valueOf(j))){
                    d++;
                }
            }
        }
        if(d==0){
            System.out.println("Type-I");
        }
        else{
            System.out.println("Invalid");
        }
    }
    public static void ty2(String a){
        String b[]=a.split(":");
        int c=0;
        if(b.length!=8){
            c++;
        }
        else{
            for(int i=0;i<b.length;i++){
                if(b[i].length()<1 || b[i].length()>4)
                    c++;
                for(int j=0;j<b[i].length();j++){
                    char d=b[i].charAt(j);
                    if((d >'f' && d<='z') || (d>'F' && d<='Z'))
                        c++;
                }
            }
        }
        if(c==0){
            System.out.println("Type-II");
        }
        else{
            System.out.println("Invalid");
        }
    }
    
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        String a=sc.nextLine();
        if(a.contains(".") && !a.contains(":")){
            ty1(a);
        }
        else{
            ty2(a);
        }
    }
}

  