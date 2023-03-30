/*
There are n football players standing in the ground, coach wants to know the 
P-th largest height of the players. Given an array of heights[] and the value of P. 
Help the coach to find the P'th largest height.

Note: You are suppose to print the P'th largest height in the sorted order of heights[].
      Not the P'th distinct height.

Input Format:
-------------
Line-1: Size of array n and P value(space separeted)
Line-2: Array elements of size n.

Output Format:
--------------
Print P'th largest height.



Sample input-1:
---------------
8 2
1 2 1 3 4 5 5 5

Sample output-1:
----------------
5


Sample input-2:
---------------
6 3
2 4 3 1 2 5

Sample output-2:
----------------
3


*/
import java.util.*;
class TreapNode
{
    int data;
    int priority;
    TreapNode left;
    TreapNode right;
    TreapNode(int data)
    {
        this.data = data;
        this.priority = new Random().nextInt(1000);
        this.left = this.right = null;
    }
}
class KthLargest{
    static int k;
    public static TreapNode rotateLeft(TreapNode root)
    {
        TreapNode R = root.right;
        TreapNode X = root.right.left;
        R.left = root;
        root.right = X;
        return R;
    }
    public static TreapNode rotateRight(TreapNode root)
    {
        TreapNode L = root.left;
        TreapNode Y = root.left.right;
        L.right = root;
        root.left = Y;
        return L;
    }
    public static TreapNode insertNode(TreapNode root, int data){
            if (root == null) {
            root = new TreapNode(data);
            return root;
        }
        else if (data < root.data)
            root.left = insertNode(root.left, data);
        else if (data > root.data)
            root.right = insertNode(root.right, data);
        return root;
    }
    static void inorder(TreapNode root,int p)
    {
        System.out.println(root.data);
        List<Integer> ls= inorderTraversal(root);
        System.out.print(ls);
        Collections.sort(ls);
        int ans=0;
        System.out.print(ls);
        for(int i=ls.size()-1;i>=0;i--){
            if(p==0){
                System.out.print(ls.get(i));
            }
            p--;
        }
        System.out.print(ans);
    }
    static List<Integer> inorderTraversal(TreapNode root){
        List<Integer> li=new ArrayList<>();
        if(root==null)
        {
            return li;
        }
        else
        {
            li.addAll(inorderTraversal(root.left));
            li.add(root.data);
            li.addAll(inorderTraversal(root.right));
        }
        return li;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int p = sc.nextInt();
        k=n-p+1;
        int arr[] = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
        }
        TreapNode root = null;
        for(int a:arr){
            root = insertNode(root,a);
        }
        Arrays.sort(arr);
        for(int i=arr.length-1;i>=0;i--){
            if(p==1){
                System.out.print(arr[i]);
                break;
            }
            p--;
        }
        //inorder(root,p);
        //System.out.println(inorderTraversal(root));
    }
}



    