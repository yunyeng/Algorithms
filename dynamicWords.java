import java.net.*;
import java.io.*;



class dynamicWords {
	public static void main(String[] args) throws Exception{

//		List<String> records = new ArrayList<String>();
		BufferedReader reader = new BufferedReader(new FileReader("word.list.txt"));
		String line;
		while ((line = reader.readLine()) != null)
			System.out.println(line);
//			records.add(line);
		reader.close();
//		return records;
		  
		 
	}
}