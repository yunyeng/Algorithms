#include <stdio.h>

int fibo(n){
	if(n < 2){
		return n;
	} else {
		return fibo(n-1) + fibo(n-2);
	}
}
int fiboLoop(n){
	int prevprev = 0;
	int prev = 1;
	int current = 0;
	if(n == 1) return 1;
	for(int i=1; i<n; i++){
		current = prev + prevprev;
		prevprev = prev;
		prev = current;
	}
	return current;
}

int main(int argc, char *argv[]) {
	int n;
	printf("Enter a number:\n");
	scanf("%d", &n);
	printf("%dth Fibonacci number is: %d\n", n, fibo(n));
	printf("%dth Fibonacci number is: %d\n", n, fiboLoop(n));
}