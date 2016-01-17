import java.util.*;
import java.io.*;
class CompoundWord {
	
	public HashMap<String, Integer> h;
	
	public CompoundWord(){
		h = new HashMap<>();
	}
	
	public boolean isCompoundWord(String word){
		if(h.containsKey(word))
			return true;
		int length = h.get(word);
		for(int i = 1; i < length; i++) {
			String prefix = word.substring(0, i);
			if(isCompoundWord(prefix)){
				String remainder = word.substring(i, length);
				if(remainder.length() == 0)
					return true;
				return isCompoundWord(remainder);
			}
		}
		return false;
	}
	
	public void init(String file){
		try{
			FileReader fileReader = new FileReader(file);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			
			String line = null;
			while((line = bufferedReader.readLine()) != null) {
				h.put(line, line.length());
//				t.addWord(line);
			}
			bufferedReader.close();
		} catch(FileNotFoundException ex) {
			System.out.println("Unable to open file");                
		} catch(IOException ex) {
			System.out.println("Error reading file");
		}
	}
	
	public String solve(){
		Set set = h.entrySet();
		Iterator i = set.iterator();
		int count = 0;
		String maxWord = "";
		while(i.hasNext()) {
			Map.Entry me = (Map.Entry)i.next();
			if(isCompoundWord((String) me.getKey())){
				if((int) me.getValue() > count){
					count = (int) me.getValue();
					maxWord = (String) me.getKey();
				}
			}
		}
		return maxWord;
	}
	
	public static void main(String[] args) {

		CompoundWord c = new CompoundWord();
		c.init("word.list.txt");
		System.out.print(c.solve());
		
	}
}