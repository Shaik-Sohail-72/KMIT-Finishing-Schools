/*
Rahul and Rohith are playing a switch game.
Rahul has given a string PresentState that contains only '+' and '-' . Both take turns to switch two consecutive "++" into "--" . The game ends when a person can no longer make a move, and therefore the other person will be the winner.
Return all possible states of the string presentState after one valid move. You may return the answer in any order.If there is no valid move, return an empty list [] .

Input Format:
-------------
Line-1: A string represents present state.

Output Format:
--------------
Array of strings of possible states.

Constraints:

    
    1 <= string.length <= 500   
    string[i] is either '+' or '-'

Sample Input-1:
---------------
--++- 

Sample Output-1:
----------------
[-----]

Explanation:
-------------
++ will be converted as --. Then game ends.
Sample Input-2:
---------------
--+++-++

Sample Output-2:
----------------
[----+-++, --+---++, --+++---]



*/
import java.util.*;
class switchGame{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        String str=sc.next();
        List<String> ls=new ArrayList<>();
        for(int i=0;i<str.length()-1;i++){
            if(str.charAt(i)=='+' && str.charAt(i+1)=='+'){
                int start=i;
                String res="";
                for(int j=0;j<str.length();j++){
                    if(j==start||j==start+1){
                        res+='-';
                    }else{
                        res+=str.charAt(j);
                    }
                }
                ls.add(res);
            }
        }
        System.out.println(ls);
    }
}