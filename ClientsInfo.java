import java.util.*;
class ClientsInfo {
	
	private HashMap<String, Integer> clients;
	private BST<Integer> credits;
	int size;
	int increment;
	
	public ClientsInfo(){
		clients = new HashMap<>();
		credits = new BST<>();
		size = 0;
		increment = 0;
	}
	
	public boolean insert(Integer credit){
		credits.insert((int) credit);
		return true;
	}
	
	public boolean insert(String customer, int credit){
		Integer client = clients.get(customer);
		if(client != null)
			credits.remove(client);
		clients.put(customer, credit-increment);
		return insert(credit - increment);
	}
	
	public Integer lookup(String customer){
		Integer client = clients.get(customer);
		if(client == null)
			return null;
		System.out.println(credits.root.right.key);
		return credits.findNode(client + increment).key;
	}
	
	public boolean remove(String customer){
		Integer client = clients.get(customer);
		if(client == null)
			return false;
		credits.remove(client);
		return true;
	}
	
	public void addAll(int inc){
		increment = inc;
	}
	
	public static void main(String[] args) {
		ClientsInfo c = new ClientsInfo();
		c.insert("KayaTeks", 250);
		c.insert("GamaTeks", 400);
		c.insert("Mutcali", 450);
		c.insert("FikoTeks", 100);
		c.insert("Orsan", 150);
		c.insert("GokhanTekstil", 100);
		System.out.println(c.lookup("GamaTeks"));
	}
	
}