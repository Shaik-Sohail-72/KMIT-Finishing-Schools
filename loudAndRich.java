/*There is a group of n people labeled from 0 to n - 1 where each person has a different amount of money and a different level of quietness.

You are given an array richer where richer[i] = [ai, bi] indicates that ai has more money than bi and an integer array quiet where quiet[i] is the quietness of the ith person. All the given data in richer are logically correct (i.e., the data will not lead you to a situation where x is richer than y and y is richer than x at the same time).

Return an integer array answer where answer[x] = y if y is the least quiet person (that is, the person y with the smallest value of quiet[y]) among all people who definitely have equal to or more money than the person x.

7
1 0
2 1
3 1
3 7
4 3
5 3
6 3
8
3 2 5 4 6 1 7 0
[5, 5, 2, 5, 4, 5, 6, 7]
 

Example 1:

Input: richer = [[1,0],[2,1],[3,1],[3,7],[4,3],[5,3],[6,3]], quiet = [3,2,5,4,6,1,7,0]
Output: [5,5,2,5,4,5,6,7]
Explanation: 
answer[0] = 5.
Person 5 has more money than 3, which has more money than 1, which has more money than 0.
The only person who is quieter (has lower quiet[x]) is person 7, but it is not clear if they have more money than person 0.
answer[7] = 7.
Among all people that definitely have equal to or more money than person 7 (which could be persons 3, 4, 5, 6, or 7), the person who is the quietest (has lower quiet[x]) is person 7.
The other answers can be filled out with similar reasoning.
Example 2:

Input: richer = [], quiet = [0]
Output: [0]
 

Constraints:

n == quiet.length
1 <= n <= 500
0 <= quiet[i] < n
All the values of quiet are unique.
0 <= richer.length <= n * (n - 1) / 2
0 <= ai, bi < n
ai != bi
All the pairs of richer are unique.
The observations in richer are all logically consistent.*/

import java.util.*;

class LoudAndRich {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        int r[][]=new int[n][2];
        for(int i=0;i<n;i++){
            int a=sc.nextInt(),b=sc.nextInt();
            r[i][0]=a;
            r[i][1]=b;
        }
        int m=sc.nextInt();
        int q[]=new int[m];
        for(int i=0;i<m;i++) q[i]=sc.nextInt();
        System.out.println(Arrays.toString(check(r,q)));
    }
    public static int[] check(int richer[][],int quiet[]){
        int n = quiet.length;
        int[]res = new int[n];
        List<Integer>[] graph = new ArrayList[n];
        for(int i=0;i<n;i++)
            graph[i] = new ArrayList<>();
        Arrays.fill(res,-1);
        int[]indegree = new int[n];
        for(int[]edge : richer){
            graph[edge[0]].add(edge[1]);
            indegree[edge[1]]++;
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<n;i++){
            if(indegree[i]==0) q.add(i);
            res[i] = i;
        }
        while(!q.isEmpty()){
            int u = q.poll();
            for(int v : graph[u]){
                if(quiet[v]>quiet[u]){
                    quiet[v] = quiet[u];
                    res[v]=res[u];
                }
                indegree[v]--;
                if(indegree[v]==0) q.offer(v);
            }
        }
        return res;
    }
}





      


   

   