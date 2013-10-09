import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Random;

public class ListSort {
	public static void main(String[] args) {
		LinkedList<ListSortNode> targetList = new LinkedList<ListSortNode>();
		ListOperation operation = new ListOperation();
		operation.initList(targetList);
		
		Collections.sort(targetList,ListSortNode.Comparators.content);
		
		Iterator<ListSortNode> iter = targetList.iterator();
		while(iter.hasNext()) {
			System.out.println(iter.next().left);
		}
	}
}

class ListOperation {
	public void initList(LinkedList<ListSortNode> list) {
		for(int i = 0; i < 10; i++) {
			Random rand = new Random();
			int a = rand.nextInt(24);
			int b = rand.nextInt(24);
			int c = rand.nextInt(100);
			
			ListSortNode node = new ListSortNode(a, b, c);
			list.add(node);
		}
	}
}
