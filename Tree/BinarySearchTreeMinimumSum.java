// Java program to find minimum sum leaf to root path in Binary Tree

// A Binary Tree node
class Node
{
	int data;
	Node left, right;

	Node(int item)
	{
		data = item;
		left = right = null;
	}
}


class BinaryTree
{
	Node root;
	int min = 99999;   // max = 0
	Node target_leaf = null;

	// A utility function that prints all nodes on the
	// path from root to target_leaf
	boolean printPath(Node node, Node target_leaf)
	{
		// base case
		if (node == null)
			return false;

		// return true if this node is the target_leaf or
		// target leaf is present in one of its descendants
		if (node == target_leaf || printPath(node.left, target_leaf)
				|| printPath(node.right, target_leaf))
		{
			System.out.print(node.data + " ");
			return true;
		}

		return false;
	}

	// This function Sets the target_leaf_ref to refer
	// the leaf node of the minimum path sum. Also,
	// returns the min_sum using min_sum_ref
	void getTargetLeaf(Node node, int min1,
					int curr_sum)
	{
		if (node == null)
			return;

	    
		curr_sum = curr_sum + node.data;

		// If this is a leaf node and path to this node
		// has minimum sum so far, the n make this node
		// target_leaf
		if (node.left == null && node.right == null)
		{
			if (curr_sum < min1)    // max = 0  ...  if (curr_sum > min1)  
			{
				this.min = curr_sum;
				target_leaf = node;
			}
		}

		// If this is not a leaf node, then recur down
		// to find the target_leaf
		
		getTargetLeaf(node.left, min , curr_sum);
	
		getTargetLeaf(node.right, min , curr_sum);
	}

	// Returns the minimum sum and prints the nodes on
	// min sum path
	int minSumPath()
	{
		// base case
		if (root == null)
			return 0;

		// find the target leaf and minimum sum
		getTargetLeaf(root, min, 0);

		// print the path from root to the target leaf
		printPath(root, target_leaf);
		return min; // return minimum sum
	}

	// driver function to test the above functions
	public static void main(String args[])
	{
		BinaryTree tree = new BinaryTree();
		tree.root = new Node(10);
		tree.root.left = new Node(-2);
		tree.root.right = new Node(7);
		tree.root.left.left = new Node(8);
		tree.root.left.right = new Node(-4);
		System.out.println("Following are the nodes "+
						"on minimum sum path");
		int sum = tree.minSumPath();
		System.out.println("");
		System.out.println("Sum of nodes is : " + sum);
	}
}
// This code has been contributed by Mayank Jaiswal
