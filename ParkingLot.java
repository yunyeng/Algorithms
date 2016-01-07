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
	
	class Floor {
		int number;
		int rows;
		int capacity;
		public Floor(int n, int r, int c){
			this.number = n;
			this.rows = r;
			this.capacity = c;
		}
	}
	
	int capacity = 200;
	int floors = 5;
	int firstFree = 0;
	
	ArrayList<Boolean> spaces = new ArrayList<Boolean>();
	
	public ParkingLot(){
		Floor f1 = new Floor(1, 5, 100);
		Floor f2 = new Floor(2, 4, 80);
		Floor f3 = new Floor(3, 3, 60);
		Floor f4 = new Floor(4, 3, 60);
		for(int i=0; i<capacity; i++) spaces.add(true);
	}
	
	public boolean isFull(){
		for(int i=0; i<capacity; i++) if(spaces.get(i) == true) return false;
		return true;
	}
	
	public boolean park(String t){
		Vehicle v = new Vehicle(t);
		if(!isFull()){
			if(isEmpty(firstFree, firstFree + v.spaces)){
				for(int i=firstFree; i<firstFree+v.spaces; i++) spaces.set(i, false);
				firstFree += v.spaces;	
				return true;
			}
		}
		return false;
	}
	
	public boolean isEmpty(int i, int j){
		for(int index=i; index<j; index++) if(spaces.get(index) == false) return false;
		return true;
	}
	
	public static void main(String[] args) {
		ParkingLot p = new ParkingLot();
		System.out.println(p.park("Car"));
		System.out.println(p.spaces.get(1));
	}
}