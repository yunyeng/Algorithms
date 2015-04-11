/*CS204 homework 10
Q1. A charitable organization receives donations in the order of $5, $10, $11, $8, $20, $2, $9, $6, $4, $20. Create a structure that represents donation list that contains two members: number of donations and an array of 10 donations of double type. Write a function that receives the donations, a function that sort the donation, and a function that displays the donations. Finally write a main function that displays the original order and after donations are sorted by bubble sort function.*/

#include <stdio.h>
#define SIZE 10

struct Donation {
   int  num;
   double donations[SIZE];
} donation;

void swap(double arr[], int f, int s){
	int temp = arr[f];
	arr[f] = arr[s];
	arr[s] = temp;
}

void receive(double d){
	donation.donations[donation.num] = d;
	donation.num++;
}

void show(double arr[]){
	for(int i=0; i<SIZE; i++){
		printf("%f, ", arr[i]);
	}
}

void bubbleSort(double arr[]){
	for(int i=0; i<SIZE-1; i++){
		for(int j=i+1; j<SIZE; j++){
			if(arr[i] > arr[j]){
				swap(arr, i, j);
			}
		}
	}
}

int main(int argc, char *argv[]) {
	donation.num = 0;
	receive(5);
	receive(10);
	receive(11);
	receive(8);
	receive(20);
	receive(2);
	receive(9);
	receive(6);
	receive(4);
	receive(20);
	show(donation.donations);
	bubbleSort(donation.donations);
	printf("\n");
	show(donation.donations);
}
