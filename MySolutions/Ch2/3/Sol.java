public void main(String[] args) {
	// to be implemented
}

class DelNode {
	public boolean delete(LinkedListNode node) {
		if(node == null || node.next == null)
			return false;

		node.data = node.next.data;
		node.next = node.next.next;

		return true;
	}
}
