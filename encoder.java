/*
Mr.Bob and Mr.Cob are working on a Military Mission. 
They are supposed to encode the message and send the message to the under-cover team.

Where Cob has written a script. Where the Script says double all the ascii values other than mentioned in the bracket
(97,101,105,111,117,65,69,73,79,85) and place a '#' in between. 

Help Bob in writing the Code. 


Sample Test Case-1
input = attack the enemy
output = at#tt#tac#ck#k t#th#he en#nem#my#y*/

import java.util.*;
class encoder{
    public static void cal(String s){
        String res="";
        ArrayList ls=new ArrayList(Arrays.asList('A','E','I','O','U','a','e','i','o','u'));
        for(int i=0;i<s.length();i++){
            if(!ls.contains(s.charAt(i))){
                res+=s.charAt(i)+"#"+s.charAt(i);
            }else{
                res+=s.charAt(i);
            }
        }
        System.out.println(res);
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        String str=sc.nextLine();
        cal(str);
    }
}