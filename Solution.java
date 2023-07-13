import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
class Solution
{
    //Function to find the smallest window in the string s consisting
    //of all the characters of string p.
    public static void main(String[] args) {
        System.out.println(findSubString("CCCbAbbBbbC"));
    }
    public static int findSubString( String str) {
        int n=str.length();
        Set<Character> mainst=new HashSet<>();
        for(int i=0;i<str.length();i++){
            mainst.add(str.charAt(i));
        }
        System.out.println(mainst);
        int k=mainst.size();
        while(k<=n){
            for(int i=0;i<n-k+1;i++){
                List<Character> ls=new ArrayList<>();
                ls.addAll(mainst);
                String tempstr="";
                int c=0;
                for(int j=i;j<i+k;j++){
                    tempstr+=str.charAt(j);
                    if(ls.contains(str.charAt(j))){
                        c++;
                        //ls.remove(Character.valueOf(str.charAt(j)));
                    }
                }
                if(c>=mainst.size()){
                    return tempstr.length();
                }
            }
            k++;
        }
        return -1;
    }
}