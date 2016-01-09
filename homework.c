#include <stdio.h>
/*CS204 Homework 6

Q1. (Parking Charges) A parking garage charges a $2.00 minimum fee to park for up to three hours and an additional $0.50 per hour for each hour or part thereof over three hours. The maximum charge for any given 24-hour period is $10.00. Assume that no car parks for longer than 24 hours at a time. Write a program that will calculate and print the parking charges for each of three customers who parked their cars in this garage yesterday. You should enter the hours parked for each customer. Your program should print the results in a neat tabular format, and should calculate and print the total of yesterday's receipts. The program should use the function calculateCharges to determine the charge for each customer. Your outputs should appear in the following format:

Car      Hours     Charge
1         1.5       2.00
2         4.0       2.50
3         24.0      10.00
TOTAL     29.5      14.50

*/

double calculateCharges(double hours){
	double total = 2.0;
	double per = 0.5; 
	if(hours > 3.0) total += (hours-3.0) * per;
	if(total > 10.0) return 10.0;
	return total;
}

int main(int argc, char *argv[]) {
	int num;
	printf("How Many Cars?\n");
	scanf("%d", &num);
	double hours[num];
	double totalHours = 0.0;
	double totalCharge = 0.0;
	
	for(int i=0; i<num; i++){
		printf("Hours for Car %d?\n", (i+1));
		scanf("%lf", &hours[i]);
	}

	printf("Car \t Hours \t Charge\n");
	for(int i=0; i<num; i++){
		printf("%d \t\t %.2f \t\t %.2f\n", i+1, hours[i], calculateCharges(hours[i]));
		totalHours += hours[i];
		totalCharge += calculateCharges(hours[i]);
	}
	printf("TOTAL \t %.2f \t %.2f\n", totalHours, totalCharge);
}