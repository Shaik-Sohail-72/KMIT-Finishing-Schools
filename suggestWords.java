/* Vikas and jayadeep are playing with strings and they try to list the matching words for a given searchword with in list of strings, can you develop a program using trie to help them.
You are given an array of strings products seperated by ',' and a string searchWord.
Design a system that suggests at most three product names from products after each character of searchWord is typed. Suggested products should have common prefix with searchWord. 
If there are more than three products with a common prefix return the three lexicographically minimums products.

Return a list of lists of the suggested products after each character of searchWord is typed.
input : line 1 : words seperated by ','
        line 2 : searchword 
output : list of lists of suggested products.
sample cases
case 1:
input :
mobile,mouse,moneypot,moniter,mousepad
mouse
output : [[mobile, moneypot, moniter], [mobile, moneypot, moniter], [mouse, mousepad], [mouse, mousepad], [mouse, mousepad]]

Explanation :output contains 5 lists as key word length is 5
list 1 contains the three lexicographically minimum products matching with m
list 2 contains the three lexicographically minimum products matching with mo
list 3 contains the three lexicographically minimum products matching with mou
list 4 contains the three lexicographically minimum products matching with mous
list 5 contains the three lexicographically minimum products matching with mouse
case 2 :
input :
mango,mobile,mouse,moneypot,moniter,mouse,maximum,marvel
mouse
output:
[[mango, marvel, maximum], [mobile, moneypot, moniter], [mouse], [mouse], [mouse]]
Explanation : output list contains 5 lists as keyword length is 5
list 1 contains the three lexicographically minimum products matching with m
list 2 contains the three lexicographically minimum products matching with mo
list 3 contains only one word which matches with mou
list 4 contains only one word which matches with mous
list 5 contains only one word which matches with mouse



input :
bag,bags,baggage,banner,baseball,box,bill,brown,ball,baby
bag
output :[[baby, bag, baggage], [baby, bag, baggage], [bag, baggage, bags]]


*/

import java.util.*;
class Solution{
public static List<List<String>> suggestedProducts(String[] products, String searchWord) {
        //sort words so they will be added in a sorted order to nodes 
        Arrays.sort(products);
        
        Trie root = new Trie();
        for (String prod : products) {
            Trie n = root;
            for (char ch : prod.toCharArray()) {
                int i = ch - 'a';
                if (n.next[i] == null) {
                    n.next[i] = new Trie();
                }
                n = n.next[i];
                if (n.words.size() < 3)
                    n.words.add(prod);
            }
        }
        
        List<List<String>> res = new ArrayList();
        Trie n = root;
        //start going over the search word char by char
        for (int i = 0; i < searchWord.length(); i++) {
            n = n.next[searchWord.charAt(i) - 'a'];
            //if we met null - means no more matches possible, the result of result can be filled by empty lists
            if (n == null) {
                for (int j = i; j < searchWord.length(); j++)
                    res.add(Collections.EMPTY_LIST);    
                break;
            }
            res.add(n.words);
        }
        return res;
}
    //trie node
    static class Trie {
        Trie[] next;
        List<String> words;
        Trie() {
            words = new ArrayList();
            next = new Trie[26];
        }
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        String words=sc.nextLine();
        String ser=sc.nextLine();
        String arr[]=words.split(",");
        System.out.println(suggestedProducts(arr,ser));
    }
}

      
