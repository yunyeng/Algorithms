import java.util.*;
class RoundRobin {
	
	public static class Servers {
		private Process[] servers;
		private int maxSize;
		private int size;
		private int head;
		private int tail;
		public Servers(int s){
			servers = new Process[s];
			maxSize = s;
			size = 0;
			head = 0;
			tail = 0;
		}
		public boolean isEmpty(){
			return size == 0;
		}
		public boolean isFull(){
			return size == maxSize;
		}
		public boolean add(Process p){
			if(isFull())
				return false;
			servers[tail] = p;
			tail = (tail + 1) % maxSize;
			size++;
			return true;
		}
		public Process remove(){
			if(isEmpty())
				return null;
			Process p = servers[head];
			head = (head + 1) % maxSize;
			size--;
			return p;
		}
		public Process front(){
			return servers[head];
		}
		public Process back(){
			int t = tail == 0 ? maxSize - 1 : tail - 1;
			return servers[t];
		}
	}
	
	public static class Process {
		int id;
		public Process(int i){
			id = i;
		}
	}
	
	public static void main(String[] args) {
		Servers servers = new Servers(5);
		
		Process p1 = new Process(1);
		servers.add(p1);
		Process p2 = new Process(2);
		servers.add(p2);
		Process p3 = new Process(3);
		servers.add(p3);
		Process p4 = new Process(4);
		servers.add(p4);
		Process p5 = new Process(5);
		servers.add(p5);
		
		System.out.println(servers.front().id);
		System.out.println(servers.back().id);
		
		servers.remove();
		
		System.out.println(servers.front().id);
		System.out.println(servers.back().id);
		
	}
}