/*
There are some cubes, each cube is printed with an alphabet [A-Z].
Using these cubes, you can create non-empty distinct words.
and length of the words should be 0< length <= no.of.cubes.

You are given a string of alphabets S, 
Your task is to findout number of possible non-empty distinct words

Input Format:
-------------
A string S, consist of Upper case A-Z letters only.

Output Format:
--------------
Print an integer, number of possible non-empty distinct words.


Sample Input-1:
---------------
EGG

Sample Output-1:
----------------
8

Explanation:
--------------
The possible distinct words are "E", "G", "EG", "GG", "GE", "EGG", "GEG", "GGE".


Sample Input-2:
---------------
MADAM

Sample Output-2:
----------------
89
*/
import java.util.*;
public class numTilePossibilities{
	static HashSet<String> se = new HashSet<String>();
	static String tiles;
	static void recur(Vector<Boolean> vis, String ans){
		if(ans.length()>0){
			if(se.contains(ans)){
				return;
			}
			se.add(ans);
		}
		for(int i = 0; i < tiles.length(); i++){
			if (vis.get(i))
				continue;
			vis.set(i, true);
			recur(vis, ans + tiles.charAt(i));
			vis.set(i, false);
		}
	}
	
	public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
		tiles = sc.next();
		String curr = "";
		Vector<Boolean> vis = new Vector<Boolean>();
		for(int i = 0; i < tiles.length(); i++)
		{
			vis.add(false);
		}
		
		recur(vis, curr);
		System.out.print(se.size());
	}
}