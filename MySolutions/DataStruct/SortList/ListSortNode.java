import java.util.Comparator;

public class ListSortNode implements Comparable<ListSortNode> {
	int right;
	int left;
	int weight;
	//ListNode next;
	
	public ListSortNode() {
		//this.next = null;
	};

	public ListSortNode(int a, int b, int c) {
		this.right = a;
		this.left = b;
		this.weight = c;
		//this.next = null;
	}
	
	public int getRight() {return right;}
	public int getLeft() {return left;}
	public int weight() {return weight;}

	public int compareTo(ListSortNode node1) {
		return 0;
	}

	public static class Comparators {
		public static Comparator<ListSortNode> content = new Comparator<ListSortNode>() {
			public int compare(ListSortNode n1, ListSortNode n2) {
				return (int) (n1.left - n2.left);
			}
		};
	}
}
