class PrimitiveTypes {
	
	class Rectangle{
		int x;
		int y;
		int width;
		int height;
		public Rectangle(int xPos, int yPos, int w, int h){
			x = xPos;
			y = yPos;
			width = w;
		   height = h;
		}
	}
	
	public static short parity(long x){
		x ^= x>>>32;
		x ^= x>>>16;
		x ^= x>>>8;
		x ^= x>>>4;
		x ^= x>>>2;
		x ^= x>>>1;
		return (short)(x & 0x1);
	}
	
	public static long swapBits(long x, int i, int j){
		if(((x >>> i) & 1) != ((x >>> j) & 1)){
			long bitMask = (1 << i) | (1 << j);
			x ^= bitMask;
		}
		return x;
	}
	
	public static boolean getBit(long num, int i){
		return ((num & (1 << i)) != 0);
	}
	
	public static long setBit(long num, int i){
		return num | (1 << i);
	}
	
	public static long clearBit(long num, int i){
		return num & ~(1 << i);
	}
	
	public static long reverseBits(long x){
		int i = 0;
		long result = 0;
		while(i < 8){
			if(!getBit(x, i)){
				result |= setBit(result, i);
			}
			i++;
		}
		return result;
	}
	
	public static long closest(long x){
		int i = 0;
		if(getBit(x, i)){
			while(getBit(x, i)){
				i++;
			}
		} else {
			while(!getBit(x, i)){
				i++;
			}
		}
		if(getBit(x, i)){
			x = clearBit(x, i);
			x = setBit(x, i-1);
		} else {
			x = setBit(x, i);
			x = clearBit(x, i-1);
		}
		return x;
	}
	
	public static int reverseDigits(int x){
		int result = 0;
		boolean neg = false;
		if(x < 0){
			neg = true;
			x *= -1;
		}
		while(x > 0){
			result = result * 10 + (x % 10);
			x /= 10;
		}
		return result;
	}
	
	public static int zeroOneRandom(){
		return (int) (Math.random() % 2);
	}
	
	public static boolean isPalindrome(int x){
		if(x < 0)
			return false;
		if(x == reverseDigits(x))
			return true;
		return false;
	}
	
	public static int uniformRandom(int lowerBound, int upperBound){
		int outcomes = upperBound - lowerBound + 1, result;
		do {
			result = 0;
			for(int i=0; (1 << i) < outcomes; ++i)
				result = (result << 1) | zeroOneRandom();
		} while(result >= outcomes);
		return result + lowerBound;
	}
	
	public static boolean intersects(Rectangle r1, Rectangle r2){
		if(r1.x <= r2.x + r2.width && r1.x + r1.width >= r2.x && r1.y <= r2.y + r2.height && r1.y + r1.height >= r2.y){
			return true;
		}
		return false;
	}
	
	public static void main(String[] args) {
//		System.out.println(swapBits(73, 6, 1));
//		System.out.println(reverseBits(73));
//		System.out.println(closest(1));
//		System.out.println(isPalindrome(68326));
//		System.out.println(uniformRandom(3, 787));
	}
}