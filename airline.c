/*Q1. (Airline Reservations System) A small airline has just purchased a computer for its new automated reservations system. The president has asked you to program the new system. You’ll write a program to assign seats on each flight of the airline’s only plane (capacity: 10 seats).
Your program should display the following menu of alternatives:
Please type 1 for "first class"
Please type 2 for "economy"
If the person types 1, then your program should assign a seat in the first class section (seats 1–
5). If the person types 2, then your program should assign a seat in the economy section (seats 6–
10).Your program should then print a boarding pass indicating the person's seat number and whether it’s in the first class or economy section of the plane.
Use a single-subscripted array to represent the seating chart of the plane. Initialize all the elements of the array to 0 to indicate that all seats are empty. As each seat is assigned, set the corresponding element of the array to 1 to indicate that the seat is no longer available.
Your program should, of course, never assign a seat that has already been assigned. When the first class section is full, your program should ask the person if it’s acceptable to be placed in the economy section (and vice versa). If yes, then make the appropriate seat assignment. If no, then print the message "Next flight leaves in 3 hours."*/
#include <stdio.h>
#include <stdlib.h>

int choice;
int capacity = 10;
int seats[10];

const char* class(int s){
	if(s >= 0 && s < 5)	return "First Class";
	else if(s >= 5 && s < 10)	return "Economy";
	return "Unknown";
}

void welcome(){
	printf("Welcome to X Airlines\n");
	printf("Please type 1 for 'First Class' or type 2 for 'Economy'");
	printf(" (3 for Exit the Menu)\n");
	scanf("%d", &choice);
}

void printTicket(int seat){
	printf("Here is your Ticket:\n");
	printf("------------------------------------------------\n");
	printf("Mr. / Mrs.\n");
	printf("Class: %s\n", class(seat));
	printf("Seat Number: %d\n", seat+1);
	printf("GATE 404\n");
	printf("Boarding\n");
	printf("------------------------------------------------\n");
	printf("Thank you for choosing X Airlines\n");
}

int isEmpty(int seats[], int type){
	if(type == 1){
		for(int i=0; i<5; i++){
			if(seats[i] == 0){
				return i;
			}
		}
	} else if(type == 2){
		for(int i=5; i<10; i++){
			if(seats[i] == 0){
				return i;
			}
		}
	}
	return -1;
}

int main(int argc, char *argv[]) {
	int seat;
	for(int i=0; i<capacity; i++) seats[i] = 0;
	welcome();
	while(choice != 3){
		if(choice == 1){
			if(isEmpty(seats, 1) != -1){
				seat = isEmpty(seats, 1);
				seats[seat] = 1;
				printTicket(seat);
			} else if(isEmpty(seats, 2) != -1){
				printf("Sorry, no more seats in the First Class, lets look at Economy.\n");
				seat = isEmpty(seats, 2);
				seats[seat] = 1;
				printTicket(seat);
			} else {
				printf("Sorry no more seats!, Next flight leaves in 3 hours.");
			}
		} else if(choice == 2){
			if(isEmpty(seats, 2) != -1){
				seat = isEmpty(seats, 2);
				seats[seat] = 1;
				printTicket(seat);
			} else if(isEmpty(seats, 1) != -1){
				printf("Sorry, no more seats in the Economu, lets look at First Class.\n");
				seat = isEmpty(seats, 1);
				seats[seat] = 1;
				printTicket(seat);
			} else {
				printf("Sorry no more seats!, Next flight leaves in 3 hours.");
				return 0;
			}
		} else {
			printf("Wrong choice!\n");
		}
		welcome();
	}
}