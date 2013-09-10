public class Sort {
	public static void main(String[] args) {
		int[] A = {1,238,8,5,8,4,66,8,92,8,10};

		System.out.println();
		for(int i: A)
			System.out.print(i + " ");
		System.out.println("\n" + "This is the original array");

		QuickSort quickS = new QuickSort(A);
	}
}

class QuickSort {
	public QuickSort(int[] A) {
		int len = A.length;
		
		quickSort(A, 0, len-1);
		
		for(int i: A)
			System.out.print(i + " ");
		System.out.println("\n" + "This is the result from QuickSort");
	}
	
	public void quickSort(int[] A, int h, int r) {
		if(h >= r)
			return;
		else {
			int p = partition(A, h, r);
			//System.out.println(p);
			quickSort(A, h, p);
			quickSort(A, p+1, r);
		}
	}
	
	public int partition(int[] A, int h, int r) {
		int pivot = A[(h+r)/2];
		int i = h - 1;
		int j = r + 1;
		
		while(true) {
			i++;
			while(i < r && A[i] < pivot) i++;
			j--;
			while(j > h && A[j] > pivot) j--;
		
			if(i < j)
				swap(A, i, j);
			else
				return j; // Must return the smaller value
		}
	}
	
	public static void swap(int[] A, int a, int b) {
		int tmp = A[a];
		A[a] = A[b];
		A[b] = tmp;
	}
}

/*
public class Sort {
	public static void main(String[] args) {
		int[] A = {11,1,45,6,32,42,8,6,8,4,55,93,8};

		quickSort(A, 0, A.length - 1);
		for(int i: A)
			System.out.print(i + ",");
		System.out.println("\b");
	}

	public static void quickSort(int[] A, int h, int r) {
		if(h >= r)
			return;

		int p = partition(A, h, r);
		quickSort(A, h, p);
		quickSort(A, p+1, r);
	}

	public static int partition(int[] A, int h, int r) {
		int pivot = A[(h+r)/2];
		int i = h - 1;
		int j = r + 1;

		while(true) {
			i++;
			while(i < r && A[i] < pivot) i++;
			j--;
			while(j > h && A[j] > pivot) j--;

			if(i < j)
				swap(A, i, j);
			else
				return j;
		}
	}

	public static void swap(int[] A, int a, int b) {
		int tmp = A[a];
		A[a] = A[b];
		A[b] = tmp;
	}
}*/
