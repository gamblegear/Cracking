import java.util.LinkedList;

public class TreeBasic {
	public static void main(String[] args) {
		Tree tree = new Tree();

		tree.insert(25);
		tree.insert(45); 
		tree.insert(1); 
		tree.insert(15); 
		tree.insert(54); 
		tree.insert(62); 
		tree.insert(18); 
		tree.insert(20);

		tree.preOrder(tree.getRoot());
		tree.inOrder(tree.getRoot());
		tree.postOrder(tree.getRoot());
		tree.levelOrder(tree.getRoot());
	}
}

class Node {
	Node left;
	Node right;
	int value;

	public Node(int v) {
		this.value = v;
		this.left = null;
		this.right = null;
	}
}

class Tree {
	private Node root;

	public Tree() {
		root = null;
	}

	public Node getRoot() {
		return root;
	}

	public void insert(int data) {
		Node newNode = new Node(data);

		if(root == null) {
			root = newNode;
			return;
		}

		Node current = root;
		Node parent;

		while(true) {
			parent = current;

			if(data < parent.value) {
				current = parent.left;
				if(current == null) {
					parent.left = newNode;
					return;
				}
			} else {
				current = parent.right;
				if(current == null) {
					parent.right = newNode;
					return;
				}
			}
		}
	}

	public void preOrder(Node rt) {
		if(rt != null) {
			System.out.println("preOder: " + rt.value);
			preOrder(rt.left);
			preOrder(rt.right);
		}
	}

	public void inOrder(Node rt) {
		if(rt != null) {
			inOrder(rt.left);
			System.out.println("inOrder: " + rt.value);
			inOrder(rt.right);
		}
	}

	public void postOrder(Node rt) {
		if(rt != null) {
			postOrder(rt.left);
			postOrder(rt.right);
			System.out.println("postOrder: " + rt.value);
		}
	}

	public void levelOrder(Node rt) {
		// cannot use recursive method
		if(rt == null)
			return;

		LinkedList<Node> queue = new LinkedList<Node>();
		Node current;

		queue.add(rt);
		while(!queue.isEmpty()) {
			current = queue.poll();
			System.out.println("levelOrder: " + current.value);
			if(current.left != null)
				queue.add(current.left);
			if(current.right != null)
				queue.add(current.right);
		}
	}
}
