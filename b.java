import java.util.HashSet;
import java.util.Set;

class b {
    public static void main(String[] args){
        String s="AABBBCBBAC";
        findSubString(s);
    }
    public static void findSubString( String str) {
        int n=str.length();
        Set<Character> st=new HashSet<>();
        for(int i=0;i<n;i++){
            st.add(str.charAt(i));
        }
        //System.out.println(st);
        int k=st.size();
        for(int i=0;i<n-k+1;i++){
            String temp="";
            int c=0;
            for(int j=i;j<i+k;j++){
                temp+=str.charAt(j);
                if(st.contains(str.charAt(i))){
                    c++;
                }
            }
            if(c>=st.size()){
                System.out.println(temp);
            }
            
        }
    }
}