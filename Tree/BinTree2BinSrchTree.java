import java.util.*;
/**
 * Given a Binary Tree, convert it to a Binary Search Tree. The conversion must
 * be done in such a way that keeps the original structure of Binary Tree.
 * 
 * @author ppatil
 * 
 * Example 1
 1. Store it in inorder list Array
 2. Sort the list Array
 3. Convert to BST using inOrder traversal
 
Input:
          10
         /  \
        2    7
       / \
      8   4
Output:
          8
         /  \
        4    10
       / \
      2   7

Example 2
Input:
          10
         /  \
        30   15
       /      \
      20       5
Output:
          15
         /  \
       10    20
       /      \
      5        30
      
	  
	  
 */
public class BinTree2BinSrchTree {


 private List<Integer> elements;
 
 public BinTree2BinSrchTree(){
	 this.elements = new ArrayList<Integer>();
 }
 
 public void storeInOrder(Node n){ 
	 if(n== null) 
		 return;
	 storeInOrder(n.left);
	  this.elements.add(n.val);
	 storeInOrder(n.right);
 }
 
 public void printList(){
	 Arrays.toString(this.elements.toArray());
 }


 

 public void binT2BST(Node n){
	 if(n== null) 
		 return;
	 this.storeInOrder(n);
	 Object[] arr = this.elements.toArray(); 
	 Arrays.sort( arr);
	 convertToBSH(n, arr);
	 
	 
 }
 
 void printOrder(Node n){
	 if (n== null ) return;
	 printOrder(n.left);
	 System.out.println(n.val);
	 printOrder(n.right);
 }

private List<Integer> bsh= new ArrayList();

 private static int index = 0;
private void convertToBSH(Node n,Object[] arr ) {
	if(n == null ) return;
	
	//first add left subtree
	convertToBSH(n.left, arr);
	n.val = (Integer) arr[index];
	++index;
	convertToBSH(n.right,arr);
	
}
 


public static void main(String[] args){

	
	BinTree2BinSrchTree binTree2BinSrchTree = new BinTree2BinSrchTree();

/* Constructing tree given in the above figure
10
/  \
30   15
/      \
20       5  
 */
	
Node root = new Node(10);
root.left = new Node(2);
root.right = new Node(7);
root.left.left = new Node(8);
root.left.right = new Node(4);

// convert Binary Tree to BST
binTree2BinSrchTree.binT2BST (root);

System.out.println("Following is Inorder Traversal of the converted BST: \n");
binTree2BinSrchTree.printOrder (root);


}
 
public static class Node {
	public Node left;
	public Node right;
	public int val;
	public Node(int in){
		this.val = in;
	}
 }
}

