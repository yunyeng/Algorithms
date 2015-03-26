/*Q2. (Dice Rolling) Write a program that simulates the rolling of two dice. The program should use rand to roll the first die, and should use rand again to roll the second die. Your program should roll the two dice 36,000 times. Use a double-subscripted array to tally the numbers of times each possible combination appears, e.g. how many times the two dices are 1 and 1? How many times they are 4 and 5? Print the results in a tabular format similar to the figure except the values should be the frequencies. 
Q3. Use a double-subscripted array to solve the following problem. A company has four salespeople (1 to 4) who sell five different products (1 to 5). Once a day, each salesperson passes in a slip for each different type of product sold. Each slip contains:
a) The salesperson number
b) The product number
c) The total dollar value of that product sold that day
Thus, each salesperson passes in between 0 and 5 sales slips per day. Assume that the information from all of the slips for last month is available. Write a program that will read all this information for last month’s sales and summarize the total sales by salesperson by product. All totals should be stored in the double-subscripted array Sales. After processing all the information for last month, print the results in tabular format with each of the columns representing a particular salesperson and each of the rows representing a particular product. Cross total each row to get the total sales of each product for last month; cross total each column to get the total sales by salesperson for last month. Your tabular printout should include these cross totals to the right of the totaled rows and to the bottom of the totaled columns.*/

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