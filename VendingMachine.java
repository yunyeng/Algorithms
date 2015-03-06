import java.util.Random;
import java.util.ArrayList;
import java.util.Stack;
class VendingMachine {
	
	double balance = 0.0;
	int shelves;
	boolean card;
	protected String screen = "Please insert cash or credit/debit card, then select your product.\n";
	String showcase = "";
	ArrayList<Product> products = new ArrayList<Product>();
	Product product;
	
	class CardReader {
		
	}
	
	class KeyCode {
		int code;
		public void enterCode(int c){
			if(c > 99 || c < 0){
				screen = "Wrong Number! There is no product with this code.";
			} else if(products.get(c).many < 1){
				screen = "Sorry, we ran out of this product.";
			} else {
				product = products.get(c);
				if(balance >= product.price){
					product.many--;
					Outbox o = new Outbox(product);
				} else {
					screen = "Insufficient Funds! Please add funds.";
				}
			}
		 	code = c;
		}
	}
	
	class Funds {
		int pennies; // 0.01
		int nickels; // 0.05
		int dimes; // 0.10
		int quarters; // 0.25
		int bills; // 1.00
		protected void insertMoney(int many, String type){
			type = type.toLowerCase();
			if(type == "bill" || type == "bills"){
				if(many > 1)	screen = "Maximum 1 Dollar Bills are allowed.";
				else	balance += 1.0;
			} else if(type == "penny" || type == "pennies"){
				balance += many * 0.01;
			} else if(type == "nickel" || type == "nickels"){
				balance += many * 0.05;
			} else if(type == "dime" || type == "dimes"){
				balance += many * 0.1;
			} else if(type == "quarter" || type == "quarters"){
				balance += many * 0.25;
			}
			if(balance > 0.0)	screen = "Balance: $" + balance + " Select your product.";
			card = false;
			screen();
		}
		protected boolean validCard(String type, String number){
			type = type.toLowerCase();
			if(type != "visa" ^ type != "mastercard"){
				screen = "Only Visa and MasterCard are accepted!";
				return false;
			} else if(number.length() != 16){
				screen = "Authorization Error! Try Again.";
				return false;
			}
			return true;
		}
	}
	
	class Product {
		int code;
		String name;
		boolean drink;
		double price;
		int many;
		public Product(){
			
		}
		public Product(String n, boolean d, double p, int m){
			name = n;
			drink = d;
			price = p;
			many = m;
		}
	}
	
	class Outbox {
		boolean dropped = false;
		int chance;
		public Outbox(Product p){
			Random rand = new Random();
			chance = rand.nextInt(31);
			if(chance < 27){
				dropped = true;
				balance -= p.price;
				if(balance > 0){ 
					if(card){
						screen = "Item Purchased Successfully. Exit? or Buy Another?";
					} else {
						screen = "Item Purchased Successfully. Change: $" + balance;
						giveChange(balance);
					}
				} else if(balance == 0){
					screen = "Item Purchased Successfully. Thank you.";
				}
			} else {
				screen = "Item Stuck! Please select again!";
				dropped = false;
			}
		}
		public void giveChange(double r){
			screen = "Here is your change $"+r+" back! Thank you!";
		}
	}
	
	public VendingMachine(int s){
		screen();
		shelves = s;
		for(int i=0; i<s; i++){
			products.add(new Product());
		}
	}
	
	public void stock(int c, String n, boolean d, double price, int m){
		Product p = new Product(n, d, price, m);
		p.code = c;
		products.set(c, p);
	}
	
	public void show(){
		for(int i=0; i<products.size(); i++){
			if(products.get(i).name != null){
				showcase += products.get(i).code + " | ";
				showcase += products.get(i).name + " | ";
				showcase += products.get(i).price + "\n";
			}
		}
		System.out.print(showcase);
	}
	
	public void exit(boolean c){
		if(c)	screen = "Thank you.";
		else	screen = "Your Balance is: " + balance +" Select your product.";
		screen();
	}
	
	public void buy(int c){
		KeyCode k = new KeyCode();
		k.enterCode(c);
		screen();
	}
	
	public void insert(int many, String type){
		Funds f = new Funds();
		f.insertMoney(many, type);
		
	}
	public void insert(String type, String number){
		Funds f = new Funds();
		if(f.validCard(type, number)){
			card = true;
			balance += 1.25;
			screen = "Authorization is valid. Your Balance is: " + balance;
		}
		screen();
	}
	
	public void screen(){
		System.out.println(screen);
	}
	
	public static void main(String[] args) {
		VendingMachine v = new VendingMachine(48);
		v.stock(0, "Twix", false, 1.25, 10);
		v.stock(5, "Snickers", false, 1.35, 8);
		v.stock(13, "Doritos Cheese", false, 1.50, 10);
		v.stock(14, "Lays Classic", false, 1.50, 10);
		v.stock(15, "Ruffles Original", false, 1.50, 10);
		v.stock(31, "Pepsi", true, 1.75, 6);
		v.stock(32, "Pepsi Light", true, 1.75, 6);
		v.stock(33, "7UP", true, 1.65, 6);
		v.stock(34, "7UP Orange", true, 1.65, 4);
		v.stock(19, "Grandma's Cookies", true, 1.15, 6);
		v.show();
		//v.insert(1, "bill");
		v.insert("Visa", "1234567891011121");
		v.buy(19);
		v.exit(false);
		v.buy(5);
		v.insert("Visa", "1234567891011121");
		v.buy(0);
		v.exit(true);
	}
}