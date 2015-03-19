class TurnToUrl {
	public static String replace(String input, int length){
		char[] charArray = input.toCharArray();
		String output = "";
		for(int i=0; i<charArray.length; i++){
			if(i == length) break;
			if(charArray[i] == ' ') output += "%20";
			else	output += charArray[i];
		}
		return output;
	}
	public static void main(String[] args) {
		System.out.println(replace("Mr John Smith", 13));
	}
}