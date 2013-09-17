import java.util.ArrayList;

public class sol {
	public static void main(String args[]) {
		Compress comp1 = new Compress("aaabbcddddeeee");
		Compress comp2 = new Compress("abcdefg");
		Compress comp3 = new Compress("");
		Compress comp4 = new Compress("a");
	}
}

class Compress {
	public Compress(String str) {
		char[] ss = str.toCharArray();

		compress(ss);
	}

	public void compress(char[] str) {
		int length = str.length;

		if(length <= 1) {
			System.out.println("String remains the same: ");
			for(char c: str)
				System.out.print(c);
			System.out.println();
			return;
		}

		int[] strComp = new int[length];
		String newStr = new String();
		char checker = '\0';
		int cnt = -1;

		for(char c: str) {
			if(checker == c) {
				strComp[cnt]++;
			} else {
				cnt += 1;
				strComp[cnt] = 1;
				checker = c;
			}
		}

		checker = '\0';
		cnt = 0;

		for(char c: str) {
			if(checker != c) {
				newStr += (c + "" + strComp[cnt++]);
				checker = c;
			}
		}

		System.out.println("Compresses string is: ");
		System.out.println(newStr);
	}
}
