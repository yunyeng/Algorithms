/*Q3. Use a double-subscripted array to solve the following problem. A company has four salespeople (1 to 4) who sell five different products (1 to 5). Once a day, each salesperson passes in a slip for each different type of product sold. Each slip contains:
a) The salesperson number
b) The product number
c) The total dollar value of that product sold that day
Thus, each salesperson passes in between 0 and 5 sales slips per day. Assume that the information from all of the slips for last month is available. Write a program that will read all this information for last month’s sales and summarize the total sales by salesperson by product. All totals should be stored in the double-subscripted array Sales. After processing all the information for last month, print the results in tabular format with each of the columns representing a particular salesperson and each of the rows representing a particular product. Cross total each row to get the total sales of each product for last month; cross total each column to get the total sales by salesperson for last month. Your tabular printout should include these cross totals to the right of the totaled rows and to the bottom of the totaled columns.*/
#include <stdio.h>

int main(int argc, char *argv[]) {
	int Sales[4][5];
	for(int i=0; i<4; i++){
		for(int j=0; j<5; j++){
			printf("SalesPerson No:%d sold how much worth of Product No:%d.\n", i+1, j+1);
			scanf("%d", &Sales[i][j]);
		}
	}
	printf("\t\t\t\tProduct1  Product2  Product3  Product4  Product5\n");
	for(int i=0; i<4; i++){
		printf("SalesPerson%d:", i);
		for(int j=0; j<5; j++){
			printf("       %d", Sales[i][j]);
		}
		printf("\n");
	}
}