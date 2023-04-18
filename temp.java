class Solution{
    static class Node{
        Node children[];
        boolean eow;
        Node(){
            children=new Node[26];
            for(int i=0;i<26;i++){
                children[i]=null;
            }
            eow=false;
        }
        
    }
    static Node root=new Node();
    public static void insert(String word){
        Node curr=root;
        for(int i=0;i<word.length();i++){
            int idx=word.charAt(i)-'a';
            if(curr.children[idx]==null){
                curr.children[idx]=new Node();
            }
            if(i==word.length()-1){
                curr.children[idx].eow=true;
            }
            curr=curr.children[idx];
        }
    }
    public static boolean search(String key){
        Node curr=root;
        for(int i=0;i<key.length();i++){
            int idx=key.charAt(i)-'a';
            if(curr.children[idx]==null){
                return false;
            }
            if(i==key.length()-1 && curr.children[idx].eow==false){
                return false;
            }
            curr=curr.children[idx];
        }
        return true;
    }
    public static int wordBreak(String s, ArrayList<String> wordDict )
    {
        if(s.length()==0){
            return 1;
        }
        for(int i=0;i<wordDict.size();i++){
            insert(wordDict.get(i));
        }
        for(int i=1;i<=s.length();i++){
            String firstPart=s.substring(0,i);
            String secPart=s.substring(i,s.length());
            if(search(firstPart)==true && wordBreak(secPart,wordDict)==1){
                return 1;
            }
        }
        return 0;
    }
}