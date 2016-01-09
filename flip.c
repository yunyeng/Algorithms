#include <stdio.h>
#include <time.h>
#include <stdlib.h>
int flip(){
	int r = rand() % 2;
	return r;
}

int main(int argc, char *argv[]) {
	srand(time(NULL));
	int headCount = 0;
	int tailCount = 0;
	for(int i=0; i<100; i++){
		if(flip() == 0){
			printf("Head\n");
			headCount++;
		} else if(flip() == 1){
			printf("Tail\n");
			tailCount++;
		}
	}
	printf("Heads: %d\n", headCount);
	printf("Tails: %d\n", tailCount);
}