/*
NOKIA company designed a special keypad.
The keypad consist of 9 keys, numbered from 1 to 9, 
each key is mapped to lowercase alphabet only. 

The mapping of the alphabet can be arranged according to your choice as follows:
 - All lowercase alhpabet should be mapped to the keys.
 - Each alphabet is mapped to exactly one key only.
 - Each key on the keypad can be mapped with at most 3 alphabet.
 
To type the first alphabet mapped to a key, press the key for one time. 
To type the second alphabet mapped to a key, press the key for two times.
To type the third alphabet mapped to a key, press the key for three times and so on.

You are given a word W, Your task is to find the least number of key presses 
needed to type W using NOKIA keypad.

Note:
- The alphabet mapped to by each key, and the order they are 
mapped in cannot be changed.


Input Format:
-------------
A string, the word W

Output Format:
--------------
Print an integer result

Sample Input-1:
---------------
pepla

Sample Output-1:
----------------
5

Explanation: 
------------
One way to arrange the mapping of alphabet in NOKIA keypad is shown bwloe:
 1    2    3 
abc  edf  ghi
 4    5    6 
lkj  mno  pqr
 7    8    9 
stu  vwx  yz

Type 'p' by pressing the key 6 once.
Type 'e' by pressing the key 3 once.
Type 'p' by pressing the key 6 once.
Type 'l' by pressing the key 5 once.
Type 'a' by pressing the key 1 once.
A total of 5 key presses are needed, so return 5.


Sample Input-2:
---------------
abcdefghijklmnopqr

Sample Output-2:
----------------
27

Explanation:
------------
One way to arrange the mapping of alphabet in NOKIA keypad is shown bwloe:
 1    2    3 
ajs  bkt  clu
 4    5    6 
dmv  enw  fox
 7    8    9 
gpy  hqz  ir

The alphabet from 'a' to 'i' can each be typed by pressing a key once.
Type 'j' by pressing the key 1 two times.
Type 'k' by pressing the key 2 two times.
Type 'l' by pressing the key 3 two times.
Type 'm' by pressing the key 4 two times.
Type 'n' by pressing the key 5 two times.
Type 'o' by pressing the key 6 two times.
Type 'p' by pressing the key 7 two times.
Type 'q' by pressing the key 8 two times.
Type 'r' by pressing the key 9 two times.

A total of 27 key presses are needed, so return 27.


*/
    
import java.util.*;
class keypad{
    public static void main (String[] args) {
        Scanner obj=new Scanner(System.in);
        String s=obj.nextLine();
        int out=0;
        int keys=9;
        HashMap<Character,Integer> map=new HashMap<>();
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            map.put(c,map.getOrDefault(c,0)+1);
        }
        List<Integer> list=new ArrayList<>();
        for(int i:map.values()){
            list.add(i);
        }
        Collections.sort(list,Collections.reverseOrder());
        for(int i:list){
            out=out+i*(keys/9);
            keys++;        
        }
        System.out.println(out);
    }
}

  

      