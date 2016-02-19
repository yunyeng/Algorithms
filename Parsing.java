import java.util.*;
class Parsing {
	
	public static class ParseResult{
		int invalid;
		String parsed;
		public ParseResult(int v, String p){
			invalid = v;
			parsed  = p;
		}
	}
	
	public static String bestSplit(HashSet<String> dict, String sentence){
		ParseResult[] memo = new ParseResult[sentence.length()];
		ParseResult r = split(dict, sentence, 0, memo);
		return r == null ? null : r.parsed;
	}
	public static ParseResult split(HashSet<String> dict, String sentence, int start, ParseResult[] memo){
		if(start >= sentence.length())
			return new ParseResult(0, "");
		if(memo[start] != null)
			return memo[start];
		int bestInvalid = Integer.MAX_VALUE;
		String bestParsing = null;
		String partial = "";
		int index = start;
		while(index < sentence.length()){
			partial += sentence.charAt(index);
			int invalid = dict.contains(partial) ? 0 : partial.length();
			if(invalid < bestInvalid){
				ParseResult result = split(dict, sentence, index+1, memo);
				if(invalid + result.invalid < bestInvalid){
					bestInvalid = invalid + result.invalid;
					bestParsing = partial + " " + result.parsed;
					if(bestInvalid == 0)
						break;
				}
			}
			index++;
		}
		memo[start] = new ParseResult(bestInvalid, bestParsing);
		return memo[start];
	}
	
	public static String addSpace(String s, HashSet<String> dict){
			Stack<String> res = new Stack<>();
			addSpace(s, res, dict);
			String result = "";
			while(!res.isEmpty()){
				result += res.pop() + " ";
			}
			return result;
		}
		public static boolean addSpace(String s, Stack<String> res, HashSet<String> dict){
			if(s.length() == 0)
				return true;
			for(int i=0; i<=s.length(); i++){
				String prefix  = s.substring(0, i);
				String postfix = s.substring(i, s.length());
				if(dict.contains(prefix) && addSpace(postfix, res, dict)){
					res.push(prefix);
					return true;
				}
			}
			return false;
		}
		
	public static int longestUniqueSubstring(String s){
		int count = 1;
		int last = 1;
		int max = 1;
		char a = s.charAt(0);
		char b = '\0';
		for(int i=1; i<s.length(); i++){
			if(s.charAt(i) == a){
				count++;
			} else if(s.charAt(i) == b) {
				b = a;
				a = s.charAt(i);
				count++;
				last = 1;
			} else {
				b = a;
				a = s.charAt(i);
				count = last + 1;
				last = 1;
			}
			max = Math.max(max, count);
		}
		return max;
	}
	
	public static void main(String[] args) {
		HashSet<String> dict = new HashSet<>();
		dict.add("looked");
		dict.add("like");
		dict.add("just");
		dict.add("her");
		dict.add("brother");
		
//		System.out.println(bestSplit(dict, "jesslookedjustliketimherbrother"));
//		System.out.println(addSpace("jesslookedjustliketimherbrother", dict));
		
		System.out.println(longestUniqueSubstring("aaacaabaaanasdaaaadad"));
	}
}