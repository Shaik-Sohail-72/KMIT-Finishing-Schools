// Build Binary Tree from preorder 
import java.util.*;
class buildBinaryTree{
    static class Node{
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data=data;
            this.left=null;
            this.right=null;
        }
    }
    static int idx=-1;
    public static Node buildTree(int nodes[]){
        idx++;
        if(nodes[idx]==-1){
            return null;
        }
        Node newNode =new Node(nodes[idx]);
        newNode.left=buildTree(nodes);    
        newNode.right=buildTree(nodes);    
        return newNode;
    }
    public static void preOrder(Node root){ // O(n)
        if(root==null){
            return;
        }
        System.out.print(root.data+" ");
        preOrder(root.left);
        preOrder(root.right);
    }
    public static void inOrder(Node root){ // O(n)
        if(root==null){
            return;
        }
        inOrder(root.left);
        System.out.print(root.data+" ");
        inOrder(root.right);
    }
    public static void postOrder(Node root){ // O(n)
        if(root==null){
            return;
        }
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.data+" ");
    }
    public static void levelOrder(Node root){ // O(n)
        if(root==null){
            return;
        }
        Queue<Node> q=new LinkedList<>();
        q.add(root);
        q.add(null);
        while(!q.isEmpty()){
            Node curr=q.remove();
            if(curr==null){
                System.out.println();
                if(q.isEmpty()){
                    break;
                }else{
                    q.add(null);
                }
            }else{
                System.out.print(curr.data+" ");
                if(curr.left!=null){
                    q.add(curr.left);
                }
                if(curr.right!=null){
                    q.add(curr.right);
                }
            }
        }
    }
    public static int countOfNodes(Node root){ // O(n)
        if(root==null){
            return 0;
        }
        int leftNodes=countOfNodes(root.left);
        int rightNodes=countOfNodes(root.right);

        return leftNodes+rightNodes+1;
    }
    public static int sumOfNodes(Node root){ // O(n)
        if(root==null){
            return 0;
        }
        int leftSum=sumOfNodes(root.left);
        int rightSum=sumOfNodes(root.right);

        return leftSum+rightSum+root.data;
    }
    public static int height(Node root){
        if(root==null){
            return 0;
        }
        int leftHeight=height(root.left);
        int rightHeight=height(root.right);
        int myHeight=Math.max(leftHeight,rightHeight)+1;
        return myHeight;
    }
    public static int diameter(Node root){  //  O(n^2)
        if(root==null){
            return 0;
        }
        int diam1=diameter(root.left);
        int diam2=diameter(root.right);
        int diam3=height(root.left)+height(root.right)+1;
        return Math.max(diam3,Math.max(diam1,diam2));
    }
    static class TreeInfo{
        int ht;
        int diam;
        TreeInfo(int ht,int diam){
            this.ht=ht;
            this.diam=diam;
        }
    }
    public static TreeInfo diameter2(Node root){
        if(root==null){
            return new TreeInfo(0, 0);
        }

        TreeInfo left=diameter2(root.left);
        TreeInfo right=diameter2(root.right);

        int myHeight=Math.max(left.ht,right.ht)+1;

        int diam1=left.diam;
        int diam2=right.diam;
        int diam3=left.ht+right.ht+1;
        
        int mydiam=Math.max(Math.max(diam1,diam2),diam3);

        TreeInfo myInfo=new TreeInfo(myHeight,mydiam);
        return myInfo;
    }
    /*public boolean isIdentical(TreeNode root,TreeNode subroot){
        if(root==null && subroot==null){
            return true;
        }
        if(root==null || subroot==null){
            return false;
        }
        if(root.val==subroot.val){
            return isIdentical(root.left,subroot.left) && isIdentical   (root.right,subroot.right);
        }
        return false;
    }
    public static boolean isSubTree(TreeNode root,TreeNode subroot){
        if(subroot==null){
            return true;
        }
        if(root==null){
            return false;
        }
        if(root.val==subroot.val){
            if(isIdentical(root,subroot)){
                return true;
            }
        }
        isSubTree(root,left, subroot) || isSubTree(root.right, subroot); 
    }*/
    public static void main(String[] args) {
        int nodes[]={1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};
        Node root=buildTree(nodes);
        // System.out.println(root.data);
        // preOrder(root);
        // inOrder(root);
        // postOrder(root);
        // levelOrder(root);
        // System.out.println(countOfNodes(root));
        //  System.out.println(sumOfNodes(root)); 
        // System.out.println(height(root));
        // System.out.println(diameter(root));
        // System.out.println(diameter2(root).diam);
    }
}