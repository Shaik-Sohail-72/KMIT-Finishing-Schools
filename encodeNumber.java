/*Birbal is creating a new binary code system BBC (Birbal Binary Code) as follows:

I	f(I)
-------
0	""
1	"0"
2	"1"
3	"00"
4	"01"
5	"10"
6	"11"
7	"000"

You are given an integer value I, where I is positive number.
Your task is to find BBC representation of  the given number I.

Input Format:
-------------
An integer I

Output Format:
--------------
Print the BBC representation of I.


Sample Input-1:
---------------
23

Sample Output-1:
----------------
1000


Sample Input-2:
---------------
45

Sample Output-2:
----------------
01110
*/
import java.util.*;
class encodeNumber{
    public String encode(int num) {
        StringBuilder sb = new StringBuilder();
        double cur = Math.log(num + 1) / Math.log(2);
        int bits = (int)(Math.floor(cur));
        int offset = num - (int)(Math.pow(2, bits)) +1;
        while (offset > 0) {
            sb.append(offset % 2);
            offset /= 2;
        }
        int l = sb.length();
        for (int i = l; i < bits; i++) {
            sb.append("0");
        }
        return sb.reverse().toString();
    }
	
	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		int s=sc.nextInt();
		System.out.println(new encodeNumber().encode(s));
	}

}