// A java program for iterative postorder traversal using stack  (LRV)
/*
	
	1.1 Create an empty stack
2.1 Do following while root is not NULL
    a) Push root's right child and then root to stack.
    b) Set root as root's left child.
2.2 Pop an item from stack and set it as root.
    a) If the popped item has a right child and the right child 
       is at top of stack, then remove the right child from stack,
       push the root back and set root as root's right child.
    b) Else print root's data and set root as NULL.
2.3 Repeat steps 2.1 and 2.2 while stack is not empty.
	
*/	

import java.util.ArrayList;
import java.util.Stack;

// A binary tree node
class Node 
{
	int data;
	Node left, right;

	Node(int item) 
	{
		data = item;
		left = right;
	}
}

class BinaryTree 
{
	Node root;
	ArrayList<Integer> list = new ArrayList<Integer>();

	// An iterative function to do postorder traversal 
	// of a given binary tree
	ArrayList<Integer> postOrderIterative(Node node) 
	{
	    ArrayList<Integer> list=new ArrayList<Integer>();
	    Stack<Node> st=new Stack<Node>();
	   Node temp;
	do{
	    if(node!=null)
	    {
	        if(node.right!=null)
	             st.push(node.right);
	       // System.out.print(node.data+" ");
	        st.push(node);
	        node=node.left;
	    }
	    else{
	        temp=st.pop();
	        //System.out.print("popped"+temp.data+" ");
	        if(temp.right!=null)
    	    { 
    	        if(!st.empty()&&temp.right==st.peek()){
    	            node=st.pop();
    	            System.out.print(node.data+" ");
    	            st.push(temp);
    	        }
    	        else 
    	        {
    	            list.add(temp.data);
    	            node=null;
    	        }
    	   }
	        else 
	        {
	            list.add(temp.data);
	            node=null;
	        }
	    }
	 
	}
	while(!st.empty()||node!=null);
	return list;
	    
	}

	// Driver program to test above functions
	public static void main(String args[]) 
	{
	BinaryTree tree = new BinaryTree();

		// Let us create trees shown in above diagram
		tree.root = new Node(1);
		tree.root.left = new Node(2);
		tree.root.right = new Node(3);
		tree.root.left.left = new Node(4);
		tree.root.left.right = new Node(5);
		tree.root.right.left = new Node(6);
		tree.root.right.right = new Node(7);

		ArrayList<Integer> mylist = tree.postOrderIterative(tree.root);
		
		System.out.println("\nPost order traversal of binary tree is :");
		System.out.println(mylist);
	}
}

// This code has been contributed by Mayank Jaiswal
