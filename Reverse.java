// Ms.Sathvika is writing english exam through online, and she has to answer one question which states that given an input string s, reverse the order of the words.

// A word is defined as a sequence of non-space characters. The words in s will be separated by at least one space.

// Return a string of the words in reverse order concatenated by a single space.

// Note that s may contain leading or trailing spaces or multiple spaces between two words. The returned string should only have a single space separating the words. Do not include any extra spaces.
// input format : string which contains words 
// output  format : reverse order of the words 
// Example 1 :
// input =this is kmit
// output =kmit is this
// example 2:
// input =hello    good                   afternoon
// output = afternoon good hello
// Note : observe input there are more than one space in between words but in the output only one space between words.



import java.util.*;
class Test
{
    public static void main (String[] args)
    {
        Scanner obj=new Scanner(System.in);
        String s=obj.nextLine();
        String arr[]=s.split(" +");
        for(int i=arr.length-1;i>=0;i--)
        {
            System.out.print(arr[i]+" ");
        }
    }
}