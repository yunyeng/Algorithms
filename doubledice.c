/*Q2. (Dice Rolling) Write a program that simulates the rolling of two dice. The program should use rand to roll the first die, and should use rand again to roll the second die. Your program should roll the two dice 36,000 times. Use a double-subscripted array to tally the numbers of times each possible combination appears, e.g. how many times the two dices are 1 and 1? How many times they are 4 and 5? Print the results in a tabular format similar to the figure except the values should be the frequencies. */

#include <stdio.h>
#include <time.h>
#include <stdlib.h>

int main(int argc, char *argv[]) {
	srand(time(NULL));	
	int dice[6][6];
	for(int i=0; i<6; i++) for(int j=0; j<6; j++) dice[i][j] = 0;
	for(int i=0; i<36000; i++){
		dice[rand() % 6][rand() % 6]++;
	}
	printf("\t  1 \t  2   \t  3  \t  4  \t  5 \t  6\n");
	for(int i=0; i<6; i++){
		for(int j=0; j<6; j++){
			printf("%d\t%d", i+1, dice[i][j]);
		}
		printf("\n");
	}
}