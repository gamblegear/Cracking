import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

public class MapTrial {
	public static void main(String[] args) throws IOException {
		// Test file operation
		FileOperation file = new FileOperation();
		file.read(args[0]);
		file.write(args[1]);
		
		// Map operation
		MapOperation mapOp = new MapOperation(args[0]);
		mapOp.mapInit();
	}
}

class MapOperation {
	HashMap<Integer, String>  map = new HashMap<Integer, String>();
	String addr = new String();
	String content = new String();
	StringBuffer sb = new StringBuffer();
	String[] charArray = new String[2];
	
	public MapOperation(String str) {
		this.addr = str;
		System.out.println("successfully init");
	}
	
	public void mapInit() throws IOException {
		FileReader reader = new FileReader(addr);
		BufferedReader br = new BufferedReader(reader);
		
		content = br.readLine();
		while(content != null) {
			charArray = content.split(", ");
			map.put(Integer.parseInt(charArray[0]), charArray[1]);
			content = br.readLine();
		}
		
		Set<Entry<Integer, String>> set = map.entrySet();
		Iterator<Entry<Integer, String>> iter = set.iterator();
		while(iter.hasNext()) {
			Entry<Integer, String> ent = iter.next();
			System.out.println("!!: " + ent.getKey());
			System.out.println("**: " + ent.getValue());
			System.out.println("##: " + ent);
		}
	}
}

class FileOperation {
	static StringBuffer sb = new StringBuffer();
	
	public void read(String addr) {
		try {
			FileReader reader = new FileReader(addr);
			BufferedReader br = new BufferedReader(reader);
			
			String str = null;
			
			while((str = br.readLine()) != null)
				sb.append(str + "\n");
			
			br.close();
			reader.close();
				
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void write(String addr) throws IOException {
		FileWriter writer = new FileWriter(addr);
		BufferedWriter bw = new BufferedWriter(writer);
		bw.write(sb.toString());
		
		bw.close();
		writer.close();
	}
}
