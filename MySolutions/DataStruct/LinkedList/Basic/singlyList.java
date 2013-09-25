public class singlyList {
	public static void main(String[] args) {
		// to be implemented
	}
}

class Node {
	int data;
	Node next;

	public Node(int n) {
		this.data = n;
		this.next = null;
	}
}

class Manipulation {

	Node head;

	public void addFront(int d) {
		Node node = new Node(d);

		node.next = this.head.next;
		this.head.next = node;
	}

	public void addRear(int d) {
		Node node = new Node(d);
		Node floater;

		floater = this.head;
		while(floater.next != null)
			floater = floater.next;
		floater.next = node;
	}

	public int getFront() {
		return this.head.next.data;
	}

	public Node removeNode(int d) {
		Node tempNode;
		Node checker;

		checker = this.head;
		while(checker.next != null) {
			if(checker.next.data == d) {
				tempNode = checker.next;
				checker.next = checker.next.next;
				return tempNode;
			}
			checker = checker.next;
		}
		return null;
	}
}
