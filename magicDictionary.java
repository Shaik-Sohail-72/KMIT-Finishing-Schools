/*
Imagine that you are playing  word game, the conept of game is,you will be given  list of different words and  Provided with a search word, you should determine if you can change exactly one character in this search word to match any word in the given list of words.
      "note use trie datastructure only."
input :
       line one is an integer(say n) which gives number of words to read
	   next n lines list of words in lowercase only
	   next line a word to search
output :
         true or false
sample cases
example 1:
input :5
hello
kmit
ngit
kmec
aiml
kmIt
output : true
Explanation : we can change the I in kmIt to i to match kmit of input word so result is true
example 2:
input = 6
bill
ball
board
bat
boat
bracnh
ball
output = true
Explanation : we have exact match for ball search key in the given strings but by changing one character that is a in ball we can make it as bill hence result is true
Example 3:
input=5
ball
board
bat
boat
branch
ball
output =false
Explanation : search keyword ball can't form any word in the given words with one character change hence result is false.
*/


import java.util.Scanner;
class MagicDictionary 
{
    static final int MAX_CHARS = 26;
    class trie 
    {
        trie[] children = new trie[MAX_CHARS];
        int ct;
        int we;
        trie() 
        {
            for (int i = 0; i < MAX_CHARS; i++) {
                children[i] = null;
            }
            ct = 0;
            we = 0;
        }
    }

    public trie root = new trie();

    public void addWord(String key)
    {
        trie current = root;
        for (int i = 0; i < key.length(); i++) {
            int ind = key.charAt(i) - 'a';
            if (current.children[ind] == null) {
                current.children[ind] = new trie();
            }
            current = current.children[ind];
        }
        current.ct = current.ct + 1;

    }

    public void buildDict(String[] dict) {
        for(String i:dict)addWord(i);
    }

    public boolean search(trie trie, char[] word, int i, int mismatch) 
    {
        if(mismatch > 1)
            return false;

        if(i==word.length) 
        {
            if(trie.ct > 0 && mismatch == 1) return true;
            return false;
        }
        for(int j = 0; j < MAX_CHARS; j++)
        {
            if(trie.children[j] == null) continue;
            if(j == (int)(word[i]-'a')) {
                if(search(trie.children[j], word, i+1, mismatch)) return true;
            }
            else {
                if(search(trie.children[j], word, i+1, mismatch+1)) return true;
            }
        }
        return false;
    }

    public boolean search(String w) {
        return search(root, w.toCharArray(), 0, 0);
    }

    public static void main(String[] args)
    {
        MagicDictionary obj = new MagicDictionary();
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        scanner.nextLine();

        String[] dict = new String[n];

        for (int i = 0; i < n; i++) 
            dict[i] = scanner.nextLine();

        obj.buildDict(dict);

        String word = scanner.nextLine();
        boolean result = obj.search(word);
        System.out.println(result);

        scanner.close();
    }
}



    