public class sol {
	public static void main(String[] args) {
		String str = "this is a new  string    ";
		int length = 21;

		Replace replace = new Replace(str, length);
	}
}

class Replace {
	public Replace(String str, int len) {
		int lenSpace = 0;
		int newLength;
		int cnt = 0;
		char[] charStr = str.toCharArray();
		char[] newCharStr;
		String newString;

		for(int i = 0; i < len; i++) {
			if(charStr[i] == ' ')
				lenSpace++;
		}

		newLength = len + lenSpace*2;
		newCharStr = new char[newLength];

		for(int i = 0; i < len; i++) {
			if(charStr[i] != ' ') {
				newCharStr[cnt+i] = charStr[i];
			} else {
				newCharStr[cnt+i] = '%';
				newCharStr[cnt+i+1] = '2';
				newCharStr[cnt+i+2] = '0';
				cnt = cnt + 2;
			}
		}

		newString = new String(newCharStr);

		System.out.println("The original string: " + str);
		System.out.println("The new string: " + newString);
	}
}
