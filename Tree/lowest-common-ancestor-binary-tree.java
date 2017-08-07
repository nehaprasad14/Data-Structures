/*
	Method 1 (By Storing root to n1 and root to n2 paths):
Following is simple O(n) algorithm to find LCA of n1 and n2.
1) Find path from root to n1 and store it in a array.
2) Find path from root to n2 and store it in another array.
3) Traverse both paths till the values in arrays are same. Return the common element just before the mismatch.
*/

import java.util.ArrayList;
import java.util.List;

class Node {
	int data;
	Node left, right;

Node(int value) {
		data = value;
		left = right = null;
	}
}

public class BT_NoParentPtr_Solution1 
{

	Node root;
	private List<Integer> path1 = new ArrayList<>();
	private List<Integer> path2 = new ArrayList<>();

	int findLCA(int n1, int n2) {
		path1.clear();
		path2.clear();
		return findLCAInternal(root, n1, n2);
	}

	private int findLCAInternal(Node root, int n1, int n2) {
           //Check if path is present or not
		if (!findPath(root, n1, path1) || !findPath(root, n2, path2)) {          
			System.out.println((path1.size() > 0) ? "n1 is present" : "n1 is missing");
			System.out.println((path2.size() > 0) ? "n2 is present" : "n2 is missing");
			return -1;
		}

		int i;
		for (i = 0; i < path1.size() && i < path2.size(); i++) {
		// System.out.println(path1.get(i) + " " + path2.get(i));
			if (!path1.get(i).equals(path2.get(i)))
				break;
		}

		return path1.get(i-1);
	}

	private boolean findPath(Node root, int n, List<Integer> path)   // find path from root and store it in path array.
	{
		if (root == null) {
			return false;
		}

		path.add(root.data);

		if (root.data == n) {
			return true;
		}

		if (root.left != null && findPath(root.left, n, path)) {
			return true;
		}

		if (root.right != null && findPath(root.right, n, path)) {
			return true;
		}

       
       // System.out.println("... "+path);
		path.remove(path.size()-1);       //leaf node remove
		//System.out.println(">>> "+path);

		return false;
	}

	public static void main(String[] args)
	{
		BT_NoParentPtr_Solution1 tree = new BT_NoParentPtr_Solution1();
		tree.root = new Node(1);
		tree.root.left = new Node(2);
		tree.root.right = new Node(3);
		tree.root.left.left = new Node(4);
		tree.root.left.right = new Node(5);
		tree.root.right.left = new Node(6);
		tree.root.right.right = new Node(7);

		System.out.println("LCA(4, 5) " + tree.findLCA(4,5));

	}
}
// This code is contributed by Sreenivasulu Rayanki.
