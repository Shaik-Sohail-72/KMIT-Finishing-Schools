/*There are N people standing in a circle waiting to be executed. The counting out begins at some point in the circle and proceeds around the circle in a fixed direction. In each step, a certain number of people are skipped and the next person is executed. The elimination proceeds around the circle (which is becoming smaller and smaller as the executed people are removed), until only the last person remains, who is given freedom. 

Given the total number of persons N and a number k which indicates that k-1 persons are skipped and the kth person is killed in a circle. The task is to choose the person in the initial circle that survives.
Examples:

Input: N = 5 and k = 2
Output: 3
Explanation: Firstly, the person at position 2 is killed, 
then the person at position 4 is killed, then the person at position 1 is killed. 
Finally, the person at position 5 is killed. So the person at position 3 survives. 

Input: N = 7 and k = 3
Output: 4
Explanations: The persons at positions 3, 6, 2, 7, 5, and 1 are killed in order, 
and the person at position 4 survives.
*/

import java.util.*;
class Main
{
    public static void main (String[] args) 
    {
        Scanner obj=new Scanner(System.in);
        int n=obj.nextInt();
        int k=obj.nextInt();
        System.out.println(findSurvivor(n,k));
    }
    public static int findSurvivor(int n,int k)
    {
        if(n==1)
        {
            return 1;
        }
        ArrayList<Integer> list=new ArrayList<>();
        for(int i=1;i<=n;i++)
        {
            list.add(i);
        }
        int ind=0;
        while(list.size()>1)
        {
            ind=(ind+k-1)%(list.size());
            list.remove(ind);
        }
        return list.get(0);
    }
}





      