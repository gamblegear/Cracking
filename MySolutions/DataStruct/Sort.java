public class Sort {
	public static void main(String[] args) {
		int[] A = {1,238,8,5,8,4,66,8,92,8,10};

		System.out.println();
		for(int i: A)
			System.out.print(i + " ");
		System.out.println("\n" + "This is the original array");

		QuickSort quickS = new QuickSort(A);
		MergeSort mergeS = new MergeSort(A);
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

class MergeSort {
	public MergeSort(int[] A) {
		int len = A.length;

		mergeSort(A, 0, len);

		for(int i: A)
			System.out.print(i + " ");
		System.out.println("\n" + "This is the result from MergeSort");
	}

	public void mergeSort(int[] A, int h, int n) {
		if(n == 1)
			return;

		int n1 = n / 2;
		int n2 = n - n1;

		mergeSort(A, h, n1);
		mergeSort(A, h+n1, n2);

		merge(A, h, n1, n2);
	}

	public void merge(int[] A, int h, int n1, int n2) {
		int[] B = new int[n1+n2];
		int k1 = 0;
		int k2 = 0;

		while((k1 < n1) && (k2 < n2)) {
			if(A[h+k1] < A[h+n1+k2]) {
				B[k1+k2] = A[h+k1];
				k1++;
			} else {
				B[k1+k2] = A[h+n1+k2];
				k2++;
			}
		}

		while(k1 < n1) {
			B[k1+k2] = A[h+k1];
			k1++;
		}

		while(k2 < n2) {
			B[k1+k2] = A[h+n1+k2];
			k2++;
		}

		for(int i = 0; i < (n1+n2); i++) {
			A[h+i] = B[i];
		}
	}
}
