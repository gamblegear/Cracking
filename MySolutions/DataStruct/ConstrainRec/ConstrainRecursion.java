import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Random;
import java.util.Set;

public class ConstrainRecursion {
	public static void main(String[] args) {
		Recursion rec = new Recursion();
		rec.initSet();
		showSet(rec.map);
		
		System.out.println("Initiation finished");
		
		//rec.traverse(null, 5);
		
		rec.traverse(new HashSet<Integer>(), 5);
		
		rec.showResult();
	}

	private static void showSet(HashMap<Integer, HashSet> map) {
		Set<Entry<Integer, HashSet>> mapSet = map.entrySet();
		
		for(Entry ent: mapSet) {
			System.out.println("** " + ent.getValue());
		}
	}
}

class Recursion {
	@SuppressWarnings("rawtypes")
	HashMap<Integer, HashSet> map = new HashMap<Integer, HashSet>();
	//private static int counter;
	HashSet<HashSet<Integer>> result = new HashSet<HashSet<Integer>>();
	
	void initSet() {
		Random rand = new Random();
		int counter = 0;
		
		while(counter < 6) {
			HashSet<Integer> set = new HashSet<Integer>();
			
			for(int i = 0; i < 3; i++)
				set.add(rand.nextInt(9));
			
			map.put(counter, set);
			counter++;
		}
	}
	
	void traverse(HashSet<Integer> parentSet, int level) {
		if(level < 0) {
			if(parentSet.size() >= 6)
				result.add(parentSet);
			return;
		}
		
		HashSet<Integer> sourceSet = map.get(level);
		Iterator iter = sourceSet.iterator();

		while(iter.hasNext()) {
			HashSet<Integer> currentSet = new HashSet<Integer>(parentSet);
			currentSet.add((Integer) iter.next());
			traverse(currentSet, level-1);
			//currentSet.addAll(traverse(currentSet, level-1));
		}		
	}
	
	void showResult() {
		Iterator<HashSet<Integer>> iter = result.iterator();
		while(iter.hasNext()) {
			HashSet<Integer> set = iter.next();
			System.out.println(set.toString());
		}
	}
}
