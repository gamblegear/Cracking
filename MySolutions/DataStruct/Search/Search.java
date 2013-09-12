import java.util.ArrayList;

public class Search {
	public static void main(String[] args) {
	int[] A = {1,5,5,9,22,91};

	System.out.println("\n" + "The origianl sorted array is:");
	for(int i: A)
		System.out.print(i + " ");
	System.out.println("\n" + "#######################");


	BinarySearch binaryS1 = new BinarySearch(A, 9);
	BinarySearch binaryS2 = new BinarySearch(A, 5);
	BinarySearch binaryS3 = new BinarySearch(A, 10);
	}
}

class BinarySearch {
	public BinarySearch(int[] A, int t) {
		int len = A.length;
		int pos;

		pos = binarySearch(A, t, 0, len);
		System.out.println("Target: " + t + " Position: " + pos);

		if(pos >= 0) {
			System.out.println("The duplicate positions are:");
			for(int i: checkDup(A, t, pos))
				System.out.print(i + " ");
			System.out.println();
		}

		System.out.println("***********************");
	}

	public int binarySearch(int[] A, int t, int h, int n) {
		if(n <= 1) {
			if(A[h] == t)
				return h;
			else
				return -1;
		}

		if(t < A[h+(n/2)])
			return binarySearch(A, t, h, n/2);
		else
			return binarySearch(A, t, h+(n/2), n-(n/2));
	}

	public ArrayList<Integer> checkDup(int[] A, int t, int pos) {
		ArrayList<Integer> DupList = new ArrayList<Integer>();
		int m1 = pos - 1;
		int m2 = pos + 1;

		DupList.add(pos);
	
		while(m1 >= 0 && A[m1] == t) {
			DupList.add(m1);
			m1--;
		}
		while(m2 < A.length && A[m2] == t) {
			DupList.add(m2);
			m2++;
		}
		
		return DupList;
	}
}
