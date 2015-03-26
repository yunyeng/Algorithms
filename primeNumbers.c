#include <stdio.h>

int isPrime(int a){
	if(a <= 1) return 0;
	if(a > 2 && a % 2 == 0) return 0;
	for(int i=2; i<a; i++)
		if(a % i == 0) return 0;
	return 1;
}

int main(int argc, char *argv[]) {
	int n;
	printf("Enter a number.\n");
	scanf("%d", &n);
	printf("First %d Prime Numbers are: \n", n);
	for(int i=0; i<n; i++) if(isPrime(i)) printf("%d, ", i);
}