//1. (Duplicate Elimination) Use a single-subscripted array to solve the following problem.
//(1) Create an array of 10 elements; (2) Populate the array with 10 numbers randomly generated, each of which is between 10 and 100, inclusive. As each number is generated, store it in the array only if it is not a duplicate of a number already generated; (3) Print the array; (4) Randomly generate a number between 0 and 120, and use linear search to determine whether this number is found in the array. 

#include <stdio.h>
#include <time.h>
#include <stdlib.h>


int isDuplicate(int elements[] ,int element){
	for(int i=0; i<10; i++){
		if(elements[i] == element){
			return 1;
		}
	}
	return 0;
}

int fill(int elements[], int index, int element){
	if(isDuplicate(elements, element) == 0){
		elements[index] = element;
		return 1;
	} else {
		return fill(elements, index, (rand() % (100-10)) + 10);
	}
}

int main(int argc, char *argv[]) {
	
	srand(time(NULL));
	
	int elements[10];
	int element;
	
	for(int i=0; i<10; i++){
		element = (rand() % (100-10)) + 10;
		fill(elements, i, element);
	}
	
	for(int i=0; i<10; i++){
		printf("%d \n", elements[i]);
	}
	
		
}