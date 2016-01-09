import java.util.ArrayList;
class Untitled {
	
	public static String[] M = {"0", "1", "ABC", "DEF", "GHI", "JKL", "MNO", "PQRS", "TUV", "WXYZ"};
	
	public static ArrayList<String> mnemonic(String num){
		ArrayList<String> result = new ArrayList<String>();
		char[] mnemonics = new char[num.length()];
		mnemonicHelper(num, 0, mnemonics, result);
		return result;
	}
	
	public static void mnemonicHelper(String num, int digit, char[] mnemonics, ArrayList<String> result){
		if(digit == num.length()){
			result.add(new String(mnemonics));
		} else {
			for(int i=0; i<M[num.charAt(digit) - '0'].length(); i++){
				char c = M[num.charAt(digit) - '0'].charAt(i);
				mnemonics[digit] = c;
				mnemonicHelper(num, digit + 1, mnemonics, result);
			}
		}
	}
	
	public static void main(String[] args) {
		ArrayList<String> r = mnemonic("2276696");
		for(int i=0; i<r.size(); i++)
			System.out.println(r.get(i));
		
		
	}
}