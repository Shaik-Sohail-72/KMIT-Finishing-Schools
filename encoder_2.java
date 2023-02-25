/* encoder-2
Mr. Bob is a Military Encoders. 
Mr. Bob writes a word as shown below and then merges them. 
Help Bob to write the code. 

Mr. Bob will be given a word 'w' and a number 'n' 

Sample Test Case - 1
input = 
ABCDE
2
output = ACEBD


This is How Bob writes the letters of the word 
A    C    E
   B    D

Now concatenate the two rows and ignore spaces in every row. We get ACEBD


Sample Test Case - 2
input = system
3
output = seytms

s         e
  y    t    m
     s

Now concatenate the 3 rows we get seytms */

import java.util.*;

class encoder_2 
{ 
	public  static void printEncoded(String str, int n) 
	{ 
      	String[] rows = new String[n]; 
		Arrays.fill(rows,"");
		int r = 0; 
		System.out.println(Arrays.toString(rows));
		boolean down = true;
		for (int i = 0; i < str.length() ; i++) 
		{ 
			rows[r] = rows[r] + str.charAt(i);
			
			if (r == n - 1) 
				down = false; 
			else if (r == 0) 
			 	down = true; 
		      
			if (down) 
				r++; 
			else
				r--; 
		} 
		for (String ns : rows)
			System.out.print(ns); 
	} 

	public static void main(String[] args) 
	{ 
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		int n = sc.nextInt();
		if (n != 1) 
			printEncoded(str, n); 
		else
			System.out.print(str); 
	} 
} 
/*
case=1
input=system                                                                                                                  
3                                                                                                                       
output=seytms                                                                                                                  

case=2
input=Bravo                                                                                                                   
4                                                                                                                       
output=Braov  

case=3
input=intelligent                                                                                                             
3                                                                                                                       
output=ilenelgntit 
*/

