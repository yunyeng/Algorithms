import java.util.regex.*;
class Regex {
	
	
	public static void regexChecker(String regex, String str){
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(str);
		
		while(matcher.find()){
			if(matcher.group().length() > 0){
				System.out.println(matcher.group().trim());
			}
		}
		
	}
	
	public static void main(String[] args) {
		
		String lngStr = "Ananin amina koyayim ,32 fenerbahce, la la la lay lay lay";
		regexChecker("[A-Za-z]{2,20}", lngStr);
//		regexChecker("\\s[A-Za-z]{2,20}\\s", lngStr);
		
	}
}