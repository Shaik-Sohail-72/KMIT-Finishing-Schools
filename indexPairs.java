/*An 8th standard student has been assigned a task as part of punishment for his mistake.

The task is, there is an input string STR(without any space) and an array of 
strings words[]. Print all the pairs of indices [s, e] where s, e are starting 
index and ending index of every string in words[] in the input string STR.

Note: Print the pairs[s, e] in sorted order.
(i.e., sort them by their first coordinate, and in case of ties sort them by 
their second coordinate).

Input Format
------------
Line-1: string STR(without any space)
Line-2: space separated strings, words[]

Output Format
-------------
Print the pairs[s, e] in sorted order.


Sample Input-1:
---------------
thekmecandngitcolleges
colleges kmec ngit

Sample Output-1:
----------------
3 6
10 13
14 21


Sample Input-2:
---------------
xyxyx
xyx xy

Sample Output-2:
----------------
0 1
0 2
2 3
2 4

Explanation: 
------------
Notice that matches can overlap, see "xyx" is found at [0,2] and [2,4].


Sample Input-3:
---------------
kmecngitkmitarecsecolleges
kmit ngit kmec cse

Sample Output-3:
----------------
0 3
4 7
8 11
15 17
*/
import java.util.*;
class Main{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        String txt=sc.nextLine();
        String temp=sc.nextLine();
        String arr[]=temp.split(" ");
        indexPairs(txt,arr);
    }
    public static void indexPairs(String text, String[] words) {
        List<int[]> indexPairsList = new ArrayList<int[]>();
        for (String word : words) {
            int wordLength = word.length();
            int curIndex = 0;
            while (curIndex >= 0) {
                curIndex = text.indexOf(word, curIndex);
                if (curIndex >= 0) {
                    indexPairsList.add(new int[]{curIndex, curIndex + wordLength - 1});
                    curIndex++;
                }
            }
        }
        Collections.sort(indexPairsList, new Comparator<int[]>() {
            public int compare(int[] array1, int[] array2) {
                if (array1[0] != array2[0])
                    return array1[0] - array2[0];
                else
                    return array1[1] - array2[1];
            }
        });
        int length = indexPairsList.size();
        int[][] indexPairs = new int[length][2];
        for (int i = 0; i < length; i++) {
            int[] indexPair = indexPairsList.get(i);
            System.out.print(indexPair[0]+" "+indexPair[1]);
            System.out.println();
        }
    }
}

  

      