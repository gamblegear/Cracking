import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Random;
import java.util.Iterator;

public class PQueue {
	public static void main(String[] args) {
		Heap mHeap = new Heap();
		mHeap.MinHeapOper();
	}
}

class Heap {
	public void MinHeapOper() {
		Queue<DataWrapper> minHeap = new PriorityQueue<DataWrapper>(3, S_TimeComp);
		
		addDataToQ(minHeap);	
		System.out.println("## peek: " + minHeap.peek().startTime);
		
		for(DataWrapper dw: minHeap) {
			System.out.println("&& traverse startTime and content: " + dw.content + ", " + dw.startTime);
		}
	
		// get the number of elements in the heap
		System.out.println("@@ Number of elements in the heap: " + minHeap.size());
		
		//see if can iterate the heap
		Iterator<DataWrapper> iter = minHeap.iterator();
		while(iter.hasNext())
			System.out.println("~~ content in the heap: " + iter.next().content);
	
		deleteDataFromQ(minHeap);	
	}
	
	Comparator<DataWrapper> S_TimeComp = new Comparator<DataWrapper>() {
		public int compare(DataWrapper d1, DataWrapper d2) {
			// This is MinHeap
			return (int) (d1.startTime - d2.startTime);
			
			// This is MaxHeap
			//return (int) (d2.startTime - d1.startTime);
		}
	};
	
	// Randomly generate data to the wrapper
	private static void addDataToQ(Queue<DataWrapper> minHeap) {
		Random rand = new Random();		
		for(int i = 0; i < 5; i++) {	
			int sTime = rand.nextInt(24);
			int eTime = rand.nextInt(24);
			int area = rand.nextInt(6);
			double content = rand.nextDouble();
				
			//DataWrapper wrapper = new DataWrapper(sTime, eTime, area, content);
			minHeap.offer(new DataWrapper(sTime, eTime, area, content));
		}
	}
	
	private static void deleteDataFromQ(Queue<DataWrapper> minHeap) {
		@SuppressWarnings("unused")
		Random rand = new Random();
		while(true) {
			// poll returns null if heap is empty while remove throws exception
			DataWrapper wrapper = minHeap.poll();
			if(wrapper == null)
				break;
			System.out.println("** Start time: " + wrapper.startTime
					+ " End time: " + wrapper.endTime);
		}
	}
}

class DataWrapper {
	int startTime;
	int endTime;
	int area;
	double content;
	
	public DataWrapper(int a, int b, int c, double d) {
		this.startTime = a;
		this.endTime = b;
		this.area = c;
		this.content = d;
	}
	
	public int getStart() {
		return startTime;
	}
	
	public int getEnd() {
		return endTime;
	}
}
