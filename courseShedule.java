/*A graduate at University of China (UoC) has to follow certain rules. The rules are as follows:

UoC is offering K subjects, the subjects are indexed from 0 to K-1.
Some subjets have to follow the conditions, like condition[i]= [Xi, Yi] which specifies you must
take the subject Yi before the subject Xi.

You are given total number of subjects and a list of the condition pairs.
Return the ordering of subjects that a graduate should take to finish all subjects.
	- the result set should follow the given order of conditions.
	- If it is impossible to complete all subjects, return an empty set.

Input Format:
-------------
Line-1: An integer K, number of subjects.
Line-2: An integer C, number of conditions.
Next C lines: Two space separated integers, Xi and Yi.

Output Format:
--------------
Return a list of integers, the ordering of subjects that a graduate should take to finish all subjects


Sample Input-1:
---------------
4
3
1 2
3 0
0 1

Sample Output-1:
----------------
[2, 1, 0, 3]

Explanation-1:
--------------
There are a total of 4 courses to take. 
Subject 1  should be taken after you finished subject 2.
Subject 3  should be taken after you finished subject 0.
Subject 0  should be taken after you finished subject 1.
So the correct subject order is [2, 1, 0, 3].

Sample Input-2:
---------------
5
5
0 1
1 2
2 3
3 4
4 0

Sample Output-2:
----------------
[]

Explanation-2:
-------------
No subject can be completed because they depend on each other.
*/
import java.util.*;
public class Main{
    public static void main (String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int c=sc.nextInt();
        List<List<Integer>>l=new ArrayList<>();
        for(int i=0;i<n;i++){
            l.add(new ArrayList<>());
        }
        for(int i=0;i<c;i++){
            int t1=sc.nextInt();
            int t2=sc.nextInt();
            l.get(t2).add(t1);
        }
        int d[]=new int[n];
        for(int i=0;i<n;i++){
            for(int j:l.get(i)){
                d[j]+=1;
            }
        }
        List<Integer>r=new ArrayList<>();
        int v=0;
        Queue<Integer>q=new LinkedList<>();
        for(int i=0;i<n;i++){
            if(d[i]==0){
                q.add(i);
            }
        }
        while(!q.isEmpty()){
            int p=q.poll();
            v++;
            r.add(p);
            for(int i:l.get(p)){
                d[i]-=1;
                if(d[i]==0){
                    q.add(i);
                }
            }
        }
        if(v!=n){
            System.out.println(new ArrayList<>());
        }
        else{
            System.out.println(r);
        }
    }
}

  