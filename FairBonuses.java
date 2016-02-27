import java.util.*;

class FairBonuses {
	
	public static List<Integer> calculateBonus(int[] codes){
		List<Integer> tickets = new ArrayList<>(Collections.nCopies(codes.length, 1));
		for(int i=1; i<codes.length; i++)
			if(codes[i] > codes[i-1])
				tickets.set(i, tickets.get(i-1) + 1);
		for(int i=codes.length-2; i>=0; i--)
			if(codes[i] > codes[i+1] && tickets.get(i) <= tickets.get(i+1))
				tickets.set(i, tickets.get(i+1) + 1);
		return tickets;
	}
	
	public static void main(String[] args) {
		int[] codes = {300, 400, 500, 200, 600, 900, 700, 100, 600, 800, 400};
		List<Integer> tickets = calculateBonus(codes);
		for(Integer ticket : tickets)
			System.out.println(ticket);
	}
}