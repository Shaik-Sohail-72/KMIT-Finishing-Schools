/*You are given an array of people, people, which are the attributes of some people in a queue (not necessarily in order). Each people[i] = [hi, ki] represents the ith person of height hi with exactly ki other people in front who have a height greater than or equal to hi.

Reconstruct and return the queue that is represented by the input array people. The returned queue should be formatted as an array queue, where queue[j] = [hj, kj] is the attributes of the jth person in the queue (queue[0] is the person at the front of the queue).


Input: people = [[7,0],[4,4],[7,1],[5,0],[6,1],[5,2]]
Output: [[5,0],[7,0],[5,2],[6,1],[4,4],[7,1]]
Explanation:
Person 0 has height 5 with no other people taller or the same height in front.
Person 1 has height 7 with no other people taller or the same height in front.
Person 2 has height 5 with two persons taller or the same height in front, which is person 0 and 1.
Person 3 has height 6 with one person taller or the same height in front, which is person 1.
Person 4 has height 4 with four people taller or the same height in front, which are people 0, 1, 2, and 3.
Person 5 has height 7 with one person taller or the same height in front, which is person 1.
Hence [[5,0],[7,0],[5,2],[6,1],[4,4],[7,1]] is the reconstructed queue.
example 2
Input: people = [[6,0],[5,0],[4,0],[3,2],[2,2],[1,4]]
Output: [[4,0],[5,0],[2,2],[3,2],[1,4],[6,0]]
*/
import java.util.*;
class Main{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        String str=sc.next();
        String res="";
        for(int i=0;i<str.length();i++){
            if(Character.isDigit(str.charAt(i))){
                res+=str.charAt(i);
            }
        }
        int arr[][]=new int[res.length()/2][2];
        int m=0;
        int n=0;
        for(int i=0;i<res.length();i++){
            if(i%2==0){
                arr[m++][0]=Character.getNumericValue(res.charAt(i));
            }else{
                arr[n++][1]=Character.getNumericValue(res.charAt(i));
            }
        }
        System.out.println(cal(arr,n));
    }
    public static List<List<Integer>> cal(int arr[][],int n){
        List<List<Integer>> mainls=new ArrayList<>();
        Arrays.sort(arr,(a,b)-> a[0]==b[0] ? a[1]-b[1] : b[0]-a[0]);   
        for(int i=0;i<n;i++){
            List<Integer> ls=new ArrayList<>();
            for(int j=0;j<2;j++){
                ls.add(arr[i][j]);
            }
            mainls.add(ls);
        }
        List<List<Integer>> mainls1=new LinkedList<>();
        for(List<Integer> ls:mainls){
            mainls1.add(ls.get(1),ls);
        }
        return mainls1;
    }
}