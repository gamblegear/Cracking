import java.util.ArrayList;
import java.util.Iterator;

public class sol {
	public static void main(String[] args) {
		// This is to show how to use replaceAll
		String test = new String("aksfj123141dsfa134");
		test = test.replaceAll("[\\D]", "");
		System.out.println("aksfj123141dsfa134" + "\n" +test);
		
		
		// This is to show how to define a 2-dimensional array
		int[][] mat = new int[][] {{1,2,3,4}, {0,6,9,1}, {9,3,0,1}, {3,3,3,3}};
		Matrix matrix = new Matrix(mat, 4, 4);
	}
}

class Matrix {
	Matrix(int[][] mat, int m, int n) {
		ArrayList<String> aList = findZero(mat, m, n);
		replace(mat, m, n, aList);
	}
	
	public ArrayList<String> findZero(int[][] mat, int m, int n) {
		ArrayList<String> strList = new ArrayList<String>();
		
		for(int i = 0; i < m; i++) {
			for(int j = 0; j < n; j++) {
				if(mat[i][j] == 0) {
					// In face no need to add "[" and "]" to the ArrayList
					String pos = new String("[" + i + "," + j + "]");
					System.out.println(pos);
					strList.add(pos);
				}
			}
		}

		return strList;
	}
	
	public void replace(int[][] mat, int m, int n, ArrayList<String> sList) {
		Iterator<String> iter = sList.iterator();
		int x, y;
		
		while(iter.hasNext()) {
			String[] pStr = iter.next().split(",");
			
			x = Integer.parseInt(pStr[0].replaceAll("\\D", ""));
			y = Integer.parseInt(pStr[1].replaceAll("[\\D]", ""));

			for(int i = 0; i < m; i++)
				mat[i][y] = 0;
			for(int j = 0; j < n; j++)
				mat[x][j] = 0;
		}
		
		for(int line = 0; line < m; line++) {
			for(int col = 0; col < n; col++)
				System.out.print(mat[line][col] + " ");
			System.out.println();
		}
	}
}
