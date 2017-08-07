import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.TreeMap;

//Calculate horizontal distance
 
class PerpendicularOrder {

	Node root;

	void verticaleOrder(Node root) {

		if (root == null) {
			return;
		}

		Queue<Node> queue = new LinkedList<Node>(); //List of all nodes
		Queue<Integer> distanceQueue = new LinkedList<Integer>(); // Distance of each node from root

		TreeMap<Integer, LinkedList<Node>> distanceMap = new TreeMap<>();  // map node to distance

		distanceQueue.add(0); // dist: 0 ... root node
		queue.add(root);  // add root node 

		while (!queue.isEmpty()) {

			Node tempNode = queue.poll();   // returns front of queue
			int distance = distanceQueue.poll();  // returns front of queue

			if (distanceMap.get(distance) == null) {
				distanceMap.put(distance, new LinkedList<Node>()); // dist = key 
			}

			distanceMap.get(distance).add(tempNode);

			if (tempNode.left != null) {
				distanceQueue.add(distance - 1);
				queue.add(tempNode.left);
			}

			if (tempNode.right != null) {
				distanceQueue.add(distance + 1);
				queue.add(tempNode.right);
			}
		}
		printVerticaleOrder(distanceMap);
	}

	void printVerticaleOrder(TreeMap<Integer, LinkedList<Node>> distanceMap) {
		for (int key : distanceMap.keySet()) {
			for (Node node : distanceMap.get(key))
				System.out.print(node.data+" ");
			System.out.println("");
		}
		
	}

	// Driver program to test the above functions
	public static void main(String args[]) {
		PerpendicularOrder tree = new PerpendicularOrder();

		tree.root = new Node(1);
		tree.root.left = new Node(2);
		tree.root.right = new Node(3);
		tree.root.left.left = new Node(4);
		tree.root.left.right = new Node(5);
		tree.root.right.left = new Node(6);
		tree.root.right.right = new Node(7);
	

		System.out.println("vertical order traversal is :");
		tree.verticaleOrder(tree.root);
	}
}

class Node {
	int data;
	Node left, right;

	Node(int item) {
		data = item;
		left = right = null;
	}
}
