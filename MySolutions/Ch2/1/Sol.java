public class Sol {
	public static void main(String[] args) {
		//to be implemented
		RemoveDup remDup = new RemoveDup("FOLLOWUP");
		remDup.remove();
	}
}

class RemoveDup {
	private String str;

	public RemoveDup(String s) {
		this.str = s;
	}

	public void remove() {
		System.out.println(str);

		char[] charArr = str.toCharArray();
		// long is 32 bit; long long is 64 bit
		long checker = 0;
		int cnt = 0;
		int flag;
		String outStr = new String();

		for(char c: charArr) {
			flag = (int) (c - 'A');
			if((checker & (1 << flag)) == 0) {
				checker |= (1 << flag);
				charArr[cnt++] = c;
			}
		}
		charArr[cnt] = '\0';

		for(int i = 0; charArr[i] != '\0'; i++) {
			outStr += charArr[i];
		}

		System.out.println(outStr);
	}
}
