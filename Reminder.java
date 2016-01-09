import java.io.PrintWriter;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Date;
class Reminder {
	
	public static String screen = "";
	public static Scanner scanner = new Scanner(System.in);
	
	public static void screen(){
		System.out.println(screen);
	}
	public static void screen(String s){
		System.out.println(s);
	}
	
	public static boolean listen(String sentence){
		sentence = sentence.toLowerCase();
		String[] command = {"take", "note", "write", "put", "add", "insert", "fill"};
		String[] command2 = {"notes", "show", "read", "get", "see", "list", "bring", "all"};
		for(int i=0; i<command.length; i++){
			if(sentence.contains(command[i])){
				screen("Ow do you wanna " + command[i]);
				note();
				return true;
			} else if(sentence.contains(command2[i])){
				screen("Here are the notes currently.");
				list();
				return true;
			}
		}
		screen("I didn't quite get it.");
		return false;
	}
	
	public static void note(){
		screen("Alright, Just write your reminder, and I will save it with date!");
		Date date = new Date();
		String dateFormat = String.format("%tc", date );
		try {
			PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter("the-file-name.txt", true)));
			writer.println(scanner.nextLine() + ", " + dateFormat);
			writer.close();
		} catch (Exception e) {System.out.println(e);}
	}
	
	public static void list(){
		try (BufferedReader br = new BufferedReader(new FileReader("the-file-name.txt"))) {
		    String line;
		    while ((line = br.readLine()) != null) {
		       screen("- "+line);
		    }
		} catch (Exception e) {System.out.println(e);}
	}
	
	public static void main(String[] args) {
		
		System.out.println("Hello Master, What would you like to do today?");
		String sentence = scanner.nextLine();
		listen(sentence);
	}
}