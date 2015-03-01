import java.util.ArrayList;
class ParkingLot {
	
	class Vehicle {
		String type;
		int spaces;
		public Vehicle(String t){
			this.type = t;
			this.spaces = space(t);
		}
		public int space(String t){
			if(t == "Car"){
				return 1;
			} else if(t == "SUV"){
				return 2;
			} else if(t == "Truck"){
				return 4;
			} else if(t == "Bus"){
				return 3;
			} else if(t == "Motorcycle"){
				return 1;
			}
			return -1;
		}
	}
	
	class floor {
		
	}
	
	int capacity = 200;
	int firstFree = 0;
	
	ArrayList<Boolean> spaces = new ArrayList<Boolean>();
	
	public ParkingLot(){
		for(int i=0; i<capacity; i++) spaces.add(true);
	}
	
	public boolean isFull(){
		for(int i=0; i<capacity; i++) if(spaces.get(i) == true) return false;
		return true;
	}
	
	public boolean park(Vehicle v){
		if(!isFull() && spaces.get(firstFree) == true){
			spaces.set(firstFree, false);
			firstFree++;
			return true;
		}
		return false;
	}
	
	public boolean isEmpty(int i){
		return spaces.get(i);
	}
	
	public static void main(String[] args) {
		ParkingLot p = new ParkingLot();
	}
}