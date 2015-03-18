//Q2. (Dice Rolling) Write a program that simulates the rolling of two dice. The program should use rand to roll the first die, and should use rand again to roll the second die. The sum of the two values should then be calculated. Note: Since each die can show an integer value from 1 to 6, the sum of the two values will vary from 2 to 12. Roll the two dice 36,000 times, and count the frequency of each sum value, e.g. how often is the sum 2? the sum is 3? … the sum is 12? Use a single-scripted array to store the results.  (1) Print the frequency of each sum value; (2) Find the sum value that is more frequent, i.e. the largest; (3) Sort the sum values using bubble sort from highest to lowest.

#include <stdio.h>
#include <time.h>
#include <stdlib.h>

void swap(int elements[], int first, int second){
	int temp = elements[first];
	elements[first] = elements[second];
	elements[second] = temp;
}

int main(int argc, char *argv[]) {
	srand(time(NULL));	
	int sum;
	int frequency[13];
	for(int i=0; i<13; i++)	frequency[i] = 0;
	for(int i=0; i<36000; i++){
		sum = ((rand() % (6)) + 1) + ((rand() % (6)) + 1);
		frequency[sum]++;
	}
	for(int i=2; i<13; i++) printf("%d: %d\n", i, frequency[i]);
	int max = frequency[2];
	int maxIndex = 2;
	for(int i=3; i<13; i++){
		if(frequency[i] > max){
			max = frequency[i];
			maxIndex = i;
		}
	}
	printf("Largest is %d with %d times.\n", maxIndex, max);
	for(int i=2; i<13; i++){
		for(int j=i; j<13; j++){
			if(frequency[j] > frequency[i]){
				swap(frequency, i, j);
			}
		}
	}
	printf("Sorted Frequencies are: \n");
	for(int i=2; i<13; i++) printf("%d\n", frequency[i]);
}