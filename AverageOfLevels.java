/*
For X-Mas, santa claus is preparing a X-Mas Tree with set of Bulbs.
The bulbs are of different voltages, and preparation of tree as follows:
	- The bulbs are arranged in level-wise, levels are numbered from 0,1,2,3..
	  so on.
	- At level-0: There will be only one bulb as root bulb.,
	- From next level onwards, we can attach atmost two bulbs, one is to left side
	  and/or the other is to right side of every bulb in previous level.
	- The empty attachements in a level are indicated with -1. 
	(for example: look in hint)
		
You will be given the X-Mas Tree root,
Your task is to findout the average of each level of the X-Mas tree, starts from level-0.

Input Format:
-------------
A single line of space separated integers, voltages of the set of bulbs.

Output Format:
--------------
Print a list of double values (averages of each level)

Sample Input-1:
---------------
3 8 4 3 5 -1 7 

Sample Output-1:
----------------
[3.0, 6.0, 5.0]

Sample Input-2:
---------------
3 8 4 3 5 7 7 

Sample Output-2:
----------------
[3.0, 6.0, 5.5]

*/

import java.util.*;

class BinaryTree
{
	public int val; 
	public BinaryTree left, right; 
	public BinaryTree(int val){
		this.val = val; 
		left = null; 
		right = null; 
	}
}

public class AverageOfLevels{
	static BinaryTree root;
    void insert(BinaryTree node, int key){
        if(node==null){
            root=new BinaryTree(key);
            return;
        }
        Queue<BinaryTree> q=new LinkedList<>();
        q.add(node);
        while(!q.isEmpty()){
            node=q.peek();
            q.remove();
            if(node.left==null){
                node.left=new BinaryTree(key);
                break;
            }else
                q.add(node.left);
            if(node.right==null){
                node.right=new BinaryTree(key);
                break;
            }else{
                q.add(node.right);
            }
        }
    }

	public List<Double> averageOfLevels(BinaryTree root) {
		List<Double> result = new ArrayList<>();
		Queue<BinaryTree> q = new LinkedList<>();
		q.add(root);
		while(!q.isEmpty()){
		    int size=q.size();
		    double s=0;
		    for(int i=0;i<size;i++){
		       BinaryTree curr=q.poll();
		       s+=curr.val;
		       if(curr.left!=null && curr.left.val!=-1){
		           q.add(curr.left);
		       }
		       if(curr.right!=null && curr.right.val!=-1){
		           q.add(curr.right);
		       }
		    }
		    result.add(s/size);
		}
		return result;
	}
	private int highest(BinaryTree root){
        //Write you code here
		List<Integer> res=new ArrayList<>();
        Queue<BinaryTree> q=new LinkedList<>();
        q.add(root);
		int c=0;
		int level=0;
		int highest=0;
        while(!q.isEmpty()){
            int size=q.size();
			c++;
            int m=Integer.MIN_VALUE;
            for(int i=0;i<size;i++){
                BinaryTree curr=q.poll();
                if(curr.val>m){
                    m=curr.val;
                }
                if(curr.left!=null && curr.left.val!=-1){
                    q.add(curr.left);
                }
                if(curr.right!=null && curr.right.val!=-1){
                    q.add(curr.right);
                }
            }
            if(m>highest){
				level=c;
				highest=m;
			}
        }
		return level;
    }
	

	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		AverageOfLevels aveLel = new AverageOfLevels();
		
		String str[]=sc.nextLine().split(" ");
		root = new BinaryTree(Integer.parseInt(str[0]));
		for(int i=1; i<str.length; i++)
			aveLel.insert(root,Integer.parseInt(str[i]));

		System.out.println(aveLel.averageOfLevels(root));
		System.out.println(aveLel.highest(root));
	}
}
