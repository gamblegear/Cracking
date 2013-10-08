public class Sort {
	public static void main(String[] args) {
		int[] A = {1,238,8,5,8,4,66,8,92,8,10};
		
		String str = "qwertyasdf";
		char[] B = str.toCharArray();

		System.out.println();
		for(int i: A)
			System.out.print(i + " ");
		System.out.println("\n" + "This is the original array");
		
		@SuppressWarnings("unused")
		QuickSort quickS = new QuickSort(A);
		
		@SuppressWarnings("unused")
		MergeSort mergeS = new MergeSort(A);
		
		/** 
		 * Below is the overload of construction method and way to 
		 * sort the String
		 *  **/
		
		System.out.println();
		for(char i: B)
			System.out.print(i + " ");
		System.out.println("\n" + "This is the original Char array");
		
		@SuppressWarnings("unused")
		QuickSort quickCharS = new QuickSort(B);
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
	
	public QuickSort(char[] A) {
		int len = A.length;
		
		quickSort(A, 0, len-1);
		
		for(char i: A)
			System.out.print(i + " ");
		System.out.println("\n" + "This is the result from QuickSort");
	}
	
	public void quickSort(int[] A, int h, int r) {
		if(h >= r)
			return;
		else {
			// 1st way
			//int p = partition_1(A, h, r);
			// 2nd way
			int p = partition_2(A, h, r);
			//System.out.println(p);
			quickSort(A, h, p);
			quickSort(A, p+1, r);
		}
	}

	// This is the first way to partition
	public int partition_1(int[] A, int h, int r) {
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
	
	public static void swap(char[] A, int a, int b) {
		char tmp = A[a];
		A[a] = A[b];
		A[b] = tmp;
	}
	
	// This is the second way to partition
	public int partition_2(int[] A, int h, int r) {
		int pivot = A[r];
		int index = h - 1;

		for(int i = h; i <= r-1; i++) {
			if(A[i] <= pivot)
				swap(A, ++index, i);
		}
		swap(A, ++index, r);

		return index;
	}

	public void quickSort(char[] A, int h, int r) {
		if(h >= r)
			return;
		else {
			int p = partition_1(A, h, r);
			//System.out.println(p);
			quickSort(A, h, p);
			quickSort(A, p+1, r);
		}
	}

	// This is the first way to partition
	public int partition_1(char[] A, int h, int r) {
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
		mergeSort(A, h + n1, n2);
		
		merge(A, h, n1, n2);
	}
	
	public void merge(int[] A, int h, int n1, int n2) {
		int[] B = new int[n1 + n2];
		int cnt1 = 0;
		int cnt2 = 0;
		
		while((cnt1 < n1) && (cnt2 < n2)) {
			if(A[h + cnt1] < A[h + n1 + cnt2]) {
				B[cnt1 + cnt2] = A[h + cnt1];
				cnt1++;
			} else {
				B[cnt1 + cnt2] = A[h +n1 + cnt2];
				cnt2++;
			}
		}
		
		while(cnt1 < n1) {
			B[cnt1 + cnt2] = A[h + cnt1];
			cnt1++;
		}
		
		while(cnt2 < n2) {
			B[cnt1 + cnt2] = A[h + cnt1 + cnt2];
			cnt2++;
		}
		
		for (int i = 0; i < (n1 + n2); i++) {
			A[h + i] = B[i];
		}
	}
}
