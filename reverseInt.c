#include<stdio.h>
#include<stdlib.h>
/*
Q2. (Reversing Digits) Write a function that takes an integer value and returns the number with its digits reversed. For example, given the number 7631, the function should return 1367.
*/
int reverse(int num){
	int reverse = 0;
	int divider = 10;
	while(num != 0){
		reverse *= 10;
		reverse += num % 10;
		num /= 10;
	}
	return reverse;
}

int main(int argc, char *argv[]) {
	printf("%d", reverse(63637327));
}